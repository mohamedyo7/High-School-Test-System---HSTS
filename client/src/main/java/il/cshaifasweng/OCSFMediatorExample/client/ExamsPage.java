package il.cshaifasweng.OCSFMediatorExample.client;

import com.google.protobuf.StringValue;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;import javafx.scene.text.Text;
public class ExamsPage {
    Exams exam = new Exams();
    @FXML
    private Text errorText;
    @FXML
    private Text errorText2;
    String courseid;
    int qnum;
    @FXML
    private TextField exam_id;
    @FXML
    private ResourceBundle resources;
    @FXML
    private TableColumn<Questions, String> tablecol;
    @FXML
    private TableView<Questions> tableviewq;
    @FXML
    private TextField eCode;
    @FXML
    private URL location;
    @FXML
    private ListView<String> coursesList;

/*
    @FXML
    private ListView<Questions> questionsList;
*/

    @FXML
    void BackB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("TeacherEamsController");
    }

    @FXML
    void DoneB(ActionEvent event) throws IOException {

        Message msg = new Message("update exam");
        exam.setTeacherName(SimpleClient.name);
        exam.setTeacherID(String.valueOf(SimpleClient.ID));

        exam.setQues_number(qnum);
        exam.setCode(eCode.getText());
        msg.setExam(exam);
        if(!exam_id.getText().isEmpty()){
            msg.setExam_id(exam_id.getText() + courseid + courseid);
            msg.setId(Integer.parseInt(exam_id.getText()));}
        sendMessage(msg);
        SimpleChatClient.setRoot("examsFinal");
    }

    @FXML
    void addToExamB(ActionEvent event) {
        Questions ques = tableviewq.getSelectionModel().getSelectedItem();
        ques.setQues_id(exam_id.getText() + SimpleClient.getCourderid(coursesList.getSelectionModel().getSelectedItem()) + SimpleClient.getCourderid(coursesList.getSelectionModel().getSelectedItem()));
        exam.setId(exam_id.getText() + courseid + courseid);
        ques.setToShow(false);
        Message msg = new Message("add ques to exam");
        msg.setQuestion(ques);
        sendMessage(msg);
        qnum++;

        //exam.setCourse_name(coursesList.getSelectionModel().getSelectedItem());

    }

    @FXML
    void deleteQuesB(ActionEvent event) {
/*        String name = questionsList.getSelectionModel().getSelectedItem();
        Message msg = new Message("delete question");
        msg.setCourseName(name);
        sendMessage(msg);*/
    }

    @FXML
    void insert_id(ActionEvent event) {
        errorText.setText(" ");
        errorText2.setText(" ");
        int allow = 1;
        if (exam_id.getText().length() != 2) {
            errorText.setText("Error ! exam id should be 2 digits");
            allow = 0;
        }
        if (eCode.getText().length() != 4) {
            errorText2.setText("Error ! Exam Code should be 4 digits");
            allow = 0;
        }
        if (allow == 1) {
            errorText.setText(" ");
            errorText2.setText(" ");
            Message msg = new Message("add exam");
            courseid = SimpleClient.getCourderid(coursesList.getSelectionModel().getSelectedItem());
            String id = exam_id.getText() + courseid;
            exam.setId(exam_id.getText() + courseid + courseid);
            exam.setEid(exam_id.getText() + courseid + courseid);
            exam.setCourse_name(coursesList.getSelectionModel().getSelectedItem());
            msg.setExam(exam);
            sendMessage(msg);
        }
    }
    @FXML
    void showQuestionsB(ActionEvent event) {
        Message msg=new Message("show questions");
        exam.setId(exam_id.getText() + courseid + courseid);
        exam.setEid(exam_id.getText() + courseid + courseid);
        msg.setExam(exam);
/*        msg.setMessage("update exam");
        sendMessage(msg)*/;
        msg.setMessage("show questions");
       // msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);

    }
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            coursesList.getItems().clear();
            List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();

            for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                // Set the data to the table
                if (Courses_from_server_reg.get(i).getLecturer() != null)
                    if (Courses_from_server_reg.get(i).getLecturer().getId() == SimpleClient.ID) {

                        coursesList.getItems().add(Courses_from_server_reg.get(i).getName());
                    }

            }
            coursesList.refresh();
        }
        if(event.getMessage().getMessage().equals("i will show questions")){
            tableviewq.getItems().clear();
            List<Questions> ques = event.getMessage().getQuestions_list_from_server();
            tablecol.setCellValueFactory(new PropertyValueFactory<>("question"));
            exam.setCourse_name(coursesList.getSelectionModel().getSelectedItem());
            for(int i=0;i<ques.size();i++){
                if(coursesList.getSelectionModel().getSelectedItem()!=null)
                if(coursesList.getSelectionModel().getSelectedItem().equals(ques.get(i).getCourse_name())){
                    if(ques.get(i).isToShow())
                    tableviewq.getItems().add(ques.get(i));
                }

            }
            tableviewq.refresh();
        }
        if(event.getMessage().getMessage().equals("exam id already exists")){
            errorText.setText("Error ! exam id already exists");

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
        qnum=0;
        sendMessage("give me the courses");

            assert coursesList != null : "fx:id=\"coursesList\" was not injected: check your FXML file 'ExamsPage.fxml'.";
            assert exam_id != null : "fx:id=\"exam_id\" was not injected: check your FXML file 'ExamsPage.fxml'.";
           // assert questionsList != null : "fx:id=\"questionsList\" was not injected: check your FXML file 'ExamsPage.fxml'.";

    }

}
