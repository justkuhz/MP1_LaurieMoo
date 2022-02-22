package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LaurieMoo_MainGUI {

    private JPanel MainPanel;
    private JTextField guessField;
    private JLabel guessNum;
    private JTextArea mooOut;
    private JTextArea endOut;
    private JLabel secretValue;
    private JButton secretButton;
    private JButton tryAgain;

    public static int guessCounter = 1;

    // instance variables
    private RandomMooValue moo = new RandomMooValue();
    private int secretNum, guess, newGuess;
    Random rng = new Random();

    public LaurieMoo_MainGUI() {
        secretValue.setVisible(false);
        secretButton.setOpaque(false);
        secretButton.setContentAreaFilled(false);
        secretButton.setBorderPainted(false);
        mooOut.setVisible(false);
        guessField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        tryAgain.setVisible(false);
        endOut.setVisible(false);

        guessNum.setText("Guess #" + guessCounter + ": ");

        secretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secretValue.setText(String.format("%04d", moo.getSecretValue()));
                secretValue.setVisible(true);

            }
        });
        guessField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int littleMoos = 0, bigMoos = 0;
                String moos = "";
                String cowbell = "You head nothing but cowbells.";
                String victory = "LaurieMOO!!!";
                String lose = "Boo hoo -- no LaurieMOO.";

                guessField.setEnabled(true);

                int newGuess = Integer.parseInt(guessField.getText());
                if (newGuess >= 0 && newGuess < 10000) {
                    guess = newGuess;
                }

                moo.setGuess(guess);

                if (moo.getGuess() > 999) { guessField.setText(String.valueOf(moo.getGuess())); }
                else if (moo.getGuess() > 99) {
                    guessField.setText("0" + moo.getGuess());
                }
                else if (moo.getGuess() > 9) {
                    guessField.setText(("00" + moo.getGuess()));
                }
                else guessField.setText("000" + moo.getGuess());

                bigMoos = moo.getBigMooCount(guess);
                littleMoos = moo.getLittleMooCount(guess);

                if (bigMoos + littleMoos == 0){
                    mooOut.setVisible(true);
                    mooOut.setText(cowbell);
                }
                else {
                    for (int i = 0; i < bigMoos; i++) {
                        moos += "MOO! ";
                    }
                    for (int i = 0; i < littleMoos; i++) {
                        moos += "moo. ";
                    }
                    mooOut.setVisible(true);
                    mooOut.setText(moos);

                    guessCounter++;

                    if (moo.isCorrectGuess(moo.getGuess()) == true) {
                        endOut.setVisible(true);
                        endOut.setText(victory);
                        tryAgain.setVisible(true);
                    }

                    if(guessCounter == 11) {
                        endOut.setText(lose);
                        tryAgain.setVisible(true);
                    }
                    else guessNum.setText("Guess #" + guessCounter + ": ");

                }
            }
        });
        tryAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moo.setSecretValue();
                guessCounter = 1;
                tryAgain.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LaurieMOO");
        frame.setContentPane(new LaurieMoo_MainGUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
