package org.example.daoImpl;

import org.example.config.Config;
import org.example.dao.TaskDao;
import org.example.maket.Lesson;
import org.example.maket.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public void saveTask(int id, Task task) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lesson = session.find(Lesson.class,id);
            lesson.addTask(task);
            task.setLesson(lesson);
            session.save(task);
            session.getTransaction().commit();
            System.out.println("Task saved");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void updateTask(int id,Task task) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Task tasks = session.find(Task.class,id);
            tasks.setTaskName(task.getTaskName());
            tasks.setTaskDeadline(task.getTaskDeadline());
            tasks.setTask(task.getTask());
            session.getTransaction().commit();
            System.out.println("Task updated");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Task> getAllTaskByLessonId(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class,Id);
            List<Task> taskList = lesson.getTask();
            session.getTransaction().commit();
            session.close();
            return taskList;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public void deleteTaskById(int Id) {

        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Task task = session.find(Task.class,Id);
            task.setLesson(null);
            session.save(task);
            session.remove(task);
            System.out.println("Task by id deleted");
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}

