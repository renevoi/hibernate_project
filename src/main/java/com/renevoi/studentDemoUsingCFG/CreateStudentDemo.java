package com.renevoi.studentDemoUsingCFG;

import com.renevoi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args){

        /*Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.configure("hibernate.cfg.xml");*/

        // Create Session Factory
        SessionFactory sessionFactory = new Configuration()
                                        .configure()
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        // Create Session
        Session session = sessionFactory.openSession();

        try {

            // create a Student Object
            Student studentRene = new Student("Renevoi", "Catapang", "renevoi.catapang@gmail");

            // start a Transaction
            session.beginTransaction();
            // save the Student Object
            session.save(studentRene);
            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }

}
