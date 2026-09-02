import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GradeManager manager = new GradeManager();

        System.out.println("====================================");
        System.out.println("       STUDENT GRADE TRACKER");
        System.out.println("====================================");

        boolean running = true;

        while (running) {

            System.out.println("\n----------- MENU -----------");
            System.out.println("1. Add Students");
            System.out.println("2. View Students");
            System.out.println("3. Calculate Average");
            System.out.println("4. Find Highest Grade");
            System.out.println("5. Find Lowest Grade");
            System.out.println("6. Summary Report");
            System.out.println("7. Exit");
            System.out.println("----------------------------");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("How many students do you want to add? ");
                    int numberOfStudents = scanner.nextInt();
                    scanner.nextLine();

                    if (numberOfStudents <= 0) {
                        System.out.println(
                                "Number of students must be greater than 0."
                        );
                        break;
                    }

                    for (int i = 1; i <= numberOfStudents; i++) {

                        System.out.println("\nStudent " + i);

                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();

                        while (name.trim().isEmpty()) {
                            System.out.print(
                                    "Name cannot be empty. Enter student name: "
                            );
                            name = scanner.nextLine();
                        }

                        System.out.print("Enter grade (0-100): ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine();

                        if (grade < 0 || grade > 100) {
                            System.out.println(
                                    "Invalid grade. Grade must be between 0 and 100."
                            );
                            i--;
                            continue;
                        }

                        Student student = new Student(name, grade);
                        manager.addStudent(student);

                        System.out.println("Student added successfully.");
                    }
                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    if (!manager.hasStudents()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.printf(
                                "Average Grade: %.2f%n",
                                manager.calculateAverage()
                        );
                    }
                    break;

                case 4:
                    if (!manager.hasStudents()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.printf(
                                "Highest Grade: %.2f%n",
                                manager.findHighestGrade()
                        );
                    }
                    break;

                case 5:
                    if (!manager.hasStudents()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.printf(
                                "Lowest Grade: %.2f%n",
                                manager.findLowestGrade()
                        );
                    }
                    break;

                case 6:
                    manager.displaySummary();
                    break;

                case 7:
                    running = false;
                    System.out.println(
                            "\nThank you for using Student Grade Tracker!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select between 1 and 7."
                    );
            }
        }
        scanner.close();
    }
}