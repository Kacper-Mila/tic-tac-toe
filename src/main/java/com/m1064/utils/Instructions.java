package com.m1064.utils;

import com.m1064.board.Board;

public class Instructions {
    Board instructions = new Board(new char [3][3]);
    public void printInstructions() {
        System.out.println("Instructions: ");
        System.out.println("The game is played on a grid that's 3 squares by 3 squares.");
        System.out.println("You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares.");
        System.out.println("The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
        System.out.println("When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.");
        System.out.println("Place your mark by entering the row and column number one at a time. For example:");
        instructions.printBoard();
        System.out.println("2\n2");
        instructions.placeMark(1, 1, 'X', instructions);
        instructions.printBoard();
    }
}
