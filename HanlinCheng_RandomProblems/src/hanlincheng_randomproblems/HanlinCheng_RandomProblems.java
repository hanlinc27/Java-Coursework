/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlincheng_randomproblems;
//Hanlin Cheng
//Sept 14, 2017
//Random Questions
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Hanlin
 */
public class HanlinCheng_RandomProblems {

    /**
     * @param args the command line arguments
     */
    public static void GuessingGame() {
        Scanner input = new Scanner(System.in);
        Random r = new Random(); //new random object
        int guess, rnum, count, accuracy, accuracy2; //declare variables
        String rating = null; //set the a string to null
        accuracy = 0; // set initial accuracy to zero

        for (int i = 1; i <= 10; i++) { //loop through ten rounds
            accuracy2 = i; //set the comparison accuracy to i
            System.out.println("");
            System.out.println("round " + i + " :");
            System.out.println("");
            count = 1; //set the accuracy count to 1
            rnum = ((r.nextInt(10)) + 1); // generate a random number for this round
            System.out.println("I am thinking of a number from 1 to 10.\nYou must guess what it is in three tries.");
            System.out.println("Enter a guess:");

            while (count <= 3) { //while loop so there can only be max three tries
                guess = input.nextInt();
                if (guess == rnum) { //scenario for a correct guess
                    accuracy++;
                    accuracy2++;
                    System.out.println("RIGHT! \nYou have won the game.");
                    count = 4;
                } else if (Math.abs(rnum - guess) == 1) { // scenario for if user guess is hot
                    System.out.println("Hot");
                    count++;
                } else if (Math.abs(rnum - guess) == 2) { //scenario for if user guess is warm
                    System.out.println("Warm");
                    count++;
                } else {
                    System.out.println("Cold"); //scenario for if user guess is cold
                    count++;
                }
            }
            if (accuracy2 == (i + 1)) { // print statement for if they lost the round
                System.out.println("The correct number was " + rnum);
                System.out.println("You have lost " + (i - accuracy) + " out of " + i + " rounds.");
            } else { //print statement for if they won the round
                System.out.println("You have won " + accuracy + " out of " + i + " rounds.");
            }

        }
        //Categorizing what the different ratings are
        if (accuracy == 7) {
            rating = "amateurs";
        }
        if (accuracy == 8) {
            rating = "advanced";
        }
        if (accuracy == 9) {
            rating = "professionals";
        }
        if (accuracy == 10) {
            rating = "hackers";
        }
        System.out.println("");
        System.out.println("Your rating: " + rating); //final print statement
    }

    public static void Pig() {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        boolean exit = false;
        int pi = 0, tsum, csum;
        int workingsum;
        tsum = 0;
        csum = 0;
        System.out.println("Pig");
        while (exit == false) { //The start of a round

            for (int i = 1; i <= 3; i++) {
                csum = csum + (r.nextInt(6) + 1);   //lets the computer roll three dies
            }
            if (csum >= 100) {
                exit = true;    //checks if the computer sum is greater than 100
            }

            System.out.println("");
            System.out.print("Computer sum is: ");
            System.out.println(csum);

            boolean player = false; // declare boolean for player as false
            workingsum = 0; //the working sum is set to zero

            while (player == false) {
                System.out.println("Press any number to roll, press zero to end.");
                int t;
                t = input.nextInt(); // input for the player's turn to start

                if (t != 0) { //as long as the player doesn't enter zero
                    int j;
                    j = (r.nextInt(6) + 1);
                    if (j == 1) { // if the player rolls a 1
                        System.out.println("You rolled a 1 ! ");
                        workingsum = 0; 
                        System.out.println("The total sum is: " + tsum);
                        player = true;
                    } else { // when the player enters zero
                        workingsum = workingsum + j;

                        System.out.println("Your working sum is: " + workingsum);
                    }
                } else { // if the player rolls anything but a one
                    tsum = tsum + workingsum;
                    System.out.println("The total sum is: " + tsum);
                    player = true;
                }
                if (tsum >= 100) { // if the sum of player is greater than 100
                    player = true;
                    exit = true;
                }
            }
        }

        //To see who has won the game
        if (tsum >= 100) {
            System.out.println("You won the game!");
        } else {
            System.out.println("Computer won the game!");
        }
    }
   
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
         int choice; // declare variable

        do // menu
        {
            System.out.println();
            System.out.println("Choose from the following menu\n");
            System.out.println("Enter 1 or 2");
            System.out.println("1 - Guessing Game");
            System.out.println("2 - Pig");

            System.out.println();
            System.out.println("Enter 0 to exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    GuessingGame();
                    break;
                case 2:
                    Pig();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        System.out.println("The program has terminated");   // exit of program  

   


    }

}
