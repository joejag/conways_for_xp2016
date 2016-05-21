package gol;

import gol.solvers.ProceduralSolver;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class AcceptanceTests {

    ProceduralSolver proceduralSolver = new ProceduralSolver();

    @Test
    public void testBlinker() {
        Set<Point> blinkerWorld = new HashSet<>();
        blinkerWorld.add(new Point(1, 2));
        blinkerWorld.add(new Point(2, 2));
        blinkerWorld.add(new Point(3, 2));

        Set<Point> nextGeneration = proceduralSolver.nextGeneration(blinkerWorld);

        Set<Point> nextBlinkerWorld = new HashSet<>();
        nextBlinkerWorld.add(new Point(2, 1));
        nextBlinkerWorld.add(new Point(2, 2));
        nextBlinkerWorld.add(new Point(2, 3));
        Assert.assertEquals(nextBlinkerWorld, nextGeneration);

    }
}
