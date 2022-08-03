package org.example.dao;

import org.example.maket.Course;

import java.util.List;

public interface CourseDao {void saveCourse(Course course);

    void updateCourse(int Id,Course course);

    Course getCourseById(int Id);

    List<Course> getAllCourse();

    void deleteCourseById(int Id);

    Course getCourseByName(String name);
}
