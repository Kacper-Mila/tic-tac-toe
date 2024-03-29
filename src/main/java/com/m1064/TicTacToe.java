package com.m1064;

import com.m1064.utils.Instructions;

import java.util.Scanner;

public class TicTacToe {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Instructions instructions = new Instructions();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose game mode: ");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs PC");
            System.out.println("3. PC vs PC");
            System.out.println("4. Instructions");
            System.out.println("0. Exit");
            int gameMode = scanner.nextInt();

            if (gameMode == 1 || gameMode == 2 || gameMode == 3) {
                Game game = new Game();
                game.game(gameMode);
            }  else if (gameMode == 4) {
                instructions.printInstructions();
            } else if (gameMode == 0) {
                break;
            } else {
                System.out.println("Invalid game mode");
            }
        }
    }
}