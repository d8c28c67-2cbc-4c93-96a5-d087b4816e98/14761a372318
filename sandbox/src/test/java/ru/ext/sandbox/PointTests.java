package ru.ext.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void test1()
    {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(6, 6);

        Assert.assertEquals(p1.distance(p2), 5*Math.sqrt(2));
    }

    @Test
    public void test2()
    {
        Point p1 = new Point();
        Point p2 = new Point(4, 3);

        Assert.assertEquals(p1.distance(p2), 5);
    }
}
