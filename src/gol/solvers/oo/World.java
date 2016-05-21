package gol.solvers.oo;

import gol.solvers.oo.cells.Cell;
import gol.solvers.oo.cells.DeadCell;
import gol.solvers.oo.cells.LiveCell;
import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.util.Arrays.asList;

public class World {

    private Map<Point, Cell> cells = new HashMap<>();

    public void letThereBeLife(Set<Point> currentGeneration) {
        for (Point point : currentGeneration) {
            addLife(point);
        }
    }

    public void meetThyNeighbours() {
        Set<Point> knownLife = new HashSet<>(cells.keySet());
        for (Point point : knownLife) {
            Cell liveCell = cells.get(point);

            for (Cell neighbouringCell : findNeighboursFor(point)) {
                neighbouringCell.meetNeighbour(liveCell);
            }
        }
    }

    public void passJudgement() {
        Map<Point, Cell> newWorld = new HashMap<>();

        for (Cell cell : cells.values()) {
            cell.decideIfJoiningTheNewWorld(newWorld);
        }

        this.cells = newWorld;
    }

    public void visit(WorldVisitor universeVisitor) {
        for (Cell cell : cells.values()) {
            cell.visit(universeVisitor);
        }
    }

    private void addLife(Point point) {
        cells.put(point, new LiveCell(point));
    }

    private List<Cell> findNeighboursFor(Point point) {
        List<Cell> neighbouringCells = new ArrayList<>();

        for (Point neighbourCord : neighbouringPointsFor(point)) {
            Cell cell = findCellEvenIfDead(neighbourCord);
            neighbouringCells.add(cell);
        }

        return neighbouringCells;
    }

    private Cell findCellEvenIfDead(Point point) {
        cells.putIfAbsent(point, new DeadCell(point));
        return cells.get(point);
    }

    private List<Point> neighbouringPointsFor(Point point) {
        int x = point.x;
        int y = point.y;

        return asList(
                new Point(x - 1, y + 1), new Point(x, y + 1), new Point(x + 1, y + 1),
                new Point(x - 1, y),     /* The middle */     new Point(x + 1, y),
                new Point(x - 1, y - 1), new Point(x, y - 1), new Point(x + 1, y - 1));
    }

}