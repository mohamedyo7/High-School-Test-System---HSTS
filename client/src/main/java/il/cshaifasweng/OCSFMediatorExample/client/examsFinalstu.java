package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class examsFinalstu {
    Message msg = new Message("");

    public static String courseid;
    @FXML
    private TextField eCode;
    private double time;
    List<Exams> exams= new ArrayList<>() ;
    @FXML
    private TableColumn<Exams, String> examsTablemini;

    @FXML
    private TableColumn<Exams, String> numberTable;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField studenid;
    @FXML
    private ListView<String> coursesList;
    @FXML
    private TableView<Exams> examsTable;
    @FXML
    private ListView<String> examsList;

    @FXML
    private Button start_b;
    @FXML
    void BackB(ActionEvent event) throws IOException {
            Message msg = new Message("give me student data");
            sendMessage(msg);
            SimpleChatClient.setRoot("StudentController");}

    @FXML
    void startB(ActionEvent event) throws IOException {
        if(examsTable.getSelectionModel().getSelectedItem().getCode().equals(eCode.getText())&&Integer.parseInt(studenid.getText())==SimpleClient.ID){
            msg.setMessage("start exam");
            msg.setLogin_name("student");
            ExamInfo examInfo=new ExamInfo();
            examInfo.setExam_id(examsTable.getSelectionModel().getSelectedItem().getId());
            examInfo.setCourseid(examsTable.getSelectionModel().getSelectedItem().getCourse_name());
            examInfo.setStudentid(SimpleClient.ID);
            msg.setExamInfo(examInfo);
            msg.setExam(examsTable.getSelectionModel().getSelectedItem());
            msg.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));
            msg.setCourse_id(Integer.parseInt(courseid));
            SimpleChatClient.setRoot("examInside");
            sendMessage(msg);

            } else{
                System.out.println("Wrong code or id");
                sendMessage("wrong code or id");}
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

                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();
                List<Exams>Exams_from_server=event.getMessage().getExams_list_from_server();
                List<Course>courses=event.getMessage().getCourses_list_from_server();


                for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                    // Set the data to the table
                    if (Courses_from_server_reg.get(i).getStudent() != null)
                        if (Courses_from_server_reg.get(i).getStudent().getId() == SimpleClient.ID) {
                            for (int j = 0; j < Exams_from_server.size(); j++) {
                                if (Courses_from_server_reg.get(i).getName().equals(Exams_from_server.get(j).getCourse_name()))
                                    if (Exams_from_server.get(j).getStat()) {
                                        exams.add(Exams_from_server.get(j));
                                        coursesList.getItems().add(Courses_from_server_reg.get(i).getName());
                                        for (int x = 0; x < courses.size(); x++) {
                                            if (Courses_from_server_reg.get(i).getName().equals(courses.get(x).getName()))
                                                courseid = String.valueOf(courses.get(x).getId());
                                        }
                                    }
                            }

                        }

                }

                coursesList.refresh();

        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();
            List<ExamsScan>examScanList=event.getMessage().getExamsScans_list_from_server();


            examsTablemini.setCellValueFactory(new PropertyValueFactory<>("id"));
            numberTable.setCellValueFactory(new PropertyValueFactory<>("ques_number"));

            for(int i=1;i<exams.size();i++){
                if(coursesList.getSelectionModel().getSelectedItem()!=null)
                    if(coursesList.getSelectionModel().getSelectedItem().equals(exams.get(i).getCourse_name())){
                        examsTable.getItems().add(exams.get(i));
                    }


            }
            for(int i=0;i<examScanList.size();i++) {
                if (examScanList.get(i).getStudent_ID() == SimpleClient.ID) {
                    if (coursesList.getSelectionModel().getSelectedItem().equals(examScanList.get(i).getName())){
                        for(int j=0;j<examsTable.getItems().size();j++){
                            if(examsTable.getItems().get(j).getId()==examScanList.get(i).getExam_ID()&&examScanList.get(i).getStudent_state_tostart().equals("false"))
                                examsTable.getItems().remove(j);
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
