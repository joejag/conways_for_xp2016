package gol;

import gol.solvers.oo.OoSolver;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class AcceptanceTests {

    //    ProceduralSolver proceduralSolver = new ProceduralSolver();
    OoSolver proceduralSolver = new OoSolver();

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

    @Test
    public void testStillLife() {
        Set<Point> stillLifeBlock = new HashSet<>();
        stillLifeBlock.add(new Point(1, 2));
        stillLifeBlock.add(new Point(2, 2));
        stillLifeBlock.add(new Point(1, 3));
        stillLifeBlock.add(new Point(2, 3));

        Set<Point> nextGeneration = proceduralSolver.nextGeneration(stillLifeBlock);

        Assert.assertEquals(stillLifeBlock, nextGeneration);
    }

    @Test
    public void testSpaceShip() {
        Set<Point> spaceShip = new HashSet<>();
        spaceShip.add(new Point(1, 2));
        spaceShip.add(new Point(2, 2));
        spaceShip.add(new Point(3, 2));
        spaceShip.add(new Point(3, 3));
        spaceShip.add(new Point(2, 4));

        Set<Point> nextGeneration = proceduralSolver.nextGeneration(spaceShip);

        Set<Point> spaceShipNextStep = new HashSet<>();
        spaceShipNextStep.add(new Point(2, 1));
        spaceShipNextStep.add(new Point(2, 2));
        spaceShipNextStep.add(new Point(3, 3));
        spaceShipNextStep.add(new Point(1, 3));
        spaceShipNextStep.add(new Point(3, 2));
        Assert.assertEquals(spaceShipNextStep, nextGeneration);
    }
}
