package ru.ext.sandbox;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    public double distance(Point p2)
    {
        Point p1 = this;

        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y-p2.y), 2));
    }

    public static double distanceEx(Point p1, Point p2)
    {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y-p2.y), 2));
    }
}
