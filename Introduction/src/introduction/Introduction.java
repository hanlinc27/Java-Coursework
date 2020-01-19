/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduction;
import javax.swing.JFrame;
import java.awt.*;
import javax.imageio.*; 
import java.io.*; 
import javax.swing.*;
import java.awt.event.*;  
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Hanlin
 */
public class Introduction extends JFrame{
    static String file = "/Users/wenlang/NetBeansProjects/Introduction/src/introduction/market.png";
    static JButton play;
    static JButton instruction;

    /**
     * @param args the command line arguments
     */
    public Introduction () {
         BtnListener btnListener = new BtnListener(); 
       play  = new JButton ("Play");
       instruction = new JButton("Instructions");
         JPanel content = new JPanel();        // Create a content pane
        content.setLayout(new BorderLayout()); // Use BorderLayout for panel
        JPanel north = new JPanel(); // where the buttons, etc. will be
           JPanel south = new JPanel();
        north.setLayout(new FlowLayout()); // Use FlowLayout for input area
    //    DrawArea board = new DrawArea(600, 400); // Area for cards to be displayed
    ImageIcon im = new ImageIcon("/Users/wenlang/NetBeansProjects/Introduction/src/introduction/market.png");
		JLabel label = new JLabel(im);
        Graphics g = null;
JLabel title = new JLabel ("Keith the Thief");
		
       content.add(north, "North"); // Input area
       content.add(south, "South");
       north.add(label);
       south.add(title);
       south.add(play);
       south.add(instruction);
       
       setContentPane(content);
        pack();
        setTitle("Keith the Thief");
        setSize(750, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit button
        setLocationRelativeTo(null);   
    }
    
 
   class BtnListener implements ActionListener {

        
        public void actionPerformed(ActionEvent e) {
           if (e.getActionCommand().equals("Instructions")){
               
           }
            if (e.getActionCommand().equals("Play")){
                
            }
        }
       // Button menu
   }
    public static void main(String[] args) {
        // TODO code application logic here
       //  new Introduction(args[0]);
           Introduction window = new Introduction();
        window.setVisible(true);

    }
    
}
