/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlincheng_stringproblems;

import java.util.Random;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Hanlin
 */
public class HanlinCheng_StringProblems {
//Hanlin Cheng
    
    /**
     * @param s
     * @param args the command line arguments
     */
    public static Boolean palindrome(String s) {
        String s2 = ""; //string that takes just the letters
        String s3 = ""; //string that will be the reverse
        for (int i = 0; i <= s.length() - 1; i++) {
            if (Character.isLetter(s.charAt(i))) {
                s2 = s2 + s.charAt(i); //takes the string with only letters
            }
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            s3 = s3 + s2.charAt(j); //takes the reverse
        }

        if (s2.equalsIgnoreCase(s3)) { //checks if they are equal
            return true;
        } else {
            return false;
        }

    }
//*******************************************************************************

    public static String shiftcode(String shift, int a) {
        String shift2 = "";
        shift = shift.toUpperCase(); //changes it to uppercase
        for (int i = 0; i <= shift.length() - 1; i++) { //for the amount of letters
            if (Character.isLetter(shift.charAt(i))) {
                int temp = (int) (shift.charAt(i))+a; //shift the letters four letters later
                if (temp > 90) { //for when the ASCII is more than 90
                    temp = temp - 90 + 64; 
                }
                shift2 = shift2 + ((char) temp); //create new string
            } else {
                shift2 = shift2 + shift.charAt(i); //for anything that's not a letter
            }
        }
        return shift2;
    }
//********************************************************************************

    public static String cryptocode(String a) {
        Random r = new Random();
        StringBuilder alphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ"); //original alphabet
        String code = "";
        for (int j = 0; j <= 100; j++) {
            int letter = r.nextInt(25); //random index
            int letter2 = r.nextInt(25); //random index two
            char temp1 = (alphabet.charAt(letter2)); //get the char at the two indices
            char temp2 = (alphabet.charAt(letter));
            alphabet.setCharAt(letter, temp1); // swap indices
            alphabet.setCharAt(letter2, temp2);
        }
        a = a.toUpperCase(); //convert to uppercase
        System.out.println("The Scrambled Alphabet is:\n" + alphabet);
        for (int i = 0; i <= a.length() - 1; i++) { //for the new length
            if (Character.isLetter(a.charAt(i))) {
                int temp;
                temp = ((int) (a.charAt(i))) - 65; //match accordingly
                code = code + alphabet.charAt(temp);
            } else {
                code = code + a.charAt(i);
            }
        }
        return code;
    }
//*********************************************************************************

    public static String secretcode(String filePath) throws FileNotFoundException {
        File code = new File(filePath); // takes in the new file
        Scanner input = new Scanner(code);
        String solved = ""; //empty solved
        String original = input.nextLine(); 
        while (input.hasNextLine()) {
            char[] oarray = original.toCharArray(); //put into an array
            String n = input.nextLine();
            String[] a = n.split(" ");  
            for (int i = 0; i < n.length(); i++) {
                int num = Integer.parseInt(a[i]); // passing the string and returning as integer
                solved = solved + oarray[num]; // getting the string from this 
            }
        }
        return solved;

    }
//*********************************************************************************
    public static void mPalindrome() { //driver method that runs palindrome
        Scanner input = new Scanner(System.in);
        String word;

        System.out.println("Palindrome");
        System.out.println("Enter a word to check:");
        word = input.nextLine();
        System.out.println(palindrome(word));
    }
//*********************************************************************************
    public static void mShiftCode() { //driver method that runs shift code
        Scanner input = new Scanner(System.in);
        System.out.println("Shift Code\nEnter a word to shift:");
        String word1;
        word1 = input.nextLine();
        System.out.println("Enter the amount of spaces you wish to shift:");
        int num = input.nextInt();
        System.out.println(shiftcode(word1, num));
    }
//*********************************************************************************
    public static void mCryptocode() { //driver method to run cryptocode
        Scanner input = new Scanner(System.in);
        System.out.println("Cryptocode\nEnter the word you'd like to encrypt:");
        String word3 = input.nextLine();
        System.out.println(cryptocode(word3));
    }
//*********************************************************************************
    public static void mSecretcode() { //driver method to run secret code
        Scanner input = new Scanner(System.in);
        System.out.println("SecretCode");
        System.out.println("Type the file path.");
        String filePath = input.nextLine();
        filePath = input.nextLine();
        try {
            System.out.println(secretcode(filePath));
        } catch (Exception e) {
        }
    }

   
//****************************************************************************

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        int choice; // declare variable

        do // menu
        {
            System.out.println();
            System.out.println("Choose from the following menu\n");
            System.out.println("Enter 1, 2, 3, or 5");
            System.out.println("1 - Palindrome");
            System.out.println("2 - ShiftCode");
            System.out.println("3 - Cryptocode");
            System.out.println("4 - SecretCode");

            System.out.println();
            System.out.println("Enter 0 to exit");
            choice = input.nextInt();

            if (choice == 1) {
                mPalindrome();
            }

            else if (choice == 2) {
                mShiftCode();
            }
            else if (choice == 3) {
                mCryptocode();
            }
            else  if (choice == 4) {
                mSecretcode();
            }
            else {
                System.out.println("Error");
            }
        } while (choice != 0);
        System.out.println("The program has terminated");   // exit of program 

    }

}
