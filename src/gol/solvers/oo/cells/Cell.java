package gol.solvers.oo.cells;

import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Cell {

    protected final List<Cell> neighbours = new ArrayList<>();
    protected final Point point;

    public Cell(Point point) {
        this.point = point;
    }

    public void meetNeighbour(Cell cell) {
        neighbours.add(cell);
    }

    public abstract void visit(WorldVisitor universeVisitor);

    public abstract void decideIfJoiningTheNewWorld(Map<Point, Cell> newWorld);
}