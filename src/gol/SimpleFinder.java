package gol;

import java.awt.*;
import java.util.ArrayList;

public class SimpleFinder {

    public ArrayList<Point> findSurvivors(boolean[][] gameBoard) {
        ArrayList<Point> survivingCells = new ArrayList<>(0);

        for (int i = 1; i < gameBoard.length - 1; i++) {
            for (int j = 1; j < gameBoard[0].length - 1; j++) {

                int surrounding = 0;

                if (gameBoard[i - 1][j - 1]) {
                    surrounding++;
                }
                if (gameBoard[i - 1][j]) {
                    surrounding++;
                }
                if (gameBoard[i - 1][j + 1]) {
                    surrounding++;
                }
                if (gameBoard[i][j - 1]) {
                    surrounding++;
                }
                if (gameBoard[i][j + 1]) {
                    surrounding++;
                }
                if (gameBoard[i + 1][j - 1]) {
                    surrounding++;
                }
                if (gameBoard[i + 1][j]) {
                    surrounding++;
                }
                if (gameBoard[i + 1][j + 1]) {
                    surrounding++;
                }

                if (gameBoard[i][j]) {
                    if ((surrounding == 2) || (surrounding == 3)) {
                        survivingCells.add(new Point(i - 1, j - 1));
                    }
                } else {
                    if (surrounding == 3) {
                        survivingCells.add(new Point(i - 1, j - 1));
                    }
                }
            }
        }

        return survivingCells;
    }

}
