package gol.solvers.oo;

import gol.solvers.oo.cells.Cell;
import gol.solvers.oo.cells.DeadCell;
import gol.solvers.oo.cells.LiveCell;
import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;
import java.util.*;

public class World {

    private Grid<Cell> grid = new Grid<>(DeadCell::new);

    public void letThereBeLife(Set<Point> currentGeneration) {
        for (Point point : currentGeneration) {
            grid.add(point, new LiveCell(point));
        }
    }

    public void meetThyNeighbours() {
        Set<Point> knownLife = grid.points();
        for (Point point : knownLife) {
            Cell liveCell = grid.get(point);

            for (Cell neighbouringCell : grid.findNeighboursFor(point)) {
                neighbouringCell.meetNeighbour(liveCell);
            }
        }
    }

    public void passJudgement() {
        Grid<Cell> newWorld = new Grid<>(DeadCell::new);

        for (Cell cell : grid.items()) {
            cell.decideIfJoiningTheNewWorld(newWorld);
        }

        this.grid = newWorld;
    }

    public void visit(WorldVisitor universeVisitor) {
        for (Cell cell : grid.items()) {
            cell.visit(universeVisitor);
        }
    }

}