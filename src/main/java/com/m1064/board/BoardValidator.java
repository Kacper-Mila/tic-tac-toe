package com.m1064.board;

public class BoardValidator {
    public static boolean isValidMove(int x, int y, Board board) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        if (board.getBoard()[x][y] != '\u0000') {
            return false;
        }
        return true;
    }

    public static boolean isBoardFull(Board board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getBoard()[row][col] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }
}
