package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExamsFinal {
    private double time;
    private PauseTransition delay;
    @FXML
    private TextField timeT;
    @FXML
    private TableColumn<Exams, String> examsTablemini;

    @FXML
    private TableColumn<Exams, String> numberTable;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> coursesList;
    @FXML
    void insetTime(ActionEvent event) {
        time=Double.parseDouble(timeT.getText());

    }
    @FXML
    private TableView<Exams> examsTable;
    @FXML
    private ListView<String> examsList;

    @FXML
    private Button start_b;
    @FXML
    void BackB(ActionEvent event) throws IOException {
        if(SimpleClient.Type.equals("Teacher"))
        SimpleChatClient.setRoot("ExamsPage");
        else if(SimpleClient.Type.equals("Student"))
            SimpleChatClient.setRoot("StudentController");
    }

    @FXML
    void startB(ActionEvent event) throws IOException {
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
        if(SimpleClient.Type.equals("Student"))
        SimpleChatClient.setRoot("examInside");
        Message msg = new Message("start exam");
        //examsTable.getSelectionModel().getSelectedItem().setStat(1);
        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
        msg.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));
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
            if(SimpleClient.Type.equals("Teacher")) {

                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();

                for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                    // Set the data to the table
                    if (Courses_from_server_reg.get(i).getLecturer() != null)
                        if (Courses_from_server_reg.get(i).getLecturer().getId() == SimpleClient.ID) {

                            coursesList.getItems().add(Courses_from_server_reg.get(i).getName());
                        }

                }
            }
            else if(SimpleClient.Type.equals("Student")){
                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();
                List<Exams>Exams_from_server=event.getMessage().getExams_list_from_server();

                for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                    // Set the data to the table
                    if (Courses_from_server_reg.get(i).getLecturer() != null)
                        if (Courses_from_server_reg.get(i).getLecturer().getId() == SimpleClient.ID) {
                            for(int j=0;j<Exams_from_server.size();j++){
                                if(Courses_from_server_reg.get(i).getName().equals(Exams_from_server.get(j).getCourse_name()))
                                    if(Exams_from_server.get(j).getStat())
                                        coursesList.getItems().add(Courses_from_server_reg.get(i).getName());
                            }


                        }

                }
            }
            coursesList.refresh();
        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();


            examsTablemini.setCellValueFactory(new PropertyValueFactory<>("id"));
            numberTable.setCellValueFactory(new PropertyValueFactory<>("ques_number"));

            for(int i=1;i<exams.size();i++){
                if(coursesList.getSelectionModel().getSelectedItem()!=null)
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
