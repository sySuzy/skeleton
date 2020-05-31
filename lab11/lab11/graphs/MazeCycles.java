package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private boolean isCircle;
    private int[] tmpEdgeTo;
    private int start = -1;

    public MazeCycles(Maze m) {
        super(m);
        tmpEdgeTo = new int[m.V()];
        for (int i = 0; i < m.V(); i += 1) {
            tmpEdgeTo[i] = Integer.MAX_VALUE;
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        announce();

        for (int w : maze.adj(v)) {
            if (marked[w] && w != tmpEdgeTo[v]) {
                isCircle = true;
                start = w;
                announce();
                return;
            }
            if (!marked[w]) {
                tmpEdgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                dfs(w);
            }
        }
    }



    @Override
    public void solve() {
        dfs(0);
        if (start >= 0) {
            edgeTo[start] = tmpEdgeTo[start];
            int t = edgeTo[start];
            while (t != start) {
                edgeTo[t] = tmpEdgeTo[t];
                t = tmpEdgeTo[t];
            }
        }
        announce();
    }

    // Helper methods go here
}

