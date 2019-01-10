package com.renevoi.studentDemoUsingCFG;

import com.renevoi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudent {

    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration()
                                        .configure()
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.openSession();


        try {
            session.beginTransaction();

           /* int studentId = 1;

            Student student = session.get(Student.class, studentId);
            System.out.println("Deleting student id " + student.getId());
            session.delete(student);*/

            session.createQuery("delete from Student where id=2").executeUpdate();


            System.out.println("\n");

            session.getTransaction().commit();

            List<Student> students = session.createQuery("from Student").list();

            displayAllStudents(students);

        } finally {
            sessionFactory.close();
        }


    }

    private static void displayAllStudents(List<Student> students) {
        students.forEach(System.out::println);
    }

}
