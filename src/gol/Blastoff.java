package gol;

import gol.gui.Gui;
import gol.solvers.ProceduralSolver;

public class Blastoff {

    public static void main(String[] args) {
        proceduralVersion();
    }

    private static void proceduralVersion() {
        Gui.go(currentGeneration -> new ProceduralSolver().nextGeneration(currentGeneration));
    }

}
