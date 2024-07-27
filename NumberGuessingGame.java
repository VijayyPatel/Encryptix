import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        boolean playAgain = true;
        int roundsWon = 0;
        int totalAttempts = 0;
        int roundsPlayed = 0;

        while (playAgain) {
            boolean guessedCorrectly = false;
            int numberToGuess = random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
            int attempts = 0;

            System.out.println("I have generated a number between " + RANGE_START + " and " + RANGE_END + ". Can you guess it?");
            
            while (!guessedCorrectly && attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    roundsWon++;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess);
            }

            roundsPlayed++;
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Here are your stats:");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Average attempts per round: " + (totalAttempts / (double) roundsPlayed));

        scanner.close();
    }
}
