/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hc_onedimensionalarrays;


import java.util.Random; //import random

/**
 *
 * @author Hanlin // ICS Period 1 // Nov 20, 2017
 */
public class HC_OneDimensionalArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random r = new Random(); //new random object
        int[] testing = new int[20]; //create a new 20 element array
        for (int i = 0; i < testing.length; i++) { //fill the array with random integers from -5 to 15
            testing[i] = r.nextInt(21) - 5;
        }
        
        System.out.println("ARRAY METHODS"); //title
        System.out.println("The 20 element array is: "); //generate a random 20 element array  with numbers from -5 to 15
        for (int i =0; i<testing.length; i++ ){
            System.out.print(testing[i] + " ");
        }
        System.out.println("");
        System.out.println("SUM METHOD"); 
        threeSums(testing); //calls the sum method
        System.out.println("TWO LARGEST ELEMENT METHOD");
        twoLargest(testing); //calls the two largest elements method
        System.out.println("CLOSEST TO ZERO METHOD");
        closestToZero(testing); //calls the closest to zero method
        System.out.println("REVERSE ELEMENTS METHOD");
        reverseElements(testing); //calls the reverse elements method
        System.out.println("SMOOTH THE INTEGERS METHOD");
        smooth(testing); //calls the smooth integers method
        System.out.println("TWEAK THE ELEMENTS METHOD");
        tweak(testing); //calls the tweak elements method
    }

    
    
    
    //*********************************************************************************************
    //Method to generate an array for the sums of all the digits, the even digits and the odd digits
    public static int[] threeSums(int[] array) {
        int sums[] = {0, 0, 0}; //a sum array where the total sum is index 0, the even sum is index 1 and the odd sum is index 2
        for (int i = 0; i < array.length; i++) { //iterate through the array
            sums[0] = sums[0] + array[i]; //add each element to the overall sum
            if (array[i] % 2 == 0) { //check if it's even
                sums[1] = sums[1] + array[i]; //add to even sum
            } else {
                sums[2] = sums[2] + array[i];//add the rest to odd sum
            }
        }
        System.out.println("The Total Sum is: " + sums[0] + "\nThe Even Sum is: " + sums[1] + "\nThe Odd Sum is: " + sums[2]); //displays information

        return sums; //returns the sum
    }
//*********************************************************************************************
//Method to compute the two largest elements in the array

    public static int[] twoLargest(int[] array) {

        int[] largest = new int[2]; //generates a new integer array where the largest element is index 0 and the second largest is index 1
        int a, b; //a will be the largest value and b will be the second largest value
        //Assuming there are two or more elements in the array
        if (array[0] >= array[1]) { //if the first element is greater than second
            a = array[0]; //set a to the first index of the array that is calling the method
            b = array[1];// set b to the second index of the array that is calling the method
        } else { //if the second element is greater than the first
            a = array[1]; //reverse and do the sae as above
            b = array[0];
        }
        for (int i = 2; i < array.length; i++) { //go through the elements in the array starting from the third element or index 2
            if (array[i] > a) { //if the number is greater than your largest value at the given moment
                b = a; //second largest value becomes currentlargest value
                a = array[i]; //current largest value gets updated
            } else if (array[i] > b) { //if the elemnt is greater than the second largest but not the greatest
                b = array[i]; //make the second largest element this element
            }
        }
        largest[0] = a; //set the first element of the array to be the greatest value
        largest[1] = b; //set the second element of the arry to be the second greatest value
        System.out.println("The largest element is: " + largest[0] + "\nThe second largest element is: " + largest[1]);
        return largest;
    }
//*********************************************************************************************
//Method to find the closest element to zero

    public static int closestToZero(int[] array) {
        int closest; //declare variable for integer that is closest to zero
        closest = array[0]; //first instance of closest to zero: assume it's first element
        for (int i = 0; i < array.length; i++) { //go through the array
            if (Math.abs(array[i]) < Math.abs(closest)) { //if the value of an element is closer to zero (abs value is less)
                closest = array[i]; //update the closest value
            }
        }
        System.out.println("The closest value to zero is: " + closest); //display it
        return closest; //return the value
    }
//*********************************************************************************************
//Method to Reverse the Elements in the Array 

    public static int[] reverseElements(int[] array) { 
        int[] reverse = new int[array.length];// create a new array called reverse
        for (int i = 0; i < array.length; i++) { //run through the original array
            reverse[array.length - i - 1] = array[i]; //the last elements in the reverse array will be the first elements of the original array
        }
        for (int i =0; i<reverse.length; i++){ //display this new array
            System.out.print(reverse[i] + " ");
                    
        }
        System.out.println();
        return reverse;
    }

//*********************************************************************************************
//Method to smooth the values in an integer array
    public static int[] smooth(int[] array) {
        int[] smoothed = new int[array.length]; //create a new smoothed array
        if (smoothed.length == 1) { //if the array is only one element then the smoothed array is the same
            smoothed[0] = array[0];
        } else {
            for (int i = 1; i < array.length - 1; i++) { //go through the original array
                smoothed[i] = (array[i - 1] + array[i] + array[i + 1]) / 3; //aside from the first and last element, the others are the average of itself with the two adjacent values
            }
            smoothed[0] = (array[0] + array[1]) / 2; //average the first and second number for the first value of smooth
            smoothed[array.length - 1] = (array[array.length - 1] + array[array.length - 2]) / 2; //average the last and second last value for the last value of smooth

        }
        System.out.print("Signal: "); //print original array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.print("\nSmooth: "); //print the smoothed array
        for (int i = 0; i < smoothed.length; i++) {
            System.out.print(smoothed[i] + " ");

        }
        System.out.println("");
        return smoothed;
    }
//*********************************************************************************************
//Method to tweak data

    public static double[] tweak(int[] array) { 
        int[] tweak = new int[array.length - 1]; //this is the new array where one element is removed
        int originalsum, changedsum; //these are the original and changed sum variables
        originalsum = 0;
        changedsum = 0;
        int rindex = 0; //this is where the index that we are removing from is
        double originalavg, changedavg, difference; //this is the original average variable, changed average variable and a difference variable that will be
        //used to compare the difference between how far off an element is from the average
       

        for (int i = 0; i < array.length; i++) { //iterate through original array to get sum
            originalsum = originalsum + array[i];
        }

        originalavg = ((originalsum) / (double) array.length); //calculate the original average
        difference = Math.abs(originalavg - array[0]); //calculate the difference by assuming the first element (for now) is the farthest off

        for (int i = 1; i < array.length; i++) { //run through the array
            if (Math.abs(originalavg - array[i]) > difference) { //if there is another element that has a greater difference then keep updating the chosen index
                difference = Math.abs(originalavg - array[i]); //update the difference as well
                rindex = i;
            }
        }

        for (int i = 0; i < rindex; i++) { //run through the array from the first element to the digit you don't want
            tweak[i] = array[i];
            changedsum = changedsum + tweak[i]; //calculate new sums
        }
        for (int i = rindex + 1; i < tweak.length; i++) { //runn through the array from the digit after the one you don't want to the end
            tweak[i] = array[i + 1];
            changedsum = changedsum + tweak[i]; //calculate new sum
        }

        changedavg = (changedsum) / (double) (tweak.length); //calculate the new average

        double[] finalresult = {originalavg, array[rindex], changedavg}; //store inside of an array where the first value is original average, second is the value that you're takng out and the thir is the changed average (these are what needs to be displayed)
        for (int i = 0; i< array.length; i++) {
            System.out.println("data[" + i +"] = " + array[i]); //display elements of original array
        }
        System.out.println("average: " + finalresult[0] + "\nmost distant value: " + finalresult[1] + "\nnew average: " + finalresult[2]); //display the necessary info
        return finalresult;
    }
}
