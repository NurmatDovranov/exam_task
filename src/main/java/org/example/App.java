package org.example;


import org.example.daoImpl.CourseDaoImpl;
import org.example.maket.Course;
import org.example.maket.Instructor;
import org.example.maket.Lesson;
import org.example.maket.Task;
import org.example.service.ServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceImpl service = new ServiceImpl();
        System.out.println("Press 1 to save course \nPress 2 to update course" +
                "\nPress 3 to get all courses \nPress 4 to delete course by id" +
                "\nPress 5 to get course by id \nPress 6 to get course by name");
        System.out.println("Press 7 to save instructor \nPress 8 to update instructor" +
                "\nPress 9 to delete instructor by id \nPress 10 to get course by id" +
                "\nPress 11 to delete");

        int number = scanner.nextInt();

        switch(number) {
            case 1:
                service.saveCourse(new Course("Python","18 months", (
                        LocalDate.of(2022,7,22)), "python.com","python"));
                break;
            case 2:
                service.updateCourse(1,new Course("java","20 months",(LocalDate.of(2022,4,01)),
                        "java.com","java"));
                break;
            case 3:
                service.getAllCourse().forEach(System.out::println);
                break;
            case 4:
                service.deleteCourseById(2);
                break;
            case 5:
                System.out.println(service.getCourseById(1));
                break;
            case 6:
                System.out.println(service.getCourseByName("SQL"));
                break;
            case 7:
                service.saveInstructor(new Instructor("Askar","Akaev",
                        "akaev@yahoo.com","+746484512515"));
                break;
            case 8:
                service.updateInstructor(3,new Instructor("Kurmanbek","Bakiev",
                        "bakiev@mail.ru", "+7998856464103"));
                break;
            case 9:
                service.deleteInstructorById(5);
                break;
            case 10:
                service.getInstructorByCourseId(1).forEach(System.out::println);
                break;
            case 11:
                System.out.println(service.getInstructorById(4));
                break;
            case 12:
                service.assignInstructorToCourse(4,2);
                break;
            case 13:
                service.saveLesson(1,new Lesson("Instruction","https://www.youtube.com/watch?v=mguK3vIpGKE"));
                break;
            case 14:
                service.updateLesson(5,new Lesson("How i danced in Bishkek","https://www.youtube.com/watch?v=mcIFk2cDC50"));
                break;
            case 15:
                System.out.println(service.getLessonById(5));
                break;
            case 16:
                System.out.println(service.getLessonsByCourseId(1));
                break;
            case 17:
                service.saveTask(10,new Task("How I escape",
                        (LocalDate.of(2022,7,19)),"I will be back"));
                break;
            case 18:
                service.updateTask(13,new Task("How I dance Andijan..",
                        (LocalDate.of(2022,7,21)), "Repaet after me0(-^-)"));
                break;
            case 19:
                System.out.println(service.getAllTaskByLessonId(8));
                break;
            case 20:
                service.deleteTaskById(11);
                break;
            default:
                System.err.println("Press from 1 to 11");
        }

        CourseDaoImpl dao = new CourseDaoImpl();
        dao.deleteCourseById(1);
    }
}