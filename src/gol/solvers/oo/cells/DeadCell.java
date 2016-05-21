package gol.solvers.oo.cells;

import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;

public class DeadCell extends Cell {

    public DeadCell(Point point) {
        super(point);
    }

    public void visit(WorldVisitor universeVisitor) {
        universeVisitor.visitDeadCell(point);
    }

    public boolean survives() {
        return neighbours.size() == 3;
    }
}

