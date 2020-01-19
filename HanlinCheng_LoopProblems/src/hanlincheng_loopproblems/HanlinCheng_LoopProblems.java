/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlincheng_loopproblems;

import java.util.Scanner;
import java.lang.Math;

//Hanlin Cheng
//Set 2
// Sep 10, 2017
//ICS4U1
public class HanlinCheng_LoopProblems {

    /**
     * @param args the command line arguments
     */
    public static void StandardDeviation() {
        Scanner input = new Scanner(System.in);
        int N; // declare the variables
        double data, sum, sqsum, sd, avgsquare;
        sum = 0;
        sqsum = 0;
        System.out.println("Standard Deviation"); 
        System.out.println("How many numbers do you want to enter?: ");
        N = input.nextInt(); // ask for the user input 
        for (int i = 1; i <= N; i++) { // loop until the number the user entered
            System.out.println("Enter Data: ");
            data = input.nextDouble();
            sum = (sum + data);
            sqsum = ((data * data) + sqsum);
        }
        avgsquare = ((sum / N) * (sum / N));
        sd = Math.sqrt((sqsum / N) - avgsquare); // calculate the standard deviation
        System.out.println("The Standard Deviation is : " + sd);
    }

    public static void AddingUpSquaresAndCubes() {
        Scanner input = new Scanner(System.in);
        int N, sSum, cSum; // declare variables
        sSum = 0; // set square sum initial to zero
        cSum = 0; // set cube sum initial to zero
        System.out.println("Upper Limit");
        N = input.nextInt(); // ask for user input 
        for (int i = 1; i <= N; i++) { // loop and add until N
            sSum = (sSum + (i * i));
            cSum = (cSum + (i * i * i));
        }

        System.out.println("The sum of Squares is " + sSum);
        System.out.println("The sum of Cubes is " + cSum);
        System.out.println("With the formula:");
        System.out.println("The sum of Squares is " + (((N * (N + 1) * (2 * N + 1)) / 6))); // Give the sum of the squares
        System.out.println("The sum of Cubes is " + ((N * N) * (N + 1) * (N + 1)) / 4); // Give the sum of the cubes

    }

    public static void PineTree() {
        // to print the top of the tree 
        for (int i = 0; i < 8; i++) { 
            for (int j = 0; j < 8 - i; j++) {
                System.out.print(" "); // for the spaces beforehand
            }
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*"); // loops to print stars
            }
            System.out.println();
        }
        //To print the stump of the tree
        for (int i = 1; i <= 3; i++) {
            System.out.println("       ***");
        }
    }

    public static void EtotheX() {
        Scanner input = new Scanner(System.in);
        System.out.println("E to the X"); 
        int x, N; //declare variables
        double sum;
        sum = 1.0; // set initial sum to zero
        double exp = 1.0;
        N = 2;
        System.out.println("Enter x:");
        x = input.nextInt(); // ask for user input
        double term = x;
        while (term > 1.0e-12) { // implement calculations  
            sum = sum + term;
            term = term * x / N;
            N++;
        }
        sum = sum + term;
        System.out.println("My E to the X is: " + sum);
        System.out.println("The real E to the X is: " + Math.exp(x));
        
    }

    public static void InRangeAdder() {
        Scanner input = new Scanner(System.in);
        int hRange, lRange, data, sum1, sum2; // declare variables
        sum1 = 0;
        sum2 = 0;
        data = 1;  // set inital sums to zero, data to one
        System.out.println("In-range Adder"); 
        System.out.println("Low end of range:");
        lRange = input.nextInt(); //ask for user input low limit
        System.out.println("High end of range:");
        hRange = input.nextInt(); // ask for user input upper limit
        while (data != 0) {
            System.out.println("Enter data:");
            data = input.nextInt(); // continue adding data until zero ends the program
            if (data <= hRange && data >= lRange) {
                sum1 = sum1 + data;
            } else {
                sum2 = sum2 + data;
            }
        }
        System.out.println("Sum of in range values: " + sum1);
        System.out.println("Sum of out of range values: " + sum2);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
         int choice; // declare variable

        do // menu
        {
            System.out.println();
            System.out.println("Choose from the following menu\n");
            System.out.println("Enter 1, 2, or 3");
            System.out.println("1 - Standard Deviation");
            System.out.println("2 - AddingUpSquaresAndCubes");
            System.out.println("3 - PineTree");
            System.out.println("4 - EtotheX");
            System.out.println("5 - InRangeAdder");

            System.out.println();
            System.out.println("Enter 0 to exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    StandardDeviation();
                    break;
                case 2:
                    AddingUpSquaresAndCubes();
                    break;
                case 3:
                    PineTree();
                    break;
                case 4:
                    EtotheX();
                    break;
                case 5:
                    InRangeAdder();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        System.out.println("The program has terminated");   // exit of program  

   
    }

}
