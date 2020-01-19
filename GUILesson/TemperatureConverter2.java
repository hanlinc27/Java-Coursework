import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

////////////////////////////////////////////////////////// class TemperatureConverter2
class TemperatureConverter2 extends JFrame implements ActionListener
{

    //======================================= instance variables
    private JTextField _celsiusTF = new JTextField (3);
    private JTextField _fahrenheitTF = new JTextField (3);

    //======================================================== constructor
    public TemperatureConverter2 ()
    {
        // 1... Create/initialize components
        JButton convertBtn = new JButton ("Convert");
        convertBtn.addActionListener (this); // Connect button to listener

        // 2... Create content pane, set layout
        setLayout (new FlowLayout ()); // Use FlowLayout

        // 3... Add the components to the content pane.
        add (new JLabel ("Degrees Celsius")); // Create, add label
        add (_celsiusTF);             // Add input field
        add (convertBtn);              // Add button
        add (new JLabel ("Degrees Fahrenheit")); // Create, add label
        add (_fahrenheitTF);           // Add output field

        // 4... Set this window's attributes.
        pack ();
        setTitle ("Temperature Converter");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
    }

    public void actionPerformed (ActionEvent e)
    {
        String celStr = _celsiusTF.getText (); // Retrieve values from text fields
        String fahStr = _fahrenheitTF.getText ();
        if (celStr.equals ("") && !fahStr.equals ("")) // Entry for fahrenheit only
        {
            double fahrenheit = Double.parseDouble (fahStr); // Convert entries to numeric data
            double celsius = Math.round((fahrenheit - 32) * 5 / 9); // Calculate result
            _celsiusTF.setText ("" + celsius); // Display result
        }
        else if (!celStr.equals ("") && fahStr.equals ("")) // Entry for celsius only
        {
            double celsius = Double.parseDouble (celStr);
            long fahrenheit = Math.round(1.8 * celsius + 32);
            _fahrenheitTF.setText ("" + fahrenheit);
        }
    }

    //======================================================== method main
    public static void main (String[] args)
    {
        TemperatureConverter2 window = new TemperatureConverter2 ();
        window.setVisible (true);
    }
}

