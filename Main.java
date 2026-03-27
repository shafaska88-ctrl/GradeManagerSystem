import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeManager manager = new GradeManager();


        manager.getStudents().addAll(
                GradeFileHandler.loadStudents());

        System.out.println("Welcome to the Student " +
                "Grade Management System");

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(
                        sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print(
                            "Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print(
                            "Enter student ID: ");
                    String id = sc.nextLine();
                    manager.addStudent(name, id);
                    break;

                case 2:
                    System.out.print(
                            "Enter student ID: ");
                    String gId = sc.nextLine();
                    System.out.print(
                            "Enter grade (0-10): ");
                    try {
                        double grade =
                                Double.parseDouble(
                                        sc.nextLine());
                        manager.addGrade(gId, grade);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid grade.");
                    }
                    break;

                case 3:
                    System.out.print(
                            "Enter student ID: ");
                    String rId = sc.nextLine();
                    manager.viewReport(rId);
                    break;

                case 4:
                    manager.viewAllStudents();
                    break;

                case 5:
                    manager.viewTopStudent();
                    break;

                case 6:
                    GradeFileHandler.saveStudents(
                            manager.getStudents());
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Try again.");
            }
        }
        sc.close();
    }


    private static void printMenu() {
        System.out.println("\n=== GRADE MANAGER ===");
        System.out.println("1. Add student");
        System.out.println("2. Add grade");
        System.out.println("3. View student report");
        System.out.println("4. View all students");
        System.out.println("5. View top student");
        System.out.println("6. Save and exit");
        System.out.println("=====================");
    }
}
