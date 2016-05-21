package gol.solvers;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class OoSolver {

    private Map<Point, Cell> knownLife = new HashMap<>();
    private Map<Point, Cell> knownLifeAndSurroundingDeadCells = new HashMap<>();

    public static void main(String[] args) {
        OoSolver god = new OoSolver();

        god.letThereBeLife(new Point(1, 1));
        god.letThereBeLife(new Point(1, 2));
        god.letThereBeLife(new Point(1, 3));

        god.meetThyNeighbours();
        god.passJudgement();

        god.visit(new UniverseVisitor());
    }

    // WORLD

    private void letThereBeLife(Point point) {
        knownLife.put(point, new LiveCell(point));
    }

    private void meetThyNeighbours() {
        knownLifeAndSurroundingDeadCells.putAll(knownLife);

        for (Point cords : knownLife.keySet()) {
            Cell liveCell = knownLifeAndSurroundingDeadCells.get(cords);

            int x = cords.x;
            int y = cords.y;

            List<Point> neighbourCords = asList(
                    new Point(x - 1, y + 1), new Point(x, y + 1), new Point(x + 1, y + 1),
                    new Point(x - 1, y),     /* The middle */     new Point(x + 1, y),
                    new Point(x - 1, y - 1), new Point(x, y - 1), new Point(x + 1, y - 1));

            for (Point neighbourCord : neighbourCords) {
                knownLifeAndSurroundingDeadCells.putIfAbsent(neighbourCord, new DeadCell(neighbourCord));

                Cell neighbour = knownLifeAndSurroundingDeadCells.get(neighbourCord);
                neighbour.addNeighbour(liveCell);
            }
        }
    }

    private void passJudgement() {
        Map<Point, Cell> newWorld = new HashMap<>();

        for (Cell cell : knownLifeAndSurroundingDeadCells.values()) {
            cell.decideIfJoiningTheNewWorld(newWorld);
        }

        this.knownLife = newWorld;
    }

    private void visit(UniverseVisitor universeVisitor) {
        for (Cell cell : knownLife.values()) {
            cell.visit(universeVisitor);
        }
    }

    // VISITOR

    private static class UniverseVisitor {

        public UniverseVisitor() {
            System.out.println("\nWorld is at...");
        }

        public void visitLiveCell(Point point) {
            System.out.println(point.x + " " + point.y);
        }

        public void visitDeadCell(Point point) {
            System.out.println(point.x + " " + point.y);
        }
    }

    // CELLS

    private abstract class Cell {

        protected final List<Cell> neighbours = new ArrayList<>();
        protected final Point point;

        public Cell(Point point) {
            this.point = point;
        }

        public abstract void visit(UniverseVisitor universeVisitor);

        public void addNeighbour(Cell cell) {
            neighbours.add(cell);
        }

        public abstract void decideIfJoiningTheNewWorld(Map<Point, Cell> newWorld);
    }

    private class LiveCell extends Cell {

        public LiveCell(Point point) {
            super(point);
        }

        public void visit(UniverseVisitor universeVisitor) {
            universeVisitor.visitLiveCell(point);
        }

        public void decideIfJoiningTheNewWorld(Map<Point, Cell> newWorld) {
            if (neighbours.size() == 2 || neighbours.size() == 3)
                newWorld.put(point, new LiveCell(point));
        }
    }

    private class DeadCell extends Cell {

        public DeadCell(Point point) {
            super(point);
        }

        public void visit(UniverseVisitor universeVisitor) {
            universeVisitor.visitDeadCell(point);
        }

        public void decideIfJoiningTheNewWorld(Map<Point, Cell> newWorld) {
            if (neighbours.size() == 3)
                newWorld.put(point, new LiveCell(point));
        }
    }
}
