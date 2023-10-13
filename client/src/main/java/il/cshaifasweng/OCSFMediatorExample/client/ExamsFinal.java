package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
public class ExamsFinal {
    private double time;
    private PauseTransition delay;
    @FXML
    private TableColumn<Exams, String> examsTablemini;
    @FXML
    private TextField timeT;
    @FXML
    private TableColumn<Exams, String> numberTable;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> coursesList;

    @FXML
    private TableView<Exams> examsTable;
    @FXML
    private ListView<String> examsList;
    @FXML
    void BackB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("ExamsPage");
    }


    @FXML
    void insetTime(ActionEvent event) {
        time=Double.parseDouble(timeT.getText());

    }
    @FXML
    void startB(ActionEvent event) throws IOException {
        // Create the PauseTransition with a 30-minute (1,800,000 ms) delay
        delay = new PauseTransition(Duration.millis(1000*60*60*time));

        // Set the action to be performed after the 30-minute delay
        delay.setOnFinished(e -> {
            // Perform your desired action here after the 30-minute delay
            Message msg = new Message("exam is over");
            System.out.println("over");
            msg.setExam(examsTable.getSelectionModel().getSelectedItem());
            sendMessage(msg);
        });

        // Start the delay
        delay.play();
        SimpleChatClient.setRoot("examInside");
        Message msg = new Message("start exam");
        //examsTable.getSelectionModel().getSelectedItem().setStat(1);
        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
        sendMessage(msg);


    }
    @FXML
    void showExams(ActionEvent event) {
        Message msg =new Message("show exams");
        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);
    }

@Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            coursesList.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();

            for (Course course : Courses_from_server) {
                // Set the data to the table
                coursesList.getItems().add(course.getName());
            }
            coursesList.refresh();
        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();


            examsTablemini.setCellValueFactory(new PropertyValueFactory<>("id"));
            numberTable.setCellValueFactory(new PropertyValueFactory<>("ques_number"));

            for(int i=1;i<exams.size();i++){
                if(coursesList.getSelectionModel().getSelectedItem().equals(exams.get(i).getCourse_name())){
                        examsTable.getItems().add(exams.get(i));
                }


            }
            examsTable.refresh();
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
    void sendMessage(String messageBody) {
        try {
            Message message = new Message( messageBody);

            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    void initialize() {
        EventBus.getDefault().register(this);
        sendMessage("give me the courses");
        assert coursesList != null : "fx:id=\"coursesList\" was not injected: check your FXML file 'examsFinal.fxml'.";
        assert examsTable != null : "fx:id=\"examsTable\" was not injected: check your FXML file 'examsFinal.fxml'.";

    }

}
