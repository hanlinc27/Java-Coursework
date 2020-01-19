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


//Q3
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic heres
        Scanner input = new Scanner (System.in);
    //−1 000 000 to 1 000 000
    //you can end up having negatives
    int arr [][] = new int [3][3];
    int row0 [] = new int[3];
    int row1 [] = new int[3];
    int row2 [] = new int[3];
    int col0 [] = new int[3];
    int col1 [] = new int[3];
    int col2 [] = new int[3];
    
 /* 00 01 02
    10 11 12
    20 21 22 */
    
    
    char a;
    for (int row = 0; row < arr.length; row++){
        for  (int col = 0; col<arr.length; col++){
               a = input.next().charAt(0);
               if (a=='X'){
                   arr[row][col]=0;
               }
               arr[row][col] = (int)a;
        }
        System.out.println();
    }
 
    for (int i =0; i<arr.length; i++){ //copied it over to the respective columns 
        row0 [i] = arr[0][i];
        row1 [i] = arr[1][i];
        row2 [i] = arr[2][i];
        col0 [i] = arr[i][0];
        col1 [i] = arr[i][1];
        col2 [i] = arr[i][2];
    }
   
   
    
  //Tester  
    for (int r = 0; r< arr.length; r++){
        System.out.println(row0[r] + " ");   
    }
    for (int r = 0; r< arr.length; r++){
        System.out.println(row1[r]);   
    }
    for (int r = 0; r< arr.length; r++){
        System.out.println(row2[r]);   
    }
    
    
    
    
    
    
    }
    
}
