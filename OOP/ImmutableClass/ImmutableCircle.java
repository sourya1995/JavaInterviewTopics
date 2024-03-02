package OOP.ImmutableClass;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

public final class ImmutableCircle {
    private final Point center;
    private final double radius;

    public ImmutableCircle(int x, int y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }
}
