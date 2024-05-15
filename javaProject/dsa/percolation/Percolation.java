import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[][] grid;
    private int n;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF wq;

    private int blockedMarker = 0;
    private int openMarker = 1;
    private int numOpen;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        if (n <= 0) throw new IllegalArgumentException("n is less than zero");
        grid = new int[n + 1][n + 1];
        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < n + 1; j++) {
        //         grid[i][j] = blockedMarker;
        //     }
        // }

        // open top and bottom virtual nodes
        top = openMarker;
        bottom = openMarker;
        numOpen = 0;

        wq = new WeightedQuickUnionUF(n * n + 2);
    }

    private int xyTo1D(int x, int y) {
        return n * (x - 1) + y;
    }

    private void checkValidIndex(int... args) {
        for (int arg : args) {
            if (arg <= 0 || arg > n) {
                throw new IllegalArgumentException("index " + arg + " is out of bounds");
            }
        }
    }

    private boolean isValidIndex(int x, int y) {
        if (x <= 0 || x > n) {
            return false;
        }
        if (y <= 0 || y > n) {
            return false;
        }
        return true;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkValidIndex(row, col);
        if (grid[row][col] != openMarker) {
            grid[row][col] = openMarker;
            numOpen++;
        }
        int nodeWqIdx = xyTo1D(row, col);
        int neighborWqIdx;
        int neighborRow;
        int neighborCol;

        // connect to all neighbors of the node if they are open
        // up neighbor
        neighborRow = row - 1;
        neighborCol = col;
        if (isValidIndex(neighborRow, neighborCol)
                && grid[neighborRow][neighborCol] == openMarker) {
            neighborWqIdx = xyTo1D(neighborRow, neighborCol);
            wq.union(nodeWqIdx, neighborWqIdx);
        }

        // down neighbor
        neighborRow = row + 1;
        if (isValidIndex(neighborRow, neighborCol)
                && grid[neighborRow][neighborCol] == openMarker) {
            neighborWqIdx = xyTo1D(neighborRow, neighborCol);
            wq.union(nodeWqIdx, neighborWqIdx);
        }

        // left neighbor
        neighborRow = row;
        neighborCol = col - 1;
        if (isValidIndex(neighborRow, neighborCol)
                && grid[neighborRow][neighborCol] == openMarker) {
            neighborWqIdx = xyTo1D(neighborRow, neighborCol);
            wq.union(nodeWqIdx, neighborWqIdx);
        }

        // right neighbor
        neighborCol = col + 1;
        if (isValidIndex(neighborRow, neighborCol)
                && grid[neighborRow][neighborCol] == openMarker) {
            neighborWqIdx = xyTo1D(neighborRow, neighborCol);
            wq.union(nodeWqIdx, neighborWqIdx);
        }

        // if node is in the top or bottom row, connect it to the
        // virtual top or bottom node
        if (row == 1) {
            wq.union(nodeWqIdx, 0);
        }

        if (row == n) {
            wq.union(nodeWqIdx, n * n + 1);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkValidIndex(row, col);
        return grid[row][col] == openMarker;
    }

    // A full site is an open site that can be connected to an open site
    // in the top row via a chain of neighboring
    // (left, right, up, down) open sites.
    public boolean isFull(int row, int col) {
        checkValidIndex(row,col);
        int nodeWqIdx = xyTo1D(row, col);
        return wq.find(nodeWqIdx) == wq.find(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numOpen;
    }

    // does the system percolate?
    public boolean percolates() {

        return wq.find(0) == wq.find(n * n + 1);
    }

    // test client (optional)
    public static void main(String[] args) {

        In in = new In(args[0]);      // input file
        int n = in.readInt();         // n-by-n percolation system
        boolean state;

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(n);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            state = perc.percolates();
        }

    }
}