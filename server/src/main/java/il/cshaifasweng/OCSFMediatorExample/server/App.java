package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class App {

    public static Session session;
    public static SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();

        // Add ALL of your entities here. You can also try adding a whole package.
        configuration.addAnnotatedClass(Exams.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Grade.class);
        configuration.addAnnotatedClass(Lecturer.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Questions.class);
        configuration.addAnnotatedClass(ExamsScan.class);
        configuration.addAnnotatedClass(ExamInfo.class);
        configuration.addAnnotatedClass(CourseReg.class);
        configuration.addAnnotatedClass(Mediator.class);
        configuration.addAnnotatedClass(Document.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void generateCourses() throws Exception {

        Course course0 = new Course("Math",10);
        session.save(course0);
        session.flush();
        Course course1 = new Course("English",11);
        session.save(course1);
        session.flush();
        Course course2 = new Course("Arabic",12);
        session.save(course2);
        session.flush();
        Course course3 = new Course("Hebrew",13);
        session.save(course3);
        session.flush();
        Course course4 = new Course("Music",14);
        session.save(course4);
        session.flush();
        Course course5 = new Course("Data Structure",15);
        session.save(course5);
        session.flush();
        Course course6 = new Course("Algorithmes",16);
        session.save(course6);
        session.flush();
        Course course7 = new Course("Object Oriented Programming",17);
        session.save(course7);
        session.flush();
        Course course8 = new Course("Assemble",18);
        session.save(course8);
        session.flush();
        Course course9 = new Course("Sport",19);
        session.save(course9);
        session.flush();
    }

// ...

    private static <T> List<T> getAll(Class<T> object) {


        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(object);
        Root<T> rootEntry = criteriaQuery.from(object);
        CriteriaQuery<T> allCriteriaQuery = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = session.createQuery(allCriteriaQuery);
        return allQuery.getResultList();
    }




    public static List<Student> getAllStudents() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        query.from(Student.class);
        List<Student> data = session.createQuery(query).getResultList();
        return data;
    }




    public static void generateQuestions(){
        Questions ques = new Questions("test", "1", "2", "3", "4", "2");
        session.save(ques);
        session.flush();
    }


    public static void updateExamStat(String examId, boolean newStat,double time) throws Exception {

        List<Exams> exams = getAllExams();

        try {


            // Find the corresponding Exam entity
            Exams exam = null;
            for (Exams e : exams) {
                if (e.getId().equals(examId)) {
                    exam = e;
                    break;
                }
            }



            if (exam == null) {
                throw new Exception("No exam found with the specified ID.");
            }

            // Update the stat
            exam.setStat(newStat);
            exam.setTime(time);
            // Save the updated exam object
            session.update(exam);
            session.getTransaction().commit(); // Save everything..commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static void updateExam(Exams updatedExam) throws Exception {

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            List<Exams> exams = getAllExams();

            Exams exam = null;
            for (Exams e : exams) {
                if (e.getId().equals(updatedExam.getId())) {
                    exam = e;
                    break;
                }
            }

            if (exam == null) {
                throw new Exception("No exam found with the specified ID.");
            }

            // Update exam properties
            exam.setId(updatedExam.getId());
            exam.setCode(updatedExam.getCode());
            exam.setQues_number(updatedExam.getQues_number());
            exam.setCourse_name(updatedExam.getCourse_name());
            exam.setStat(updatedExam.getStat());
            exam.setRequest(updatedExam.isRequest());
            exam.setTeacherID(updatedExam.getTeacherID());
            exam.setTeacherName(updatedExam.getTeacherName());
            exam.setReason(updatedExam.getReason());
            exam.setEid(updatedExam.getEid());
            session.update(exam);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            throw e; // Rethrow the exception for higher-level error handling
        }
    }
    public static List<ExamInfo> getAllExamInfo() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ExamInfo> query = builder.createQuery(ExamInfo.class);
        query.from(ExamInfo.class);
        List<ExamInfo> data = session.createQuery(query).getResultList();
        return data;
    }
    public static void updateExamInfo(ExamInfo updatedExamInfo) throws Exception {

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            List<ExamInfo> exams = getAllExamInfo();

            ExamInfo exam = null;
            for (ExamInfo e : exams) {
                if(e.getExam_id().equals(updatedExamInfo.getExam_id()) && e.getStudentid()==updatedExamInfo.getStudentid() && e.getCourseid().equals(updatedExamInfo.getCourseid())) {
                    exam = e;
                    break;
                }
            }

            if (exam == null) {
                throw new Exception("No exam found with the specified ID.");
            }

            // Update exam properties
            exam.setExam_id(updatedExamInfo.getExam_id());
            exam.setStudentid(updatedExamInfo.getStudentid());
            exam.setNumberOfFailedStudents(updatedExamInfo.getNumberOfFailedStudents());
            exam.setNumberOfStartedStudents(updatedExamInfo.getNumberOfStartedStudents());
            exam.setNumberOfCompletedStudents(updatedExamInfo.getNumberOfCompletedStudents());
            exam.setExecutionDateTime(updatedExamInfo.getExecutionDateTime());
            exam.setActualDuration(updatedExamInfo.getActualDuration());
            exam.setId(updatedExamInfo.getId());
            exam.setCourseid(updatedExamInfo.getCourseid());
            session.update(exam);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            throw e; // Rethrow the exception for higher-level error handling
        }
    }

    public static List<Grade> getGradesByStudentId(int studentId) throws Exception{


        boolean found=false;

        List<Student> students = getAll(Student.class);
        for(int i =0;i<students.size() && !found ;i++)
        {
            if(students.get(i).getStudent_id()==studentId) {
                found=true;
            }
        }
        if(found)
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
            Root<Grade> gradeRoot = query.from(Grade.class);
            Join<Grade, Student> studentJoin = gradeRoot.join("student");
            query.select(gradeRoot).where(builder.equal(studentJoin.get("student_id"), studentId));
            List<Grade> grades = session.createQuery(query).getResultList();
            return grades;
        }
        return null;


    }
    public static void  changeGrade(int studentId, int courseId, int newGrade) throws Exception {



        List<Grade> student_grades = getGradesByStudentId(studentId);
        try {

            // Find the corresponding Grade entity
            Grade grade = null;
            for (Grade g : student_grades) {
                if (g.getCourseid() == courseId) {
                    grade = g;
                    break;
                }
            }

            if (grade == null) {
                throw new Exception("No grade found for the specified student and course.");
            }


            // Update the grade
            grade.setGrade(String.valueOf(newGrade));
            session.update(grade);

            session.getTransaction().commit(); // Save everything..commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
    public static void  changeGradetoExam(int studentId, int courseId, int newGrade,String examID) throws Exception {



        List<Grade> student_grades = getGradesByStudentId(studentId);
        try {

            // Find the corresponding Grade entity
            Grade grade = null;
            for (Grade g : student_grades) {
                if (g.getCourseid() == courseId) {
                    grade = g;
                    break;
                }
            }

            if (grade == null) {
                throw new Exception("No grade found for the specified student and course.");
            }


            // Update the grade
            grade.setExamId(examID);
            grade.setGrade(String.valueOf(newGrade));
            session.update(grade);

            session.getTransaction().commit(); // Save everything..commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static List<Exams> getAllExams() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Exams> query = builder.createQuery(Exams.class);
        query.from(Exams.class);
        List<Exams> exams = session.createQuery(query).getResultList();
        return exams;
    }
    public static void generateExam(Exams exam){

        session.save(exam);
        session.flush();
    }
    public static void generateExams(){
        Exams exam = new Exams("-1");
        session.save(exam);
        session.flush();
    }
    public static List<Course> getAllCourses() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        query.from(Course.class);
        List<Course> COURSES = session.createQuery(query).getResultList();
        return COURSES;
    }
    public static void generate(){
        Lecturer lec = new Lecturer(7,"Rai","Massalha","7");
        session.save(lec);
        session.flush();
        List<Course> c = getAllCourses();
        for(int i=0;i<7;i++){
            CourseReg r =new CourseReg(lec,c.get(i).getName(),"Teacher");
            session.save(r);
            session.flush();
        }

    }
    public static void main(String[] args) {

        try {
            try {
                session = sessionFactory.openSession();
                session.beginTransaction();
            }catch (HibernateException e){
                e.printStackTrace();
            }
            //generateQuestions();
            generateCourses();
            generateExams();
            generate();

            session.getTransaction().commit(); // Save everything.

        } catch (Exception exception) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.err.println("An error occured, changes have been rolled back.");
            exception.printStackTrace();
        } finally {
            assert session!=null;
            session.close();
        }

    }
}