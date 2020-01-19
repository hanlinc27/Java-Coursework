/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package cccquestion1;
import java.util.Scanner;
/**
 *
 * @author Hanlin
 */

//Q2
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic heres
        Scanner input = new Scanner (System.in);
        int T, num1 = 0, num2 = 0; 
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
    arr [i] = input.nextInt()*2;
}

//check the inequality
for (int a=0; a< arr.length; a++){ //traverse the array

if (arr[a]>1000){
for (int r = 1; r<=arr[a]/10; r++){ //gets the pairs
    if (isPrime(r) && isPrime(arr[a]-r)){    
         num1 = r;
        num2 = arr[a]-r;
    }
    }
}
else {
    for (int r = 1; r<=arr[a]/2; r++){ //gets the pairs
    
    if (isPrime(r) && isPrime(arr[a]-r)){ 
        num1 = r;
        num2 = arr[a]-r;
    }
}
}
  System.out.println(num1 + " " + num2); //should never print 00 since a value always exists
}


  }
static boolean isPrime (int n){
    int count = 0;
    for (int k = 1; k <=n/2; k++){
        if (n%k == 0){
            count++;
        }
    }
    if (count==1){
            return true;
    }
    else {
        return false;
    }  
}
}
