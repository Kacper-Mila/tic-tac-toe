package com.m1064;

import com.m1064.board.Board;
import com.m1064.board.BoardValidator;
import com.m1064.player.HumanPlayer;
import com.m1064.utils.Utils;

import java.util.Scanner;


public class Game {
    private static final Scanner scanner = new Scanner(System.in);

    public void startGame(int gameMode) {
        if (gameMode == 1) {
            startHumanVsHuman();
        }
    }

    private void startHumanVsHuman() {
        HumanPlayer player1 = new HumanPlayer("Player 1", 'X');
        HumanPlayer player2 = new HumanPlayer("Player 2", 'O');
        Board board = new Board(new char[3][3]);

        boolean loop = true;
        HumanPlayer currentPlayer = player2;
        while (loop) {
            if (currentPlayer == player2) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }
            loop = gameLoop(board, currentPlayer);
        }
    }

    private boolean gameLoop(Board board, HumanPlayer player) {
        board.printBoard();
        System.out.println(player.getPlayerName() + " make your move: ");
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        if (BoardValidator.isValidMove(x, y, board)) {
            board.placeMark(x, y, player.getPlayerMark(), board);
        } else {
            System.out.println(Utils.ANSI_RED + "Invalid move!" + Utils.ANSI_RESET);
            gameLoop(board, player);
        }
        if (board.isWinner(player.getPlayerMark())) {
            board.printBoard();
            System.out.println(Utils.ANSI_GREEN + player.getPlayerName() + " wins!" + Utils.ANSI_RESET);
            System.out.println();
            return false;
        }
        if (BoardValidator.isBoardFull(board)) {
            board.printBoard();
            System.out.println("It's a draw!");
            System.out.println();
            return false;
        }
        return true;
    }
}
