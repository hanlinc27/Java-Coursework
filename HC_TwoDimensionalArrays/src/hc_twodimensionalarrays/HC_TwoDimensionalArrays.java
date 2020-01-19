/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hc_twodimensionalarrays;

/**
 *
 * @author Hanlin
 */
public class HC_TwoDimensionalArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      int[][] data = {  //The Two-Dimensional Array Assigned
                     {3, 2, 5},
                     {1, 4, 4, 8, 13},
                     {9, 1, 0, 2},
                     {0, 2, 6, 3, -1, -8} };
  System.out.println("2D Arrays");
  System.out.println("The Testing Array is: ");
  for ( int row=0; row < data.length; row++) //Loop through rows
    {
      for ( int col=0; col < data[row].length; col++) //Loop through columns
      {
     System.out.print(data[row][col]+ " "); //display the value
      }
      System.out.println("");
    }
      System.out.println("");
   totalSum(data); //get total sum
       System.out.println("");
    rowSum(data); //get sum of rows
        System.out.println("");
    columnSum(data); // get column sums
    System.out.println("");
    maxMin(data); // get minimum and maximum values
    }
   
//******************************************************************************
    public static void totalSum(int [][] arr){ //method to get total sum
        int sum =0; //initialize sum to zero
         for ( int row=0; row < arr.length; row++) //iterate through row
    {
      for ( int col=0; col < arr[row].length; col++)  //nested loop to iterate through column
      {
       sum = sum + arr[row][col]; //add the values to the total sum
      }
    }
        System.out.println("The Total Sum is:" + sum); //display the sum
    }

//******************************************************************************
    public static void rowSum (int[][]arr){ //method to calculate row sum
        int rsum=0; //set the row sum to zero
        for ( int row=0; row < arr.length; row++) //iterate through row
    {
      for ( int col=0; col < arr[row].length; col++) //iterate through column
      {
       rsum = rsum + arr[row][col]; //add the value to the row sum each time 
                                    //note that this is only going through a row
    
      }
      System.out.println("Row " + row + " Sum: " + rsum ); //display the row's sum
        rsum =0; //set row sum back to zero before incrementing row
    }
       
    }
//******************************************************************************
     public static void columnSum(int[][] arr) { //method to calculate column sum
    int longest = 0; //set longest value to zero
    for ( int row=0; row < arr.length; row++){//iterate through the array rows
    if ( arr[row].length > longest ){
        longest = arr[row].length; //find the longest row and make its length equal to longest
    }
}
    int sum[] = new int [longest]; //create a new array where each index is the column in the old array
    for ( int i = 0; i < arr.length; i++ ){ //iterate through row of original array
        for (int j = 0; j < arr[i].length; j++){ //iterate through column of original array
               sum[j] = sum[j] + arr[i][j];      //add the index value of the new array with each value that's appropriate
            }           
    }
    for (int a = 0; a<sum.length; a++){ //iterate through the column new array
        System.out.println("Column: " + a + " Sum: " + sum[a]); //display values
    } 
  }
//******************************************************************************
  public static void maxMin(int [][] arr){// method to calculate maximum and minimum values
      int max = 0;   //set max and min to zero
      int min=0;
      
for ( int row=0; row < arr.length; row++) //iterate through the rows
    {
      for ( int col=0; col < arr[row].length; col++)  //iterate through the columns
      {
        if (arr[row][col]>max){ //if there's a value greater than max, let max equal the value
            max = arr[row][col];
        }
        if (arr[row][col]<min){ //if there's a value less than min, let min equal the value
            min = arr[row][col];
        }
      }
    }
    System.out.println( "Max Value: " + max + " Min Value: " + min ); // display the values
    
  }
//******************************************************************************

    
    


}
