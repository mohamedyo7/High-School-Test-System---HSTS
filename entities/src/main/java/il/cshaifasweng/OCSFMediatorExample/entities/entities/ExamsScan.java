package il.cshaifasweng.OCSFMediatorExample.entities.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "examsscan")
public class ExamsScan  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=1000;




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public String getStudent_state_tostart() {
        return Student_state_tostart;
    }

    public void setStudent_state_tostart(String student_state_tostart) {
        Student_state_tostart = student_state_tostart;
    }

    private String Student_state_tostart;

    public String getStudent_can_scan() {
        return student_can_scan;
    }

    public void setStudent_can_scan(String student_can_scan) {
        this.student_can_scan = student_can_scan;
    }

    private String student_can_scan;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String answer;

    public String getChange_grade_reason() {
        return change_grade_reason;
    }

    public void setChange_grade_reason(String change_grade_reason) {
        this.change_grade_reason = change_grade_reason;
    }

    private String change_grade_reason;

    // Pay attention to this one: name is a reserved keyword in MySQL.
    @Column(name = "Exam_Name")
    private String name;

    public String getExam_ID() {
        return Exam_ID;
    }

    public void setExam_ID(String exam_ID) {
        Exam_ID = exam_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Exam_ID")
    private String Exam_ID;


    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int student_ID) {
        Student_ID = student_ID;
    }

    @Column(name = "student_ID")
    private int Student_ID;


    public ExamsScan(int student_id,String exam_name, String exam_id,String type,String ans,String state)
    {

        setStudent_ID(student_id);
        setName(exam_name);
        setExam_ID(exam_id);
        setType(type);
        setAnswer(ans);
        setState("");
        setStudent_can_scan("");
        setStudent_state_tostart("false");



    }
    public ExamsScan(ExamsScan exam){

        this.Student_ID=exam.getStudent_ID();
        this.Exam_ID=exam.getExam_ID();
        this.name=exam.name;
        this.type=exam.getType();
        this.answer=exam.answer;
        this.state="";
        this.student_can_scan="";
        this.Student_state_tostart="false";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public ExamsScan() {
    }

    public ExamsScan(String name) {
        this.name = name;
    }



}