import java.util.*;
import java.io.*;

public class LeaderBoard {

    File scores;
    Scanner c;
    FileWriter writer;
    public LeaderBoard() throws Exception{
     scores = new File("src\\Scores");
     c = new Scanner(scores);
     writer = new FileWriter(scores);
    }
/**
    public void add(String name, int score)throws Exception{
        writer.write(name + " " + score);
    }

    public String[] getNames(File scores){

    }

    public int[] getScore(File scores){

    }

*/
}
