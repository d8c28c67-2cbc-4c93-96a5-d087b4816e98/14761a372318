package ru.ext.sandbox;

public class Initial {
	public static void main(String args[]){
		//System.out.println("test message");

		Point p1 = new Point(1.0, 1.0);
		Point p2 = new Point(2.0, 2.0);

		System.out.println("distance1 = " + distance(p1,p2));
		System.out.println("distance2 = " + Point.distanceEx(p1,p2));
		System.out.println("distance3 = " + p1.distance(p2));
	}

	public static double distance(Point p1, Point p2)
	{
		return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y-p2.y), 2));
	}
}