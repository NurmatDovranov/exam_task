package org.example.dao;

import org.example.maket.Task;

import java.util.List;

public interface TaskDao {

        void saveTask(int Id, Task task);

        void updateTask(int Id,Task task);
        List<Task> getAllTaskByLessonId(int Id);

        void deleteTaskById(int Id);

    }

