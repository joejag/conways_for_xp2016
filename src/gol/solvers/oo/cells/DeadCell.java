package gol.solvers.oo.cells;

import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;
import java.util.Map;

public class DeadCell extends Cell {

    public DeadCell(Point point) {
        super(point);
    }

    public void visit(WorldVisitor universeVisitor) {
        universeVisitor.visitDeadCell(point);
    }

    public void decideIfJoiningTheNewWorld(Map<Point, Cell> newWorld) {
        if (neighbours.size() == 3)
            newWorld.put(point, new LiveCell(point));
    }
}

