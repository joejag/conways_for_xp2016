package gol.solvers.oo;

import gol.solvers.oo.visitors.WorldVisitor;

import java.awt.*;
import java.util.Set;

public class God {

    private final World world = new World();

    public void performGodsWork(Set<Point> currentGeneration) {
        world.letThereBeLife(currentGeneration);
        world.meetThyNeighbours();
        world.passJudgement();
    }

    public void visit(WorldVisitor visitor) {
        world.visit(visitor);
    }
}