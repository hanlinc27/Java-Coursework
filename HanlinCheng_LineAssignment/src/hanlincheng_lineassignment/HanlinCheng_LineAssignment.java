/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlincheng_lineassignment;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Hanlin
 */
public class HanlinCheng_LineAssignment {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static Random r = new Random();
//******************************************************************

    public static void main(String[] args) {
        // TODO code application logic here

        Line a = new Line(1, 1, 1);

        System.out.println("Welcome to the Line Class.");
        a.readLine(input); //methods are tested within this method
        System.out.format("50.8f%10d%n",10.333333+5);

    }

}
//******************************************************************
class Line { //Line Class

    private int xvalue1, yvalue1, constant1; //Instance Variables

    public Line(int a, int b, int c) {  //Constructor
        xvalue1 = a;
        yvalue1 = b;
        constant1 = c;
    }

    public String toString() { //To String Method 
        String A1 = Integer.toString(xvalue1);
        if (A1.equals("1")) { //if the x value is equal to one
            A1 = "x";
        } else if (A1.equals("-1")) { //if the x value is equal to negative one
            A1 = "-x";
        } else if (A1.equals("0")) { //if there is no x value
            A1 = "";
        } else if (A1.charAt(0) == '-') {  //for negative values
            A1 = A1 + "x";
        } else {
            A1 = A1 + "x";
        }
        String B1 = Integer.toString(yvalue1);
        if (B1.equals("1")) { //if the y value is equal to one
            B1 = "+y";
        } else if (B1.equals("-1")) { // if the y value is equal to negative one
            B1 = "-y";
        } else if (B1.equals("0")) { //if hte y value is equal to zero
            B1 = "";
        } else if (B1.charAt(0) == '-') { //if the y value is negative
            B1 = B1 + "y";
        } else {
            B1 = "+" + B1 + "y"; //if the y value is positive
        }
        String C1 = Integer.toString(constant1);
        if (C1.equals("0")) {
            C1 = ""; //if there is no constant
        } else if (C1.charAt(0) == '-') {//if the constant is negative
            C1 = C1;
        } else { 
            C1 = "+" + C1; //if the constant is positive
        }
        return (A1 + B1 + C1 + "=0");
    }

    public static void readLine(Scanner input) {
        Random r = new Random();
        try {
            String  complete;    //The string that is the line (which will be manipulated)
            complete = "";
            int xvalue1, yvalue1, constant1; //the integer values of the line Ax + By + C 
            xvalue1 = 0; //set initial vlaues
            yvalue1 = 0;
            constant1 = 0;
            System.out.println("Please enter your line:"); //Ask the user for input of line
            complete = input.nextLine();

            String[] line;
            complete = complete.substring(0, complete.indexOf('='));  //taking the values on the left side
            complete = complete.replace(" ", ""); //replacing any spaces the user may have entered
            complete = complete.toLowerCase(); //converting it all to lowercase
            complete = complete.replace("-", "+-"); //Reffered to another person's code: essentially this makes it easier to split the string after
            complete = complete.replace("+", "a"); //use a as a placeholder
            line = complete.split("a"); //split the string at point a
            for (int k = 0; k <= line.length - 1; k++) { //run through the line
                line[k] = line[k].trim(); //take in the values
                try {
                    if (line[k].endsWith("x")) { //for the case when final value is an x
                        xvalue1 = Integer.parseInt(line[k].substring(0, line[k].length() - 1)); //convert it to an integer
                    } else if (line[k].endsWith("y")) { //for the case when the final value is an y
                        yvalue1 = Integer.parseInt(line[k].substring(0, line[k].length() - 1)); //convert it to integer
                    } else {
                        constant1 = Integer.parseInt(line[k]); //for the constant
                    }
                } catch (Exception e) { //with the exception

                    if (line[k].endsWith("x")) { 
                        if (line[k].equals("-x")) { //if it is a negative x value
                            xvalue1 = -1; //x should be -1
                        } else if (line[k].equals("x")) { //if it is a positive x value
                            yvalue1 = 1; //x should be 1
                        }
                    } else if (line[k].endsWith("y")) { 
                        if (line[k].equals("-y")) {//if it is a negative y value
                            yvalue1 = -1; //y should be -1
                        } else if (line[k].equals("y")) {//if it is a positive y value
                            yvalue1 = 1;//y should be 1
                        }
                    }
                }

            }

            System.out.println("x: " + xvalue1); //displays A of Ax
            System.out.println("y: " + yvalue1); //displays B of Bx
            System.out.println("c: " + constant1); // displays constant
            Line t = new Line(xvalue1, yvalue1, constant1); //constructs the new line
            t.toString(); //formats this line
            System.out.println("X-Intercept:" + t.xintercept()); //this is the x intercept
            System.out.println("Y-Intercept:" + t.yintercept()); // this is the yintercept
            System.out.println("Slope:" + t.slope()); //this is the slope
            System.out.println("Vertical Line:" + t.vertical()); //this checks if it's a vertical line
            System.out.println("Horizontal Line: " + t.horizontal()); //this checks if it's a horizontal line
            int e, f, g; //randomly generate a new line
            e = r.nextInt(9) + 1;
            f = r.nextInt(9) + 1;
            g = r.nextInt(9) + 1;
            Line s = new Line(e, f, g);
            System.out.println("Your comparison line is: " + s.toString()); //display comparison line
            System.out.println("Intersection at:"); //call intersection method
            System.out.println(t.intersect(s).toString());
        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }
//******************************************************************
    public double xintercept() { //returns x int
        return (double) -constant1 / xvalue1;
    }
//******************************************************************
    public double yintercept() { // returns y int
        return (double) -xvalue1 / yvalue1;
    }
//******************************************************************
    public double slope() { //returns slope
        return (double) -constant1 / yvalue1;
    }
//******************************************************************
    public boolean vertical() { //returns boolean of if vertical

        if (yvalue1 == 0 && xvalue1 != 0) {
            return true;
        } else {
            return false;
        }
    }
//******************************************************************
    public boolean horizontal() { //returns boolean of if horizontal
        if (xvalue1 == 0 && yvalue1 != 0) {
            return true;
        } else {
            return false;
        }
    }
//******************************************************************
    public point intersect(Line c) { //returns the point of intersection 
        double A = c.xvalue1;
        double B = c.yvalue1;
        double C = c.constant1;
        double x, y;
        x = (yvalue1 * C - B * constant1) / (B * xvalue1 - yvalue1 * A);
        y = -(xvalue1 * x + constant1) / yvalue1;
        point POI = new point(x, y);
        return POI;
    }
//******************************************************************
    class point { //point class

        private double x, y; //Instance Variables

        point(double a, double b) { //constructor
            x = a;
            y = b;
        }

        public String toString() { //formatting
            String point = "";
            point = String.format("(%.3f,%.3f)", x, y);
            return point;
        }
    }
}
