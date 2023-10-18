package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamsScan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class EditGrade {

    @FXML
    private ListView<String> STD_ID_LIST;

    public static int student_id_toaddnote;
    public static String course_name;

    @FXML
    void Back_but(ActionEvent event) throws IOException {
     SimpleChatClient.setRoot("TeacherPage");

    }
    @FXML
    private ListView<String> STD_Course_LIST;

    @FXML
    void STD_Course_LIST_Pressed(MouseEvent event) {
        Message msg=new Message("give me students id2");
        String s1=STD_Course_LIST.getSelectionModel().getSelectedItem();
        msg.setCourseName(s1);
        sendMessage(msg);


    }

    @FXML
    void STD_ID_LIST_PRESS(MouseEvent event) throws IOException {
        SimpleChatClient.setRoot("ScanPage");
        Message msg=new Message("give me exams scans");
        String s=STD_ID_LIST.getSelectionModel().getSelectedItem();
        if(s!=null) {
            msg.setId(Integer.parseInt(s));
            student_id_toaddnote = Integer.parseInt(s);
        }
        course_name=STD_Course_LIST.getSelectionModel().getSelectedItem();
        msg.setCourseName(STD_Course_LIST.getSelectionModel().getSelectedItem());
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
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you students id")) {
            int c=0;
            int h=0;
            List<CourseReg> coursesRegList=event.getMessage().getCourses_list_from_server_reg();
            List<Exams>examsList=event.getMessage().getExams_list_from_server();
            List<ExamsScan>examsScanList=event.getMessage().getExamsScans_list_from_server();

            for(int i=0;i<coursesRegList.size();i++){
                if(coursesRegList.get(i).getType().equals("Teacher")&&coursesRegList.get(i).getLecturer().getId()==event.getMessage().getId()){
                    for(int j=0;j<examsList.size();j++){
                        if(coursesRegList.get(i).getName().equals(examsList.get(j).getCourse_name())){
                            for(int z=0;z<STD_Course_LIST.getItems().size();z++){
                                if(STD_Course_LIST.getItems().get(z).equals(coursesRegList.get(i).getName())){
                                    h=1;
                                    break;
                                }
                            }
                            if(h==0)
                                STD_Course_LIST.getItems().add(coursesRegList.get(i).getName());

                        }
                    }
                }
            }





        }
        if (event.getMessage().getMessage().equals("i will give you students id2")) {
            int c=0;
            String s=STD_Course_LIST.getSelectionModel().getSelectedItem();
            List<ExamsScan>examsScanList=event.getMessage().getExamsScans_list_from_server();

            for(int x=0;x<examsScanList.size();x++){
                if(examsScanList.get(x).getName().equals(s)){
                    for(int y=0;y<STD_ID_LIST.getItems().size();y++){
                        if(STD_ID_LIST.getItems().get(y).equals(String.valueOf(examsScanList.get(x).getStudent_ID()))) {
                            c = 1;
                            break;
                        }

                    }
                    if(c==0)
                        STD_ID_LIST.getItems().add(String.valueOf(examsScanList.get(x).getStudent_ID()));
                }
            }



        }
    }


    @FXML
    void initialize() {
        int msgId=0;
        EventBus.getDefault().register(this);
        Message msg=new Message("give me students id");
        msg.setId(SimpleClient.ID);
        msg.setType(SimpleClient.Type);
        sendMessage(msg);




    }

}
