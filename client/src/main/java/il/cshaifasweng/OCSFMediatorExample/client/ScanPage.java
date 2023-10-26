package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamsScan;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class ScanPage {

    @FXML
    private TextArea Corr_Ans;

    @FXML
    private ListView<String> Questions_exam_list;

    @FXML
    private TextArea Your_ans;
    @FXML
    private Label wrong_ans;
    @FXML
    private TextField Student_grade_Area;

    @FXML
    private Label student_grade;
    @FXML
    private Label Correct_ans;
    @FXML
    private Label student_id;

    @FXML
    private TextField student_id_field;
     String grade_reason=null;

public static String course_ID;


    @FXML
    void Back_but(ActionEvent event) throws IOException {
        if(SimpleClient.Type.equals("Student"))
        SimpleChatClient.setRoot("StudentController");
        else if(SimpleClient.Type.equals("Teacher"))
            SimpleChatClient.setRoot("EditGrade");

    }
    @FXML
    private TextField Ques_notes;

    @FXML
    private TextArea Std_notes;
    @FXML
    private Button change_grade_but;
    @FXML
    private TextField grade_reason_textfield;
    @FXML
    private Label student_grade_label;

    @FXML
    private Label reson_grade;

    @FXML
    void Done_send_grade(ActionEvent event) throws IOException {
        if(!grade_text.getText().isEmpty()){
            Message msg = new Message("change the student grade");
            msg.setGrade(Double.parseDouble(grade_text.getText()));
            msg.setGrade_to_change((int) msg.getGrade());
            msg.setCourse_id(Integer.parseInt(course_ID));
            msg.setStudentId(EditGrade.student_id_toaddnote);
            sendMessage(msg);
        }
        Message msg=new Message("finish editing");
        msg.setCourseName(EditGrade.course_name);
        msg.setStudentId(EditGrade.student_id_toaddnote);
        msg.setExam_id(exam_list.getSelectionModel().getSelectedItem());
        msg.setQues_name(Questions_exam_list.getSelectionModel().getSelectedItem());
        msg.setQues_note(Ques_notes.getText());
        msg.setGrade_reason(grade_reason_textfield.getText());
        sendMessage(msg);
        SimpleChatClient.setRoot("ScanPage");
        Message msg2=new Message("give me exams scans");
        msg2.setId(msg.getStudentId());
        msg2.setCourseName(EditGrade.course_name);
        sendMessage(msg2);


    }
    @FXML
    private Button insert_note_but;
    @FXML
    void insert_note(ActionEvent event) {
        Message msg=new Message("add note");
        msg.setCourseName(EditGrade.course_name);
        msg.setStudentId(EditGrade.student_id_toaddnote);
        msg.setExam_id(exam_list.getSelectionModel().getSelectedItem());
        msg.setQues_name(Questions_exam_list.getSelectionModel().getSelectedItem());
        msg.setQues_note(Ques_notes.getText());
        sendMessage(msg);



    }


    @FXML
    void Show_Ans(ActionEvent event) {


    }

    @FXML
    private Button done_but;

    @FXML
    private ListView<String> exam_list;
    @FXML
    private TextField grade_text;
    @FXML
    void Show_Ques(ActionEvent event) {
        Message msg=new Message("give me exam questions");
        String s=exam_list.getSelectionModel().getSelectedItem();
        msg.setId(Integer.parseInt(s));
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
        if (event.getMessage().getMessage().equals("i will give you exams scans")) {
            int c = 0;
            System.out.println("hat nshof"+event.getMessage().getId());
            System.out.println("hat nshof1"+event.getMessage().getCourseName());
            System.out.println("hat nshof2"+c);

            exam_list.getItems().clear();


            List<ExamsScan> examsScanList = event.getMessage().getExamsScans_list_from_server();
            List<Grade> grades = event.getMessage().getGrades_list_from_server();

            List<Questions> questionsList = event.getMessage().getQuestions_list_from_server();
            if(SimpleClient.Type.equals("Student")){
                for (int i = 0; i < examsScanList.size(); i++) {

                    if (examsScanList.get(i).getStudent_ID() == event.getMessage().getId() && examsScanList.get(i).getName().equals(event.getMessage().getCourseName())) {
                        if (examsScanList.get(i).getStudent_can_scan().equals("true")) {
                            if (!isExitst(examsScanList, Integer.parseInt(examsScanList.get(i).getExam_ID())))


                                exam_list.getItems().add(examsScanList.get(i).getExam_ID());
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < examsScanList.size(); i++) {

                    if (examsScanList.get(i).getStudent_ID() == event.getMessage().getId() && examsScanList.get(i).getName().equals(event.getMessage().getCourseName())) {

                            if (!isExitst(examsScanList, Integer.parseInt(examsScanList.get(i).getExam_ID())))


                                exam_list.getItems().add(examsScanList.get(i).getExam_ID());
                    }
                }
            }
            for (int i = 0; i < grades.size(); i++) {
                if (grades.get(i).getStudent_id() == event.getMessage().getId() && grades.get(i).getCourse_name().equals(event.getMessage().getCourseName())) {
                    Student_grade_Area.setText(grades.get(i).getGrade());
                    student_id_field.setText(String.valueOf(grades.get(i).getStudent_id()));
                    course_ID= String.valueOf(grades.get(i).getCourseid());
                }


            }
            exam_list.refresh();


        }




        else  if (event.getMessage().getMessage().equals("i will give you exams questions")) {


            Questions_exam_list.getItems().clear();


            List<Questions>questionsList=event.getMessage().getQuestions_list_from_server();
            for(int i=0;i<questionsList.size();i++) {

                if (questionsList.get(i).getQues_id().equals(String.valueOf(event.getMessage().getId()))) {
                    Questions_exam_list.getItems().add(questionsList.get(i).getQuestion());

                }
            }
            Questions_exam_list.refresh();


        }
        else  if (event.getMessage().getMessage().equals("i will Show Answers")) {
            wrong_ans.setVisible(false);
            List<Questions>questionsList=event.getMessage().getQuestions_list_from_server();
            for(int i=0;i<questionsList.size();i++) {

                if(questionsList.get(i).getQues_id().equals(String.valueOf(event.getMessage().getId())))
                if (questionsList.get(i).getQuestion().equals(String.valueOf(event.getMessage().getCourseName()))) {
                    Corr_Ans.setText(questionsList.get(i).getCorrect_ans());
                }
            }
            List<ExamsScan>examsScanList=event.getMessage().getExamsScans_list_from_server();
            for(int i=0;i<examsScanList.size();i++) {

                if(examsScanList.get(i).getExam_ID().equals(event.getMessage().getExam_id()))
                    if (examsScanList.get(i).getType().equals(String.valueOf(event.getMessage().getCourseName()))) {
                        Your_ans.setText(examsScanList.get(i).getAnswer());
                        Std_notes.setText(examsScanList.get(i).getState());
                    }
            }


            if(!Corr_Ans.getText().equals(Your_ans.getText())) {
                wrong_ans.setVisible(true);

            }

        }
        else  if (event.getMessage().getMessage().equals("i will add note")) {

        }
        else  if (event.getMessage().getMessage().equals("i finished editing")) {

        }

        }
    public boolean isExitst(List<ExamsScan> l , int id){
        for(int i =0 ; i<exam_list.getItems().size();i++){
            if(exam_list.getItems().get(i).equals(String.valueOf(id))){
                return true;
            }
        }
        return false;
    }
    public boolean isExitst2(List<ExamsScan> l , int id){
        for(int i =0 ; i<exam_list.getItems().size();i++){
            if(exam_list.getItems().get(i).equals(String.valueOf(id))){
                return true;
            }
        }
        return false;
    }
    @FXML
    void initialize() {
        wrong_ans.setVisible(false);

        if(SimpleClient.Type.equals("Teacher"))
            Std_notes.setVisible(false);
        if(SimpleClient.Type.equals("Student")) {
            Ques_notes.setVisible(false);
            insert_note_but.setVisible(false);
            done_but.setVisible(false);
            student_grade.setVisible(false);
           Student_grade_Area.setVisible(false);
           grade_text.setVisible(false);
           reson_grade.setVisible(false);
           student_grade_label.setVisible(false);
           grade_reason_textfield.setVisible(false);

        }

        EventBus.getDefault().register(this);

    }

    public void Questions_exam_list_press(javafx.scene.input.MouseEvent mouseEvent) {
        Message msg=new Message("Show Answers");
        String s=exam_list.getSelectionModel().getSelectedItem();
        msg.setId(Integer.parseInt(s));
        msg.setExam_id(s);
        msg.setCourseName(Questions_exam_list.getSelectionModel().getSelectedItem());
        sendMessage(msg);
    }
}

