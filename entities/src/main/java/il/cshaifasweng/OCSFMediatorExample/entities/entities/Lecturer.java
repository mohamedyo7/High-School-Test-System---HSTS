package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecturers")
public class Lecturer implements Serializable {
    public int getId_prim() {
        return id_prim;
    }

    public void setId_prim(int id_prim) {
        this.id_prim = id_prim;
    }

    @Id
    private int id_prim;


    private int id;

    public String getOnline_state() {
        return online_state;
    }

    public void setOnline_state(String online_state) {
        this.online_state = online_state;
    }

    private String online_state="test";

    private String firstName;

    private String lastName;

    private String Password;

    // Note that in this case, choosing CascadeType.ALL would mean that deleting a lecturer would also delete all his or her courses.
    // This is a design choice, and may not be ideal.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lecturer")
    private List<Course> courses;


    public List<CourseReg> getCoursesReg() {
        return coursesReg;
    }

    public void setCoursesReg(List<CourseReg> coursesReg) {
        this.coursesReg = coursesReg;
    }

    @OneToMany(mappedBy = "lecturer")
    private List<CourseReg> coursesReg = new ArrayList<>();
  /*  @OneToMany(fetch = FetchType.LAZY, mappedBy = "lecturerReg")
    private List<CourseReg> coursesReg;*/


 /*   public List<CourseReg> getCoursesReg() {
        return coursesReg;
    }

    public void setCoursesReg(List<CourseReg> coursesReg) {
        this.coursesReg = coursesReg;
    }*/


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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course)
    {
        this.courses.add(course);
    }

    public void deleteCourseByName(Course course)
    {
        for(int i=0;i< courses.size();i++)
        {
            if(courses.get(i).getId()==course.getId())
            {
                courses.remove(i);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Lecturer(int id, String firstName, String lastName, String password) {
        this.id=id;
        this.Password=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<Course>();
        this.coursesReg=new ArrayList<>();
        this.id_prim=id;
    }
    public Lecturer(Lecturer lec) {
        this.id=lec.id;
        this.Password=lec.Password;
        this.firstName = lec.firstName;
        this.lastName = lec.lastName;
        this.courses = new ArrayList<Course>();
        this.coursesReg=new ArrayList<>();
        this.id_prim=lec.id_prim;
    }

    public Lecturer() {

    }

    public void setStudentGrade(Student student, float grade, int course_id){

}


}