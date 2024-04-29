package DesignPatterns.Flyweight;

public class Circle implements Shape {

    private String color;
    private int d;
    private int radius;
    private int c;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int c) {
        this.c = c;
    }

    public void setY(int d) {
        this.y = d;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : "
                + color + ", c : " + c + ", d :" + d + ", radius :"
                + radius);
    }

}
