package com.m1064.player;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private static final Scanner scanner = new Scanner(System.in);
    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }
    @Override
    public void setMove() {
        System.out.println(getPlayerName() + " make your move: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        move = new int[]{row, col};
    }
}
