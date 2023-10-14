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


    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    @Column(name = "student_ID")
    private String Student_ID;


    public ExamsScan(String student_id,String exam_name, String exam_id,String type,String ans)
    {

        setStudent_ID(student_id);
        setName(exam_name);
        setExam_ID(exam_id);
        setType(type);
        setAnswer(ans);



    }
    public ExamsScan(ExamsScan exam){

        this.Student_ID=exam.Student_ID;
        this.Exam_ID=getExam_ID();
        this.name=exam.name;
        this.type=exam.getType();
        this.answer=exam.answer;
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