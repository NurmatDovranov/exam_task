package org.example.maket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    @Column(name = "lesson_name")
    private String lessonName;
    @Column(name = "lesson_video_link")
    private String lessonVideoLink;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;
    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.EAGER,
            mappedBy = "lesson")
    private List<Task> task;

    public void addTask(Task newTask) {
        this.task.add(newTask);
    }

    public Lesson(String lessonName, String lessonVideoLink) {
        this.lessonName = lessonName;
        this.lessonVideoLink = lessonVideoLink;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                ", lessonVideoLink='" + lessonVideoLink + '\'' +
                '}';
    }
}
