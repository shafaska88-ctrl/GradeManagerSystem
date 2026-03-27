
import java.util.ArrayList;

public class GradeManager {

    private ArrayList<Student> students;


    public GradeManager() {
        this.students = new ArrayList<>();
    }


    public void addStudent(String name,
                           String studentId) {
        if (findStudent(studentId) != null) {
            System.out.println("Student ID already " +
                    "exists.");
            return;
        }
        students.add(new Student(name, studentId));
        System.out.println("Student " + name +
                " added successfully.");
    }


    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }


    public void addGrade(String studentId,
                         double grade) {
        Student s = findStudent(studentId);
        if (s != null) {
            s.addGrade(grade);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void viewReport(String studentId) {
        Student s = findStudent(studentId);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("\n=== Student Report ===");
        System.out.println("Name:    " + s.getName());
        System.out.println("ID:      " +
                s.getStudentId());
        s.printGrades();
        System.out.printf("Average: %.2f%n",
                s.getAverage());
        System.out.println("Highest: " +
                s.getHighest());
        System.out.println("Lowest:  " +
                s.getLowest());
        System.out.println("Status:  " +
                s.getStatus());
        System.out.println("======================");
    }


    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n=== All Students ===");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("====================");
    }


    public void viewTopStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getAverage() > top.getAverage()) {
                top = s;
            }
        }
        System.out.println("\nTop Student: " +
                top.getName() +
                " | Average: " + String.format("%.2f",
                top.getAverage()));
    }


    public ArrayList<Student> getStudents() {
        return students;
    }
}