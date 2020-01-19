import java.awt.*;
import javax.swing.*;



////////////////////////////////////////////////////////// class TemperatureConverter1
class TemperatureConverter1 extends JFrame {

    //======================================= instance variables
    private JTextField _celsiusTF = new JTextField(5);
    private JTextField _fahrenheitTF   = new JTextField(15);

    //======================================================== constructor
    public TemperatureConverter1() {
        // 1... Create/initialize components
        JButton convertBtn = new JButton("Convert");             

        // 2... Create content pane, set layout
        setLayout(new FlowLayout());   // Use FlowLayout

        // 3... Add the components to the JFrame.
        add(new JLabel("Degrees Celsius"));  // Create, add label
        add(_celsiusTF);              // Add input field
        add(new JLabel("    Degrees Fahrenheit"));// Create, add label
        add(_fahrenheitTF);            // Add output field
        add(convertBtn);               // Add button

        // 4... Set this window's attributes.
        pack();                      
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);            // Center window.
    }

    //======================================================== method main
    public static void main(String[] args) {       
        TemperatureConverter1 window = new TemperatureConverter1();
        window.setVisible(true);
    }
}
