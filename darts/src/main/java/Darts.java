import java.awt.geom.Point2D;

class Darts {

    private final double x;
    private final double y;
    private final Point2D CENTER = new Point2D.Double(0, 0);

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        Point2D hit = new Point2D.Double(x, y);

        if (hit.distance(CENTER) > 10)
            return 0;
        else if (hit.distance(CENTER) > 5)
            return 1;
        else if (hit.distance(CENTER) > 1)
            return 5;
        else
            return 10;
    }

}
