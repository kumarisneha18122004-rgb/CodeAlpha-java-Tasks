import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");
        System.out.println("Enter student grades (Enter -1 to stop):");

        while (true) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            if (grade == -1) {
                break;
            }
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade! Please enter a value between 0 and 100.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            int total = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int grade : grades) {
                total += grade;
                if (grade > highest) highest = grade;
                if (grade < lowest) lowest = grade;
            }

            double average = (double) total / grades.size();

            System.out.println("\n--- Summary Report ---");
            System.out.println("Total Students: " + grades.size());
            System.out.printf("Average Score: %.2f\n", average);
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
        }

        scanner.close();
    }
}
