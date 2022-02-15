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
    private JLabel debugField;
    private JLabel debugField2;

    //instance variables
    private RandomMooValue moo = new RandomMooValue();
    private int secretValue, newSecretValue, guess, newGuess;
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

                newSecretValue = Integer.parseInt(secretValueTextField.getText());
                if (newSecretValue >= 0 && newSecretValue < 10000){
                    moo.setSecretValue(newSecretValue);
                }
                else {
                    secretValueTextField.setText(String.format("%04d", moo.getSecretValue()));
                }
            }
        });

        guessTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessTextField.setEnabled(true);

                int newGuess = Integer.parseInt(guessTextField.getText());
                if (newGuess >= 0 && newGuess < 10000) {
                    guess = newGuess;
                }

                moo.setGuess(guess);

                if (moo.getGuess() > 999) { guessTextField.setText(String.valueOf(moo.getGuess())); }
                else if (moo.getGuess() > 99) {
                    guessTextField.setText("0" + moo.getGuess());
                }
                else if (moo.getGuess() > 9) {
                    guessTextField.setText(("00" + moo.getGuess()));
                }
                else guessTextField.setText("000" + moo.getGuess());

                debugField2.setText("SV: " + moo.getArray(moo.valueToArray(moo.getSecretValue())));
                debugField.setText("Guess: " + moo.getArray(moo.valueToArray(moo.getGuess())));

                littleMooLabel.setText(String.valueOf(moo.getLittleMooCount(moo.getGuess())));
                bigMooLabel.setText(String.valueOf(moo.getBigMooCount(moo.getGuess())));
                if (moo.isCorrectGuess(moo.getGuess())) {
                    correctGuessLabel.setText("Yes");
                }
                else {
                    correctGuessLabel.setText("No");
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
