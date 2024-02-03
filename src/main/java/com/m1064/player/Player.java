package com.m1064.player;

interface Player {
    public String getPlayerName();

    public char getPlayerMark();

    public int[] getMove();

    public void setMove(int x, int y);
}
