package FinalProjectCode_BradleyPelton.Utility;

/**
 * Basic "POJO" to represent a (x,y) coordinate
 */
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

    /**
     * Move the direction represented by the vector
     * int[] direction (e.g. int[] direction = {0,1})
     */
    public void moveDirection(int[] direction) {
        i += direction[0];
        j += direction[1];
    }

    /**
     * Undo the move direction by inverting the direction
     */
    public void undoMoveDirection(int[] direction) {
        i -= direction[0];
        j -= direction[1];
    }

    @Override
    public String toString() {
        return "[" + i + "," + j + "]";
    }
}
