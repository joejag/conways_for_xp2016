package gol.solvers.oo.cells;

import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;

public class LiveCell extends Cell {

    public LiveCell(Point point) {
        super(point);
    }

    public void visit(WorldVisitor universeVisitor) {
        universeVisitor.visitLiveCell(point);
    }

    public boolean survives() {
        return neighbours.size() == 2 || neighbours.size() == 3;
    }
}