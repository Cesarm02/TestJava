package com.test.testJava.player;

public class Player {

    private Dice dice;
    private int minNumberToWin;

    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    public Boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }
}
