/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlincheng_boxexercise;
import java.util.Scanner;
/**
 *
 * @author Hanlin
 */
public class HanlinCheng_BoxExercise {
 static Scanner input = new Scanner( System.in );
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double length,width,height,cdimension;
        Box nBox, nCube, change;
        int choice, choicebox;
       
        choice = 2;
        while (choice !=0) {
             System.out.println("Box Tester\nEnter 1 to Start:");
            choice = input.nextInt();
            System.out.println("Enter the length of your box:");
            length = input.nextDouble();
            System.out.println("Enter the width of your box:");
            width = input.nextDouble();
            System.out.println("Enter the height of your box:");
            height = input.nextDouble();
            nBox = new Box (length,width,height);
            System.out.println("The volume of the box is: " + nBox.volume());
            System.out.println("The surface area of the box is: " + nBox.area());
            System.out.println("For the cube enter your dimension: ");
            cdimension = input.nextDouble();
            nCube = new Box (cdimension);
            System.out.println("The volume of the cube is: " + nCube.volume());
            System.out.println("The surface area of the cube is: " + nCube.area());
            System.out.println("We can now play around with the first box that was created:");
            change = new Box (nBox);
            System.out.println("Would you like a bigger (1) or smaller box (2) ?");
            choicebox = input.nextInt();
            if (choicebox==1){
                change = change.biggerBox(nBox);
              System.out.println("Length: " + change.length());
               System.out.println("Width: " + change.length());
                System.out.println("Height: " + change.height());
            }
            else if (choicebox==2){
                change = change.smallerBox(nBox);
                System.out.println("Length: " + change.length());
               System.out.println("Width: " + change.length());
                System.out.println("Height: " + change.height());
            }
            else {
                System.out.println("Invalid number entered");
            }
            System.out.println("Does the cube fit inside: " + nCube.nests(change));
            System.out.println("That is the end of Box Tester. Press Zero to Exit. One to Start Again");
                    }
        

    }
    
}
class Box // Box Class 
{
    private double l,w,h; // Box Constructors
    public Box (){
        l = 0;
        w = 0;
        h = 0;
    }
    public Box( double dim1, double dim2, double dim3 ) //Three Dimensions
  {
    if( dim1 > 0 ){
        l = dim1;
    }
    else {
        l = 0;
    }
    if( dim2 > 0 ){
        w = dim2;
    }
    else {
        w = 0;
    }
    if( dim3 > 0 ) {
        h = dim3;
    }
    else{
        h = 0;
    }
  }
    public Box(double dim1){ //Cube
       if (dim1>0){
        l = dim1;
        w = dim1;
        h = dim1;
       }
       else {
           l = 0;
           w = 0;
           h = 0;
       }
    }
    public Box( Box oldBox ){ // Copy of a box
        l = oldBox.l;
       
        w = oldBox.w;
        h = oldBox.h;
    }
    public Box biggerBox( Box oldBox ){ //makes a bigger box of dimensions 125%
        return new Box( 1.25*oldBox.length(), 1.25*oldBox.width(), 1.25*oldBox.height());
    }
    public Box smallerBox (Box oldBox) { // makes a smaller box of dimensions 75%
        return new Box ( 0.75*oldBox.length(), 0.75*oldBox.width(), 0.75*oldBox.height());
    }
    public Box rearrangedBox ()  //arranges dimensions in order for comparison
  {
    double high = l, med = w, low = h;
      double temp; 
    if( low > high ) 
    {
      temp = low;
      low = high;
      high = temp;
    }
    if( med > high ) 
    {
      temp = med;
      med = high;
      high = temp;
    }
    if( low > med ) 
    {
      temp = low;
      low = med;
      med = temp;
    }
    return new Box( high, med, low );
  }
public double length () { // returns length
    return l;
}
public double width () { // returns width
    return w;
}
public double height () { // returns height
    return h;
}
public double volume (){ // returns volume
    return l*w*h;
} 
public double faceArea () { // returns area of front face
    return h*w;
}
public double sideArea () { // returns area of side face
    return l*h;
}
public double topArea (){ // returns area of top face
    return l*w;
}
public double area (){ // returns total surface area 
    return 2*(faceArea() + sideArea() + topArea());
}
public boolean nests( Box outsideBox ) // returns if the box fits or not
  {
    if( rearrangedBox().l <= outsideBox.rearrangedBox().l && rearrangedBox().w <= outsideBox.rearrangedBox().w && rearrangedBox().h <= outsideBox.rearrangedBox().h )
      return true;
    else{
       return false; 
    }
  }
  }
    
