package com.m1064.player;

import com.m1064.board.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PcPlayer extends Player {
    private static final Random random = new Random();
    private final Board board;

    public PcPlayer(String name, char mark, Board board) {
        super(name, mark);
        this.board = board;
    }

    public char[][] getBoard() {
        return board.getBoard();
    }

    @Override
    public void setMove() {
        try {
            if (willOponentWin(getBoard())) {
                this.move = getBestMove(getBoard(), 'X');
            } else {
                this.move = getBestMove(getBoard(), 'O');
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int[] getBestMove(char[][] board, char mark) throws InterruptedException {
        Thread.sleep(1000);
        int size = board.length; // Size of the board

        // Check rows for two marks in a row
        for (int i = 0; i < size; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == '\u0000') {
                return new int[]{i, 2};
            }
            if (board[i][0] == mark && board[i][1] == '\u0000' && board[i][2] == mark) {
                return new int[]{i, 1};
            }
            if (board[i][0] == '\u0000' && board[i][1] == mark && board[i][2] == mark) {
                return new int[]{i, 0};
            }
        }

        // Check columns for two marks in a column
        for (int j = 0; j < size; j++) {
            if (board[0][j] == mark && board[1][j] == mark && board[2][j] == '\u0000') {
                return new int[]{2, j};
            }
            if (board[0][j] == mark && board[2][j] == mark && board[1][j] == '\u0000') {
                return new int[]{1, j};
            }
            if (board[1][j] == mark && board[2][j] == mark && board[0][j] == '\u0000') {
                return new int[]{0, j};
            }
        }

        // Check main diagonal for two marks
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == '\u0000') {
            return new int[]{2, 2};
        }
        if (board[0][0] == mark && board[1][1] == '\u0000' && board[2][2] == mark) {
            return new int[]{1, 1};
        }
        if (board[0][0] == '\u0000' && board[1][1] == mark && board[2][2] == mark) {
            return new int[]{0, 0};
        }

        // Check anti-diagonal for two marks
        if (board[0][2] == mark && board[1][1] == mark && board[2][0] == '\u0000') {
            return new int[]{2, 0};
        }
        if (board[0][2] == mark && board[1][1] == '\u0000' && board[2][0] == mark) {
            return new int[]{1, 1};
        }
        if (board[0][2] == '\u0000' && board[1][1] == mark && board[2][0] == mark) {
            return new int[]{0, 2};
        }

        // If no immediate winning move is found, return any empty space
        List<int[]> emptySpaces = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '\u0000') {
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }

        // Check for own marks and place next to them
        if (!isOnlyOneMark(board)) {
            for (int[] pos : emptySpaces) {
                int x = pos[0];
                int y = pos[1];
                if (isAdjacentToMark(x, y)) {
                    return new int[]{x, y};
                }
            }
        }

        if(board[1][1] == '\u0000') {
            return new int[]{1, 1};
        }

        return new int[]{random.nextInt(3), random.nextInt(3)};
    }

    private static boolean isAdjacentToMark(int x, int y) {
        int[] dx = {-1, 1, 0, 0}; // Offsets for adjacent cells (up, down, left, right)
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            return true;
        }
        return false;
    }

    private boolean willOponentWin(char[][] board) {
        char mark = this.getPlayerMark();
        if (mark == 'X') {
            mark = 'O';
        } else {
            mark = 'X';
        }

        int diagonal = 0;
        for (int row = 0; row < board.length; row++) {
            int horizontal = 0;
            int vertical = 0;
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == mark) {
                    horizontal++;
                    if (horizontal == 2) {
                        return true;
                    }
                }
                if (board[col][row] == mark) {
                    vertical++;
                    if (vertical == 2) {
                        return true;
                    }
                }
                if (row == col && board[row][col] == mark) {
                    diagonal++;
                    if (diagonal == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isOnlyOneMark(char[][] board) {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] != '\u0000') {
                    count++;
                }
            }
        }
        return count == 1 || count == 0;
    }
}
