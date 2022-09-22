package minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Minefield {
    private final List<List<Square>> minefield;    
    private final int width;
    private final int height;

    public Minefield(int width, int height) {
        if (width < 1 || height < 1) {
            throw new IllegalStateException("Must have dimentions larger than 0.");
        }

        //Fill minefield with null
        minefield = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Square> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(null);
            }
            minefield.add(row);
        }

        this.width = width;
        this.height = height;
    }

    public Square getSquare(int x, int y) {
        if (isOutOfBounds(x, y)) {
            throw new IllegalArgumentException("Coordinates are out of bounds");
        }
        return minefield.get(y).get(x);
    }

    public void setSquare(Square square, int x, int y) {
        if (isOutOfBounds(x, y)) {
            throw new IllegalStateException("Coordinates are out of bounds");
        }
        minefield.get(y).set(x, square);
    }

    private boolean isOutOfBounds(int x, int y) {
        return
            x < 0 ||
            x >= width ||
            y < 0 ||
            y >= height;
    }

}