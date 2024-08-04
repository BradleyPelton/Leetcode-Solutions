package COMPSCIX404.FinalProject.Utility;

public class Point {
    public int i;
    public int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public Point(Point otherPoint) {
        this.i = otherPoint.i;
        this.j = otherPoint.j; // COPY CONSTRUCTOR
    }

    public void moveDirection(int[] direction) {
        i += direction[0];
        j += direction[1];
    }

    public void undoMoveDirection(int[] direction) {
        i -= direction[0];
        j -= direction[1];
    }

    @Override
    public String toString() {
        return "[" + i + "," + j + "]";
    }
}
