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

    // Pay attention to this one: name is a reserved keyword in MySQL.
    @Column(name = "Exam_Name")
    private String name;

    public int getExam_ID() {
        return Exam_ID;
    }

    public void setExam_ID(int exam_ID) {
        Exam_ID = exam_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Exam_ID")
    private int Exam_ID;


    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int student_ID) {
        Student_ID = student_ID;
    }

    @Column(name = "student_ID")
    private int Student_ID;


    public ExamsScan(int student_id,String exam_name, int exam_id,String type,String ans,String state)
    {

        setStudent_ID(student_id);
        setName(exam_name);
        setExam_ID(exam_id);
        setType(type);
        setAnswer(ans);
        setState(state);
        setStudent_can_scan("false");



    }
    public ExamsScan(ExamsScan exam){

        this.Student_ID=exam.getStudent_ID();
        this.Exam_ID=exam.getExam_ID();
        this.name=exam.name;
        this.type=exam.getType();
        this.answer=exam.answer;
        this.state=exam.state;
        this.student_can_scan="false";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


   /* public Lecturer getLecturer() {
        return lecturer;
    }*/

    /*    public void setLecturer(Lecturer lecturer) {
            this.lecturer = lecturer;
            lecturer.getCoursesReg().add(this); // IMPORTANT!
        }*/
    public ExamsScan() {
    }

    public ExamsScan(String name) {
        this.name = name;
    }

 /*   public CourseReg(String name, Lecturer lecturer) {
        this.name = name;
        setLecturer(lecturer); // IMPORTANT: Why are we doing this?
        //this.students = new ArrayList<Student>();
    }*/

}