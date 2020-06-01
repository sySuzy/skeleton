import edu.princeton.cs.algs4.Picture;

import java.awt.*;

public class SeamCarver {
    private Picture picture;
    private int width;
    private int height;

    public SeamCarver(Picture picture) {
        this.picture = picture;
        this.width = picture.width();
        this.height = picture.height();
    }

    public Picture picture()  {
        // current picture
        return this.picture;
    }

    public int width() {
        // width of current picture
        return this.width;
    }

    public int height() {
        // height of current picture
        return this.height;
    }

    private int upperY(int y) {
        if (y + 1 >= height) {
            return 0;
        }
        return y + 1;
    }

    private int bottomY(int y) {
        if (y - 1 < 0) {
            return height - 1;
        }
        return y - 1;
    }

    private int leftX(int x) {
        if (x - 1 < 0) {
            return width - 1;
        }
        return x - 1;
    }

    private int rightX(int x) {
        if (x + 1 >= width) {
            return 0;
        }
        return x + 1;
    }

    private double xGradientSq(int x, int y) {
        int xLeft = leftX(x);
        int xRight = rightX(x);
        Color colorLeft = picture.get(xLeft, y);
        Color colorRight = picture.get(xRight, y);
        return Math.pow(colorRight.getRed() - colorLeft.getRed(), 2) +
                Math.pow(colorRight.getGreen() - colorLeft.getGreen(), 2) +
                Math.pow(colorRight.getBlue() - colorLeft.getBlue(), 2);
    }

    private double yGradientsSq(int x, int y) {
        int yBottom = bottomY(y);
        int yUpper = upperY(y);
        Color colorBottom = picture.get(x, yBottom);
        Color colorUpper = picture.get(x, yUpper);
        return Math.pow(colorUpper.getRed() - colorBottom.getRed(), 2) +
                Math.pow(colorUpper.getGreen() - colorBottom.getGreen(), 2) +
                Math.pow(colorUpper.getBlue() - colorBottom.getBlue(), 2);
    }

    public double energy(int x, int y) {
        // energy of pixel at column x and row y
        return xGradientSq(x, y) + yGradientsSq(x, y);
    }

    private int minXOfEnergy(int[] X, int y) {
        int minIndex = -1;
        double minValue = Double.MAX_VALUE;

        for (int x : X) {
            if (energy(x, y) < minValue) {
                minIndex = x;
                minValue = energy(x, y);
            }
        }
        return minIndex;
    }

    public int[] findVerticalSeam() {
        // sequence of indices for vertical seam
        int[] delCols = new int[height];
        double[][] distTo = new double[width][height];
        int[][] edgeTo = new int[width][height];
        for (int x = 0; x < width; x++) {
            distTo[x][0] = energy(x, 0);
            edgeTo[x][0] = -1;
        }

        
        for (int y = 1; y < height; y++) {
            int index = minXOfEnergy(new int[]{0, 1}, y - 1);
            edgeTo[0][y] = index;
            distTo[0][y] = energy(0, y) + distTo[index][0];
            for (int x = 1; x < width-1; x++) {
                index = minXOfEnergy(new int[]{x-1, x, x+1}, y - 1);
                edgeTo[x][y] = index;
                distTo[x][y] = energy(x, y) + distTo[index][y-1];
            }
            index = minXOfEnergy(new int[]{width-2, width-1}, y - 1);
            edgeTo[width-1][y] = index;
            distTo[width-1][y] = energy(width-1, y) + distTo[index][y - 1];
        }

        int minIndex = 0;
        double minValue = Double.MAX_VALUE;
        for (int i = 0; i < width; i++) {
            if (distTo[i][height - 1] < minValue) {
                minValue = distTo[i][height - 1];
                minIndex = i;
            }
        }

        delCols[height - 1] = minIndex;
        int t = minIndex;
        for (int i = height - 2; i >= 0; i--) {
            delCols[i] = edgeTo[t][i+1];
            t = edgeTo[t][i+1];
        }
        return delCols;
    }

    private Picture transpose(Picture p) {
        int width = p.width();
        int height = p.height();
        Picture q = new Picture(height, width);
        for (int i = 0; i < q.width(); i++) {
            for (int j = 0; j < q.height(); j++) {
                q.setRGB(i, j, p.getRGB(j, i));
            }
        }
        return q;
    }

    private void changePicture(Picture p) {
        this.picture = p;
        this.width = p.width();
        this.height = p.height();
    }

    public   int[] findHorizontalSeam() {
        // sequence of indices for horizontal seam
        Picture orgPic = picture;
        Picture tmpPic = transpose(orgPic);
        changePicture(tmpPic);
        int[] delRows = findVerticalSeam();
        changePicture(orgPic);
        return delRows;
    }

    public void removeHorizontalSeam(int[] seam) {
        // remove horizontal seam from picture
        Picture newPic = SeamRemover.removeHorizontalSeam(this.picture, seam);
        changePicture(newPic);
    }
    public    void removeVerticalSeam(int[] seam) {
        // remove vertical seam from picture
        Picture newPic = SeamRemover.removeVerticalSeam(this.picture, seam);
        changePicture(newPic);
    }
}

