package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.LessonDao;
import org.example.maket.Course;
import org.example.maket.Lesson;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class LessonDaoImpl implements LessonDao {
    @Override
    public void saveLesson(int Id, Lesson lesson) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,Id);
            lesson.setCourse(course);
            session.persist(lesson);
            session.getTransaction().commit();
            System.out.println("Lesson saved");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void updateLesson(int Id,Lesson lesson) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lessons = session.find(Lesson.class,Id);
            lessons.setLessonName(lesson.getLessonName());
            lessons.setLessonVideoLink(lesson.getLessonVideoLink());
            session.getTransaction().commit();
            System.out.println("Lesson updated");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Lesson getLessonById(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class,Id);
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public List<Lesson> getLessonsByCourseId(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,Id);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            session.close();
            return  lessons;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

