public class Student {

    private String name;
    private String studentId;
    private double[] grades;
    private int gradeCount;


    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new double[10];
        this.gradeCount = 0;
    }


    public Student(String name, String studentId,
                   double[] grades, int gradeCount) {
        this.name = name;
        this.studentId = studentId;
        this.grades = grades;
        this.gradeCount = gradeCount;
    }


    public void addGrade(double grade) {
        if (grade < 0 || grade > 10) {
            System.out.println("Grade must be " +
                    "between 0 and 10.");
            return;
        }
        if (gradeCount >= grades.length) {
            System.out.println("Maximum grades reached.");
            return;
        }
        grades[gradeCount] = grade;
        gradeCount++;
        System.out.println("Grade " + grade +
                " added for " + name);
    }


    public double getAverage() {
        if (gradeCount == 0) return 0.0;
        double total = 0;
        for (int i = 0; i < gradeCount; i++) {
            total += grades[i];
        }
        return total / gradeCount;
    }


    public double getHighest() {
        if (gradeCount == 0) return 0.0;
        double highest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }


    public double getLowest() {
        if (gradeCount == 0) return 0.0;
        double lowest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }


    public String getStatus() {
        if (gradeCount == 0) return "No grades yet";
        return getAverage() >= 5.0 ? "PASS" : "FAIL";
    }

    public void printGrades() {
        if (gradeCount == 0) {
            System.out.println("No grades added yet.");
            return;
        }
        System.out.print("Grades for " + name + ": ");
        for (int i = 0; i < gradeCount; i++) {
            System.out.print(grades[i]);
            if (i < gradeCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }


    public String getName()      { return name; }
    public String getStudentId() { return studentId; }
    public double[] getGrades()  { return grades; }
    public int getGradeCount()   { return gradeCount; }


    @Override
    public String toString() {
        return "ID: " + studentId
                + " | Name: " + name
                + " | Average: " + String.format("%.2f",
                getAverage())
                + " | Status: " + getStatus();
    }
}