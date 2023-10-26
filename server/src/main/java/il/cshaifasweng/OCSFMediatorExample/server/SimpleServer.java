package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.client.SimpleClient;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.SubscribedClient;
import javafx.animation.PauseTransition;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static il.cshaifasweng.OCSFMediatorExample.server.App.*;

public class SimpleServer extends AbstractServer {
	private static ArrayList<SubscribedClient> SubscribersList = new ArrayList<>();
	private PauseTransition delay;
	public static int client_id = 0;

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
	public static List<Document> getAllLDecuments() throws Exception {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Document> query = builder.createQuery(Document.class);
		query.from(Document.class);
		List<Document> dec = session.createQuery(query).getResultList();
		return dec;
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
	public static List<ExamInfo> getAllExamInfo() throws Exception {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ExamInfo> query = builder.createQuery(ExamInfo.class);
		query.from(ExamInfo.class);
		List<ExamInfo> data = session.createQuery(query).getResultList();
		return data;
	}
	public static void generateExamInfo(ExamInfo examInfo) throws Exception{
		session.save(examInfo);
		session.flush();
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
	private static void generateDocument(Document lec) throws Exception {

		session.save(lec);
		session.flush();
	}

	private static void
	generateExamsScan(ExamsScan lec) throws Exception {
		List<ExamsScan> exams = getAllexamsscans();
		for (int i = 0; i < exams.size(); i++) {
			if (exams.get(i).getStudent_ID() == lec.getStudent_ID() && exams.get(i).getName().equals(lec.getName()) && exams.get(i).getExam_ID().equals(lec.getExam_ID())&& exams.get(i).getType().equals(lec.getType())) {
				session.remove(exams.get(i));

			}

		}

		session.save(lec);
		session.flush();
	}
	public static int generateQuestion(Questions questions){
		List<Questions> questionsList = getAllQuestions();
		for (int i = 0; i < questionsList.size(); i++) {
			if (questionsList.get(i).getQues_id().equals(questions.getQues_id()) && questionsList.get(i).getCourse_name().equals(questions.getCourse_name()) && questionsList.get(i).getId().equals(questions.getId())&& questionsList.get(i).getQuestion().equals(questions.getQuestion())) {
				return 1;
			}

		}
		session.save(questions);
		session.flush();
		return 0;
	}

	public static void generateregcourse(int id, String name) throws Exception {
		int c = 0;
		List<Student> students = getAllStudents();
		List<CourseReg> courses = getAllregCourses();
		for (int j = 0; j < courses.size(); j++) {
			if (!courses.isEmpty())
				if (courses.get(j).getType().equals("Student")) {
					if (courses.get(j).getStudent().getStudent_id() == id) {
						if (courses.get(j).getName().equals(name)) {
							c = 1;
							break;
						}
					}
				}
		}
		if (c == 0) {
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

	public static void generateregcourse2(int id, String name) throws Exception {
		int c = 0;
		List<Lecturer> lecturers = getAllLecturers();
		List<CourseReg> courses = getAllregCourses();

		for (int j = 0; j < courses.size(); j++) {
			if (!courses.isEmpty()) {
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
		if (c == 0) {
			for (int i = 0; i < lecturers.size(); i++) {
				if (lecturers.get(i).getId() == id) {
					CourseReg cor = new CourseReg(lecturers.get(i), name, "Teacher");
					session.save(cor);
					session.flush();
					break;

				}

			}
		}


	}

	private static void generateGrades(Student s, Course c, String g, String name) throws Exception {
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
		if (c1 == 0) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getStudent_id() == s.getStudent_id()) {


					Grade grade = new Grade(s, c, g, name);
					session.save(grade);
					session.flush();
					break;

				}


			}

		}


	}

	public static void updateExamscanStat(String course_name, String student_id, String examId, String ques_name, String ques_note) throws Exception {
		List<ExamsScan> exams = getAllexamsscans();
		try {

			// Find the corresponding Exam entity
			ExamsScan exam = null;

			for (int i = 0; i < exams.size(); i++) {
				if (exams.get(i).getStudent_ID() == Integer.parseInt(student_id) && exams.get(i).getName().equals(course_name) && exams.get(i).getExam_ID().equals(examId) && exams.get(i).getType().equals(ques_name)) {
					exam = exams.get(i);

				}
			}


			if (exam == null) {
				throw new Exception("No exam found with the specified ID.");
			}

			// Update the stat
			exam.setState(ques_note);

			// Save the updated exam object
			session.update(exam);
			session.getTransaction().commit(); // Save everything..commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	/*public static void updateExamscanStat_studentstate(String course_name, String student_id, String examId) throws Exception {
		List<ExamsScan> exams = getAllexamsscans();

		try {

			// Find the corresponding Exam entity
			ExamsScan exam = null;

			for (int i = 0; i < exams.size(); i++) {
				if (exams.get(i).getStudent_ID() == Integer.parseInt(student_id) && exams.get(i).getName().equals(course_name) && exams.get(i).getExam_ID() == Integer.parseInt(examId)) {
					exam = exams.get(i);

				}
			}


			if (exam == null) {
				throw new Exception("No exam found with the specified ID.");
			}

			// Update the stat
			exam.setStudent_state_tostart("true");

			// Save the updated exam object
			session.update(exam);
			session.getTransaction().commit(); // Save everything..commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}*/
		public static void updateExamscanStat2(String course_name, String student_id, String examId, String ques_name, String ques_note) throws Exception {
			List<ExamsScan> exams = getAllexamsscans();
			try {

				// Find the corresponding Exam entity
				ExamsScan exam = null;

				for (int i = 0; i < exams.size(); i++) {
					if (exams.get(i).getStudent_ID() == Integer.parseInt(student_id) && exams.get(i).getName().equals(course_name) && exams.get(i).getExam_ID().equals(examId)) {
						exam = exams.get(i);


						if (exam == null) {
							throw new Exception("No exam found with the specified ID.");
						}

						// Update the stat
						exam.setStudent_can_scan("true");
						if(ques_note!=null)
							exam.setChange_grade_reason(ques_note);

						// Save the updated exam object
						session.update(exam);
					}
				}
						session.getTransaction().commit(); // Save everything..commit();



			} catch (Exception e) {
				session.getTransaction().rollback();
			} finally {
				session.close();
			}
	}
	public static void updateOnlinestate_student(int id,String type) throws Exception {

		List<Student> students = getAllStudents();


		try {
			Student std = null;

			// Find the corresponding Exam entity




			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getStudent_id() == id) {
					std = students.get(i);

				}
			}
			if (std == null) {
				throw new Exception("No exam found with the specified ID.");
			}

			// Update the stat
			std.setOnline_state("online");

			// Save the updated exam object
			session.update(std);
			session.getTransaction().commit(); // Save everything..commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public static void updateOnlinestate_lecturer(int id,String type) throws Exception {
		List<Lecturer> lecturers = getAllLecturers();


		try {
			Lecturer lec = null;
			// Find the corresponding Exam entity
			for (int i = 0; i < lecturers.size(); i++) {
				if (lecturers.get(i).getId() == id) {
					lec = lecturers.get(i);

				}
			}


			if (lec == null) {
				throw new Exception("No exam found with the specified ID.");
			}

			// Update the stat
			lec.setOnline_state("online");

			// Save the updated exam object
			session.update(lec);
			session.getTransaction().commit(); // Save everything..commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}




	public static void updateOnlinestate_mediator(int id,String type) throws Exception {
		List<Mediator>mediators=getAllMediator();

		try{

				Mediator med=null;

				for (int i = 0; i < mediators.size(); i++) {
					if (mediators.get(i).getId() == id) {
						med = mediators.get(i);

					}
				}


				if (med == null) {
					throw new Exception("No exam found with the specified ID.");
				}

				// Update the stat
				med.setOnline_state("online");

				// Save the updated exam object
				session.update(med);
				session.getTransaction().commit(); // Save everything..commit();



		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	public static void updateOfflinestate(int id,String type) throws Exception {
		List<Lecturer>lecturers=getAllLecturers();
		List<Student>students=getAllStudents();
		List<Mediator>mediators=getAllMediator();


		try {

			// Find the corresponding Exam entity
			Lecturer lec=null;
			Student std=null;
			Mediator med=null;

			if(type.equals("Student")) {

				for (int i = 0; i < students.size(); i++) {
					if (students.get(i).getStudent_id() == id) {
						std = students.get(i);

					}
				}


				if (std == null) {
					throw new Exception("No exam found with the specified ID.");
				}

				// Update the stat
				std.setOnline_state("offline");
				// Save the updated exam object
				session.update(std);
				session.getTransaction().commit(); // Save everything..commit();
			}
			if(type.equals("Teacher")) {

				for (int i = 0; i < lecturers.size(); i++) {
					if (lecturers.get(i).getId() == id) {
						lec = lecturers.get(i);

					}
				}


				if (lec == null) {
					throw new Exception("No exam found with the specified ID.");
				}

				// Update the stat
				lec.setOnline_state("offline");

				// Save the updated exam object
				session.update(lec);
				session.getTransaction().commit(); // Save everything..commit();
			}
			if(type.equals("Mediator")) {

				for (int i = 0; i < mediators.size(); i++) {
					if (mediators.get(i).getId() == id) {
						med = mediators.get(i);

					}
				}


				if (med == null) {
					throw new Exception("No exam found with the specified ID.");
				}

				// Update the stat
				med.setOnline_state("offline");
				// Save the updated exam object
				session.update(med);
				session.getTransaction().commit(); // Save everything..commit();
			}

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}


	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		Message message;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			message = (Message) msg;
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

				} else if (request.equals("give me the students2")) {

					message.setMessage("i will give you the students2");
					message.setStudents_list_from_server(getAllStudents());
					message.setLecturers_list_from_server(getAllLecturers());
					message.setMediators_list_from_server(getAllMediator());

					client.sendToClient(message);


				} else if (request.equals("check id exist")) {

					message.setMessage("i will check id exist");
					message.setStudents_list_from_server(getAllStudents());
					message.setLecturers_list_from_server(getAllLecturers());
					message.setMediators_list_from_server(getAllMediator());
					client.sendToClient(message);

				} else if (request.equals("give me the student grades")) {

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

				} else if (request.equals("register the course")) {

					message.setMessage("course has been registered");
					if (message.getLogin_name().equals("Student")) {
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
								generateGrades(s.get(i), course, "No grade yet", message.getCourseName());
						}
					}
					if (message.getLogin_name().equals("Teacher"))
						generateregcourse2(message.getId(), message.getCourseName());
					message.setStudents_list_from_server(getAllStudents());
					message.setCourses_list_from_server_reg(getAllregCourses());
					client.sendToClient(message);

				}

				 else if (request.equals("change the student grade")) {
					changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
					message.setMessage("i changed the grade");
					client.sendToClient(message);

				}

					 else if (request.equals("change the student state")) {
						//changeState(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
						message.setMessage("i changed the grade");
						client.sendToClient(message);
						//sendToAllClients(message);

					} else if (request.equals("add questions to course")) {
						message.setMessage("i added question to course");
						client.sendToClient(message);
					} else if (request.equals("create question")) {
						 int i=0;
						 List<Questions> q = getAllQuestions();
						 for(Questions que : q) {
							 if (que.getId().equals(message.getQuestion().getId())) {
								 message.setMessage("questions id exist");
								 client.sendToClient(message);
								 i = 1;
							 }
						 }
						 if(i==0) {
							 message.setMessage("i created question");
							 Questions question = message.getQuestion();
							 generateQuestion(question);
							 client.sendToClient(message);
						 }


					} else if (request.equals("show questions")) {

						message.setMessage("i will show questions");
						List<Questions> ques = getAllQuestions();
						message.setQuestions_list_from_server(ques);
						client.sendToClient(message);

					} else if (request.equals("Save The Student Details")) {

						message.setMessage("I Saved The Student Details");
						generateStudents(message.getStudent());
						message.setCourses_list_from_server(getAllCourses());
						client.sendToClient(message);

					} else if (request.equals("Save The Teacher Details")) {

						message.setMessage("I Saved The Teacher Details");
						generateLecturers(message.getLec());
						message.setCourses_list_from_server(getAllCourses());
						client.sendToClient(message);

					} else if (request.equals("Save The Mediator Details")) {

						message.setMessage("I Saved The Mediator Details");
						generateMediator(message.getMediator());
						message.setCourses_list_from_server(getAllCourses());
						client.sendToClient(message);

					} else if (request.equals("give me student data")) {

						message.setMessage("i will give you the student data");
						List<CourseReg> s = getAllregCourses();
						message.setCourses_list_from_server_reg(s);

						client.sendToClient(message);
						//sendToAllClients(message);
					}
				else if (request.equals("log in")){
					if(message.getType().equals("Student"))
					updateOnlinestate_student(message.getId(),message.getType());
					else if(message.getType().equals("Teacher"))
						updateOnlinestate_lecturer(message.getId(),message.getType());
					else if(message.getType().equals("Mediator"))
						updateOnlinestate_mediator(message.getId(),message.getType());



				}
				else if (request.equals("update state")) {
					updateOfflinestate(message.getId(),message.getType());
				}
				else if (request.equals("update document")) {
					Document doc=new Document(String.valueOf(message.getExam().getId()),String.valueOf(message.getStudentId()), message.getPath(),"false", message.getCourseName());
					generateDocument(doc);
				}
				else if (request.equals("download the exam")) {
					message.setMessage("i will download the exam");
					generateExamInfo(message.getExamInfo());
					message.setQuestions_list_from_server(getAllQuestions());
					message.setDocuments_list_from_server(getAllLDecuments());
					client.sendToClient(message);
				}

					 else if (request.equals("give me exams scans")) {

						message.setMessage("i will give you exams scans");
						List<CourseReg> s = getAllregCourses();
						message.setCourses_list_from_server_reg(s);
						List<Questions> questions = getAllQuestions();
						List<ExamsScan> examsScans = getAllexamsscans();
						List<Exams> exams = getAllExams();
						message.setQuestions_list_from_server(questions);
						message.setExamsScans_list_from_server(examsScans);
						message.setExams_list_from_server(exams);
						message.setGrades_list_from_server(getAllgrades());
						message.setCourses_list_from_server(getAllCourses());

						client.sendToClient(message);
						//sendToAllClients(message);
					}
				else if (request.equals("give me teacher exams")) {

					message.setMessage("i will give you teacher exams");
					List<CourseReg> s = getAllregCourses();
					message.setCourses_list_from_server_reg(s);
					List<Questions> questions = getAllQuestions();
					List<ExamsScan> examsScans = getAllexamsscans();
					List<Exams> exams = getAllExams();
					message.setQuestions_list_from_server(questions);
					message.setExamsScans_list_from_server(examsScans);
					message.setExams_list_from_server(exams);
					message.setGrades_list_from_server(getAllgrades());
					message.setCourses_list_from_server(getAllCourses());

					client.sendToClient(message);
					//sendToAllClients(message);
				}


					 else if (request.equals("add note")) {

						message.setMessage("i will add note");
						updateExamscanStat(message.getCourseName(), String.valueOf(message.getStudentId()), message.getExam_id(), message.getQues_name(), message.getQues_note());
						client.sendToClient(message);
					}
				else if (request.equals("finish editing")) {

					message.setMessage("i finished editing");
					updateExamscanStat2(message.getCourseName(), String.valueOf(message.getStudentId()), message.getExam_id(), message.getQues_name(), message.getGrade_reason());
					client.sendToClient(message);

				}
					 else if (request.equals("give me students id")) {

						message.setMessage("i will give you students id");
						List<CourseReg> s = getAllregCourses();
						message.setCourses_list_from_server_reg(s);
						List<Questions> questions = getAllQuestions();
						List<ExamsScan> examsScans = getAllexamsscans();
						List<Exams> exams = getAllExams();
						message.setQuestions_list_from_server(questions);
						message.setExamsScans_list_from_server(examsScans);
						message.setExams_list_from_server(exams);
						client.sendToClient(message);


					} else if (request.equals("give me students id2")) {
						message.setMessage("i will give you students id2");
						List<CourseReg> s = getAllregCourses();
						message.setCourses_list_from_server_reg(s);
						List<Questions> questions = getAllQuestions();
						List<ExamsScan> examsScans = getAllexamsscans();
						List<Exams> exams = getAllExams();
						message.setQuestions_list_from_server(questions);
						message.setExamsScans_list_from_server(examsScans);
						message.setExams_list_from_server(exams);
						message.setDocuments_list_from_server(getAllLDecuments());
						message.setCourses_list_from_server(getAllCourses());
						client.sendToClient(message);
					}
				else if (request.equals("give me word scan")) {

					message.setMessage("i will give you word scan");
					List<CourseReg> s = getAllregCourses();
					message.setCourses_list_from_server_reg(s);
					List<Questions> questions = getAllQuestions();
					List<ExamsScan> examsScans = getAllexamsscans();
					List<Exams> exams = getAllExams();
					message.setQuestions_list_from_server(questions);
					message.setExamsScans_list_from_server(examsScans);
					message.setExams_list_from_server(exams);
					message.setDocuments_list_from_server(getAllLDecuments());
					client.sendToClient(message);
				}

					 else if (request.equals("give me exam questions")) {

						message.setMessage("i will give you exams questions");
						List<Questions> questions = getAllQuestions();
						List<ExamsScan> examsScans = getAllexamsscans();
						message.setQuestions_list_from_server(questions);
						message.setExamsScans_list_from_server(examsScans);
						client.sendToClient(message);
						//sendToAllClients(message);

					} else if (request.equals("Show Answers")) {

						message.setMessage("i will Show Answers");
						List<Questions> questions = getAllQuestions();
						List<ExamsScan> examsScans = getAllexamsscans();
						message.setQuestions_list_from_server(questions);
						message.setExamsScans_list_from_server(examsScans);
						client.sendToClient(message);

					} else if (request.equals("give me teacher data")) {

						message.setMessage("i will give you the teacher data");
						List<CourseReg> s = getAllregCourses();
						message.setCourses_list_from_server_reg(s);
						client.sendToClient(message);

					} else if (request.equals("give me mediator data")) {

						message.setMessage("i will give you the mediator data");
						List<CourseReg> s = getAllregCourses();
						message.setCourses_list_from_server_reg(s);
						client.sendToClient(message);

					} else if (request.equals("give me teacher stats")) {

						message.setMessage("i will give you the teacher stats");
						List<CourseReg> s = getAllregCourses();
						List<Lecturer> lec = getAllLecturers();
						message.setLecturers_list_from_server(lec);
						message.setCourses_list_from_server_reg(s);
						client.sendToClient(message);

					} else if (request.equals("show stats")) {

						message.setMessage("i will show stats");
						List<CourseReg> s = getAllregCourses();
						List<Lecturer> lec = getAllLecturers();
						List<Grade> grades = getAllgrades();
						message.setGrades_list_from_server(grades);
						message.setLecturers_list_from_server(lec);
						message.setCourses_list_from_server_reg(s);
						message.setExamInfos(getAllExamInfo());
						message.setExamsScans_list_from_server(getAllexamsscans());
						client.sendToClient(message);

					}
				else if (request.equals("give me exams info")){

					message.setMessage("i will give you exams info");
					message.setExamInfos(getAllExamInfo());
					client.sendToClient(message);

				}

					 else if (request.equals("update exam")) {

						Exams exams = message.getExam();
						updateExam(exams);
						message.setMessage("i updated the exam");
						client.sendToClient(message);

					} else if (request.equals("show exams")) {

						message.setMessage("i will give you the exams");
						List<Exams> exams = getAllExams();
						message.setExamsScans_list_from_server(getAllexamsscans());
						message.setExams_list_from_server(exams);
						message.setDocuments_list_from_server(getAllLDecuments());
						client.sendToClient(message);

					} else if (request.equals("add exam")) {
						 int allow=1;
						List<Exams> ex = getAllExams();
						for(Exams e : ex){
							if(e.getEid().equals(message.getExam().getEid())){
								message.setMessage("exam id already exists");
								client.sendToClient(message);
								allow=0;
							}
						}
						if(allow == 1) {
							Exams exam = message.getExam();
							generateExam(exam);
							message.setMessage("i added the exam");
							client.sendToClient(message);
						}
					} else if (request.equals("add ques to exam")) {
					int x=generateQuestion(message.getQuestion());
					if(x==1) {
						message.setMessage("question is already exist");
						client.sendToClient(message);
					}



					} else if (request.equals("start exam")) {

						if (message.getLogin_name().equals("teacher")) {

							updateExamStat(message.getExam().getId(), true, message.getTime());
						}
						generateExamInfo(message.getExamInfo());
						message.setCourseName(message.getExam().getCourse_name());
						message.setMessage("i will start exam");
						message.setExam_id(message.getExam().getId());
						client.sendToClient(message);
					} else if (request.equals("save data")) {
						message.setMessage("i will save data");
						ExamsScan exam = new ExamsScan(message.getStudentId(), message.getCourseName(), message.getExam_id(), message.getType(), message.getAns(), "False");
						generateExamsScan(exam);
						client.sendToClient(message);

					} else if (request.equals("exam is over")) {
						updateExamInfo(message.getExamInfo());
						message.setMessage("exam is over done");
						client.sendToClient(message);

					} else if (request.equals("end exam")) {
						message.setMessage("exam is over done");
						changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
						updateExamStat(message.getExam_id(), false, message.getTime());
						client.sendToClient(message);

					} else if (request.equals("show questions2")) {

						message.setMessage("i will show questions2");
						List<Questions> ques = getAllQuestions();
						List<Exams> exams = getAllExams();
						message.setExams_list_from_server(exams);
						message.setQuestions_list_from_server(ques);
						client.sendToClient(message);

					} else if (request.equals("the grade is")) {
						message.setMessage("the grade is");
						client.sendToClient(message);
				} else if (request.equals("extraTimeRequest")) {
						updateExam(message.getExam());
						message.setMessage("extra time request");
						sendToAllClients(msg);
					} else if (request.equals("extraTime")) {
						message.setMessage("extra time");
						sendToAllClients(message);
					} else if (request.equals("test it baby")) {
						message.setMessage("test");
						sendToAllClients2(message);
					} else if (request.equals("wrong code or id")) {
						client.sendToClient(message);
					} else if (request.equals("show mediator requests")) {
						 message.setMessage("i will show mediator requests");
						 List<CourseReg> courseRegs= getAllregCourses();
						 List<Exams> exams = getAllExams();
						 message.setExams_list_from_server(exams);
						 message.setCourses_list_from_server_reg(courseRegs);
						 client.sendToClient(message);
					}
				else if (request.equals("Wrong id or password")){
					client.sendToClient(message);

				}
				else if (request.equals("This id already exists check again please")){
					client.sendToClient(message);

				} else {
						sendToAllClients(message);
					}


				} catch(IOException e1){
					e1.printStackTrace();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				assert session != null;
				session.close();
			}

		}

		public void sendToAllClients (Message message){
			try {
				for (SubscribedClient SubscribedClient : SubscribersList) {
					SubscribedClient.getClient().sendToClient(message);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}


		public void sendToAllClients2 (Message message){
			try {
				for (SubscribedClient SubscribedClient : SubscribersList) {
					if (message.getId() == SimpleClient.ID)
						SubscribedClient.getClient().sendToClient(message);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}


	}
