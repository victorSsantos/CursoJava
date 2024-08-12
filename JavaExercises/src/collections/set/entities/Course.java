package collections.set.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {

    private String name;
    private Set<Student> students;

    public Course() {
    }

    public Course(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public static int totalStudents(List<Course> courses){

        if(courses!=null){
            Set<Student> total = new HashSet<>();
            for (var course : courses){
                total.addAll(course.students);
            }

            return total.size();
        }
        return 0;
    }
}
