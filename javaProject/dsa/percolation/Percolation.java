import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    public int[][] grid;
    public int n;
    public int[] top;
    public int[] bottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n is less than zero");
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }

        // open top and bottom virtual nodes
        top = new int[1];
        bottom = new int[1];
        bottom[0] = n * n + 1;
    }

    private int xyTo1D(int x, int y) {
        return n * (x - 1) + y;
    }

    private void checkValidIndex(int... args) {
        for (int arg : args) {
            if (arg <= 0 || arg > n) {
                throw new IndexOutOfBoundsException("index arg is out of bounds");
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkValidIndex(row, col);
        grid[row][col] = 0;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkValidIndex(row, col);
        return grid[row][col] != -1;
    }

    // is the site (row, col) full?
    // A full site is an open site that can be connected to an open site
    // in the top row via a chain of neighboring
    // (left, right, up, down) open sites.
    public boolean isFull(int row, int col) {
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int numOpen = 0;
        return numOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}