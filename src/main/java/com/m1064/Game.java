package com.m1064;

import com.m1064.board.Board;
import com.m1064.board.BoardValidator;
import com.m1064.player.HumanPlayer;
import com.m1064.player.PcPlayer;
import com.m1064.player.Player;
import com.m1064.utils.Utils;

import java.util.Scanner;


public class Game {
    private static final Scanner scanner = new Scanner(System.in);

    public void game(int gameMode) {
        Board board = new Board(new char[3][3]);
        if (gameMode == 1) {
            startGame(
                    board,
                    new HumanPlayer("Player 1", 'X'),
                    new HumanPlayer("Player 2", 'O')
            );
        } else if (gameMode == 2) {
            startGame(
                    board,
                    new HumanPlayer("Player 1", 'X'),
                    new PcPlayer("Player 2", 'O', board)
            );
        }
    }

    private void startGame(Board board, Player player1, Player player2) {
        Player currentPlayer = player1;

        boolean loop = true;
        while (loop) {
            board.printBoard();
            makeMove(board, currentPlayer);

            if (BoardValidator.isWinner(currentPlayer.getPlayerMark(), board.getBoard())) {
                board.printBoard();
                System.out.println(Utils.ANSI_GREEN + currentPlayer.getPlayerName() + " wins!" + Utils.ANSI_RESET);
                System.out.println();
                loop = false;
            }
            if (BoardValidator.isBoardFull(board)) {
                board.printBoard();
                System.out.println(Utils.ANSI_ORANGE + "It's a draw!" + Utils.ANSI_RESET);
                System.out.println();
                loop = false;
            }

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }

    public void makeMove(Board board, Player player) {
        int row = player.getMove()[0];
        int col = player.getMove()[1];
        if (BoardValidator.isValidMove(row, col, board)) {
            board.placeMark(row, col, player.getPlayerMark(), board);
        } else {
            System.out.println(Utils.ANSI_RED + "Invalid move!" + Utils.ANSI_RESET);
            makeMove(board, player);
        }
    }
}
