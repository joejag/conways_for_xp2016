package gol.solvers.oo;

import gol.solvers.oo.visitors.UniverseCaptureVisitor;
import gol.solvers.oo.visitors.UniverseSysoutVisitor;

import java.awt.*;
import java.util.Set;

public class OoSolver {

    public Set<Point> nextGeneration(Set<Point> currentGeneration) {
        God god = new God();
        god.performGodsWork(currentGeneration);

        god.visit(new UniverseSysoutVisitor());

        UniverseCaptureVisitor visitor = new UniverseCaptureVisitor();
        god.visit(visitor);
        return visitor.getKnownLife();
    }

}
