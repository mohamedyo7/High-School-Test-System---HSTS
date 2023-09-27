package il.cshaifasweng.OCSFMediatorExample.entities;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;



public class Message implements Serializable {

    int id;

    List<Object> object;
    LocalDateTime timeStamp;
    String message;
    String data;
    String test;
    int studentId;

    int course_id;
    private Questions question ;
    int grade_to_change;
    private List<Questions> questions_list_from_server;

    public List<Questions> getQuestions_list_from_server() {
        return questions_list_from_server;
    }

    public void setQuestions_list_from_server(List<Questions> questions_list_from_server) {
        this.questions_list_from_server = questions_list_from_server;
    }

    private List<Student> students_list_from_server;
    private List<Grade> grades_list_from_server;
    private List<Course> courses_list_from_server;
    private String courseName;
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }


    public int getCourse_id()
    {
        return course_id;
    }
    public void setObject(List<Object> object) {
        this.object = object;
    }

    public List<Object> getObject() {
        return object;
    }
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getGrade_to_change() {
        return grade_to_change;
    }

    public void setGrade_to_change(int grade_to_change) {
        this.grade_to_change = grade_to_change;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int number) {
        this.studentId = number;
    }

    public Message(String message, List<Student> students, List<Grade> grades) {
        System.out.println("2444210sd");
        this.students_list_from_server=students;
        this.grades_list_from_server=grades;
        this.message = message;
    }

    public List<Grade> getGrades_list_from_server() {
        return grades_list_from_server;
    }

    public List<Student> getStudents_list_from_server() {

        return this.students_list_from_server;

    }
    public List<Course> getCourses_list_from_server() {

        return this.courses_list_from_server;

    }
    public void setGrades_list_from_server(List<Grade> grades_list_from_server) {

        this.grades_list_from_server = grades_list_from_server;
    }

    public void setStudents_list_from_server(List<Student> students_list_from_server) {
        System.out.println("440sd");
        this.students_list_from_server=students_list_from_server;

    }
    public void setCourses_list_from_server(List<Course> courses_list_from_server){
        System.out.println("20sd");
        this.courses_list_from_server = courses_list_from_server ;
    }
    public Message(int id, LocalDateTime timeStamp, String message) {
        System.out.println("10sd");
        this.id = id;
        this.timeStamp = timeStamp;
        this.message = message;
    }


    public Message(int id, String message) {
        System.out.println("110sd");
        this.id = id;
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.data = null;
    }
    public Message(String message){
        this.id=0;
        this.message=message;
        this.timeStamp = LocalDateTime.now();
        this.data = null;
    }

    public Message(int id, String message,String data) {
        System.out.println("220sd");
        this.id = id;
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.data = data;
    }
    public Message(int id, String s1, String message,String s2) {
        System.out.println("10sd");
        this.id = id;
        this.message = s1;
        this.data = message;
        this.test=s2;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}