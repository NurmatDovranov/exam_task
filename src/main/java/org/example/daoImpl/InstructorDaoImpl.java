package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.maket.Course;
import org.example.maket.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    @Override
    public void saveInstructor(Instructor instructor) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Instructor saved");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void updateInstructor(int Id,Instructor instructor) {

        try {
             Session session = Config.getSession().openSession();
             session.beginTransaction();
             Instructor instructors = session.find(Instructor.class,Id);
             instructors.setFirstName(instructor.getFirstName());
             instructors.setEmail(instructor.getEmail());
             instructors.setPhoneNumber(instructor.getPhoneNumber());
             session.getTransaction().commit();
            System.out.println("Instructor updated");
             session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Instructor getInstructorById(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class,Id);
            session.getTransaction().commit();
            session.close();
            return instructor;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Instructor> getInstructorByCourseId(int Id) {

        try {
            Session  session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.get(Course.class,Id);
            List<Instructor> instructors = course.getInstructors();
            session.getTransaction().commit();
            session.close();
            return instructors;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public void deleteInstructorById(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class,Id);
            session.delete(instructor);
            session.getTransaction().commit();
            System.out.println("Instructor removed by id");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void assignInstructorToCourse(int course_id, int instructor_id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class,instructor_id);
            Course course = session.find(Course.class,course_id);
            instructor.addCourse(course);
            course.addInstructors(instructor);
            session.persist(instructor);
          //  session.persist(course);
            session.getTransaction().commit();
            System.out.println("Instructor assigned to course");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}

