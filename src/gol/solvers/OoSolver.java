package gol.solvers;

import gol.solvers.oo.God;
import gol.solvers.oo.visitors.UniverseCaptureVisitor;

import java.awt.*;
import java.util.Set;

public class OoSolver {

    private final God god = new God();

    public Set<Point> nextGeneration(Set<Point> currentGeneration) {
        god.performGodsWork(currentGeneration);

        UniverseCaptureVisitor visitor = new UniverseCaptureVisitor();
        god.visit(visitor);
        return visitor.getKnownLife();
    }

}
