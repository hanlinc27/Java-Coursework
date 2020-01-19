import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

////////////////////////////////////////////////////////// class TemperatureConverter3
class TemperatureConverter3 extends JFrame implements ActionListener
{

    //======================================= instance variables
    private JTextField _lowCelsiusTF = new JTextField (3);
    private JTextField _highCelsiusTF = new JTextField (3);
    private JTextArea _temperatureTA = new JTextArea (); // Multi-line text field

    //======================================================== constructor
    public TemperatureConverter3 ()
    {
        // 1... Create/initialize components
        JButton convertBtn = new JButton ("Convert");
        convertBtn.addActionListener (this); // Connect button to listener class

        // 2... Create content pane, set layout
        setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel ();        
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area

        // 3... Add the components to the input area.
        north.add (new JLabel ("Starting Celsius")); // Create, add label
        north.add (_lowCelsiusTF);            // Add input field
        north.add (new JLabel ("Ending Celsius")); // Create, add label
        north.add (_highCelsiusTF);          // Add output field
        north.add (convertBtn);             // Add button

        add (north, "North"); // Input area
        add (_temperatureTA, "South"); // Output area

        // 4... Set this window's attributes.
        pack ();
        setTitle ("Temperature Converter");
        setSize(400,400);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
    }

    public void actionPerformed (ActionEvent e)
    {
        String lowCelStr = _lowCelsiusTF.getText (); // Retrieve values from text fields 
        String highCelStr = _highCelsiusTF.getText ();

        int lowCelsius = Integer.parseInt (lowCelStr); // Convert entries to numeric data
        int highCelsius = Integer.parseInt (highCelStr);

        // Create output string for text area
        String outputStr = "\n\tCelsius\t\tFahrenheit\n\t-----------\t\t----------------\n";
        _temperatureTA.setText(outputStr);            
        for (int x = lowCelsius ; x <= highCelsius ; x += 5) // increments of 5 deg C
        {
            long fahrenheit = Math.round (1.8 * x + 32); // Convert temperature
            outputStr += "\t"+x+"\t\t"+fahrenheit+"\n"; // Update output string
            _temperatureTA.setText(outputStr);
        }
        //  pack();
    }

    //======================================================== method main
    public static void main (String[] args)
    {
        TemperatureConverter3 window = new TemperatureConverter3 ();
        window.setVisible (true);
    }
}

