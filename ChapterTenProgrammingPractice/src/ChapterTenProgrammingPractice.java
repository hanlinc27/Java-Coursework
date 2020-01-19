/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package chaptertenprogrammingpractice;

/**
 *
 * @author Hanlin
 */
import java.util.Scanner;

public class ChapterTenProgrammingPractice {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner (System.in);
  /*    //Area of a Circle
              int x;
        System.out.println("Circle Area");
        System.out.println("Input the radius: ");
        x = input.nextInt();
        System.out.println("The radius is " + x + " The area is: " + ((Math.PI)*(x*x)));
        */ 
 /*     //Cents to Dollars
        System.out.println("Dollars");
            int a;
        System.out.println("Input the cents: ");
        a = input.nextInt();
        System.out.println("That is " + (a/100) + " dollars and " + (a%100) + " cents.");
  */    //Correct Change
  /*    System.out.println("Correct Change");
        int b, dchange, qchange, dichange, nichange, ctchange;
        System.out.println("What is your change? ");
        b = input.nextInt();
        dchange = (b/100);
        qchange = ((b%100)/25);
        dichange = (((b-(dchange*100)-(qchange*25))%100)/10);
        int c;
        c = (b-(dchange*100)-(qchange*25)-(dichange*10));
        nichange = c/5;
        ctchange = c-nichange;
        System.out.println("Your change is: " + dchange + " dollars " + qchange + " quarters " + nichange + " nickels "+ ctchange + " cents.");
*/
        //Ohm's Law
        System.out.println("Ohm's Law");
        int v, r;
        System.out.print("What is your voltage? ");
        v = input.nextInt();
        System.out.print("What is your resistance? ");
        r = input.nextInt();
        System.out.println("The current is " + ((v+0.0)/r) + " ohms");
        
        
        
    }
    
}
