import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        final int MAX_ATTEMPTS = 5;

        int roundsPlayed = 0;
        int roundsWon = 0;

        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Type 'exit' anytime during guessing to quit the game.\n");

        while (playAgain) {
            roundsPlayed++;
            int randomNum = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + roundsPlayed + ": Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");

                String input = scanner.next();

            
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("👋 Exiting the game. Thanks for playing!");
                    printSummary(roundsPlayed - 1, roundsWon); 
                    scanner.close();
                    return;
                }

                
                int userGuess;
                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number between 1 and 100.");
                    continue;
                }

                
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Number out of range! Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (userGuess == randomNum) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempt(s).");
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess > randomNum) {
                    System.out.println("Too high! Attempts left: " + (MAX_ATTEMPTS - attempts));
                } else {
                    System.out.println("Too low! Attempts left: " + (MAX_ATTEMPTS - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts. The correct number was: " + randomNum);
            }

            playAgain = askToPlayAgain(scanner);
        }

        printSummary(roundsPlayed, roundsWon);
        scanner.close();
    }

    
    private static boolean askToPlayAgain(Scanner scanner) {
        String answer;
        while (true) {
            System.out.print("Do you want to play again? (yes/no): ");
            answer = scanner.next().trim().toLowerCase();
            if (answer.equals("yes")) {
                return true;
            } else if (answer.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }
    }

    
    private static void printSummary(int roundsPlayed, int roundsWon) {
        System.out.println("\n Game Over!");
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Total rounds won: " + roundsWon);
        double winRate = (roundsPlayed == 0) ? 0 : ((double) roundsWon / roundsPlayed) * 100;
        System.out.printf("Your win rate: %.2f%%\n", winRate);
        System.out.println("Thanks for playing!");
    }
}
