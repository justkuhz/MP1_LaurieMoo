package test;

import java.util.*;

public class RandomMooValue {
    private int secretValue;

    int getBigMooCount(int guess) {

    }

    int getLittleMooCount(int guess) {
        int[] secretArray = valueToArray(secretValue);
        int[] guessArray = valueToArray(guess);
        int littleMooCounter = 0;

        for (int i = 0; i < 4; i++){
            if (guessArray[i] == secretArray[i]) {
                secretArray[i] = -1;
            }
        }

        return littleMooCounter;
    }

    int getSecretValue() {
        return secretValue;
    }

    boolean isCorrectGuess(int guess) {
        if (guess == secretValue) {
            return true;
        }
        return false;
    }

    boolean setSecretValue() {
        Random rng = new Random();
        secretValue = rng.nextInt(10000);
        if (secretValue >= 0 && secretValue < 10000) {
            return true;
        }
        return false;
    }

    boolean setSecretValue(int n) {
        if (n >= 0 || n < 10000) {
            secretValue = n;
            return true;
        }
        System.out.println("The number you tried to set the secret value to is invalid.");
        return false;
    }

    int[] valueToArray(int num) {
        int[] arr = {0, 0, 0, 0};
        if (num >= 1000 && num <= 9999) {
            for (int i = 3; i >= 0; i--) {
                arr[i] = num % 10;
                num /= 10;
            }
        }
        if (num >= 100 && num <= 999) {
            for (int i = 3; i > 0; i--) {
                arr[i] = num % 10;
                num /= 10;
            }
            if (num >= 10 && num <= 99) {
                arr[3] = num % 10;
                arr[2] = num / 10;
            }
            else {
                arr[3] = num;
            }
        }
        return arr;
    }
}


