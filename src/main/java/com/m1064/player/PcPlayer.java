package com.m1064.player;

public class PcPlayer implements Player {
    private String name;
    private char mark;
    private int[] move;

    public PcPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String getPlayerName() {
        return this.name;
    }

    @Override
    public char getPlayerMark() {
        return this.mark;
    }

    @Override
    public int[] getMove() {
        return this.move;
    }

    @Override
    public void setMove(int x, int y) {
        this.move = new int[]{x, y};
    }
}
