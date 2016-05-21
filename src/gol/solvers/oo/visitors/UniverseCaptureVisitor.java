package gol.solvers.oo.visitors;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class UniverseCaptureVisitor implements WorldVisitor {

    private Set<Point> knownLife = new HashSet<>();

    public void visitLiveCell(Point point) {
        knownLife.add(point);
    }

    public void visitDeadCell(Point point) {
        // NO OP
    }

    public Set<Point> getKnownLife() {
        return knownLife;
    }
}