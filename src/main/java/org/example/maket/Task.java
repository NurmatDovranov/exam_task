package org.example.maket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter@Setter

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_deadline")
    private LocalDate taskDeadline;
    private String task;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
    CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Lesson lesson;

    public Task(String taskName, LocalDate taskDeadline, String task) {
        this.taskName = taskName;
        this.taskDeadline = taskDeadline;
        this.task = task;

    }

    @Override
    public String toString() {
        return "Task{" +
                "task_name='" + taskName + '\'' +
                ", task_deadline='" + taskDeadline + '\'' +
                ", task_task='" + task + '\'' +
                '}';
    }
}
