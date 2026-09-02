import java.util.ArrayList;

public class GradeManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean hasStudents() {
        return !students.isEmpty();
    }

    public void displayStudents() {

        if (!hasStudents()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n===== Student Records =====");

        for (Student student : students) {
            System.out.printf(
                    "Name: %-15s Grade: %.2f%n",
                    student.getName(),
                    student.getGrade()
            );
        }
    }

    public double calculateAverage() {

        if (!hasStudents()) {
            return 0;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getGrade();
        }

        return total / students.size();
    }

    public double findHighestGrade() {

        if (!hasStudents()) {
            return 0;
        }

        double highest = students.get(0).getGrade();

        for (Student student : students) {
            if (student.getGrade() > highest) {
                highest = student.getGrade();
            }
        }

        return highest;
    }

    public double findLowestGrade() {

        if (!hasStudents()) {
            return 0;
        }

        double lowest = students.get(0).getGrade();

        for (Student student : students) {
            if (student.getGrade() < lowest) {
                lowest = student.getGrade();
            }
        }

        return lowest;
    }
    public void displaySummary() {

        if (!hasStudents()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n========== SUMMARY REPORT ==========");

        displayStudents();

        System.out.printf(
                "\nAverage Grade : %.2f%n",
                calculateAverage()
        );
        System.out.printf(
                "Highest Grade : %.2f%n",
                findHighestGrade()
        );
        System.out.printf(
                "Lowest Grade  : %.2f%n",
                findLowestGrade()
        );
        System.out.println("====================================");
    }
}