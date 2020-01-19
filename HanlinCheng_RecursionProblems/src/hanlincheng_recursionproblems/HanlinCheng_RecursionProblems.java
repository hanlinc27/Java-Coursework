/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlincheng_recursionproblems;
//Hanlin Cheng
//Sept 25, 2017

import java.util.Scanner;

/**
 *
 * @author Hanlin
 */
public class HanlinCheng_RecursionProblems {

    /**
     * @param a
     * @param b
     * @return
     */
    public static int GCFRecursion(int a, int b) {

        if (b == 0) { //in the case that b == 0
            return a;
        } else {
            return (GCFRecursion(b, a % b)); //swap the b to the int a
            //taking the remainder of a/b
        }
    }
//*******************************************************************************

    public static int GCFLoop(int a, int b) {
        while (a != b) { //while the two numbers are not the same
            if (a == 0) { // situations for if a or b is 0
                return b;
            } else if (b == 0) {
                return a;
            }
            else if (a > b) { //continuous subtraction to find GCF
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
//***************************************************************************************

    public static int FibonacciRecursion(int s) {
        if (s == 0) {  //for if the 0th term is called
            return 0;
        } else if (s == 1) { //for if the first term is called
            return 1;
        } else {
            return FibonacciRecursion(s - 1) + FibonacciRecursion(s - 2); //runs through the loop for the two numbers before (which sums up to those two numbers)

        }
    }
//*****************************************************************************************

    public static int FibonacciLoop(int i) {
        int a = 0; //zeroth term
        int b = 1; //first term
        int c = 0; //second term
        if (i == 0) {
            return 0;
        }
        else if (i == 1){
            return 1;
        }
        else {
        for (int j = 1; j <=i-1; j++) {
            c = a + b; //sums up the two terms before
            a = b; //switches
            b = c; //switches
        }
        }
        return c;
    }
//********************************************************************************************

    public static void GreatestCommonFactor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Greatest Common Factor");
        int n1, n2; //the two numbers which the user wants the gcf of
        System.out.println("What is your first integer?"); //ask for the first method
        n1 = input.nextInt();
        System.out.println("What is your second integer?"); //ask for the second method
        n2 = input.nextInt();
        System.out.println("Press 1 for the Recursion Method\nPress 2 for the Looped Method:");
        int c = input.nextInt();
        if (c == 1) {
            System.out.println("GCF = " + GCFRecursion(n1, n2)); //runs the recursion method
        } else if (c == 2) {
            System.out.println("GCF = " + GCFLoop(n1, n2)); //runs the looped method
        } else {
            System.out.println("Invalid Choice Entered. Greatest Common Factor Program Ended.");
        }

    }
//********************************************************************************************

    public static void Fibonacci() {
        Scanner input = new Scanner(System.in);
        System.out.println("Fibonacci Sequence");
        System.out.println("Which term of the series do you want?"); //asks user for which term they want
        int n = input.nextInt();
        System.out.println("Press 1 for the Recursion Method\nPress 2 for the Looped Method:");
        int p;
        p = input.nextInt();
        if (p == 1) {
            System.out.println("Term " + n + " = " + FibonacciRecursion(n));//runs the recursion method
        
        }
        else if (p == 2) {
            System.out.println("Term " + n + " = " + FibonacciLoop(n));//runs the looped method
          
        } else {
            System.out.println("Invalid Choice Entered. Fibonacci Program Ended.");
        }
    }
//********************************************************************************************

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice; // declare variable

        do // menu
        {
            System.out.println();
            System.out.println("Choose from the following menu\n");
            System.out.println("Enter 1, or 2");
            System.out.println("1 - Greatest Common Factor");
            System.out.println("2 - Fibonacci Sequence");

            System.out.println();
            System.out.println("Enter 0 to exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    GreatestCommonFactor();
                    break;
                case 2:
                    Fibonacci();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
        System.out.println("The program has terminated");   // exit of program 

    }

}
