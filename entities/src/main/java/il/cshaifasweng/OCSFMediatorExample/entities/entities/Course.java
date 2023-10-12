package il.cshaifasweng.OCSFMediatorExample.entities.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=1000;

    // Pay attention to this one: name is a reserved keyword in MySQL.
    @Column(name = "course_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;


/*
    @ManyToOne
    @JoinColumn(name = "ques_id")
    private Questions questions;
*/


    //////////////
    @OneToMany(mappedBy = "course")
    private List<Grade> grades = new ArrayList<>();


/*
    public List<Questions> getQuestion() {
        return Question;
    }

    public void setQuestion(List<Questions> question) {
        Question = question;
    }
    public void addQuestion(Questions question) {
        Question.add(question) ;
    }
*/

    //@OneToMany(mappedBy = "Questions")
    //private List<Questions> Question=new ArrayList<>();
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

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
        lecturer.getCourses().add(this); // IMPORTANT!
    }
    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, Lecturer lecturer) {
        this.name = name;
        setLecturer(lecturer); // IMPORTANT: Why are we doing this?
        //this.students = new ArrayList<Student>();
    }


}