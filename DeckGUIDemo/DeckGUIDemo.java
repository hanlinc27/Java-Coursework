import java.awt.*;
import javax.imageio.*; // allows image loading
import java.io.*; // allows file access
import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

class DeckGUIDemo extends JFrame
{
    static Deck deck = new Deck ();

    //======================================================== constructor
    public DeckGUIDemo ()
    {
        // 1... Create/initialize components
        BtnListener btnListener = new BtnListener (); // listener for all buttons

        JButton shuffleBtn = new JButton ("Shuffle");
        shuffleBtn.addActionListener (btnListener);
        JButton sortBtn = new JButton ("Sort");
        sortBtn.addActionListener (btnListener);

        // 2... Create content pane, set layout
        JPanel content = new JPanel ();        // Create a content pane
        content.setLayout (new BorderLayout ()); // Use BorderLayout for panel
        JPanel north = new JPanel (); // where the buttons, etc. will be
        north.setLayout (new FlowLayout ()); // Use FlowLayout for input area

        DrawArea board = new DrawArea (600, 400); // Area for cards to be displayed

        // 3... Add the components to the input area.
        north.add (shuffleBtn);
        north.add (sortBtn);
        content.add (north, "North"); // Input area
        content.add (board, "South"); // Deck display area

        // 4... Set this window's attributes.
        setContentPane (content);
        pack ();
        setTitle ("Deck Demo");
        setSize (600, 500);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo (null);           // Center window.
    }

    // put ActionListener class for your buttons here
    class BtnListener implements ActionListener // Button menu
    {
        public void actionPerformed (ActionEvent e)
        {
            if (e.getActionCommand ().equals ("Shuffle"))
                deck.shuffle (); // shuffle deck
            else if (e.getActionCommand ().equals ("Sort"))
                deck.quickSort (); // shuffle deck
            repaint (); // do after each action taken to update deck
        }
    }

    class DrawArea extends JPanel
    {
        public DrawArea (int width, int height)
        {
            this.setPreferredSize (new Dimension (width, height)); // size
        }

        public void paintComponent (Graphics g)
        {
            deck.show (g);
        }
    }

    //======================================================== method main
    public static void main (String[] args)
    {
        DeckGUIDemo window = new DeckGUIDemo ();
        window.setVisible (true);
    }
}

// -------------------------------------- Card Class ------------------------------------------------------
class Card
{
    private int rank, suit;
    private Image image;
    private boolean faceup;
    private static Image cardback; // shared image for back of card

    public Card (int cardNum)  // Creates card from 0-51
    {
        rank = cardNum % 13;
        suit = cardNum / 13;
        faceup = true;

        image = null;
        try
        {
            image = ImageIO.read (new File ("cards/" + (cardNum + 1) + ".gif")); // load file into Image object
            cardback = ImageIO.read (new File ("cards/b.gif")); // load file into Image object
        }
        catch (IOException e)
        {
            System.out.println ("File not found");
        }
    }

    public void show (Graphics g, int x, int y)  // draws card face up or face down
    {
        if (faceup)
            g.drawImage (image, x, y, null);
        else
            g.drawImage (cardback, x, y, null);

    }
}

// -------------------------------------- Deck Class ------------------------------------------------------
class Deck
{
    private Card deck[];

    public Deck ()
    {
        deck = new Card [52];
        for (int x = 0 ; x < 52 ; x++)  // for each card in standard deck
        {
            deck [x] = new Card (x); // create card
        }
    }

    public void show (Graphics g)  // draws card face up or face down
    {
        for (int c = 0 ; c < deck.length ; c++)
        {
            deck [c].show (g, c % 13 * 20 + 150, c / 13 * 50 + 20);
        }
    }


    public void shuffle ()
    {
    }

    public void quickSort ()
    {
    }

}

