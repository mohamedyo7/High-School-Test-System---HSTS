package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Lecturer;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
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
	public static List<Questions> getAllQuestions() {
		System.out.println("server get all questions1");
		CriteriaBuilder builder = session.getCriteriaBuilder();
		System.out.println("server get all questions2");
		CriteriaQuery<Questions> query = builder.createQuery(Questions.class);
		query.from(Questions.class);
		System.out.println("server get all questions3");
		List<Questions> ques = session.createQuery(query).getResultList();
		System.out.println("server get all questions4");
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
					System.out.println("in ?");
					message.setMessage("i will give you the students");

					message.setStudents_list_from_server(getAllStudents());
					System.out.println("in ?");
					//message.setCourses_list_from_server(getAllCourses());
					client.sendToClient(message);
					sendToAllClients(message);
				} else if (request.equals("give me the student grades")) {
					System.out.println("whyy god why");
					message.setMessage("i will give you the student grades");
					message.setGrades_list_from_server(getGradesByStudentId(message.getStudentId()));
					client.sendToClient(message);
					sendToAllClients(message);

				} else if (request.equals("give me the courses")) {

					message.setMessage("i will give you the courses");
					System.out.println("server students 2");
					message.setCourses_list_from_server(getAllCourses());
					System.out.println("server tudents 3");
					client.sendToClient(message);
					sendToAllClients(message);

				/*}/*else if (request.equals("i will give you the courses")) {
				System.out.println("whyy god why");
				message.setMessage("i will give you the student courses");
				message.setGrades_list_from_server(getGradesByStudentId(messageId()));.getStudent
				client.sendToClient(message);
				sendToAllClients(message);*/
				} else if (request.equals("change the student grade")) {
					changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
					message.setMessage("i changed the grade");
					client.sendToClient(message);
					sendToAllClients(message);

				}else if(request.equals("add questions to course")){
				message.setMessage("i added question to course");
				client.sendToClient(message);
			}
				else if(request.equals("create question")) {
					message.setMessage("i created question");
					System.out.println("server create question1");
				String name= message.getCourseName();
				Questions question = message.getQuestion();
					System.out.println("server create question2");
				question.setCourse_name(name);
					System.out.println("server create question3");
				generateQuestion(question);
					System.out.println("server create question4");

				client.sendToClient(message);
				}else if(request.equals("show questions")){
					message.setMessage("i will show questions");
					List<Questions> ques = getAllQuestions();
					for (int i=0;i< ques.size();i++){
					System.out.println(ques.get(i).getQuestion());}
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