package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Lecturer;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Mediator;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class RegisterPage {

    @FXML
    private TextField FirstName_Text;

    @FXML
    private TextField ID_Text;

    @FXML
    private TextField LastName_Text;

    @FXML
    private TextField Password_Text;
    @FXML
    private ChoiceBox<String> choose_Login;

    int c=0;

    @FXML
    void Back_RegLogin_but(ActionEvent event) throws IOException {
SimpleChatClient.setRoot("FirstPage");
    }

    @FXML
    void Reg_Done(ActionEvent event) throws IOException {
        //SimpleChatClient.setRoot("CoursesReg");
        Message msg=new Message("");
        if(choose_Login.getSelectionModel().getSelectedItem().equals("Student")) {
            msg.setMessage("check id exist");
           // msg.setMessage("Save The Student Details");
            msg.setId(Integer.parseInt(ID_Text.getText()));
            msg.setFirst_name(FirstName_Text.getText());
            msg.setLast_name(LastName_Text.getText());
            msg.setPassword(Password_Text.getText());
            msg.setLogin_name("Student");
            Student s=new Student(msg.getId(), msg.getFirst_name(), msg.getLast_name(), msg.getPassword());
            msg.setStudent(s);


        }
        if(choose_Login.getSelectionModel().getSelectedItem().equals("Teacher")) {
            msg.setMessage("check id exist");
            //msg.setMessage("Save The Teacher Details");
            msg.setId(Integer.parseInt(ID_Text.getText()));
            msg.setFirst_name(FirstName_Text.getText());
            msg.setLast_name(LastName_Text.getText());
            msg.setPassword(Password_Text.getText());
            msg.setLogin_name("Teacher");
            Lecturer lec=new Lecturer(msg.getId(), msg.getFirst_name(), msg.getLast_name(), msg.getPassword());
            msg.setLec(lec);


        }
        if(choose_Login.getSelectionModel().getSelectedItem().equals("Mediator")) {
            //msg.setMessage("check id exist");
            msg.setMessage("Save The Mediator Details");
            msg.setId(Integer.parseInt(ID_Text.getText()));
            msg.setFirst_name(FirstName_Text.getText());
            msg.setLast_name(LastName_Text.getText());
            msg.setPassword(Password_Text.getText());
            msg.setLogin_name("Mediator");
            Mediator lec=new Mediator(msg.getId(), msg.getFirst_name(), msg.getLast_name(), msg.getPassword());
            msg.setMediator(lec);


        }
        sendMessage(msg);

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
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) throws IOException {


        if (event.getMessage().getMessage().equals("i will check id exist")) {
            if (choose_Login.getSelectionModel().getSelectedItem().equals("Student")) {
                List<Student> students_from_server = event.getMessage().getStudents_list_from_server();

                for (int i = 0; i < students_from_server.size(); i++) {
                    if (students_from_server.get(i).getStudent_id() == Integer.parseInt(ID_Text.getText())) {
                        c = 1;
                        break;

                    }
                }
                if (c == 1) {
                    //Message msg=new Message("");
                    sendMessage("");

                } else {
                    SimpleChatClient.setRoot("CoursesReg");
                    Message msg=new Message ("Save The Student Details");
                    msg.setId(Integer.parseInt(ID_Text.getText()));
                    msg.setFirst_name(FirstName_Text.getText());
                    msg.setLast_name(LastName_Text.getText());
                    msg.setPassword(Password_Text.getText());
                    msg.setLogin_name("Student");
                    Student s=new Student(msg.getId(), msg.getFirst_name(), msg.getLast_name(), msg.getPassword());
                    msg.setStudent(s);
                    c = 0;
                    sendMessage(msg);


                }
            } else if (choose_Login.getSelectionModel().getSelectedItem().equals("Teacher")) {
                List<Lecturer> lecturers_from_server = event.getMessage().getLecturers_list_from_server();

                for (int i = 0; i < lecturers_from_server.size(); i++) {
                    if (lecturers_from_server.get(i).getId() == Integer.parseInt(ID_Text.getText())) {
                        c = 1;
                        break;

                    }
                }
                if (c == 1) {
                    //Message msg=new Message("");
                    sendMessage("");

                } else {
                    SimpleChatClient.setRoot("CoursesReg");
                    Message msg = new Message("Save The Teacher Details");
                    msg.setId(Integer.parseInt(ID_Text.getText()));
                    msg.setFirst_name(FirstName_Text.getText());
                    msg.setLast_name(LastName_Text.getText());
                    msg.setPassword(Password_Text.getText());
                    msg.setLogin_name("Teacher");
                    Lecturer lec=new Lecturer(msg.getId(), msg.getFirst_name(), msg.getLast_name(), msg.getPassword());
                    msg.setLec(lec);
                    c = 0;
                    sendMessage(msg);




                }


            }
        }
        else if (event.getMessage().getMessage().equals("I Saved The Mediator Details")) {

        }
    }


    @FXML
    void initialize() {

        EventBus.getDefault().register(this);

        c=0;
        // sendMessage("give me the students");
        choose_Login.getItems().add("Student");
        choose_Login.getItems().add("Teacher");
        choose_Login.getItems().add("Mediator");

        // Choose_login.setVisible(true);
    }

}
