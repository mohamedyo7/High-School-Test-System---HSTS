package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.SubscribedClient;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static il.cshaifasweng.OCSFMediatorExample.server.App.*;

public class SimpleServer extends AbstractServer {
	private static ArrayList<SubscribedClient> SubscribersList = new ArrayList<>();

	//private static Session session;

	public SimpleServer(int port) {
		super(port);

	}
	public static List<Student> getAllStudents() throws Exception {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		query.from(Student.class);
		List<Student> data = session.createQuery(query).getResultList();
		return data;
	}

	public static List<Course> getAllCourses() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Course> query = builder.createQuery(Course.class);
		query.from(Course.class);
		List<Course> COURSES = session.createQuery(query).getResultList();
		return COURSES;
	}

	public static List<Lecturer> getAllLecturers() throws Exception {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Lecturer> query = builder.createQuery(Lecturer.class);
		query.from(Lecturer.class);
		List<Lecturer> Letcurers = session.createQuery(query).getResultList();
		return Letcurers;
	}
	public static List<Exams> getAllExams1() throws Exception {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Exams> query = builder.createQuery(Exams.class);
		query.from(Exams.class);
		List<Exams> exams = session.createQuery(query).getResultList();
		return exams;
	}
	public static List<Questions> getAllQuestions() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Questions> query = builder.createQuery(Questions.class);
		query.from(Questions.class);
		List<Questions> ques = session.createQuery(query).getResultList();
		return ques;
	}
	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Message message = (Message) msg;
			String request = message.getMessage();

			try {

				if (request.isBlank()) {
					message.setMessage("Error! we got an empty message");
					client.sendToClient(message);
				} else if (request.equals("add client")) {

					SubscribedClient connection = new SubscribedClient(client);
					SubscribersList.add(connection);
					message.setMessage("client added successfully");
					client.sendToClient(message);

				} else if (request.equals("give me the students")) {

					message.setMessage("i will give you the students");
					message.setStudents_list_from_server(getAllStudents());
					//message.setCourses_list_from_server(getAllCourses());
					client.sendToClient(message);
					sendToAllClients(message);

				} else if (request.equals("give me the student grades")) {

					message.setMessage("i will give you the student grades");
					message.setGrades_list_from_server(getGradesByStudentId(message.getStudentId()));
					client.sendToClient(message);
					sendToAllClients(message);

				} else if (request.equals("give me the courses")) {

					message.setMessage("i will give you the courses");
					message.setCourses_list_from_server(getAllCourses());
					client.sendToClient(message);
					sendToAllClients(message);

				}else if (request.equals("update exam")) {

					Exams exams = message.getExam();
					//exams.setQues_number(exams.getQuestions().size());
					//System.out.println(exams.getQuestions().size());
					updateExam(exams);
					message.setMessage("i updated the exam");
					client.sendToClient(message);

				}else if (request.equals("show exams")) {

					message.setMessage("i will give you the exams");
					List<Exams> exams= getAllExams();
					message.setExams_list_from_server(exams);
					client.sendToClient(message);

				}else if (request.equals("add exam")) {

					Exams exam = message.getExam();
					generateExam(exam);
					message.setMessage("i added the exam");
					client.sendToClient(message);

				} else if (request.equals("add ques to exam")) {

					generateQuestion(message.getQuestion());

				} else if (request.equals("change the student grade")) {

					changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
					message.setMessage("i changed the grade");
					client.sendToClient(message);
					sendToAllClients(message);

				}else if(request.equals("start exam")){

					updateExamStat(message.getExam().getId(),true);
					message.setMessage("i will start exam");
					client.sendToClient(message);

				}else if(request.equals("end exam")){

					updateExamStat(message.getExam().getId(),false);

				}else if(request.equals("add questions to course")){

				message.setMessage("i added question to course");
				client.sendToClient(message);

			}
				else if(request.equals("create question")) {

					message.setMessage("i created question");
					Questions question = message.getQuestion();
					generateQuestion(question);
					client.sendToClient(message);

				}else if(request.equals("show questions")){

					message.setMessage("i will show questions");
					List<Questions> ques = getAllQuestions();
					message.setQuestions_list_from_server(ques);
					client.sendToClient(message);

				}else if(request.equals("show questions2")){

					message.setMessage("i will show questions2");
					List<Questions> ques = getAllQuestions();
					List<Exams> exams = getAllExams1();
					message.setExams_list_from_server(exams);
					message.setQuestions_list_from_server(ques);
					client.sendToClient(message);

				}else {
					sendToAllClients(message);
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			assert session != null;
			session.close();
		}
	}

	public void sendToAllClients(Message message) {
		try {
			for (SubscribedClient SubscribedClient : SubscribersList) {
				SubscribedClient.getClient().sendToClient(message);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}