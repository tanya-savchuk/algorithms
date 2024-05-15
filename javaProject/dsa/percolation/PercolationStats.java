import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {

    private double [] percTreshold;
    private int trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        int row;
        int col;
        int numOpen;
        this.trials = trials;
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("arguments must " +
                    "be greater than zero. Got n: " + n + " trials: " + trials);
        }
        percTreshold = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            numOpen = 0;
            // open sites at random until system percolates
            while (!perc.percolates()){
                row = StdRandom.uniformInt(n) + 1;
                col = StdRandom.uniformInt(n) + 1;
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                    numOpen = numOpen + 1;
                }
            }

            percTreshold[i] = 1.0*numOpen/n;
        }
        
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percTreshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percTreshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96*stddev()/Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96*stddev()/Math.sqrt(trials);
    }

    // test client (see below)
    public static void main(String[] args) {

        int n = StdIn.readInt();
        int trials = StdIn.readInt();

        PercolationStats pStats= new PercolationStats(n, trials);
        double percMean = pStats.mean();
        double percStddev = pStats.stddev();
        double percCILo = pStats.confidenceLo();
        double percCIHi = pStats.confidenceHi();

        System.out.println("mean                     = " + percMean);
        System.out.println("stdev                    = " + percStddev);
        System.out.println("95% confidence interval  = [" + percCILo + ", " + percCIHi + "]");

    }

}