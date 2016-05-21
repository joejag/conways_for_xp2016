package gol.solvers.oo.visitors;

import java.awt.*;

public interface WorldVisitor {
    void visitLiveCell(Point point);

    void visitDeadCell(Point point);
}
