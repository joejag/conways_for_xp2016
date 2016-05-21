package gol.solvers.oo;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;

public class Grid<T> {

    private final Function<Point, T> defaultDefaultValueCreator;
    private Map<Point, T> items = new HashMap<>();

    public Grid(Function<Point, T> defaultValue) {
        this.defaultDefaultValueCreator = defaultValue;
    }

    public T fetch(Point point) {
        items.putIfAbsent(point, defaultDefaultValueCreator.apply(point));
        return items.get(point);
    }

    public void add(Point point, T item) {
        items.put(point, item);
    }

    public Set<Point> points() {
        return new HashSet<>(items.keySet());
    }

    public Collection<T> items() {
        return items.values();
    }

    public List<T> findNeighboursFor(Point point) {
        List<T> neighbouringItems = new ArrayList<>();

        for (Point neighbourPoint : neighbouringPointsFor(point)) {
            T item = fetch(neighbourPoint);
            neighbouringItems.add(item);
        }

        return neighbouringItems;
    }

    private List<Point> neighbouringPointsFor(Point point) {
        int x = point.x;
        int y = point.y;

        return asList(
                new Point(x - 1, y + 1), new Point(x, y + 1), new Point(x + 1, y + 1),
                new Point(x - 1, y),     /* The middle */     new Point(x + 1, y),
                new Point(x - 1, y - 1), new Point(x, y - 1), new Point(x + 1, y - 1));
    }

}
