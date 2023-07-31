package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades = new ArrayList<>();
    @OneToMany(mappedBy = "student")
private List<Course> courses=new ArrayList<>();

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int id) {
        this.student_id = id;
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
    public List<Course> getCourses() {
        return courses;

    }



    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }



    public Student() {

    }

    public Student(int id ,String firstName, String lastName) {
        this.student_id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = new ArrayList<Grade>();
    }



}