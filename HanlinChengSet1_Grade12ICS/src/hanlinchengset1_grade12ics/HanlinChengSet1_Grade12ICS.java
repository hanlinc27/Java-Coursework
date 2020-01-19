/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hanlinchengset1_grade12ics;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author Hanlin
 */
public class HanlinChengSet1_Grade12ICS {
    public static void WindChill () {
        Scanner input = new Scanner (System.in);
        double v,t,WCI; // Decalre the variables for velocity, time and Wind Chill Index
        System.out.println();
        System.out.println("WIND CHILL");
        System.out.println("What is your wind speed in miles per hour?");
        v = input.nextDouble(); // Ask for user's velocity input
        System.out.println("What is your temperature in Farenheit?");
        t = input.nextDouble(); // Ask for user's time input
        if (0 >= v && v <= 4) {
            WCI = t; // Check for first restriction 
        }
        if (v>=45) { // Check for second restriction
            WCI = ((1.6*t) - 55);
        }
        else {
            WCI = (91.4 + (91.4 - t)*(0.0203*v - 0.304*(Math.sqrt(v)) )- 0.474); // Do the normal calculations
        }
     
       
        System.out.format("%1.2f", WCI);
        System.out.print(" degrees is the Wind Chill Index."); // 
    }
    
    public static void FantasyGame () {
        Scanner input = new Scanner (System.in);
        int strength, health, luck; // declare the variables for strengthn health and luck
        String name; // declare a variable for name 
        System.out.println();
        System.out.println("FANTASY GAME");
        System.out.println("Welcome to Yertle's Quest");
        System.out.println("Enter the name of your character:");
        name = input.nextLine(); //ask the user for input about name
        System.out.println("Enter strength (1-10):");
        strength = input.nextInt(); // ask the user for input about strength
        System.out.println("Enter health (1-10):");
        health = input.nextInt(); // ask the user for input about strength
        System.out.println("Enter luck (1-10):"); 
        luck = input.nextInt(); // ask the user for input about luck
        
        if ((strength+health+luck)>15){
            System.out.println("You have give your character too many points!  Default values have been assigned: \n" + name + " strength: 5, health: 5, luck: 5");
        }
        else 
            System.out.println(name + " strength: " + strength + " health: " + health + " luck: " + luck); // output to the user
    }
    public static void TirePressure () {
        Scanner input = new Scanner (System.in);
        int rfp, lfp, rrp, lrp; // declare variables for the tires
        boolean goodPressure; // boolean variable for pressure
        goodPressure = true; // set initial pressure to true
        System.out.println();
        System.out.println("TIRE PRESSURE");
        System.out.println("Input right front pressure");
        rfp = input.nextInt(); // ask for input
        if (rfp < 35|| rfp > 45){
            System.out.println("Warning: pressure is out of range \n"); // check for range
            goodPressure = false;
        }
        System.out.println("Input left front pressure");
        lfp = input.nextInt(); // ask fo input
         if (lfp<  35|| lfp > 45){ 
            System.out.println("Warning: pressure is out of range \n"); // check for range
            goodPressure = false;
        }
        System.out.println("Input right rear pressure");
        rrp = input.nextInt(); // ask for input
         if (rrp< 35|| rrp > 45){
            System.out.println("Warning: pressure is out of range \n"); // check for range
            goodPressure = false;
        }
            
        System.out.println("Input left rear pressure");
        lrp = input.nextInt(); // ask for input 
         if (lrp< 35|| lrp > 45){
            System.out.println("Warning: pressure is out of range \n"); // check for range
            goodPressure = false;
        }
         if (Math.abs(rfp-lfp)>3 || Math.abs(rrp-lrp)>3){ // check for the plus minus three range
             goodPressure = false;
         }
         if (goodPressure == false) {
             System.out.println("\n Inflation is BAD"); // give user output
         }
         else {
             System.out.println("\n Inflation is OK"); // give user output
         }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner (System.in);
        int choice; // declare variable
 
 do // menu
 {
     System.out.println();
  System.out.println ("Choose from the following menu\n");
  System.out.println ("Enter 1, 2, or 3");
  System.out.println("1 - WindChill");
  System.out.println("2 - Fantasy Game");
  System.out.println("3 - Tire Pressure");
  
  System.out.println ();
  System.out.println("Enter 0 to exit");
  choice = input.nextInt();
  
            switch (choice) {
                case 1:
                    WindChill();
                    break;
                case 2:
                    FantasyGame();
                    break;
                case 3:
                    TirePressure();
                    break;
                default:
                    break;
            } 
 }

 while (choice != 0);
 System.out.println ("The program has terminated");   // exit of program  

 

    }
    
}
