

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GUIGame extends JPanel {
    //variable declarations
    int size;
    char[][] board;
    ArrayList<String> words;
    JButton[][] buttons;
    JFrame f;
    JLabel[] list;
    JButton submit;
    //constructor
    public GUIGame(int size, char[][] board, ArrayList<String> words) {
        this.size = size;
        this.board = board;
        this.words = words;
        f = new JFrame();

        //setup gui stuffs
        f.setSize(850, 600);
        f.setLayout(null);
        f.setVisible(true);

        //generate buttons from board *sigh*
        buttons = new JButton[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[j][i] = new JButton(board[j][i] + "");
                buttons[j][i].setBounds(j * 51, i * 51, 50, 50);
                f.add(buttons[j][i]);
                final int a = j;
                final int b = i;
                //event listener for onclick
                buttons[j][i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //call method when pressed
                        searchButton(a,b);
                    }
                });
            }
        }

        //generate wordlist
        list = new JLabel[words.size()];
        for (int i = 0; i < words.size(); i++) {
            list[i] = new JLabel();
            list[i].setText(words.get(i));
            list[i].setBounds(1300, 21 * i, 100, 20);
            f.add(list[i]);
        }

        //submit button
        submit = new JButton("SUBMIT");
        submit.setBounds(1350,750,100,50);
        submit.setBackground(Color.green);
        f.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //method when submitting
                submitButton();
            }
        });


    }

    //called to update the GUI
    private void update(){
        f.setLayout(null);
        f.setVisible(true);

        //update buttons (RESET)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
               buttons[j][i].setText(board[j][i]+"");
            }
        }

        //update wordlist reset all, then rewrite
        for (int i = 0; i < words.size()+1; i++) {
            list[i].setText("");
        }
        for (int i = 0; i < words.size(); i++) {
            list[i].setText(words.get(i));
        }

        //update submit button
        submit.setText("SUBMIT");
        submit.setFont(new Font ("Arial", Font.BOLD, 24));
        
    }


    //when wordsearch is pressed
    private void searchButton(int a, int b){
        if(buttons[a][b].getText().equals("A")){
            buttons[a][b].setText(board[a][b]+"");
        }else{
            buttons[a][b].setText("A");
        }
    }
    //when submitting
    private void submitButton(){
        if(submit()){
            submit.setText("GOOD");
            update();
        }
    }

    //reverse string checker, used for submit
    private static String reverse(String str) {
        String reverse = "";
        int length = str.length();
        //loop to reverse
        for( int i = length - 1 ; i >= 0 ; i-- ) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    //linked, to check if coordinates are continuous
    public boolean linked(ArrayList<Integer> x, ArrayList<Integer> y){
        //check x and y to see if they have larger differences
        for(int i = 0; i<x.size()-1; i++){
            if(Math.abs(x.get(i)-x.get(i+1)) > 1 || Math.abs(y.get(i)-y.get(i+1)) > 1){
                return false;
            }
        }
        return true;
    }


    //submit button check if it's a word
    public boolean submit(){
        //final word to be checked
        String word = "";
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();

        //check all "A" to fill word
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                String text = buttons[j][i].getText();
                if(text == "A"){
                    word+=board[j][i];
                    x.add(j);
                    y.add(i);
                }
            }
        }

        //checks for continuity, else false
        if(!linked(x,y)){
            return false;
        }

        //reverse word to check backwards
        String revWord = reverse(word);
        System.out.println(word);
        System.out.println(revWord);

        //checks word and reverseWord here
        for(int i = 0; i<words.size(); i++){
            if(words.get(i).equals(word) || words.get(i).equals(revWord)){
                words.remove(i);
                return true;
            }
        }
        return false;
    }







}
