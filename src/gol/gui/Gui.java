package gol.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Gui {

    private static Function<Set<Point>, Set<Point>> solver;

    public static void go(Function<Set<Point>, Set<Point>> solver) {
        Gui.solver = solver;
        ConwaysGameOfLife.showGui();
    }

    static class ConwaysGameOfLife extends JFrame implements ActionListener {
        private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(800, 600);
        private static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(400, 400);
        private static final int BLOCK_SIZE = 50;

        private JMenuBar mb_menu;
        private JMenu m_game;
        private JMenuItem mi_game_play;
        private JMenuItem mi_game_stop;
        private JMenuItem mi_game_reset;
        private int i_movesPerSecond = 3;
        private GameBoard gb_gameBoard;
        private Thread game;

        public static void showGui() {
            // Setup the swing specifics
            JFrame game = new ConwaysGameOfLife();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setTitle("Conway's Game of Life");
            game.setSize(DEFAULT_WINDOW_SIZE);
            game.setMinimumSize(MINIMUM_WINDOW_SIZE);
            game.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - game.getWidth()) / 2,
                    (Toolkit.getDefaultToolkit().getScreenSize().height - game.getHeight()) / 2);
            game.setVisible(true);
        }

        public ConwaysGameOfLife() {
            // Setup menu
            mb_menu = new JMenuBar();
            setJMenuBar(mb_menu);
            m_game = new JMenu("Game");
            mb_menu.add(m_game);

            mi_game_play = new JMenuItem("Play");
            mi_game_play.addActionListener(this);
            mi_game_stop = new JMenuItem("Stop");

            mi_game_stop.setEnabled(false);
            mi_game_stop.addActionListener(this);

            mi_game_reset = new JMenuItem("Reset");
            mi_game_reset.addActionListener(this);

            m_game.add(mi_game_play);
            m_game.add(mi_game_stop);
            m_game.add(mi_game_reset);

            // Setup game board
            gb_gameBoard = new GameBoard();
            add(gb_gameBoard);
        }

        public void setGameBeingPlayed(boolean isBeingPlayed) {
            if (isBeingPlayed) {
                mi_game_play.setEnabled(false);
                mi_game_stop.setEnabled(true);
                game = new Thread(gb_gameBoard);
                game.start();
            } else {
                mi_game_play.setEnabled(true);
                mi_game_stop.setEnabled(false);
                game.interrupt();
            }
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource().equals(mi_game_reset)) {
                gb_gameBoard.resetBoard();
                gb_gameBoard.repaint();
            } else if (ae.getSource().equals(mi_game_play)) {
                setGameBeingPlayed(true);
            } else if (ae.getSource().equals(mi_game_stop)) {
                setGameBeingPlayed(false);
            }
        }

        private class GameBoard extends JPanel implements ComponentListener, MouseListener, MouseMotionListener, Runnable {
            private Dimension d_gameBoardSize = null;
            private java.util.Set<Point> point = new HashSet<>();

            public GameBoard() {
                // Add resizing listener
                addComponentListener(this);
                addMouseListener(this);
                addMouseMotionListener(this);
            }

            private void updateArraySize() {
                ArrayList<Point> removeList = new ArrayList<>(0);
                for (Point current : point) {
                    if ((current.x > d_gameBoardSize.width - 1) || (current.y > d_gameBoardSize.height - 1)) {
                        removeList.add(current);
                    }
                }
                point.removeAll(removeList);
                repaint();
            }

            public void addPoint(int x, int y) {
                point.add(new Point(x, y));
                repaint();
            }

            public void addPoint(MouseEvent me) {
                int x = me.getPoint().x / BLOCK_SIZE - 1;
                int y = me.getPoint().y / BLOCK_SIZE - 1;
                if ((x >= 0) && (x < d_gameBoardSize.width) && (y >= 0) && (y < d_gameBoardSize.height)) {
                    addPoint(x, y);
                }
            }

            public void resetBoard() {
                point.clear();
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Set<Point> viewablePoints = point.stream()
                            .filter(p -> p.getY() < d_gameBoardSize.height)
                            .filter(p -> p.getX() < d_gameBoardSize.width)
                            .collect(Collectors.toSet());

                    for (Point newPoint : viewablePoints) {
                        // Draw new point
                        g.setColor(Color.blue);
                        g.fillRect(BLOCK_SIZE + (BLOCK_SIZE * newPoint.x), BLOCK_SIZE + (BLOCK_SIZE * newPoint.y), BLOCK_SIZE, BLOCK_SIZE);
                    }
                } catch (ConcurrentModificationException cme) {
                }
                // Setup grid
                g.setColor(Color.BLACK);
                for (int i = 0; i <= d_gameBoardSize.width; i++) {
                    g.drawLine(((i * BLOCK_SIZE) + BLOCK_SIZE), BLOCK_SIZE, (i * BLOCK_SIZE) + BLOCK_SIZE, BLOCK_SIZE + (BLOCK_SIZE * d_gameBoardSize.height));
                }
                for (int i = 0; i <= d_gameBoardSize.height; i++) {
                    g.drawLine(BLOCK_SIZE, ((i * BLOCK_SIZE) + BLOCK_SIZE), BLOCK_SIZE * (d_gameBoardSize.width + 1), ((i * BLOCK_SIZE) + BLOCK_SIZE));
                }
            }

            @Override
            public void componentResized(ComponentEvent e) {
                // Setup the game board size with proper boundries
                d_gameBoardSize = new Dimension(getWidth() / BLOCK_SIZE - 2, getHeight() / BLOCK_SIZE - 2);
                updateArraySize();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Mouse was released (user clicked)
                addPoint(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Mouse is being dragged, user wants multiple selections
                addPoint(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void run() {
                Set<Point> survivingCells = solver.apply(point);
                resetBoard();
                point.addAll(survivingCells);
                repaint();
                try {
                    Thread.sleep(1000 / i_movesPerSecond);
                    run();
                } catch (InterruptedException ex) {
                }
            }

        }
    }

}
