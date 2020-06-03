package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;
import java.util.Set;

public class Hexagon {
    private int size;
    private Pos p;
    private TETile tile;

    public Hexagon(int size, Pos p, TETile tile) {
        this.size = size;
        this.p = p;
        this.tile=  tile;
    }

    public void draw(TERenderer ter) {
        // initialize tiles
        TETile[][] hex = new TETile[3 * size - 2][2 * size];
        for (int x = 0; x < 3 * size - 2; x += 1) {
            for (int y = 0; y < 2 * size; y += 1) {
                hex[x][y] = Tileset.NOTHING;
            }
        }

        // fills in a block 14 tiles wide by 4 tiles tall
        for (int row = 0; row < size; row++) {
            for (int i = size - 1 - row; i < 2 * size - 2 + row + 1; i++) {
                hex[i][row] = tile;
            }
        }

        for (int row = size; row < 2 * size; row++) {
            for (int i = row - size; i < 4 * size - 2 - row; i++) {
                hex[i][row] = tile;
            }
        }
        ter.renderFrame(hex, p.x, p.y - size);
    }

    public Pos getPos() {
        return p;
    }




}

