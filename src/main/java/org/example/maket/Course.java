package org.example.maket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq",allocationSize = 1)
    private int Id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "imagine_link")
    private String imagineLink;
    private String description;

    @ManyToMany(mappedBy = "course",cascade = {
        CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH},fetch = FetchType.LAZY)
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course",fetch = FetchType.EAGER)
    private List<Lesson> lessons;

    public void addInstructors(Instructor instructor) {
        instructor.getCourse().add(this);
    }

    public Course(String courseName, String duration,
                  LocalDate createAt, String imagineLink,
                  String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imagineLink = imagineLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_name='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", create_at=" + createAt +
                ", imagine_link='" + imagineLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
