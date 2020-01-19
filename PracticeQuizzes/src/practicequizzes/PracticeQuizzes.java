/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicequizzes;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Hanlin
 */
public class PracticeQuizzes {

    /**
     */
    /*
     public static void WhileLoop() {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        int a, b, c, points;
        points = 0;
        boolean win = true;
        char i;
        while (win == true) {
            a = (r.nextInt(100) + 1);
            b = (r.nextInt(100) + 1);
            c = (r.nextInt(100) + 1);
            System.out.println("The numbers are " + a + " and " + b);
            System.out.print("Inside or outside? (i/o):");
            i = input.next().charAt(0);
            if (a > b) { //b<a
                if (i == 'i') {
                    if (c>=b && c <= a) {
                        win = true;
                        points = points + 1;
                    } else {
                        win = false;
                    }
                } else {
                    if (c > a || c < b) {
                        win = true;
                        points = points + 1;
                    } else {
                        win = false;
                    }

                }
               
            } else { //a<b
                if (i == 'i') {
                    if (c<=a && c <= b) {
                        win = true;
                        points = points + 1;
                    } else {
                        win = false;
                    }
                } else {
                    if (c > b || c < a) {
                        win = true;
                        points = points + 1;
                    } else {
                        win = false;
                    }

                }
            }
       System.out.println("The next one is " + c);
        }
      
        System.out.println("");
        System.out.println("You scored " + points + " points.");
    }
*/
    public static int draw21 ( ){
        Random r = new Random ();
        int a = r.nextInt(13)+1;
        if (a==11 || a==12 || a==13){
            a=10;
        }
        return a;
    }
    
    public static String status (int x) {
     String s;
        if (x>=16) {
            s = "16 or less - Hit";
        }
        else if (x>=17 && x<=20){
            s = "17-20 - Stick";
        }
        else if (x==21){
            s= "21-Blackjack!";
        }          
        else {
            s = "22 or more – Bust!!";
        }
               
      return s;         
    }
    public static void main(String[] args) {
        // TODO code application logic here
int a;
a=15;
int b = 0;
for (int i =1; i<=a; i++){
    if (a%i==0){
        System.out.print(i + " ");
        b = b+1;
    }
}
System.out.println("\n\n" + b + " Factors");
}
    
}
