
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Point implements Cloneable {
    private double x;
    private double y;

    public Point() {}
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point another){
        this.x = another.x;
        this.y = another.y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public Point clonePoint() {
        Point point = new Point();
        point.setX(this.x);
        point.setY(this.y);
        return point;
    } //manual cloning - shallow clone

    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    } //using Object.clone() + Cloneable interface

    private static<T> T cloneThroughSerialization(T t) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(t);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (T) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return t;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }



}
