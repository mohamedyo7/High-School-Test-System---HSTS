package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamsScan;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExamsFinal {

    public static String courseid;
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
        else if(SimpleClient.Type.equals("Student")){
            Message msg = new Message("give me student data");
            sendMessage(msg);
            SimpleChatClient.setRoot("StudentController");}
    }

    @FXML
    void startB(ActionEvent event) throws IOException {
      /*  delay = new PauseTransition(Duration.millis(1000*60*60*time));

        delay.setOnFinished(e -> {
            Message msg = new Message("exam is over");
            System.out.println("over");
            msg.setExam(examsTable.getSelectionModel().getSelectedItem());
            sendMessage(msg);
        });*/

        //delay.play();
        Message msg = new Message("start exam");
        if(SimpleClient.Type.equals("Student")) {
            SimpleChatClient.setRoot("examInside");

            msg.setStudentId(SimpleClient.ID);
        }
        msg.setLogin_name(SimpleClient.Type);

        //examsTable.getSelectionModel().getSelectedItem().setStat(1);
        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
        msg.setId(examsTable.getSelectionModel().getSelectedItem().getId());
        msg.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));



        sendMessage(msg);


    }
    @FXML
    void showExams(ActionEvent event) {
        Message msg =new Message("show exams");
        msg.setLogin_name(SimpleClient.Type);
        msg.setId(SimpleClient.ID);
        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);
    }

@Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            int c=0;

            coursesList.getItems().clear();
            if(SimpleClient.Type.equals("Teacher")) {

                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();
                List<Course>courses=event.getMessage().getCourses_list_from_server();

                for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                    // Set the data to the table
                    if (Courses_from_server_reg.get(i).getLecturer() != null)
                        if (Courses_from_server_reg.get(i).getLecturer().getId() == SimpleClient.ID) {
                                coursesList.getItems().add(Courses_from_server_reg.get(i).getName());


                            for(int j=0;j<courses.size();j++){
                                if(Courses_from_server_reg.get(i).getName().equals(courses.get(j).getName()))
                                    courseid= String.valueOf(courses.get(j).getId());
                            }

                        }

                }
            }
            else if(SimpleClient.Type.equals("Student")){
                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();
                List<Exams>Exams_from_server=event.getMessage().getExams_list_from_server();
                List<Course>courses=event.getMessage().getCourses_list_from_server();
                List<ExamsScan>examsScanList=event.getMessage().getExamsScans_list_from_server();

                for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                    // Set the data to the table
                    if (Courses_from_server_reg.get(i).getStudent() != null)
                        if (Courses_from_server_reg.get(i).getStudent().getId() == SimpleClient.ID) {
                            for(int j=0;j<Exams_from_server.size();j++){
                                if(Courses_from_server_reg.get(i).getName().equals(Exams_from_server.get(j).getCourse_name()))
                                    if(Exams_from_server.get(j).getStat()) {
                                        for(int x=0;x<coursesList.getItems().size();x++){
                                            System.out.println(coursesList.getItems().get(x)+"course");
                                            System.out.println(Courses_from_server_reg.get(i).getName()+"coursereg");
                                            if(coursesList.getItems().get(x).equals(Courses_from_server_reg.get(i).getName())) {
                                                c = 1;
                                                break;
                                            }

                                        }
                                        if(c==0)
                                        coursesList.getItems().add(Courses_from_server_reg.get(i).getName());

                                        for(int x=0;x<courses.size();x++){
                                            if(Courses_from_server_reg.get(i).getName().equals(courses.get(x).getName()))
                                                courseid= String.valueOf(courses.get(x).getId());
                                        }
                                    }
                            }


                        }

                }
            }
            coursesList.refresh();
        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();
            List<ExamsScan>examsScanList=event.getMessage().getExamsScans_list_from_server();


            examsTablemini.setCellValueFactory(new PropertyValueFactory<>("id"));
            numberTable.setCellValueFactory(new PropertyValueFactory<>("ques_number"));

            for(int i=1;i<exams.size();i++){
                    if (coursesList.getSelectionModel().getSelectedItem() != null) {
                        if (coursesList.getSelectionModel().getSelectedItem().equals(exams.get(i).getCourse_name())) {
                            examsTable.getItems().add(exams.get(i));
                        }
                    }
                }
            if(event.getMessage().getLogin_name().equals("Student")) {
                for(int i=0;i<examsScanList.size();i++){
                    if(examsScanList.get(i).getStudent_ID()==event.getMessage().getId()) {
                        for (int j = 0; j < examsTable.getItems().size(); j++) {

                            if (examsTable.getItems().get(j).getId() == examsScanList.get(i).getExam_ID() && examsTable.getItems().get(j).getCourse_name().equals(examsScanList.get(i).getName())) {
                                for(int x=0;x<exams.size();x++){
                                    if(exams.get(x).getId()==examsTable.getItems().get(j).getId()&&exams.get(x).getCourse_name().equals(examsTable.getItems().get(j).getCourse_name())) {
                                        if (!exams.get(x).getStat())
                                            examsTable.getItems().remove(j);
                                    }
                                }

                            }
                        }
                    }
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
