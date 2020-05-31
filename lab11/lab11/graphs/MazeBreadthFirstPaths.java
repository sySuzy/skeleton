package lab11.graphs;
import java.util.*;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private int s;
    private int t;
    private boolean targetFound;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = s;
        edgeTo[s] = s;
        // Add more variables here!
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        Deque<Integer> fringe = new ArrayDeque<>();
        fringe.addLast(s);
        bfs(fringe);
    }

    private void bfs(Deque<Integer> fringe) {
        if (!fringe.isEmpty()) {
            int v = fringe.removeFirst();
            marked[v] = true;
            announce();

            if (v == t) {
                targetFound = true;
                return;
            }

            for (int v1 : maze.adj(v)) {
                if (!marked[v1]) {
                    fringe.addLast(v1);
                    edgeTo[v1] = v;
                    distTo[v1] = distTo[v] + 1;
                    marked[v1] = true;
                }
            }
            bfs(fringe);
        }
    }




    @Override
    public void solve() {
        bfs();
    }
}

