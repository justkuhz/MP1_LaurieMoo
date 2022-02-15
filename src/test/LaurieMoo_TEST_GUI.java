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
    private JLabel bigMooLabel;
    private JLabel littleMooLabel;
    private JLabel correctGuessLabel;

    //instance variables
    private RandomMooValue moo = new RandomMooValue();
    private int secretValue, guess;
    Random rng = new Random();

    public LaurieMoo_TEST_GUI() {
        randomButton.setEnabled(true);
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int generatedRandom = rng.nextInt(10000);
               moo.setSecretValue(generatedRandom);
               if (generatedRandom >= 1000){
                   secretValueTextField.setText(String.valueOf(moo.getSecretValue()));
               }
               else if (generatedRandom >= 100){
                   secretValueTextField.setText("0" + moo.getSecretValue());
               }
               else if (generatedRandom >= 10){
                   secretValueTextField.setText("00" + moo.getSecretValue());
               }
               else {
                   secretValueTextField.setText("000" + moo.getSecretValue());
               }
            }
        });

        secretValueTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secretValueTextField.setEnabled(true);
                if (Integer.parseInt(secretValueTextField.getText()) >= 0
                        && Integer.parseInt(secretValueTextField.getText()) < 10000){
                    moo.setSecretValue(Integer.parseInt(secretValueTextField.getText()));
                }
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

                littleMooLabel.setText(String.valueOf(moo.getLittleMooCount(moo.getGuess())));
                bigMooLabel.setText(String.valueOf(moo.getBigMooCount(moo.getGuess())));
                if (moo.isCorrectGuess(moo.getGuess())){
                    correctGuessLabel.setText("Yes");
                }
                else
                    correctGuessLabel.setText("No");

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
