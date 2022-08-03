package org.example.service;

import org.example.maket.Course;
import org.example.maket.Instructor;
import org.example.maket.Lesson;
import org.example.maket.Task;

import java.util.List;

public interface Service {
    void saveCourse(Course course);

    void updateCourse(int Id,Course course);


    Course getCourseById(int Id);

    List<Course> getAllCourse();

    void deleteCourseById(int Id);

    Course getCourseByName(String name);

    void saveInstructor(Instructor instructor);

    void updateInstructor(int Id,Instructor instructor);

    Instructor getInstructorById(int Id);

    List<Instructor> getInstructorByCourseId(int Id);

    void deleteInstructorById(int Id);

    void assignInstructorToCourse(int course_id,int instructor_id);

    void saveLesson(int Id, Lesson lesson);

    void updateLesson(int Id,Lesson lesson);

    Lesson getLessonById(int Id);

    List<Lesson> getLessonsByCourseId(int Id);

    void saveTask(int Id, Task task);

    void updateTask(int Id,Task task);

    List<Task> getAllTaskByLessonId(int Id);

    void deleteTaskById(int Id);
}
