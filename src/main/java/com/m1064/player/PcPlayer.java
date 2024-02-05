package com.m1064.player;

import com.m1064.board.Board;

import java.util.Arrays;
import java.util.Random;

public class PcPlayer extends Player {
    private static final Random random = new Random();
    private Board board;
    public PcPlayer(String name, char mark, Board board) {
        super(name, mark);
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void setMove() {
        if (willOpponentWin(getBoard())){

        } else {
            if (isOnlyOneMark(getBoard())) {
                this.move = new int[]{random.nextInt(3), random.nextInt(3)};
            }
        };
    }

    private boolean willOpponentWin(Board board){
        return false;
    }

    private void makeMove(Board board, int[] move){

    }
    private boolean isOnlyOneMark(Board board){
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getBoard()[row][col] != '\u0000') {
                    count++;
                }
            }
        }
        return count == 1;
    }
}
