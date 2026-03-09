package com.benchmark;

// Static baseline class. No lookup, and no dynamic dispatch
public final class CircleStatic {
    public static double area(double radius) {
        return Math.PI * radius * radius;
    }
}
