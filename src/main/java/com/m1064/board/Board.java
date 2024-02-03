package com.m1064.board;

import com.m1064.utils.Utils;

public class Board {
    private final char[][] board;

    public Board(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void placeMark(int x, int y, char mark, Board board) {
        board.getBoard()[x][y] = mark;
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cellValue = board[row][col];
                String sign;

                if (cellValue == 'X') {
                    sign = "X";
                } else if (cellValue == 'O') {
                    sign = Utils.ANSI_O;
                } else {
                    sign = " ";
                }

                sb.append(Utils.ANSI_WHITE_BACKGROUND + Utils.ANSI_BLACK + " " + sign + " " + Utils.ANSI_RESET);

                if (col < 2) {
                    sb.append(Utils.ANSI_WHITE_BACKGROUND + Utils.ANSI_BLACK + Utils.ANSI_VERTICAL + Utils.ANSI_RESET);
                }
            }

            sb.append("\n");

            if (row < 2) {
                sb.append(Utils.ANSI_WHITE_BACKGROUND + Utils.ANSI_BLACK + Utils.ANSI_HORIZONTAL + Utils.ANSI_HORIZONTAL + Utils.ANSI_HORIZONTAL + Utils.ANSI_CROSS + Utils.ANSI_HORIZONTAL + Utils.ANSI_HORIZONTAL + Utils.ANSI_HORIZONTAL + Utils.ANSI_CROSS + Utils.ANSI_HORIZONTAL + Utils.ANSI_HORIZONTAL + Utils.ANSI_HORIZONTAL + Utils.ANSI_RESET + "\n");
            }
        }

        System.out.println(sb);
    }

    public boolean isWinner(char mark) {
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
