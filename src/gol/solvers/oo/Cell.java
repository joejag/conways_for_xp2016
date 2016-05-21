package gol.solvers.oo;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cell {

    private final List<Cell> liveNeighbours = new ArrayList<>();

    private final Point point;
    private final boolean isAlive;

    public Cell(Point point, boolean isAlive) {
        this.point = point;
        this.isAlive = isAlive;
    }

    public void meetNeighbour(Cell cell) {
        liveNeighbours.add(cell);
    }

    public void decideIfJoiningTheNewWorld(Grid<Cell> newWorld) {
        if (survives())
            newWorld.add(point, new Cell(point, true));
    }

    private boolean survives() {
        return (!isAlive && (liveNeighbours.size() == 3)) ||
                (isAlive && ((liveNeighbours.size() == 2) || (liveNeighbours.size() == 3)));
    }

}