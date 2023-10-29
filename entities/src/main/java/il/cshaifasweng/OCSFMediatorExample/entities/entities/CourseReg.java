package il.cshaifasweng.OCSFMediatorExample.entities.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coursesReg")
public class CourseReg  implements Serializable {


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

    // Pay attention to this one: name is a reserved keyword in MySQL.
    @Column(name = "course_name_Reg")
    private String name;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @ManyToOne
    @JoinColumn(name = "lecturer")
    private Lecturer lecturer;

    @OneToMany(mappedBy = "course")
    private List<Grade> grades = new ArrayList<>();


    public CourseReg(Student student, String course,String type)
    {

        setStudent(student);
        setCourse(course);
        this.type=type;
    }
    public CourseReg(Lecturer lec, String course,String type)
    {

        setLecturer(lec);
        setCourse(course);
        this.type=type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public CourseReg() {
    }

    public CourseReg(String name) {
        this.name = name;
    }

    public String getCourse() {
        return name;
    }

    public void setCourse(String course) {
        this.name = course;
    }


}