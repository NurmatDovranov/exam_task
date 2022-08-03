package org.example.dao;

import org.example.maket.Lesson;

import java.util.List;

public interface LessonDao {
    void saveLesson(int Id,Lesson lesson);

    void updateLesson(int Id,Lesson lesson);

    Lesson getLessonById(int Id);

    List<Lesson> getLessonsByCourseId(int Id);
}
