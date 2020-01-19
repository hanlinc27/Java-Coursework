import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Main extends JPanel{



    public static void main(String[] args) throws Exception {
        //start generation algorithms
        Game game = new Game(10);

        //dictionary array
        String[] dict = new String[20000];

        //generate dict array
        File file = new File("/Users/wenlang/NetBeansProjects/ICS_FindyWords/src/Dict");
        Scanner c= new Scanner(file);
        for(int i = 0; i<20000; i++){
            dict[i] = c.nextLine();
        }

        //actually generate it
        game.generate(dict,7);

        //test
        game.printBoard();
        for(int i = 0 ; i<7; i++){
            System.out.println(game.wordList().get(i));
        }
        //end test stuff

        ////////////////////GUI ///////////////////////////////////////////////

        GUIGame main = new GUIGame(10,game.board(),game.wordList());




    }
}