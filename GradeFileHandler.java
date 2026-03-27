import java.io.*;
import java.util.ArrayList;

public class GradeFileHandler {

    private static final String FILE_NAME =
            "students.txt";


    public static void saveStudents(
            ArrayList<Student> students) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(FILE_NAME))) {
            for (Student s : students) {

                StringBuilder sb = new StringBuilder();
                sb.append(s.getName()).append(",");
                sb.append(s.getStudentId()).append(",");
                sb.append(s.getGradeCount());
                for (int i = 0;
                     i < s.getGradeCount(); i++) {
                    sb.append(",")
                            .append(s.getGrades()[i]);
                }
                pw.println(sb.toString());
            }
            System.out.println("Data saved " +
                    "successfully.");
        } catch (IOException e) {
            System.out.println("Error saving: " +
                    e.getMessage());
        }
    }


    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No saved data found. " +
                    "Starting fresh.");
            return students;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String name  = parts[0];
                    String id    = parts[1];
                    int count    = Integer.parseInt(
                            parts[2]);
                    double[] grades = new double[10];
                    for (int i = 0; i < count; i++) {
                        grades[i] = Double.parseDouble(
                                parts[3 + i]);
                    }
                    students.add(new Student(
                            name, id, grades, count));
                }
            }
            System.out.println("Data loaded " +
                    "successfully.");
        } catch (IOException e) {
            System.out.println("Error loading: " +
                    e.getMessage());
        }
        return students;
    }
}