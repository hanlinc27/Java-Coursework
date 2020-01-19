/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cccquestion1;
import java.util.Scanner;

/**
 *
 * @author Hanlin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Problem S2
Scanner input = new Scanner (System.in);
 int T; 
//N>3 
//N = (A+B)/2     A and B are prime integers
//Instructions for Prime: P>1 only two factors! (loop)
// T lies, r T (1 ≤ T ≤ 1000)
//  next T lines contain one integer Ni (4 ≤ Ni ≤ 1 000 000, 1 ≤ i ≤ T)
// OUTPUT AND INPUT BOTH HAVE T LINES



//first line (T- number of test cases)
T = input.nextInt();
int [] arr = new int [T]; //create the array to store values
for (int i =0; i< T; i++){
    arr [i] = input.nextInt();
}


    }
    
}
