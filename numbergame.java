import java.util.Random;
import java.util.Scanner;

public class  numbergame  {
    public static void main(String[] args) {
        guessTheNumber();
    }

    static void guessTheNumber() {
    
        int lowerLimit = 1;
        int upperLimit = 100;
        Random random = new Random();
        int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        
        int attemptsLimit = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
        
            roundsPlayed++;
            System.out.println("\nRound " + roundsPlayed + " - Guess the number between " + lowerLimit + " and " + upperLimit);

        
            for (int attempt = 1; attempt <= attemptsLimit; attempt++) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempt + " attempts.");
                    totalAttempts += attempt;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attempt == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
                }
            }
            scanner.close();

        
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

    
        System.out.println("\nGame Over. You played " + roundsPlayed + " rounds with an average of " + (double) totalAttempts / roundsPlayed + " attempts per round.");
    }
}
