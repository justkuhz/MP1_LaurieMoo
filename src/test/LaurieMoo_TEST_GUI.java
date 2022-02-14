package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LaurieMoo_TEST_GUI {
    private JButton randomButton;
    private JTextField secretValueTextField;
    private JTextField guessTextField;
    private JPanel TestPanel;
    private JLabel guessLabel;
    private JLabel secretValueLabel;

    //instance variables
    private RandomMooValue moo = new RandomMooValue();
    private int secretValue, guess;

    public LaurieMoo_TEST_GUI() {
        randomButton.setEnabled(true);
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        secretValueTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        guessTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessTextField.setEnabled(true);
                if (Integer.parseInt(guessTextField.getText()) >= 0 || Integer.parseInt(guessTextField.getText()) < 10000){
                    int guess = Integer.parseInt(guessTextField.getText());
                    moo.setGuess(guess);

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("MP1 Test");
        myFrame.setContentPane(new LaurieMoo_TEST_GUI().TestPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
