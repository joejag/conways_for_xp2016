package gol.solvers.oo;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cell {

    private final List<Cell> neighbours = new ArrayList<>();

    private final Point point;
    private final boolean isAlive;

    public Cell(Point point, boolean isAlive) {
        this.point = point;
        this.isAlive = isAlive;
    }

    public void meetNeighbour(Cell cell) {
        neighbours.add(cell);
    }

    public void decideIfJoiningTheNewWorld(Grid<Cell> newWorld) {
        if (survives())
            newWorld.add(point, new Cell(point, true));
    }

    private boolean survives() {
        return (!isAlive && (neighbours.size() == 3)) ||
                (isAlive && ((neighbours.size() == 2) || (neighbours.size() == 3)));
    }

}