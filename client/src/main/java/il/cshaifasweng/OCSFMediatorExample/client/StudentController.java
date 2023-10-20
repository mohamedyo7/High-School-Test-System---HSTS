package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class StudentController {


    @FXML
    private TextField Std_name;

    @FXML
    private ListView<String> Student_Courses_Table;

    @FXML
    void Show_Scan(ActionEvent event) throws IOException {
        String Name= Student_Courses_Table.getSelectionModel().getSelectedItem();
        Message msg=new Message("give me exams scans");
        SimpleChatClient.setRoot("ScanPage");
        msg.setCourseName(Name);
        msg.setId(SimpleClient.ID);
        sendMessage(msg);

    }
    @FXML
    private ListView<String> STD_ID;

    @FXML
    void Show_grades(ActionEvent event) {
         String Name= Student_Courses_Table.getSelectionModel().getSelectedItem();
         if(Name!= null) {
             int s;
             Message msg = new Message("give me the student grades");
            s= Integer.parseInt(STD_ID.getItems().get(0));
             msg.setStudentId(s);
             msg.setId(s);
             sendMessage(msg);
         }
         else sendMessage("");;

    }
    @FXML
    void logout_but(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("FirstPage");
    }

    @FXML
    void Start_Exam(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("examsFinalstu");

    }
    @FXML
    void Reg_Courses(ActionEvent event) throws IOException {
       SimpleChatClient.setRoot("CoursesReg");
        Message msg = new Message("give me the courses");
       msg.setStudentId(Integer.parseInt(STD_ID.getItems().get(0)));
        sendMessage(msg);
    }
    @FXML
    private ListView<String> Grade_Text;
    @FXML
    private TextArea grade_show;


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
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {
            if (STD_ID.getItems().isEmpty()) {
                STD_ID.getItems().add(String.valueOf(event.getMessage().getStudentId()));
            }
        }
         else if (event.getMessage().getMessage().equals("i will give you the student grades")) {

            grade_show.clear();


            String s="null";


            List<Grade> grades_list_from_server1 = event.getMessage().getGrades_list_from_server();


            for (int i = 0; i < grades_list_from_server1.size(); i++) {
                if(grades_list_from_server1.get(i).getStudent().getStudent_id()==event.getMessage().getId()) {
                    if (grades_list_from_server1.get(i).getCourseName().equals(Student_Courses_Table.getSelectionModel().getSelectedItem())) {
                       s= (grades_list_from_server1.get(i).getGrade());
                        grade_show.setText((s));

                    }

                }
            }
        }
        else if (event.getMessage().getMessage().equals("i will give you the student data")) {
            int s=0;
            if (STD_ID.getItems().isEmpty()) {
                STD_ID.getItems().add(String.valueOf(SimpleClient.ID));
            }
                Student_Courses_Table.getItems().clear();
                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();

                for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                    // Set the data to the table
                    if(Courses_from_server_reg.get(i).getStudent()!=null)
                    if(Courses_from_server_reg.get(i).getStudent().getStudent_id()==SimpleClient.ID){
                        Student_Courses_Table.getItems().add(Courses_from_server_reg.get(i).getName());
                    }
                }
                Student_Courses_Table.refresh();



        }


    }

    @FXML
    void initialize() {
        EventBus.getDefault().register(this);
        int msgId = 0;
        try {
            Message message = new Message(msgId, "add client");
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Message msg=new Message("test it baby");
        msg.setToid(7);
        sendMessage(msg);
        sendMessage("give me student data");
        //sendMessage("Show The Courses");

    }
}
