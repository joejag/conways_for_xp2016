package gol.solvers;

import java.awt.*;
import java.util.Set;

public interface ConwaysSolver {
    Set<Point> nextGeneration(Set<Point> currentGeneration);
}
