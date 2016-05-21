package gol.solvers.oo.cells;

import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;
import java.util.Map;

public class LiveCell extends Cell {

    public LiveCell(Point point) {
        super(point);
    }

    public void visit(WorldVisitor universeVisitor) {
        universeVisitor.visitLiveCell(point);
    }

    public void decideIfJoiningTheNewWorld(Map<Point, Cell> newWorld) {
        if (neighbours.size() == 2 || neighbours.size() == 3)
            newWorld.put(point, new LiveCell(point));
    }
}