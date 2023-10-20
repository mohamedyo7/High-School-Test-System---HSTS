package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class TeacherStats {

    @FXML
    private TextArea Course_Avg;

    @FXML
    private TextArea Higher_Grade;

    @FXML
    private TextArea Lowest_Grade;

    @FXML
    private TextArea Student_Number;

    @FXML
    private TextArea Student_succ;

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
    @FXML
    void Show_Stats_but(ActionEvent event) {
        sendMessage("show stats");

    }
    @FXML
    private ListView<String> Stat_ID;
    @FXML
    private ListView<String> Teacher_Courses;

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
            String Name= Teacher_Courses.getSelectionModel().getSelectedItem();
            int students_num=0;
            int higher_grade=-1;
            int lowest_grade=110;
            float calculate=0;
            int succedded=0;
            if(Name==null){sendMessage("");}
            else{
                List<CourseReg>courses=event.getMessage().getCourses_list_from_server_reg();
                List<Grade>grades=event.getMessage().getGrades_list_from_server();
                for(int i=0;i<courses.size();i++){
                    if(courses.get(i).getType().equals("Student")&&courses.get(i).getName().equals(Name)){
                        for(int j=0;j<grades.size();j++){
                            if(courses.get(i).getStudent().equals(grades.get(j).getStudent())){
                                if(grades.get(j).getCourse_name().equals(Name)) {
                                    if (!grades.get(j).getGrade().equals("null")) {
                                        if(Integer.parseInt(grades.get(j).getGrade())>higher_grade)
                                            higher_grade=Integer.parseInt(grades.get(j).getGrade());
                                        if(Integer.parseInt(grades.get(j).getGrade())<lowest_grade);
                                            lowest_grade=Integer.parseInt(grades.get(j).getGrade());
                                        students_num++;
                                        calculate+=Integer.parseInt(grades.get(j).getGrade());
                                        if(Integer.parseInt(grades.get(j).getGrade())>51)
                                            succedded++;

                                    }

                                }
                            }
                        }

                    }
                }




                Student_Number.setText(String.valueOf(students_num));
                Student_succ.setText(String.valueOf(succedded));
                if(students_num==0)
                    Course_Avg.setText("null");
                else
                Course_Avg.setText(String.valueOf(calculate/students_num));
                if(higher_grade==-1)
                    Higher_Grade.setText("null");
                else
                Higher_Grade.setText(String.valueOf(higher_grade));
                if(lowest_grade==110)
                    Lowest_Grade.setText("null");
                else
                Lowest_Grade.setText(String.valueOf(lowest_grade));
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
