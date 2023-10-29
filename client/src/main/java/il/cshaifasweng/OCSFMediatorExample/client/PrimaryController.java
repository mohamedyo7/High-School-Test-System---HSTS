package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.sql.SQLException;
import java.util.List;


/**
 * Sample Skeleton for 'primary.fxml' Controller Class
 */


public class PrimaryController {

	private int msgId;

	@FXML
	private Button change_but;

	@FXML
	private Label choosestudent_gradeupdate_label;

	@FXML
	private Label choosestudent_view_label;


	@FXML
	private Label insert_new_grade_label;

	@FXML
	private TextField new_grade_txf;

	@FXML
	private Button show_grade_but;

	@FXML
	private Button show_student_after_update_but;

	@FXML
	private Label showallstudent_label;

	@FXML
	private Button showallstudents_but;

	@FXML
	private Label showstudent_grades_after_update_label;


	@FXML
	private Label time_label;

	@FXML
	private TextField time_txf;


	@FXML
	private TableView<Student> show_all_students_table;
	@FXML
	private TableColumn<Student, String> first_name_column;

	@FXML
	private TableColumn<Student, String> last_name_column;

	@FXML
	void BackB(ActionEvent event) throws IOException {
	SimpleChatClient.setRoot("TeacherPage");
	}
	@FXML
	private TableColumn<Student, Integer> student_id_column;

	@FXML
	private TableView<Grade> course_grade_table;

	@FXML
	private TableColumn<Grade, String> course_column;


	@FXML
	private TableColumn<Grade, Integer> grade_column;

	private  Student student_save;

	@FXML
	private ListView<String> ID_prime;




	void sendMessage(String messageBody) {
		try {
			Message message = new Message(messageBody);

			SimpleClient.getClient().sendToServer(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void sendMessage(Message message) {

		try {
			SimpleClient.getClient().sendToServer(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@FXML
	void on_button_show_after_update_pressed(ActionEvent event) {
		if (student_save != null) {
			showstudent_grades_after_update_label.setVisible(true);
			show_student_after_update_but.setVisible(true);
			Message message = new Message("give me the student grades");
			message.setStudentId(student_save.getStudent_id());
			sendMessage(message);
			/*try {

				SimpleClient.getClient().sendToServer(message);
				message.setStudentId(student_save.getStudent_id());
				sendMessage(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

		}


	}
	@FXML
	void Back_but(ActionEvent event)throws IOException {
		if(ID_prime.getItems().get(1).equals("Teacher")) {
			SimpleChatClient.setRoot("TeacherPage");
			Message msg = new Message("give me teacher data");
			msg.setId(Integer.parseInt(ID_prime.getItems().get(0)));
			sendMessage(msg);
		}
		else if(ID_prime.getItems().get(1).equals("Mediator")){
			SimpleChatClient.setRoot("MediatorPage");
			Message msg=new Message("give me mediator data");
					msg.setId(Integer.parseInt(ID_prime.getItems().get(0)));
					msg.setLogin_name("Mediator");
			sendMessage(msg);
		}

	}

	@FXML
	void on_show_all_students_pressed(ActionEvent event) throws SQLException {
		/*show_all_students_table.setVisible(true);
		show_grade_but.setVisible(true);
		choosestudent_view_label.setVisible(true);*/
		sendMessage("give me the students");

	}

	@FXML
	void on_button_show_grades_pressed(ActionEvent event) {
		Student selectedItem = show_all_students_table.getSelectionModel().getSelectedItem();
		student_save=selectedItem;
		if (selectedItem != null) {

			Message message = new Message( "give me the student grades");
			message.setStudentId(selectedItem.getStudent_id());
			sendMessage(message);

		}
		}

	@FXML
	void on_button_change_clicked(ActionEvent event) {
		Grade selectedItem = course_grade_table.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {

			if(!new_grade_txf.getText().isBlank())
			{
				course_grade_table.setVisible(true);
				Message message = new Message("change the student grade");
				message.setStudentId(selectedItem.getStudent_id());
				//message.setCourse_id(selectedItem.getCourse());
				message.setGrade_to_change( Integer.parseInt(new_grade_txf.getText()));
				message.setCourse_id(selectedItem.getCourseid());
				choosestudent_gradeupdate_label.setVisible(true);
				insert_new_grade_label.setVisible(true);
				new_grade_txf.setVisible(true);
				change_but.setVisible(true);
				sendMessage(message);
			}
			else {
				sendMessage("");
			}

		}
		else{
			sendMessage("");
		}
	}

	@Subscribe
	public void errorEvent(ErrorEvent event){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		Platform.runLater(() -> {
			Alert alert = new Alert(Alert.AlertType.ERROR,
					String.format("Message:\nId: %d\nData: %s\nTimestamp: %s\n",
							event.getMessage().getId(),
							event.getMessage().getMessage(),
							event.getMessage().getTimeStamp().format(dtf))
			);
			alert.setTitle("Error!");
			alert.setHeaderText("Error:");
			alert.show();
		});
	}

	@Subscribe
	public void setDataFromServerTF(MessageEvent event) {
		if (event.getMessage().getMessage().equals("i will give you the students")) {
			if(ID_prime.getItems().isEmpty()){
				ID_prime.getItems().add (String.valueOf(event.getMessage().getId()));
				ID_prime.getItems().add(event.getMessage().getLogin_name());
			}
			if(ID_prime.getItems().get(1).equals("Mediator")) {
				insert_new_grade_label.setVisible(false);
				new_grade_txf.setVisible(false);
				change_but.setVisible(false);
				showstudent_grades_after_update_label.setVisible(false);
				show_student_after_update_but.setVisible(false);
				insert_new_grade_label.setVisible(false);
				choosestudent_gradeupdate_label.setVisible(false);
				choosestudent_gradeupdate_label.setVisible(false);
				showallstudents_but.setVisible(false);

			}
			showallstudents_but.setVisible(false);

			List<Student> students_from_server = event.getMessage().getStudents_list_from_server();

			show_all_students_table.getItems().clear();
			show_all_students_table.refresh();

			// Set up the columns
			student_id_column.setCellValueFactory(new PropertyValueFactory<>("student_id"));
			last_name_column.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			first_name_column.setCellValueFactory(new PropertyValueFactory<>("firstName"));

			for (int i = 0; i < students_from_server.size(); i++) {
				show_all_students_table.getItems().add(students_from_server.get(i));
			}

		} else if (event.getMessage().getMessage().equals("i will give you the student grades")) {

			course_column.setCellValueFactory(new PropertyValueFactory<>("course"));
			course_column.setCellValueFactory(new PropertyValueFactory<>("Grade"));
			course_grade_table.setVisible(true);
			if(ID_prime.getItems().get(1).equals("Mediator")) {
				insert_new_grade_label.setVisible(false);
				new_grade_txf.setVisible(false);
				change_but.setVisible(false);
				showstudent_grades_after_update_label.setVisible(false);
				show_student_after_update_but.setVisible(false);
				insert_new_grade_label.setVisible(false);
				choosestudent_gradeupdate_label.setVisible(false);
				choosestudent_gradeupdate_label.setVisible(false);
				showallstudents_but.setVisible(false);

			}
			else {
				choosestudent_gradeupdate_label.setVisible(true);
				insert_new_grade_label.setVisible(true);
				new_grade_txf.setVisible(true);
				change_but.setVisible(true);
				showstudent_grades_after_update_label.setVisible(true);
				show_student_after_update_but.setVisible(true);
				showallstudents_but.setVisible(false);
			}
			showallstudents_but.setVisible(false);

			List<Grade> grades_list_from_server1 = event.getMessage().getGrades_list_from_server();


			course_grade_table.getItems().clear();
			course_grade_table.refresh();
			grade_column.setCellValueFactory(new PropertyValueFactory<>("grade"));
			course_column.setCellValueFactory(new PropertyValueFactory<>("courseName"));

			for (int i = 0; i < grades_list_from_server1.size(); i++) {
				if (grades_list_from_server1.get(i).getStudent().getStudent_id() == event.getMessage().getStudentId())
					// Set the data to the table
					course_grade_table.getItems().add(grades_list_from_server1.get(i));
			}
		} else if (event.getMessage().getMessage().equals("i changed the grade")) {
			new_grade_txf.setText("");
			Student student = course_grade_table.getSelectionModel().getSelectedItem().getStudent();

			showstudent_grades_after_update_label.setVisible(true);
			show_student_after_update_but.setVisible(true);

		} else {
			if (ID_prime.getItems().isEmpty()) {
				ID_prime.getItems().add(String.valueOf(event.getMessage().getId()));

			}

		}
	}


	@FXML
	void initialize() {

		EventBus.getDefault().register(this); /// this line did lot of problems to me!!

		msgId = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			LocalTime currentTime = LocalTime.now();
			time_txf.setText(currentTime.format(dtf));
		}),
				new KeyFrame(Duration.seconds(1))
		);

		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();

/*		try {
			Message message = new Message(msgId, "add client");
			SimpleClient.getClient().sendToServer(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


		show_all_students_table.setVisible(true);
		change_but.setVisible(true);
		course_grade_table.setVisible(true);
		insert_new_grade_label.setVisible(true);
		new_grade_txf.setVisible(true);
		change_but.setVisible(true);
		showstudent_grades_after_update_label.setVisible(true);
		show_student_after_update_but.setVisible(true);
		show_grade_but.setVisible(true);
		choosestudent_gradeupdate_label.setVisible(true);
		choosestudent_view_label.setVisible(true);
	}


}