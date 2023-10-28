package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamInfo;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class ExamScan {

    @FXML
    private TextArea Date_Time;

    @FXML
    private TextArea Exam_Time;

    @FXML
    private TextArea Student_finish;

    @FXML
    private TextArea Students_nofinish;



    @FXML
    private ListView<String> Teachers_Exams_ID;
    @FXML
    private ListView<String> Stat_ID;
    @FXML
    private ListView<String> Teacher_Courses;
    @FXML
    private TextArea Student_Number;
    @FXML
    void Show_Stats_but(ActionEvent event) {
        sendMessage("show stats");

    }

    @FXML
    void teacher_Courses_mouse(MouseEvent event) {
String s=Teacher_Courses.getSelectionModel().getSelectedItem();
Message msg=new Message("give me teacher exams");
msg.setCourseName(s);
msg.setId(SimpleClient.ID);
sendMessage(msg);
    }

    @FXML
    void Back_but(ActionEvent event) throws IOException {
        if(Stat_ID.getItems().get(1).equals("Teacher")) {
            SimpleChatClient.setRoot("TeacherPage");
            Message msg = new Message("give me teacher data");
            msg.setId(Integer.parseInt(Stat_ID.getItems().get(0)));
            sendMessage(msg);
        }
        else if(Stat_ID.getItems().get(1).equals("Mediator")){
            SimpleChatClient.setRoot("MediatorPage");
            Message msg = new Message("give me mediator data");
            msg.setId(Integer.parseInt(Stat_ID.getItems().get(0)));
            msg.setLogin_name("Mediator");
            sendMessage(msg);
        }

    }



    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the teacher stats")) {
            if (Stat_ID.getItems().isEmpty()) {
                Stat_ID.getItems().add(String.valueOf(event.getMessage().getId()));
                Stat_ID.getItems().add(event.getMessage().getLogin_name());


            }
            int s = 0;
            Teacher_Courses.getItems().clear();
            List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();

            for (int i = 0; i < Courses_from_server_reg.size(); i++) {
                // Set the data to the table
                if(Courses_from_server_reg.get(i).getLecturer()!=null)
                    if(Courses_from_server_reg.get(i).getLecturer().getId()==event.getMessage().getId()){
                        Teacher_Courses.getItems().add(Courses_from_server_reg.get(i).getName());
                    }
            }
            Teacher_Courses.refresh();
        }
        else if (event.getMessage().getMessage().equals("i will show stats")) {
            String Name = Teacher_Courses.getSelectionModel().getSelectedItem();
            String ID = Teachers_Exams_ID.getSelectionModel().getSelectedItem();
            if (Name == null || ID == null) {
                sendMessage("");
            } else {
                ExamInfo examInfo = new ExamInfo();
                List<ExamInfo> examInfos = event.getMessage().getExamInfos();
                for (int i = 0; i < examInfos.size(); i++) {
                    if (examInfos.get(i).getCourseid().equals(Name) && examInfos.get(i).getExam_id().equals(ID)) {

                        examInfo = examInfos.get(i);

                    }
                }
                Student_Number.setText(String.valueOf(examInfo.getNumberOfStartedStudents()));
                Student_finish.setText(String.valueOf(examInfo.getNumberOfCompletedStudents()));
                Students_nofinish.setText(String.valueOf(examInfo.getNumberOfFailedStudents()));
                Date_Time.setText(String.valueOf(examInfo.getExecutionDateTime()));
                Exam_Time.setText(String.valueOf(examInfo.getActualDuration()));



            }
        }
        else if (event.getMessage().getMessage().equals("i will give you teacher exams")) {
            int c=0;
            List<Exams>examsList=event.getMessage().getExams_list_from_server();
            for(int i=0;i<examsList.size();i++){
                if(examsList.get(i)!=null&& examsList.get(i).getTeacherID() != null)
                if(examsList.get(i).getTeacherID().equals(String.valueOf(event.getMessage().getId()))&&examsList.get(i).getCourse_name().equals(event.getMessage().getCourseName())){
                    for(int j=0;j<Teachers_Exams_ID.getItems().size();j++){
                        if(Teachers_Exams_ID.getItems().get(j).equals(String.valueOf(examsList.get(i).getId()))) {
                            c = 1;
                            break;
                        }

                    }
                    if(c==0)
                        Teachers_Exams_ID.getItems().add(String.valueOf(examsList.get(i).getId()));
                }
            }
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
    }



}
