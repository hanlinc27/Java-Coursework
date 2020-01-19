/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlincheng_methodproblems;

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

/**
 *
 * @author Hanlin
 */
// Hanlin Cheng
// Methods Set
//Sept 15, 2017
public class HanlinCheng_MethodProblems {

    /**
     * @para
     */
    public static Double areaCircle(double r)  { //accepts a decimal radius
        double area;
        area = ((Math.PI) * r * r);  //formula to calculate area
        return area;
    }

    public static boolean odd(int a) {  //accepts an integer
        boolean b;
        b = true;
        if (a % 2 == 1) { //check if the value is odd
            return b;
        } else { //in the case that the value is even
            b = false;
            return b; 
        }
    }

    public static String monthName(int m) { //accepts a month number
        String name; //name of month
        switch (m) {
            case 1:
                name = "January";
                break;
            case 2:
                name = "February";
                break;
            case 3:
                name = "March";
                break;
            case 4:
                name = "April";
                break;
            case 5:
                name = "May";
                break;
            case 6:
                name = "June";
                break;
            case 7:
                name = "July";
                break;
            case 8:
                name = "August";
                break;
            case 9:
                name = "September";
                break;
            case 10:
                name = "October";
                break;
            case 11:
                name = "November";
                break;
            case 12:
                name = "December";
                break;
            default:
                name = "Invalid";
                break;
        }
        return name;
    }

    public static int daysInMonth(int j) { //accepts a month number
        int d;
        switch (j) { //looks at the dates
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                d = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                d = 30;
                break;
            case 2:
                d = 28;
                break;
            default:
                d = 0;
                break;
        }
        return d;
    }

    public static int random(int min, int max) {
        Random r = new Random();
        int k; 
        if (min > max) { //in the case that min is greater than max
            int q = min;
            min = max;
            max = q;
        }
        k = (r.nextInt(max - min + 1) + (min));
        return k;
    }

    public static char flip() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return 'H';
        } else {
            return 'T';
        }
    }

    public static char randomLetter() {
        int x;
        x = random(65,90);
        char c = (char) x;
        return c;
    }

    public static void CircleArea() {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius of circle");
        int radius;
        radius = input.nextInt();
        if (odd(radius)) {
            System.out.println("The radius is odd.");
        } else {
            System.out.println("The radius is even");
        }
        System.out.format ("Area = %.1f square units%n", areaCircle (radius));
    }

    public static void MonthDays() {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Month      Days");
        for (int i = 1; i <= 12; i++) {
            System.out.format("%-9s%5d%n", monthName(i), daysInMonth(i));
        }
    }

    public static void RandomFlipsandLetters() {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        System.out.print("10 coin flips: ");
        int a,b;
        a=0;
        b=0;
        for (int i = 1; i <= 10; i++) {
            System.out.print(flip());
            if (flip()=='H'){
                a = a+1;
            }
            else {
                b=b+1;
            }
        }
        System.out.print(" " + b + "0% tails");
        System.out.print("\n\nFive random 4-letter combos: ");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 4; j++) {
                System.out.print(randomLetter());
            }
            System.out.print(" ");
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        int choice; // declare variable
 System.out.format("%1.3f%9.4f",112.87878787878787, 12.1232131);
 do // menu
 {
     System.out.println();
  System.out.println ("Choose from the following menu\n");
  System.out.println ("Enter 1, 2, or 3");
  System.out.println("1 - Circle Area");
  System.out.println("2 - Month Days");
  System.out.println("3 - Random Flips and Letters");
  
  System.out.println ();
  System.out.println("Enter 0 to exit");
  choice = input.nextInt();
  
            switch (choice) {
                case 1:
                    CircleArea();
                    break;
                case 2:
                    MonthDays();
                    break;
                case 3:
                    RandomFlipsandLetters();
                    break;
                default:
                    break;
            } 
 }
 while (choice != 0);
 System.out.println ("The program has terminated");   // exit of program 
    }
}
