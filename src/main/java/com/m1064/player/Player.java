package com.m1064.player;

public abstract class Player {
    String playerName;
    char playerMark;

    int[] move;


    public Player(String playerName, char playerMark) {
        this.playerName = playerName;
        this.playerMark = playerMark;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getPlayerMark() {
        return playerMark;
    }

    public int[] getMove() {
        return move;
    }
    public void setMove() {
        this.move = move;
    }
}
