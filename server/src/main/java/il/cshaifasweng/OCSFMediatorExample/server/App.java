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

        configuration.addAnnotatedClass(CourseReg.class);
        configuration.addAnnotatedClass(Mediator.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void generateGrades() {

        List<Student> students = getAll(Student.class);
        List<Course> courses = getAll(Course.class);
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                Grade grade = new Grade(students.get(i), courses.get(j), 100);
                session.save(grade);
                session.flush();
            }
        }

    }


    private static final String[] sFIRST_NAMES = {
            "Sophia", "Oliver", "Emma", "Liam", "Ava", "Noah",
            "Isabella", "Olivia", "Elijah", "Charlotte", "William", // Add more names here if needed
    };

    private static final String[] sLAST_NAMES = {
            "Smith", "Johnson", "Brown", "Jones", "Garcia", "Miller",
            "Davis", "Rodriguez", "Martinez", "Taylor", "Anderson", // Add more names here if needed
    };

    private static final String[] FIRST_NAMES = {
            "Ethan", "Sophia", "Caleb", "Lily", "Lucas", "Ava",
            "Benjamin", "Olivia", "Gabriel", "Emma", "Michael", // Add more names here if needed
    };



    private static void generateLecturers() throws Exception {
        for (int i = 0; i < 10; i++) {
            Lecturer lect = new Lecturer(generateRandomName(FIRST_NAMES), generateRandomName(LAST_NAMES));
            session.save(lect);
            session.flush();
        }

    }

    private static void generateCourses() throws Exception {

        Course course0 = new Course("Math");
        session.save(course0);
        session.flush();
        Course course1 = new Course("English");
        session.save(course1);
        session.flush();
        Course course2 = new Course("Arabic");
        session.save(course2);
        session.flush();
        Course course3 = new Course("Hebrew");
        session.save(course3);
        session.flush();
        Course course4 = new Course("Music");
        session.save(course4);
        session.flush();
        Course course5 = new Course("Data Structure");
        session.save(course5);
        session.flush();
        Course course6 = new Course("Algorithmes");
        session.save(course6);
        session.flush();
        Course course7 = new Course("Object Oriented Programming");
        session.save(course7);
        session.flush();
        Course course8 = new Course("Assemble");
        session.save(course8);
        session.flush();
        Course course9 = new Course("Sport");
        session.save(course9);
        session.flush();
    }

// ...


    private static int generateRandomID() {
        Random random = new Random();
        return 100000000 + random.nextInt(900000000); // Generates a random 9-digit ID
    }


    private static void generateStudents() throws Exception {
        for (int i = 0; i < 10; i++) {
            int id = generateRandomID();
            Student std0 = new Student(id, generateRandomName(sFIRST_NAMES), generateRandomName(sLAST_NAMES));
            session.save(std0);
            session.flush();
        }
    }


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

    public static void generateQuestion(Questions questions) {
    public static void generateQuestion(Questions questions){
        session.save(questions);
        session.flush();
    }

    public static void generateQuestions() {
        Questions ques = new Questions("test", "1", "2", "3", "4", "2");
    }
    public static void generateQuestions(){
        Questions ques = new Questions();
        session.save(ques);
        session.flush();
    }
    public static void generateregcourse(String course,int id){


            List<CourseReg> cor = getAll(CourseReg.class);

            //List<Course> courses = getAll(Course.class);

            for (int i=0; i<cor.size();i++){

                    if(cor.get(i).getStudent().getStudent_id()==id){
                        if(cor.get(i).getName()==null) {
                            cor.get(i).setName(course);
                            session.update(cor.get(i));
                            session.getTransaction().commit();
                            break;
                        }
                    }


                    //session.flush();

            }

    }

    public static void generateStdReg(Student s,List<CourseReg> reg){
        //Student s0=new Student(s);
        s.setCoursesReg(reg);
        //s0.setStudent_id(id);
        //session.remove(s);

        session.update(s);
        session.getTransaction().commit();
        //session.close();
        //session.flush();


    }


    public static void updateExamStat(int examId, boolean newStat) throws Exception {

        List<Exams> exams = getAllExams();
        try {


            // Find the corresponding Exam entity
            Exams exam = null;
            for (Exams e : exams) {
                if (e.getId() == examId) {
                    exam = e;
                    break;
                }
            }

            if (exam == null) {
                throw new Exception("No exam found with the specified ID.");
            }

            // Update the stat
            exam.setStat(newStat);

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
                if (e.getId() == updatedExam.getId()) {
                    exam = e;
                    break;
                }
            }

            if (exam == null) {
                throw new Exception("No exam found with the specified ID.");
            }

            // Update exam properties
            exam.setId(updatedExam.getId());
            exam.setQues_number(updatedExam.getQues_number());
            exam.setCourse_name(updatedExam.getCourse_name());
            exam.setStat(updatedExam.getStat());

            // Clear the existing list of questions
            //exam.getQuestions().clear();

            // Add the updated list of questions
/*            List<Questions> updatedQuestions = updatedExam.getQuestions();
            for (Questions question : updatedQuestions) {
                exam.add_Ques(question);
            }*/

            // Update the exam
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
        Exams exam = new Exams(1);
        session.save(exam);
        session.flush();
    }





    public static void main(String[] args) {

        try {
            try {
                session = sessionFactory.openSession();
                session.beginTransaction();
            }catch (HibernateException e){
                e.printStackTrace();
            }
            generateQuestions();
            generateCourses();
            //generateLecturers();
            //generateStudents();
            //generateGrades();
            generateQuestions();
            //generateregcourse();
            //List<Student> students = getAll(Student.class);
            generateLecturers();
            generateStudents();
            generateGrades();
            generateExams();
            List<Student> students = getAll(Student.class);
            List<Course> courses = getAll(Course.class);
            List<Lecturer> lecturers = getAll(Lecturer.class);
         /*   for(int i=0;i<lecturers.size();i++){
                lecturers.get(i).addCourse(courses.get(generateRandomlecture()));}*/

           /* lecturers.get(0).addCourse(courses.get(8));
            lecturers.get(0).addCourse(courses.get(6));
            lecturers.get(1).addCourse(courses.get(0));
            lecturers.get(2).addCourse(courses.get(7));
            lecturers.get(3).addCourse(courses.get(5));
            lecturers.get(4).addCourse(courses.get(2));
            lecturers.get(5).addCourse(courses.get(1));
            lecturers.get(6).addCourse(courses.get(4));
            lecturers.get(7).addCourse(courses.get(3));
            lecturers.get(8).addCourse(courses.get(9));
            lecturers.get(9).addCourse(courses.get(8));*/

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