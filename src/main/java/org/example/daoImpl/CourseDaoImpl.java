package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.maket.Course;
import org.example.maket.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

@Override
public void saveCourse(Course course) {

       try {
           Session session = Config.getSession().openSession();
           session.beginTransaction();
           session.save(course);
           session.getTransaction().commit();
           System.out.println("Course saved");
           session.close();
       } catch (HibernateException e) {
           System.out.println(e.getMessage());
       }

        }
@Override
public void updateCourse(int Id, Course course) {

         try {
             Session session = Config.getSession().openSession();
             session.beginTransaction();
             Course courses = session.find(Course.class,Id);
             courses.setCourseName(course.getCourseName());
             courses.setDuration(course.getDuration());
             courses.setCreateAt(course.getCreateAt());
             courses.setDescription(course.getDescription());
             courses.setImagineLink(course.getImagineLink());
             session.getTransaction().commit();
             System.out.println("Course updated");
             session.close();
         } catch (HibernateException e) {
             System.out.println(e.getMessage());
         }
        }
@Override
public Course getCourseById(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.get(Course.class,Id);
            session.getTransaction().commit();
            session.close();
             return course;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
        }
@Override
public List<Course> getAllCourse() {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Query<Course> query = session.createQuery("SELECT c FROM Course c ORDER BY c.createAt DESC",Course.class);
            List<Course> courses = query.getResultList();
            session.getTransaction().commit();
            session.close();
            return courses;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
        }
@Override
public void deleteCourseById(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,Id);
            for (Instructor i : course.getInstructors()) {i.setCourse(null);}
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Course removed by id");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        }
@Override
public Course getCourseByName(String name) {

      try {
          Session session = Config.getSession().openSession();
          session.beginTransaction();
          Course course = session.createQuery("select c from Course c where c.courseName = :name",Course.class)
                  .setParameter("name",name)
                  .getSingleResult();
          session.getTransaction().commit();
          session.close();
          return course;
      } catch (HibernateException e) {
          System.out.println(e.getMessage());
          return null;
      }
    }
}
