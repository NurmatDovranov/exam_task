package org.example.service;

import org.example.daoImpl.CourseDaoImpl;
import org.example.daoImpl.InstructorDaoImpl;
import org.example.daoImpl.LessonDaoImpl;
import org.example.daoImpl.TaskDaoImpl;
import org.example.maket.Course;
import org.example.maket.Instructor;
import org.example.maket.Lesson;
import org.example.maket.Task;

import java.util.List;

public class ServiceImpl implements Service{
    private final CourseDaoImpl courseDao = new CourseDaoImpl();
    private final InstructorDaoImpl instructorDao = new InstructorDaoImpl();
    private final LessonDaoImpl lessonDao = new LessonDaoImpl();
    private final TaskDaoImpl taskDao = new TaskDaoImpl();


    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public void updateCourse(int Id,Course course) {
        courseDao.updateCourse(Id,course);
    }

    @Override
    public Course getCourseById(int Id) {
        return courseDao.getCourseById(Id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void deleteCourseById(int Id) {
        courseDao.deleteCourseById(Id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(int Id,Instructor instructor) {
        instructorDao.updateInstructor(Id,instructor);
    }

    @Override
    public Instructor getInstructorById(int Id) {
        return instructorDao.getInstructorById(Id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(int Id) {
        return instructorDao.getInstructorByCourseId(Id);
    }

    @Override
    public void deleteInstructorById(int Id) {
        instructorDao.deleteInstructorById(Id);
    }

    @Override
    public void assignInstructorToCourse(int course_id, int instructor_id) {
        instructorDao.assignInstructorToCourse(course_id,instructor_id);
    }

    @Override
    public void saveLesson(int Id, Lesson lesson) {
        lessonDao.saveLesson(Id,lesson);
    }

    @Override
    public void updateLesson(int Id,Lesson lesson) {
        lessonDao.updateLesson(Id,lesson);
    }

    @Override
    public Lesson getLessonById(int Id) {
        return lessonDao.getLessonById(Id);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(int Id) {
        return lessonDao.getLessonsByCourseId(Id);
    }

    @Override
    public void saveTask(int Id, Task task) {
        taskDao.saveTask(Id,task);
    }


    @Override
    public void updateTask(int Id,Task task) {taskDao.updateTask(Id,task);}

    @Override
    public List<Task> getAllTaskByLessonId(int Id) {
        return taskDao.getAllTaskByLessonId(Id);
    }

    @Override
    public void deleteTaskById(int Id) {
        taskDao.deleteTaskById(Id);
    }
}
