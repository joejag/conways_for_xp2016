package gol.solvers.oo.cells;

import gol.solvers.oo.Grid;
import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Cell {

    protected final List<Cell> neighbours = new ArrayList<>();
    protected final Point point;

    public Cell(Point point) {
        this.point = point;
    }

    public void meetNeighbour(Cell cell) {
        neighbours.add(cell);
    }

    public void decideIfJoiningTheNewWorld(Grid<Cell> newWorld) {
        if (survives())
            newWorld.add(point, new LiveCell(point));
    }

    public abstract void visit(WorldVisitor universeVisitor);

    protected abstract boolean survives();


}