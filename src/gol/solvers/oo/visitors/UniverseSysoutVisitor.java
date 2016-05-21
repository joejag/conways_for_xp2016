package gol.solvers.oo.visitors;

import java.awt.*;

public class UniverseSysoutVisitor implements WorldVisitor {

    public UniverseSysoutVisitor() {
        System.out.println("\nWorld is at...");
    }

    public void visitLiveCell(Point point) {
        System.out.println(point.x + " " + point.y);
    }

    public void visitDeadCell(Point point) {
        System.out.println(point.x + " " + point.y);
    }
}
