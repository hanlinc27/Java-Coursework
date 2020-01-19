/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package radixsort;
import java.util.*;
import java.util.Random;
import java.awt.*;
import javax.imageio.*; 
import java.io.*; 
import javax.swing.*;
import java.awt.event.*;  
import java.awt.Graphics;
import javax.swing.JFrame;
/**
 *
 * @author Hanlin
 */
 class RadixSort extends JFrame {

  
     
     
     public RadixSort () {
     BtnListener btnListener = new BtnListener();
//GUI Portion
 // 2... Create content pane, set layout
        JPanel content = new JPanel();        // Create a content pane
        content.setLayout(new BorderLayout()); // Use BorderLayout for panel
        JPanel north = new JPanel(); // where the buttons, etc. will be
        north.setLayout(new FlowLayout()); // Use FlowLayout for input area
        DrawArea board = new DrawArea(800, 800); // Area for cards to be displayed

// 4... Set this window's attributes.
        setContentPane(content);
        pack();
        setTitle("Radix Sort - Hanlin C. and Janet C.");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit button
        setLocationRelativeTo(null);           // Center window.
 }
     
     
     
//Drawing out the different objects inside of the panel   
     public void paint(Graphics g) 
    {
        Random r = new Random();
     int [] sort = new int[20];   

  
        sort[0] = 150; //store the height inside 
        sort[1] = 74;
        sort[2]= 101;
        sort[3] = 193;
        sort[4] = 57;
        sort[5] = 111;
        sort[6] = 112;
        sort[7] = 88;
        sort[8] = 60;
        sort[9] = 109;
        sort[10] = 158;
        sort[11] = 120;
        sort[12] = 46;
        sort[13] = 136;
        sort[14] = 170;
        sort[15] = 91;
        sort[16] = 131;
        sort[17] = 125;
        sort[18] = 85;
        sort[19] = 142;
        try{
            Font num = new Font("arial", Font.PLAIN, 8);
            Font subtitle = new Font ("arial", Font.PLAIN,12);
        for (int i=0; i<20; i++){
            
           g.setColor(Color.black);
            g.fillRect((i*15),0,10,sort[i]); //fill the initial rectangles
            g.setColor(Color.lightGray);
             g.drawRect((i*15),0,10,sort[i]); //draw initial rectangles with colour
             
             //Labelling
             g.setFont(num); 
             g.setColor(Color.black);
             g.drawString(sort[i]+"", (i*15),200);          
             Thread.sleep(200);  
        }
        g.setFont(subtitle);
        g.setColor(Color.black);
        g.drawString("Original Rectangles",50, 215);
        
       int[]sort1 =  radixSort(sort,1); //sort by ones digit
         for (int i=0; i<20; i++){
           g.setColor(Color.black); 
            g.fillRect((i*15),220,10,sort1[i]);  //fill the sorted once rectangles
            g.setColor(Color.lightGray);
             g.drawRect((i*15),220,10,sort1[i]);  //draw the sorted once rectangles
             
             //Labelling
             g.setFont(num); 
             g.setColor(Color.black);
             g.drawString(sort1[i]+"", (i*15),460);
             Thread.sleep(200);
        }
         g.setFont(subtitle);
             g.setColor(Color.black);
         g.drawString("Sorted by Ones Digit",50,480);
         
         
         
         
         
         
         
         int[]sort2 = radixSort(sort1,10); //sort by tens digit
    for (int i=0; i<20; i++){
           g.setColor(Color.black);
            g.fillRect((350+(i*15)),0,10,sort2[i]); //fill the sorted twice rectangles
            g.setColor(Color.lightGray);
             g.drawRect((350+(i*15)),0,10,sort2[i]); //draw the sorted twice rectangles
             
             //Labelling
             g.setFont(num); 
             g.setColor(Color.black);
             g.drawString(sort2[i]+"", 350+(i*15),200);
             Thread.sleep(200);
         
        }
    g.setFont(subtitle);
        g.setColor(Color.black);
     g.drawString("Sorted by Tens Digit",450,215);
     
     
     
     
     
     
     int[]sort3 = radixSort(sort2,100); //sort by hundreds digit
    for (int i=0; i<20; i++){
           g.setColor(Color.black);
            g.fillRect((350+(i*15)),220,10,sort3[i]); //fill the sorted three time rectangles
            g.setColor(Color.lightGray);
             g.drawRect((350+(i*15)),220,10,sort3[i]); //draw the sorted three time rectangles
             
             //Labelling
              g.setFont(num); 
             g.setColor(Color.black);
             g.drawString(sort3[i]+"", 350+(i*15),460);
             Thread.sleep(200);

        }
    g.setFont(subtitle);
        g.setColor(Color.black);
     g.drawString("Final: Sorted by Hundreds Digit",425,480);
        }
        catch (Exception e) {
            System.out.println(e);
         }
    }
    

     
     
     
     
     
     class BtnListener implements ActionListener // Button menu
    {

        public void actionPerformed(ActionEvent e) {
        }
        
    }
    
     
      class DrawArea extends JPanel {

        public DrawArea(int width, int height) {
            this.setPreferredSize(new Dimension(width, height));
        }
    }
//find the amount of places in the largest integer
    public static int findPlace(int[] input) {
        int value = input[0];
        for (int i =0; i<input.length; i++) {
            if (input[i]>=value) {
                value = input[i];
            }
        }
        value = (int)Math.log10(value)+1;
        value = (int) Math.pow(10,(value-1));
        return value;
    }
  
    
    // Sort the numbers beginning with least-significant digit
    public static int[] sort(int[] input){

        // Largest place for a 32-bit int is the 1 billion's place
        
        for(int place=1; place <= findPlace(input); place *= 10){
            // Use counting sort at each digit's place
            input = radixSort(input, place);
        }

        return input;
    }

    public static int[] radixSort(int[] input, int place){
        int[] out = new int[input.length]; //makes a new array of equal length

        int[] count = new int[10]; //array of 0-9

        for(int i=0; i < input.length; i++){ //going through the original array
            int digit = getDigit(input[i], place); //get the digit
            count[digit] = count[digit] + 1; //the specific element between 0-9 goes up by one (keep track of amount)
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in out[]
        //since each time you add it becomes more so this is the new position
        for(int i=1; i < count.length; i++){ //each index of 1-9 becomes the value of the one before it plus itsself
            count[i] = count[i] + count[i-1];
        }

        for(int i = input.length-1; i >= 0; i--){  //from the last index of original array to the first
            int digit = getDigit(input[i], place); // get the digit
            out[count[digit]-1] = input[i];   
            count[digit]--;
        }

        return out;

    }

    public static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
    //the getDigit method gets the digit in the certain place, e.g. the 10th digit of 125 is 2

    
     public static void main(String[] args) {
        // TODO code application logic here
   Random r = new Random ();
         
        //   RadixSort window = new RadixSort();
     //   window.setVisible(true);
      //  window.paint(null); 

        
        //For a list of 100
        int SIZE = 100; 
        int[] test = new int[SIZE];

        for (int i = 0; i < SIZE; i++){ //run through the array and put random integers inside
            test[i] = r.nextInt(500); //store random integers from 0-499
        }
        System.out.println("");
        long start = System.currentTimeMillis(); //Start time
        test = sort(test); //radix sort the list of 100
        long end = System.currentTimeMillis(); //end time
        for (int i =0; i<test.length; i++){
            System.out.println(test[i] ); //print the sorted array
        }
      

        //for a list of 10000 integers
        int SIZE1 = 10000; 
        int[] test1 = new int[SIZE1];

        for (int i = 0; i < SIZE1; i++){
            test1[i] = r.nextInt(500); //store 10000 random integers from 0-499
        }
        System.out.println("");
        long start1 = System.currentTimeMillis(); //Start time
        test1 = sort(test1); //radix sort the 10000 elements
        long end1 = System.currentTimeMillis(); //Ed time
        for (int i =0; i<test1.length; i++){ 
            System.out.println(test1[i]); //print the sorted array
        }
       
        
        //for a list of 1000000 integers
          int SIZE2 = 1000000; 
        int[] test2 = new int[SIZE2];

        for (int i = 0; i < SIZE2; i++){
            test2[i] = r.nextInt(500); //create an array of 1000000 random values from 0-499
        }
        System.out.println("");
        long start2 = System.currentTimeMillis(); //start time
        test2 = sort(test2);
        long end2 = System.currentTimeMillis(); //end time
        for (int i =0; i<test2.length; i++){
            System.out.println(test2[i]); //print the sorted array
        }
        
        //Display the times for the Radix Sort
         System.out.println("\n\n100 RS Time: " + (end-start) + " milliseconds");
        System.out.println("\n\n10000 RS Time: " + (end1-start1) + " milliseconds");
        System.out.println("\n\n1000000 RS Time: " + (end2-start2) + " milliseconds");
        
        
   
   
    }
    
     
 
     
     

}
 


