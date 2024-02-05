package com.m1064.board;

import com.m1064.utils.Utils;

public class Board {
    private final char[][] boardArr;

    public Board(char[][] boardArr) {
        this.boardArr = boardArr;
    }

    public char[][] getBoard() {
        return boardArr;
    }

    public void placeMark(int x, int y, char mark, Board board) {
        board.getBoard()[x][y] = mark;
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char cellValue = boardArr[row][col];
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
}
