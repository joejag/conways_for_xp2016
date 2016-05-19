package gol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class God {

    private Map<int[], Cell> knownLife = new HashMap<>();

    public static void main(String[] args) {
        God god = new God();

        god.addLife(1, 1);
        god.addLife(1, 2);
        god.addLife(1, 3);

        god.visit(new UniverseVisitor());

        god.passJudgement();

        god.visit(new UniverseVisitor());
    }

    private void passJudgement() {
        for (int[] cords : knownLife.keySet()) {
            int x = cords[0];
            int y = cords[1];

            List<int[]> neighbourCords = asList(
                    new int[]{x - 1, y + 1}, new int[]{x, y + 1}, new int[]{x + 1, y + 1},
                    new int[]{x - 1, y},     /* The middle */     new int[]{x + 1, y},
                    new int[]{x - 1, y - 1}, new int[]{x, y - 1}, new int[]{x + 1, y - 1});

            for (int[] neighbourCord : neighbourCords) {
                knownLife.putIfAbsent(neighbourCord, new DeadCell(neighbourCord[0], neighbourCord[1]));
            }

            List<Cell> neighbours = new ArrayList<>();
            for (int[] neighbourCord : neighbourCords) {
                neighbours.add(knownLife.get(neighbourCord));
            }

            for (Cell cell : knownLife.values()) {
                cell.emitEnergy(neighbours);
            }
        }

        // count times life energy is present
        // ask new world factory for new child


    }

    private void visit(UniverseVisitor universeVisitor) {
        for (Cell cell : knownLife.values()) {
            cell.visit(universeVisitor);
        }
    }

    private void addLife(int x, int y) {
        knownLife.put(new int[]{x, y}, new LiveCell(x, y));
    }

    private static class UniverseVisitor {

        public UniverseVisitor() {
            System.out.println("\nWorld is at...");
        }

        public void visitLiveCell(int x, int y) {
            System.out.println(x + " " + y);
        }

        public void visitDeadCell(int x, int y) {
            System.out.println(x + " " + y);
        }
    }

    private abstract class Cell {
        final int x;
        final int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public abstract void visit(UniverseVisitor universeVisitor);

        public abstract void emitEnergy(List<Cell> neighbours);
    }

    private class LiveCell extends Cell {

        public LiveCell(int x, int y) {
            super(x, y);
        }

        public void visit(UniverseVisitor universeVisitor) {
            universeVisitor.visitLiveCell(x, y);
        }

        public void emitEnergy(List<Cell> neighbours) {

        }
    }

    private class DeadCell extends Cell {

        public DeadCell(int x, int y) {
            super(x, y);
        }

        public void visit(UniverseVisitor universeVisitor) {
            universeVisitor.visitDeadCell(x, y);
        }

        public void emitEnergy(List<Cell> neighbours) {

        }
    }
}
