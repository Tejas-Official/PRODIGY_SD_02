
package advancedguessthenumbergui;
import java.util.Scanner;
import java.util.Random;

public class AdvancedGuessTheNumberGUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange, maxRange, maxAttempts;
        int userGuess;
        int attempts;

        System.out.println("Welcome to Advanced Guess the Number Game!");

        do {
            System.out.print("Choose difficulty level (easy, medium, hard): ");
            String difficulty = scanner.nextLine().toLowerCase();

            switch (difficulty) {
                case "easy":
                    minRange = 1;
                    maxRange = 50;
                    maxAttempts = 10;
                    break;
                case "medium":
                    minRange = 1;
                    maxRange = 100;
                    maxAttempts = 7;
                    break;
                case "hard":
                    minRange = 1;
                    maxRange = 200;
                    maxAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid difficulty. Please choose again.");
                    continue;
            }

            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            attempts = 0;

            System.out.println("I have generated a number between " + minRange + " and " + maxRange +
                    ". You have " + maxAttempts + " attempts. Good luck!");

            do {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }

            } while (userGuess != generatedNumber && attempts < maxAttempts);

            if (userGuess != generatedNumber) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + generatedNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }

        } while (true);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
