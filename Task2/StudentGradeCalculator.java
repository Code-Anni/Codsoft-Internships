import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects;
        int totalMarks = 0;

        
        System.out.println("Welcome to the Student Grade Calculator!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();
        
        int[] marks = new int[numberOfSubjects];

       
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " out of 100: ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

       
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        char grade;

        
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        
        System.out.println("\n----- Results for " + name + " -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");

        scanner.close();
    }
}
