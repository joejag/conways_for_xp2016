package gol;

import gol.gui.Gui;
import gol.solvers.OoSolver;
import gol.solvers.ProceduralSolver;

public class Blastoff {

    public static void main(String[] args) {
        objectVersion();
    }

    private static void proceduralVersion() {
        Gui.go(currentGeneration -> new ProceduralSolver().nextGeneration(currentGeneration));
    }

    private static void objectVersion() {
        Gui.go(currentGeneration -> new OoSolver().nextGeneration(currentGeneration));
    }

}
