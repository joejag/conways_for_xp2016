package gol.solvers;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class ProceduralSolver {

    public Set<Point> nextGeneration(Set<Point> currentGeneration) {
        Set<Point> survivingCells = new HashSet<>();

        // assume grid size of 200
        for (int x = 0; x < 200; x++) {
            for (int y = 0; y < 200; y++) {

                // 1. Find survivors
                int surrounding = 0;

                if (currentGeneration.contains(new Point(x - 1, y - 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(x - 1, y))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(x - 1, y + 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(x, y - 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(x, y + 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(x + 1, y - 1))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(x + 1, y))) {
                    surrounding++;
                }
                if (currentGeneration.contains(new Point(x + 1, y + 1))) {
                    surrounding++;
                }

                // 2. Decide is the cell lives or dies
                if (currentGeneration.contains(new Point(x, y))) {
                    if ((surrounding == 2) || (surrounding == 3)) {
                        survivingCells.add(new Point(x, y));
                    }
                } else {
                    if (surrounding == 3) {
                        survivingCells.add(new Point(x, y));
                    }
                }
            }
        }

        return survivingCells;
    }

}
