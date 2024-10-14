import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();
        int totalScore = 0;
        
        for (int i = 0; i < rounds; i++) {
            totalScore += playGame(scanner, random);
        }
        
        System.out.println("Total score after " + rounds + " rounds: " + totalScore);
        scanner.close();
    }
    
    private static int playGame(Scanner scanner, Random random) {
        int lowerBound = 1;
        int upperBound = 100;
        int number = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attempts = 0;
        int maxAttempts = 10;
        int score = 0;
        
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);
        
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess < number) {
                System.out.println("Too low!");
            } else if (guess > number) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct Guess!");
                score = 1;
                break;
            }
        }
        
        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + number + ".");
        }
        
        System.out.println("Your score: " + score);
        return score;
    }
}
