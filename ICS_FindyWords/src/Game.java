import java.io.*;
import java.util.*;

/**
 * TODO
 * -Edit fill so it checks for multiple words DOONE
 * -Create the subclasses
 * -Add wordList   DONE
 *
 *
 */
public class Game {
    //Game class is basically just a 2d char array with word in it

    //variables, accessors for stuff thats necessarry at the bottom
    private char[][] board;
    private int size;
    private ArrayList<String> wordList = new ArrayList<String>();

    //normal constructor
    public Game(int size) {
        this.size = size;
        board = new char[size][size];
    }

    //default constructor
    public Game() {
        this.size = 25;
        board = new char[25][25];
    }

    //method to find starting square for random word placement
    public Point startSquare() {
        int x = (int) (Math.random() * this.size);
        int y = (int) (Math.random() * this.size);
        return new Point(x, y);
    }

    //method to find orientation, 0-7 of word
    public int orient() {
        int dir = (int) (Math.random() * 8);
        return dir;
    }

    //method that plugs in words, use in fill method
    //EG takes a word say "HI", orientation and starting square, then puts the word into an array
    //very prone to error, make sure to properly check array bounds before calling
    public void putWord(String word, Point square, int ori) {
        wordList.add(word);
        String removable = word;
        //current x and y to be filled
        int x = square.x();
        int y = square.y();
        while (word.length() > 0) {
            //putting the char in
            char filler = word.charAt(0);
            if(board[x][y]== '\u0000'|| board[x][y] == filler) {
                board[x][y] = filler;
            }else{
                wordList.remove(removable);
                return;
            }
            //update for next x y values
            if (ori == 0) {//up
               y--;
            } else if (ori == 1) {//up top diag
                x++;
                y--;
            } else if (ori == 2) {//right
                x++;
            } else if (ori == 3) {//right down diag
                x++;
                y++;
            } else if (ori == 4) {//down
                y++;
            } else if (ori == 5) {//LEFT down diag
                x--;
                y++;
            } else if (ori == 6) {//left
                x--;
            } else if (ori == 7) {//left up diag
                x--;
                y--;
            }

            //update word, cut off front
            word = word.substring(1);
        }

    }

    //NOTE: BE CAREFUL OF INFINITE WORD LOOP IF THERE ARE ABSOLUTELY NO REMAINING SPACES. ALSO WORDS CAN BE ONE LETTER SO BE AWARE
    //Method to fill a word in   Mainly tests word, then calls putWord method.
    public void fill(String[] dict) {

        //check if the word fits
        boolean fits = false;

        //loop until a word fits
        while (!fits) {
            //SETUP//////////////////////////////////////////////////////////////////
            //get starting point

            Point start = startSquare();
            int x = start.x();
            int y = start.y();

            //get direction
            int ori = orient();

            //get Word
            String word = dict[(int) (Math.random() * 20000)];
            int len = word.length();

            /////////////////////////////////////////////////////////////////////////

            //orientation checker, 0 being up, rest going clockwise, including diaganols
            if (ori == 0) {//up
                //check if the word fits
                if (y - len >= 0) {
                    fits = true;
                }
            } else if (ori == 1) {//up top diag
                if (x + len < size && y - len >= 0) {
                    fits = true;
                }
            } else if (ori == 2) {//right
                if (x + len < size) {
                    fits = true;
                }
            } else if (ori == 3) {//right down diag
                if (x + len < size && y + len < size) {
                    fits = true;
                }
            } else if (ori == 4) {//down
                if (y + len < size) {
                    fits = true;
                }
            } else if (ori == 5) {//LEFT down diag
                if (x - len >= 0 && y + len < size) {
                    fits = true;
                }
            } else if (ori == 6) {//left
                if (x - len >= 0) {
                    fits = true;
                }
            } else if (ori == 7) {//left up diag
                if (x - len >= 0 && y - len >= 0) {
                    fits = true;
                }
            }
            //put in word if it fits
            if(fits){
                putWord(word,start,ori);
            }
        }



    }

    public void fillUp(){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(board[j][i] == '\u0000'){
                    char rand = (char) (Math.random() * 26 + 97 );
                    board[j][i] = rand;
                }
            }

        }

    }
    //Ease of use method for group members to call
    public void generate(String[] dict, int words){
        while(this.wordList().size()<words) {
            fill(dict);
        }
        fillUp();
    }


    //accessor for char [][] (MAIN BOARD OF BOARD GAME)
    public char[][] board(){
        return board;
    }

    //accessor for wordList arraylist
    public ArrayList<String> wordList(){
        return wordList;
    }

    //for testing
    public void printBoard(){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if(board[j][i] == '\u0000'){
                    System.out.print(" ");
                }
                System.out.print(board[j][i]);
            }
            System.out.println();
        }
    }


}

//subclasses, childclasses meh.    These are different modes of the game. Game should become abstract later on

//just adds a timer. When this times out, the word will be auto-submitted
class Timed extends Game{
    //edit the word submition method

}

//just overrides the generation of the board, instead crossreferences for words when checking
class Rand extends Game{
    public void generate(){
        fillUp();
    }
    //ALSO NEEDS TO OVERRIDE SUBMITTION PART SO IT CROSS REFERENCES IT

}

//just the same as game hehe
class Casual extends Game{
}


//simple point class basically stores an x and y
class Point{
    private int x = 0;
    private int y = 0;
    public Point(int x, int y){
        this.x = x;
        this.y = y;

    }

    public int x (){
        return x;
    }

    public int y(){
        return y;
    }
}