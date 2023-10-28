package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Grades")
public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grade_id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String grade;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Column(name="coursename")
    private String course_name;





    public String getCourseName() {
        // System.out.println("getCourseName "+ course.getName());
        return course.getName();
    }

    public int getStudent_id()
    {
        // System.out.println("getStudent_id "+ student.getStudent_id());
        return student.getStudent_id();
    }


    public String getGrade() {
        // System.out.println("getGrade "+grade);
        return grade;
    }

    public int getGrade_id() {
        return grade_id;
    }


    public int getCourseid()
    {
        return course.getId();
    }
   // public int getCourseid_reg()
    //{
       // return courseReg.getId();
   // }


    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }
    /*public CourseReg getCourseReg(){return courseReg;}*/

    public Student getStudent() {
        return student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    /*public void setCourseReg(CourseReg courseReg){this.courseReg=courseReg;}*/

    public void setStudent(Student student) {
        this.student = student;
    }

    public Grade()
    {

    }
    public Grade(Student student, Course course,String grade,String course_name)
    {

        setStudent(student);
        setCourse(course);
        this.grade =grade;
        this.course_name=course_name;
    }

}