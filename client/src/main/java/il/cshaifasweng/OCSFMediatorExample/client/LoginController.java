package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Lecturer;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Mediator;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LoginController {

    public String getStd_ID() {
        return Std_ID;
    }

    public void setStd_ID(String std_ID) {
        Std_ID = std_ID;
    }

    private String Std_ID;
    int c;
    String pass;
    @FXML
    private Text time_txf;
    @FXML
    private ChoiceBox<String> Choose_login;
    @FXML
    private TextField Password_text;

    @FXML
    void backB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("FirstPage");
    }
    @FXML
    void Login_But(ActionEvent event) throws IOException {
        pass=Password_text.getText();
        if (Choose_login.getSelectionModel().isEmpty() || ID_text.getText().isEmpty() || Password_text.getText().isEmpty()) {
            Message msg = new Message("");
            sendMessage(msg);
        } else {
            int s;
            s = Integer.parseInt(ID_text.getText());
            if (Choose_login.getSelectionModel().getSelectedItem().equals("Student")) {


                //SimpleChatClient.setRoot("StudentController");
               // Message msg = new Message("give me student data");
               Message msg = new Message("give me the students2");
                msg.setStudentId(s);
                msg.setId(s);
                msg.setLogin_name("Student");
                sendMessage(msg);


            } else if (Choose_login.getSelectionModel().getSelectedItem().equals("Teacher")) {
                //SimpleChatClient.setRoot("TeacherPage");
                //Message msg = new Message("give me teacher data");
                Message msg = new Message("give me the students2");
                msg.setId(s);
                msg.setLogin_name("Teacher");
                sendMessage(msg);

            }
            else if (Choose_login.getSelectionModel().getSelectedItem().equals("Mediator")) {
                //SimpleChatClient.setRoot("TeacherPage");
                //Message msg = new Message("give me teacher data");
                Message msg = new Message("give me the students2");
                msg.setId(s);
                msg.setLogin_name("Mediator");
                sendMessage(msg);

            }


            else sendMessage("");
        }

    }



    @FXML
    public TextField ID_text;

    public LoginController() {
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


        if (event.getMessage().getMessage().equals("i will give you the students2")) {
            if (Choose_login.getSelectionModel().getSelectedItem().equals("Student")) {
                List<Student> students_from_server = event.getMessage().getStudents_list_from_server();

                for (int i = 0; i < students_from_server.size(); i++) {

                    if (students_from_server.get(i).getStudent_id() == Integer.parseInt(ID_text.getText()) && students_from_server.get(i).getPassword().equals(pass)&&!students_from_server.get(i).getOnline_state().equals("online")) {
                        c = 1;
                        break;

                    }
                }
                if (c == 0) {
                    //Message msg=new Message("");
                    sendMessage("");

                } else {
                    try {
                        Message message = new Message(Integer.parseInt(ID_text.getText()),"add client");
                        SimpleClient.getClient().sendToServer(message);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    SimpleChatClient.setRoot("StudentController");
/*                    Message msg = new Message("give me student data");
                    // Message msg = new Message("give me the students");
                    msg.setStudentId(Integer.parseInt(ID_text.getText()));
                    msg.setId(Integer.parseInt(ID_text.getText()));

                    sendMessage(msg);*/
                    c = 0;
                    pass = "[p]";

                }
            }
            if (Choose_login.getSelectionModel().getSelectedItem().equals("Teacher")) {
                List<Lecturer> lecturers_from_server = event.getMessage().getLecturers_list_from_server();

                for (int i = 0; i < lecturers_from_server.size(); i++) {
                    if (lecturers_from_server.get(i).getId() == Integer.parseInt(ID_text.getText()) && lecturers_from_server.get(i).getPassword().equals(pass)) {
                        SimpleClient.name=lecturers_from_server.get(i).getFirstName();
                        c = 1;
                        break;

                    }
                }
                if (c == 0) {
                    //Message msg=new Message("");
                    sendMessage("");

                } else {
                    try {
                        Message message = new Message(Integer.parseInt(ID_text.getText()),"add client");
                        SimpleClient.getClient().sendToServer(message);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    SimpleChatClient.setRoot("TeacherPage");
                    //Message msg = new Message("give me teacher data");
                    // Message msg = new Message("give me the students");
                   // msg.setId(Integer.parseInt(ID_text.getText()));
                    c = 0;
                    pass = "[p]";
                   // sendMessage(msg);


                }
            }
            if (Choose_login.getSelectionModel().getSelectedItem().equals("Mediator")) {
                List<Mediator> mediators_from_server = event.getMessage().getMediators_list_from_server();

                for (int i = 0; i < mediators_from_server.size(); i++) {
                    if (mediators_from_server.get(i).getId() == Integer.parseInt(ID_text.getText()) && mediators_from_server.get(i).getPassword().equals(pass)&&!mediators_from_server.get(i).getOnline_state().equals("online")) {
                        c = 1;
                        break;

                    }
                }
                if (c == 0) {
                    //Message msg=new Message("");
                    sendMessage("");

                } else {
                    try {
                        Message message = new Message(Integer.parseInt(ID_text.getText()),"add client");
                        SimpleClient.getClient().sendToServer(message);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    SimpleChatClient.setRoot("MediatorPage");
                    //Message msg = new Message("give me mediator data");
                    // Message msg = new Message("give me the students");
                    //msg.setLogin_name("Mediator");
                   // msg.setId(Integer.parseInt(ID_text.getText()));
                    c = 0;
                    pass = "[p]";
                    //sendMessage(msg);


                }
            }
        }
    }









    @FXML
    void initialize() {
        EventBus.getDefault().register(this);

c=0;
pass="[p]";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            time_txf.setText(currentTime.format(dtf));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();;
        //sendMessage("give me the students");
        Choose_login.getItems().add("Student");
        Choose_login.getItems().add("Teacher");
        Choose_login.getItems().add("Mediator");
       // Choose_login.setVisible(true);
    }

}
