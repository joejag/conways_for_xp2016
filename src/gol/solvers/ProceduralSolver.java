package gol.solvers;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class ProceduralSolver {

    public Set<Point> nextGeneration(Set<Point> currentGeneration) {
        Set<Point> survivingCells = new HashSet<>();

        // assume grid size of 200
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {

                // 1. Find survivors
                int surrounding = 0;

                if (currentGeneration.contains(new Point(i - 1, j - 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(i - 1, j))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(i - 1, j + 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(i, j - 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(i, j + 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(i + 1, j - 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(i + 1, j))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(i + 1, j + 1))) {
                    surrounding++;
                }

                // 2. Decide is the cell lives or dies
                if (currentGeneration.contains(new Point(i, j))) {
                    if ((surrounding == 2) || (surrounding == 3)) {
                        survivingCells.add(new Point(i, j));
                    }
                } else {
                    if (surrounding == 3) {
                        survivingCells.add(new Point(i, j));
                    }
                }
            }
        }

        return survivingCells;
    }

}
