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

    public static boolean isWinner(char mark, char board[][]) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) {
                return true;
            }
            if (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark) {
                return true;
            }
        }
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
            return true;
        }
        if (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) {
            return true;
        }
        return false;
    }
}
