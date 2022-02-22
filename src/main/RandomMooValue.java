package main;

import java.util.Random;

public class RandomMooValue {
    private int secretValue;
    private int guess;
    Random rng = new Random();

    public RandomMooValue(){
        this.secretValue = rng.nextInt(10000);
    }

    int getBigMooCount(int guess) {
        int bigMooCounter = 0;
        int[] secretArray = valueToArray(secretValue);
        int[] guessArray = valueToArray(guess);

        for (int i = 0; i < 4; i++){
            if (guessArray[i] == secretArray[i]){
                bigMooCounter++;
            }
        }
        return bigMooCounter;
    }

    void setGuess(int n){
        if (n >= 0 || n < 10000) {
            this.guess = n;
        }
    }

    int getGuess(){
        return guess;
    }

    int getLittleMooCount(int guess) {
        int[] secretArray = valueToArray(secretValue);
        int[] guessArray = valueToArray(guess);
        int littleMooCounter = 0;

        for (int i = 0; i < 4; i++){
            if (guessArray[i] == secretArray[i]) {
                guessArray[i] = -1;
                secretArray[i] = -2;
            }
        }

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (i == j) continue;
                if (guessArray[i] == secretArray[j]){
                    guessArray[i] = -1;
                    littleMooCounter++;
                    break;
                }
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
        secretValue = rng.nextInt(10000);
        if (secretValue >= 0 && secretValue < 10000) {
            return true;
        }
        return false;
    }

    boolean setSecretValue(int n) {
        if (n >= 0 && n < 10000) {
            secretValue = n;
            return true;
        }
        return false;
    }

    int[] valueToArray(int num) {
        int[] arr = {0, 0, 0, 0};
        if (num >= 1000) {
            for (int i = 3; i >= 0; i--) {
                arr[i] = num % 10;
                num /= 10;
            }
        }
        else if (num >= 100) {
            for (int i = 3; i > 0; i--) {
                arr[i] = num % 10;
                num /= 10;
            }
        }
        else if (num >= 10) {
                arr[3] = num % 10;
                arr[2] = num / 10;
        }
        else {
            arr[3] = num;
            }
        return arr;
    }

    String getArray(int[] arr){
        String arg = "";
        for (int i = 0; i < arr.length; i++){
            arg += String.valueOf(arr[i]);
        }
        return arg;
    }
}



