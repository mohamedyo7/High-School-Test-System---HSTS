package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "students")
public class Student implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int student_id;

    private String firstName;


    private String lastName;
    private String Password;

    public String getOnline_state() {
        return online_state;
    }

    public void setOnline_state(String online_state) {
        this.online_state = online_state;
    }

    private String online_state="test";

    @OneToMany(mappedBy = "student")
    private List<CourseReg> coursesReg = new ArrayList<>();





    @OneToMany(mappedBy = "student")
    private List<Grade> grades = new ArrayList<>();

    public List<CourseReg> getCoursesReg() {
        return coursesReg;
    }

    public void setCoursesReg(List<CourseReg> coursesReg) {
        this.coursesReg = coursesReg;
    }




    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int id) {
        this.student_id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Grade> getGrades() {
        return grades;
    }




    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }



    public Student() {

    }
    public Student(Student s){
        this.student_id=s.student_id;
        this.firstName =s.firstName;
        this.lastName = s.lastName;
        this.Password=s.Password;
        this.grades = new  ArrayList<Grade>();
        this.coursesReg = new ArrayList<CourseReg>();
        this.id=s.id;




    }

    public Student(int id ,String firstName, String lastName,String Password) {
        this.student_id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = new ArrayList<Grade>();
        this.coursesReg =new ArrayList<>();
        this.Password = Password;
        this.id=id;


    }
    public Student(int id ) {
        this.student_id=id;
        this.coursesReg = new ArrayList<CourseReg>();


    }



}