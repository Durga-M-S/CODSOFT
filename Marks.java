import java.util.Scanner;

public class MarksCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSubjects = 0;

        // Validate number of subjects
        while (true) {
            System.out.print("Enter number of subjects: ");
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive number.");
                scanner.next(); 
            }
        }

        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        boolean allSubjectsPassed = true;

        
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + " (0 to 100): ");
                if (scanner.hasNextInt()) {
                    int input = scanner.nextInt();
                    if (input >= 0 && input <= 100) {
                        marks[i] = input;
                        totalMarks += input;

                        
                        if (input < 35) {
                            allSubjectsPassed = false;
                        }

                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 100.");
                    scanner.next(); 
                }
            }
        }

        double average = (double) totalMarks / numSubjects;

        System.out.println("\n Results:");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);

        if (allSubjectsPassed) {
            
            char grade;
            if (average >= 90) {
                grade = 'A';
            } else if (average >= 80) {
                grade = 'B';
            } else if (average >= 70) {
                grade = 'C';
            } else if (average >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Status: Pass");
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Status: Fail (One or more subjects below 35)");
        }

        scanner.close();
    }
}
