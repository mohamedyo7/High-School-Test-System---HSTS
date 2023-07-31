package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.SubscribedClient;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
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
	private static <T> List<T> getAll(Class<T> object) {


		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(object);
		Root<T> rootEntry = criteriaQuery.from(object);
		CriteriaQuery<T> allCriteriaQuery = criteriaQuery.select(rootEntry);
		TypedQuery<T> allQuery = session.createQuery(allCriteriaQuery);
		return allQuery.getResultList();
	}
	public static List<Student> getAllStudents() throws Exception {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		query.from(Student.class);
		List<Student> data = session.createQuery(query).getResultList();
		return data;
	}
	public static List<Grade> getGradesByStudentId(int studentId) throws Exception{

		// System.out.println("getGradesByStudentId Begin");

		boolean found=false;

		List<Student> students = getAll(Student.class);
		for(int i =0;i<students.size() && !found ;i++)
		{
			if(students.get(i).getStudent_id()==studentId) {
				found=true;
			}
		}
		if(found)
		{
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
			Root<Grade> gradeRoot = query.from(Grade.class);
			Join<Grade, Student> studentJoin = gradeRoot.join("student");
			query.select(gradeRoot).where(builder.equal(studentJoin.get("student_id"), studentId));
			List<Grade> grades = session.createQuery(query).getResultList();
			return grades;
		}
		return null;

		// System.out.println("getGradesByStudentId End");

	}


	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Message message = (Message) msg;
			String request = message.getMessage();

			try {
				//we got an empty message, so we will send back an error message with the error details
				if (request.isBlank()) {
					message.setMessage("Error! we got an empty message"); //see simpleclient handle messagefromserver
					client.sendToClient(message);
				} else if (request.equals("add client")) {
					SubscribedClient connection = new SubscribedClient(client);
					SubscribersList.add(connection);
					message.setMessage("client added successfully");
					client.sendToClient(message);
				} else if (request.equals("give me the students")) {

					message.setMessage("i will give you the students");
					message.setStudents_list_from_server(getAllStudents());
					client.sendToClient(message);

				} else if (request.equals("give me the student grades")) {
					Message msg2=new Message(177,"smeer");
					//  System.out.println("i am here");
					//msg2.setStudents_list_from_server(getAllStudents());
					//client.sendToClient(msg2);

					//  System.out.println("the id is :" + message.getStudentId());
					//message.setGrades_list_from_server(getGradesByStudentId(message.getStudentId()));
					message.setCourses_list_from_server(getAllCoursess());
					message.setMessage("i will give you the student grades");



					// System.out.println("back from getgradesbystudent");

					client.sendToClient(message);
					//client.sendToClient(msg2);


				} else if (request.equals("change the student grade")) {

					////
					// System.out.println("i am here");
					// System.out.println("the student to change his grade is:" + message.getStudentId());
					//  System.out.println("the course id that we want to change it's grade is:" + message.getCourse_id());
					//   System.out.println("change grade to:" + message.getGrade_to_change());

					changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());

					//  System.out.println("i finished");

					message.setMessage("i changed the grade");
					client.sendToClient(message);


				} else {
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