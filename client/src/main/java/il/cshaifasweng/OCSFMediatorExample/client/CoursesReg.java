package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class CoursesReg {

    @FXML
    private ListView<String> Reg_Courses_Table;

    @FXML
    void Back_Reg(ActionEvent event) throws IOException {
       SimpleChatClient.setRoot("FirstPage");

    }

    @FXML
    void Reg_but(ActionEvent event) {

        String Name= Reg_Courses_Table.getSelectionModel().getSelectedItem();
        if(Name!= null) {
            int s;
            Message msg = new Message("register the course");
           msg.setLogin_name(STD_ID_Reg.getItems().get(1));
            s= Integer.parseInt(STD_ID_Reg.getItems().get(0));
            msg.setCourseName(Name);
            CourseReg cor=new CourseReg(Name);
          msg.setCourse(cor);
          msg.setId(s);
            sendMessage(msg);

        }
        else sendMessage("");;


    }
    @FXML
    private ListView<String> STD_ID_Reg;


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
            if (STD_ID_Reg.getItems().isEmpty())
                STD_ID_Reg.getItems().add(String.valueOf(event.getMessage().getStudentId()));
            Reg_Courses_Table.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
            System.out.println(event.getMessage().getStudentId());

            for (int i = 0; i < Courses_from_server.size(); i++) {
                // Set the data to the table
                //if(Courses_from_server.get(i).getName().equals(Std_name.getText()))
                Reg_Courses_Table.getItems().add(Courses_from_server.get(i).getName());
                // System.out.println(Courses_from_server.get(i).getName());
            }
            Reg_Courses_Table.refresh();
        }
        else if (event.getMessage().getMessage().equals("i will give you the students")) {
            List<Student> students_from_server = event.getMessage().getStudents_list_from_server();

        }
        else if (event.getMessage().getMessage().equals("I Saved The Student Details")) {
            if (STD_ID_Reg.getItems().isEmpty()) {
                STD_ID_Reg.getItems().add(String.valueOf(event.getMessage().getId()));
                STD_ID_Reg.getItems().add(event.getMessage().getLogin_name());
            }
            Reg_Courses_Table.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
            for (int i = 0; i < Courses_from_server.size(); i++) {

                Reg_Courses_Table.getItems().add(Courses_from_server.get(i).getName());

            }
            Reg_Courses_Table.refresh();
        }
        else if (event.getMessage().getMessage().equals("I Saved The Teacher Details")) {
            if (STD_ID_Reg.getItems().isEmpty()) {
                STD_ID_Reg.getItems().add(String.valueOf(event.getMessage().getId()));
                STD_ID_Reg.getItems().add(event.getMessage().getLogin_name());
            }
            Reg_Courses_Table.getItems().clear();
            List<Course> Courses_from_server = event.getMessage().getCourses_list_from_server();
            for (int i = 0; i < Courses_from_server.size(); i++) {

                Reg_Courses_Table.getItems().add(Courses_from_server.get(i).getName());

            }
            Reg_Courses_Table.refresh();
        }
        else if (event.getMessage().getMessage().equals("course has been registered")) {
          /*  if(STD_ID.getItems().isEmpty()) {
                STD_ID.getItems().add(String.valueOf(event.getMessage().getStudentId()));


            }*/
            List<Student> s1 = event.getMessage().getStudents_list_from_server();


            //System.out.println(s1.get(0).getCoursesReg() + "tq");


        }


        }


    @FXML
    void initialize() {
        EventBus.getDefault().register(this);
        // sendMessage("give me the courses");
    }

}
