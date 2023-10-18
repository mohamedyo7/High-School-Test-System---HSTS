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

	public static int client_id=0;

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
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Questions> query = builder.createQuery(Questions.class);
		query.from(Questions.class);
		List<Questions> ques = session.createQuery(query).getResultList();
		return ques;
	}
	public static List<CourseReg> getAllregCourses() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<CourseReg> query = builder.createQuery(CourseReg.class);
		query.from(CourseReg.class);
		List<CourseReg> ques = session.createQuery(query).getResultList();
		return ques;
	}
	public static List<Mediator> getAllMediator() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Mediator> query = builder.createQuery(Mediator.class);
		query.from(Mediator.class);
		List<Mediator> ques = session.createQuery(query).getResultList();
		return ques;
	}
	public static List<Grade> getAllgrades() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
		query.from(Grade.class);
		List<Grade> ques = session.createQuery(query).getResultList();
		return ques;
	}
	public static List<ExamsScan> getAllexamsscans() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ExamsScan> query = builder.createQuery(ExamsScan.class);
		query.from(ExamsScan.class);

		List<ExamsScan> ques = session.createQuery(query).getResultList();
		return ques;
	}
	private static void generateStudents(Student s) throws Exception {

			Student std0 = new Student(s);
			session.save(std0);
			session.flush();
		}

	private static void generateLecturers(Lecturer lec) throws Exception {

			Lecturer lect = new Lecturer(lec);
			session.save(lect);
			session.flush();
		}
	private static void generateMediator(Mediator lec) throws Exception {

		Mediator lect = new Mediator(lec);
		session.save(lect);
		session.flush();
	}
	private static void generateExamsScan(ExamsScan lec) throws Exception {
		List<ExamsScan>exams=getAllexamsscans();
		for(int i=0;i<exams.size();i++){
			if (exams.get(i).getStudent_ID()==lec.getStudent_ID()&&exams.get(i).getName().equals(lec.getName())&&exams.get(i).getExam_ID()==lec.getExam_ID()&&exams.get(i).getType().equals(lec.getType())) {
				session.remove(exams.get(i));

			}

			}

		session.save(lec);
		session.flush();
		System.out.println("op");
	}
	public static void generateregcourse(int id,String name) throws Exception {
		int c = 0;
		List<Student> students = getAllStudents();
		List<CourseReg> courses = getAllregCourses();
		for (int j = 0; j < courses.size(); j++) {
			if(!courses.isEmpty())
			if (courses.get(j).getType().equals("Student")) {
				if (courses.get(j).getStudent().getStudent_id() == id) {
					if (courses.get(j).getName().equals(name)) {
						c = 1;
						break;
					}
				}
			}
		}
		if (c==0) {
			for (int i = 0; i < students.size(); i++) {

					if (students.get(i).getStudent_id() == id) {


						CourseReg cor = new CourseReg(students.get(i), name, "Student");
						session.save(cor);
						session.flush();
						break;

					}
				}



		}
	}
	public static void generateregcourse2(int id,String name) throws Exception {
		int c = 0;
		List<Lecturer> lecturers = getAllLecturers();
		List<CourseReg> courses = getAllregCourses();

		for (int j = 0; j < courses.size(); j++) {
			if(!courses.isEmpty()) {
				if (courses.get(j).getType().equals("Teacher")) {
					if (courses.get(j).getLecturer().getId() == id) {
						if (courses.get(j).getName().equals(name)) {
							c = 1;
							break;
						}
					}
				}
			}
		}
		if (c==0) {
			for (int i = 0; i < lecturers.size(); i++) {
					if (lecturers.get(i).getId() == id) {


						//System.out.println(courses.get(i).getName() + "nf7s");
						CourseReg cor = new CourseReg(lecturers.get(i), name, "Teacher");
						session.save(cor);
						session.flush();
						break;

					}

				}
			}


	}
	private static void generateGrades(Student s,Course c,String g,String name) throws Exception {
		int c1 = 0;
		List<Student> students = getAllStudents();
		List<Grade> grades = getAllgrades();
		for (int j = 0; j < grades.size(); j++) {

			if (grades.get(j).getStudent().getStudent_id() == s.getStudent_id()) {
				if (grades.get(j).getCourse_name().equals(name)) {
					c1 = 1;
					break;
				}
			}
		}
		if (c1==0) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getStudent_id() == s.getStudent_id()) {


					Grade grade = new Grade(s,c,g,name);
					session.save(grade);
					session.flush();
					break;

				}


			}

		}




	}
	public static void updateExamscanStat(String course_name,String student_id,String examId,String ques_name,String ques_note) throws Exception {
		System.out.println("glb generate0");
		List<ExamsScan> exams = getAllexamsscans();
		System.out.println("glb generate00");
	/*	if(exams.size()==0) {
			System.out.println("glb generate1");
			exit();
		}*/

		try {
			System.out.println("glb generate2");

			// Find the corresponding Exam entity
			ExamsScan exam=null;
			System.out.println("glb generate3");

			for (int i=0;i<exams.size();i++) {
				if (exams.get(i).getStudent_ID() == Integer.parseInt(student_id) && exams.get(i).getName().equals(course_name) && exams.get(i).getExam_ID() == Integer.parseInt(examId) && exams.get(i).getType().equals(ques_name)) {
					System.out.println("glb generate4");
					exam = exams.get(i);

				}
			}


				if (exam == null) {
					throw new Exception("No exam found with the specified ID.");
				}

				// Update the stat
				System.out.println("glb generate5");
				exam.setState(ques_note);
				System.out.println("glb generate6");

				// Save the updated exam object
				session.update(exam);
				System.out.println("glb generate7");
				session.getTransaction().commit(); // Save everything..commit();
				System.out.println("glb generate8");

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
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
					//message.setLecturers_list_from_server(getAllLecturers());
					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if (request.equals("give me the students2")) {
					message.setMessage("i will give you the students2");

					message.setStudents_list_from_server(getAllStudents());
					message.setLecturers_list_from_server(getAllLecturers());
					message.setMediators_list_from_server(getAllMediator());
					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if (request.equals("check id exist")) {
					message.setMessage("i will check id exist");


					message.setStudents_list_from_server(getAllStudents());
					message.setLecturers_list_from_server(getAllLecturers());
					message.setMediators_list_from_server(getAllMediator());
					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if (request.equals("give me the student grades")) {
					message.setMessage("i will give you the student grades");

					message.setGrades_list_from_server(getAllgrades());
					client.sendToClient(message);
					//sendToAllClients(message);

				} else if (request.equals("give me the courses")) {
					message.setMessage("i will give you the courses");
					message.setCourses_list_from_server(getAllCourses());
					message.setStudents_list_from_server(getAllStudents());
					message.setCourses_list_from_server_reg(getAllregCourses());
					message.setExams_list_from_server(getAllExams());
					message.setExamsScans_list_from_server(getAllexamsscans());
					client.sendToClient(message);
					//sendToAllClients(message);
				}

					else if (request.equals("register the course")) {
						message.setMessage("course has been registered");
					if(message.getLogin_name().equals("Student")) {
						List<Student> s = getAllStudents();

						generateregcourse(message.getId(), message.getCourseName());
						List<Course> cor = getAllCourses();
						Course course = new Course();
						for (int j = 0; j < cor.size(); j++) {
							if (cor.get(j).getName().equals(message.getCourseName()))
								course = cor.get(j);
						}
						for (int i = 0; i < s.size(); i++) {
							if (s.get(i).getStudent_id() == message.getId())
								generateGrades(s.get(i), course, "null", message.getCourseName());
						}
					}
					if(message.getLogin_name().equals("Teacher"))
						generateregcourse2(message.getId(), message.getCourseName());

					message.setStudents_list_from_server(getAllStudents());
					message.setCourses_list_from_server_reg(getAllregCourses());
						client.sendToClient(message);
					}



				 else if (request.equals("change the student grade")) {
					changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
					message.setMessage("i changed the grade");
					client.sendToClient(message);
					//sendToAllClients(message);

				}
				else if (request.equals("change the student state")) {
					//changeState(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
					message.setMessage("i changed the grade");
					client.sendToClient(message);
					//sendToAllClients(message);

				}

				 else if(request.equals("add questions to course")){
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
				}
				else if(request.equals("Save The Student Details")) {
					message.setMessage("I Saved The Student Details");
					generateStudents(message.getStudent());
					message.setCourses_list_from_server(getAllCourses());
					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("Save The Teacher Details")) {
					message.setMessage("I Saved The Teacher Details");
					generateLecturers(message.getLec());
					message.setCourses_list_from_server(getAllCourses());
					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("Save The Mediator Details")) {
					message.setMessage("I Saved The Mediator Details");
					generateMediator(message.getMediator());
					message.setCourses_list_from_server(getAllCourses());
					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me student data")){

					message.setMessage("i will give you the student data");
					List<CourseReg> s=getAllregCourses();
					message.setCourses_list_from_server_reg(s);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me exams scans")){

					message.setMessage("i will give you exams scans");
					List<CourseReg> s=getAllregCourses();
					message.setCourses_list_from_server_reg(s);
					List<Questions>questions=getAllQuestions();
					List<ExamsScan>examsScans=getAllexamsscans();
					List<Exams>exams=getAllExams();
					message.setQuestions_list_from_server(questions);
					message.setExamsScans_list_from_server(examsScans);
					message.setExams_list_from_server(exams);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("add note")){

					message.setMessage("i will add note");
					updateExamscanStat(message.getCourseName(), String.valueOf(message.getStudentId()),message.getExam_id(),message.getQues_name(),message.getQues_note());
					System.out.println("note 3");
					//List<ExamsScan>examsScans=getAllexamsscans();
					System.out.println("note 4");
					//message.setExamsScans_list_from_server(examsScans);
					System.out.println("note 8");

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me students id")){

					message.setMessage("i will give you students id");
					List<CourseReg> s=getAllregCourses();
					message.setCourses_list_from_server_reg(s);
					List<Questions>questions=getAllQuestions();
					List<ExamsScan>examsScans=getAllexamsscans();
					List<Exams>exams=getAllExams();
					message.setQuestions_list_from_server(questions);
					message.setExamsScans_list_from_server(examsScans);
					message.setExams_list_from_server(exams);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me students id2")){

					message.setMessage("i will give you students id2");
					List<CourseReg> s=getAllregCourses();
					message.setCourses_list_from_server_reg(s);
					List<Questions>questions=getAllQuestions();
					List<ExamsScan>examsScans=getAllexamsscans();
					List<Exams>exams=getAllExams();
					message.setQuestions_list_from_server(questions);
					message.setExamsScans_list_from_server(examsScans);
					message.setExams_list_from_server(exams);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me exam questions")){

					message.setMessage("i will give you exams questions");
					List<Questions>questions=getAllQuestions();
					List<ExamsScan>examsScans=getAllexamsscans();
					message.setQuestions_list_from_server(questions);
					message.setExamsScans_list_from_server(examsScans);
					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("Show Answers")){

					message.setMessage("i will Show Answers");
					List<CourseReg> s=getAllregCourses();
					message.setCourses_list_from_server_reg(s);
					List<Questions>questions=getAllQuestions();
					List<ExamsScan>examsScans=getAllexamsscans();
					List<Exams>exams=getAllExams();
					message.setQuestions_list_from_server(questions);
					message.setExamsScans_list_from_server(examsScans);
					message.setExams_list_from_server(exams);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me teacher data")){

					message.setMessage("i will give you the teacher data");
					List<CourseReg> s=getAllregCourses();
					message.setCourses_list_from_server_reg(s);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me mediator data")){

					message.setMessage("i will give you the mediator data");
					List<CourseReg> s=getAllregCourses();
					message.setCourses_list_from_server_reg(s);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("give me teacher stats")){

					message.setMessage("i will give you the teacher stats");
					List<CourseReg> s=getAllregCourses();
					List<Lecturer> lec=getAllLecturers();
					message.setLecturers_list_from_server(lec);
					message.setCourses_list_from_server_reg(s);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if(request.equals("show stats")){

					message.setMessage("i will show stats");
					List<CourseReg> s=getAllregCourses();
					List<Lecturer> lec=getAllLecturers();
					List<Grade>grades=getAllgrades();
					message.setGrades_list_from_server(grades);
					message.setLecturers_list_from_server(lec);
					message.setCourses_list_from_server_reg(s);

					client.sendToClient(message);
					//sendToAllClients(message);
				}
				else if (request.equals("update exam")) {

					Exams exams = message.getExam();
					//exams.setQues_number(exams.getQuestions().size());
					//System.out.println(exams.getQuestions().size());
					updateExam(exams);
					message.setMessage("i updated the exam");
					client.sendToClient(message);

				}
				else if (request.equals("show exams")) {

					message.setMessage("i will give you the exams");
					List<Exams> exams= getAllExams();
					message.setExamsScans_list_from_server(getAllexamsscans());
					message.setExams_list_from_server(exams);
					client.sendToClient(message);

				}
				else if (request.equals("add exam")) {

					Exams exam = message.getExam();
					generateExam(exam);
					message.setMessage("i added the exam");
					client.sendToClient(message);

				} else if (request.equals("add ques to exam")) {

					generateQuestion(message.getQuestion());

				} else if(request.equals("start exam")){


					/*if(message.getLogin_name().equals("Student")){
						ExamsScan exam=new ExamsScan(message.getStudentId(),message.getExam().getCourse_name(),message.getExam().getId(),"Student","null");
						System.out.println("ID_1"+message.getExam().getId());
						generateExamsScan(exam);
					}*/
					if(message.getLogin_name().equals("Teacher")) {

						updateExamStat(message.getExam().getId(), true);

						//updateExamscanStat(message.getExam().getId(), true);

					}
					message.setCourseName(message.getExam().getCourse_name());
					message.setMessage("i will start exam");
					message.setId(message.getExam().getId());
					client.sendToClient(message);
				}
				else if(request.equals("save data")){
					message.setMessage("i will save data");
					System.out.println("kl");
					ExamsScan exam=new ExamsScan(message.getStudentId(),message.getCourseName(),message.getId(), message.getType(), message.getAns(),"False");
					System.out.println("ID_1"+message.getId());
					generateExamsScan(exam);
					System.out.println("ID_2"+message.getId());
					client.sendToClient(message);

				}


				else if(request.equals("exam is over")){

					updateExamStat(message.getId(),false);
					message.setMessage("exam is over");
					client.sendToClient(message);
					sendToAllClients(message);
				}else if(request.equals("end exam")){

					updateExamStat(message.getId(),false);

				}
				else if(request.equals("show questions2")){

					message.setMessage("i will show questions2");
					List<Questions> ques = getAllQuestions();
					List<Exams> exams = getAllExams();
					message.setExams_list_from_server(exams);
					message.setQuestions_list_from_server(ques);
					client.sendToClient(message);

				}else if(request.equals("the grade is")){
					message.setMessage("the grade is");
					client.sendToClient(message);


				}
				else {
					//sendToAllClients(message);
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