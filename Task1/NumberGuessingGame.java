import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int maxTries = 10;
            int guess;
            boolean win = false;

            System.out.println("Hello, " + name + "! I have selected a number between 1 and 100.");
            System.out.println("You have " + maxTries + " attempts to guess it. Good luck!");

            for (int tries = 1; tries <= maxTries; tries++) {
                System.out.print("Attempt " + tries + ": Enter your guess: ");
                guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Your guess is out of the range! Please guess a number between 1 and 100.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    win = true;
                    System.out.println("Congratulations, " + name + "! You guessed the number in " + tries + " attempts.");
                    score += (maxTries - tries + 1);
                    break;
                }

                if (tries == maxTries) {
                    System.out.println("Sorry, " + name + ". You've used all your attempts. The number was " + numberToGuess + ". Better luck next time!");
                }
            }

            System.out.println("Your current score is: " + score);

            System.out.print("Do you want to continue the game? Yes/No: ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("Yes");

            if (!playAgain) {
                System.out.println("Thanks for playing, " + name + "! Your final score is: " + score);
            }
        }

        scanner.close();
    }
}
