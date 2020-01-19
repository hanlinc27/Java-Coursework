/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ccc4;

/**
 *
 * @author Hanlin
 */

//Q4
import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int N, K;
        int days = 0;
        int sum = 0; 
       Scanner input = new Scanner (System.in);
       N = input.nextInt(); //get N
       K = input.nextInt(); //get K
       int [] arr = new int [N]; //store the numbers into an array
       for (int i =0; i<N; i++){
           arr [i] = input.nextInt();
       }
       //since you have to take the feweset numer of days as possible
       
       if (N%K != 0){
           days = N/K +1;
       }
       else {
       days = N/K;  //2
       }
       
       int split = N/days;    //2
       int remainder = N%days;
       int[] group = new int[split]; 
       int[] groupr = new int[split+remainder]; 
       
       
       for (int j = 1; j<=days-(split+remainder); j+= split){
        for (int t = j; t < split; t++){
            group [t] = arr[t];
       
        }
           sum = sum + highestVal(group);
        }

       for (int y = days-split-remainder; y<=days; y++){
          for (int i=0; i<split+remainder; i++){
              groupr[i] = group[y];
          }   
          sum = sum + highestVal(groupr);
       }

       System.out.println(sum);
       
       
       
       
    }
    
    static int highestVal (int [] a){
       int count = 0;
        for (int i = 0; i<a.length; i++){
         if (a[i] > count){
             count = a[i];
         }   
        }  
        return count;
    }
}
