package org.example.dao;

import org.example.maket.Instructor;

import java.util.List;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);

    void updateInstructor(int Id, Instructor instructor);

    Instructor getInstructorById(int Id);

    List<Instructor> getInstructorByCourseId(int Id);

    void deleteInstructorById(int Id);

    void assignInstructorToCourse(int course_id,int instructor_id);
}
