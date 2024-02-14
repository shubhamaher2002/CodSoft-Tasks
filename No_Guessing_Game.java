/*
Firts Task Of the codsoft internship. 
In this task We created a Random number(1-100) using random module & get input no from the user and check weather the guessed is right or not
In this Guessing game user has 20 chances to Guess the correct number. If user dont guess the number then user loose the game.
*/ 
import java.util.Scanner;
import java.util.Random;

public class No_Guessing_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("***Welcome to the Game***");
        while (!exit) {
            System.out.println("Enter following option:");
            System.out.println("1: Play Game\n2: Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    play_Game();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("You Entered an Invalid Choice...");
            }
        }
        sc.close();
    }

    public static void play_Game() {
        System.out.println("Note - You have 20 lives only ");
        Scanner sc = new Scanner(System.in);
        Random rdm = new Random();
        int new_rdm = rdm.nextInt(100);
        int count = 0;
        while (count < 20) {
            System.out.println("Chances remaining: " + (20 - count));
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            count++;
            if (guess == new_rdm) {
                System.out.println("Congratulations! You guessed the correct number in " + count + " attempts.");
                if(count>18) {
                	System.out.println("TOO High/Congratulation :)");
                }
                else if(count<5) {
                	System.out.println("Too Low/Very low accuracy");
                }
                return;
                
            } else if (guess < new_rdm) {
                System.out.println("Too low. Try a higher number.");
            } else {
                System.out.println("Too high. Try a lower number.");
            }
        }
        System.out.println("Sorry, you have used all your chances. The correct number was: " + new_rdm);
    }
}
