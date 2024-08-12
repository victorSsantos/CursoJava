package collections.set.application;

import collections.set.entities.Course;
import collections.set.entities.Student;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("How many courses to register? ");
        int nCourses = sc.nextInt();
        List<Course> courses = new ArrayList<>();

        sc.nextLine();
        for (var i=0 ; i < nCourses ; ++i){
            System.out.print("What the name of the course #" + (i+1)+ "? ");
            String nameCourse = sc.nextLine();
            System.out.print("How many students for course " + nameCourse + "? ");
            int nStudentsA = sc.nextInt();

            Course course = new Course(nameCourse, new HashSet<>());
            sc.nextLine();
            for (var j=0 ; j < nStudentsA ; ++j){
                System.out.println("Enter student #" + (j+1) + " data:" );
                System.out.print("First name: ");
                String firstNameStudent = sc.nextLine();
                System.out.print("Last name: ");
                String LastNameStudent = sc.nextLine();
                System.out.print("E-mail: ");
                String emailStudent = sc.nextLine();

                Student student = new Student(firstNameStudent, LastNameStudent , emailStudent);
                course.getStudents().add(student);
            }
            courses.add(course);
        }
        System.out.println("Total Students: " + Course.totalStudents(courses) );
    }
}
