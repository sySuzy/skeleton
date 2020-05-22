package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private double[] openFraction;
    private int T;
    private int N;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Argument Exception!");
        }
        this.T = T;
        this.N = N;

        this.openFraction = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = pf.make(N);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(0, N);
                int col = StdRandom.uniform(0, N);
                percolation.open(row, col);
            }
            double fraction = (double) percolation.numberOfOpenSites() / (double) (N * N);
            openFraction[i] = fraction;
        }
    }

    public double mean() {
        return StdStats.mean(this.openFraction);
    }

    public double stddev() {
        return StdStats.stddev(this.openFraction);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(this.T);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(this.T);
    }

}
