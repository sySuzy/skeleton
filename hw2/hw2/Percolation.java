package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    WeightedQuickUnionUF WQF;
    boolean[] openStatus;
    int N;
    int openSiteN;

    public Percolation(int N) {
        this.openStatus = new boolean[N * N];
        for (int i = 0; i < N * N; i++) {
            this.openStatus[i] = false;
        }
        this.WQF = new WeightedQuickUnionUF(N * N + 2);
        this.N = N;
    }

    private int xyTo1D(int row, int col) {
        return row * N + col;
    }

    public void open(int row, int col) {
        int index = xyTo1D(row, col);

        if (!openStatus[index]) {
            openStatus[index] = true;
            openSiteN += 1;

            if (row == 0) {
                WQF.union(index, N * N);
            }
            if (row == this.N - 1) {
                WQF.union(index, N * N + 1);
            }

            if (row - 1 >= 0) {
                int upperIndex = xyTo1D(row - 1, col);
                if (openStatus[upperIndex]) {
                    WQF.union(index, upperIndex);
                }
            }
            if (col - 1 >= 0) {
                int leftIndex = xyTo1D(row, col - 1);
                if (openStatus[leftIndex]) {
                    WQF.union(index, leftIndex);
                }
            }
            if (row + 1 < N) {
                int bottomIndex = xyTo1D(row + 1, col);
                if (openStatus[bottomIndex]) {
                    WQF.union(index, bottomIndex);
                }
            }
            if (col + 1 < N) {
                int rightIndex = xyTo1D(row, col + 1);
                if (openStatus[rightIndex]) {
                    WQF.union(index, rightIndex);
                }
            }

        }
    }

    public boolean isOpen(int row, int col) {
        int index = xyTo1D(row, col);
        return openStatus[index];
    }

    public boolean isFull(int row, int col) {
        int index = xyTo1D(row, col);
        return WQF.connected(index, N * N);
    }

    public int numberOfOpenSites() {
        return openSiteN;
    }

    public boolean percolates() {
        return WQF.connected(N * N, N * N + 1);
    }

    public static void main(String[] args) {
        return;
    }
}
