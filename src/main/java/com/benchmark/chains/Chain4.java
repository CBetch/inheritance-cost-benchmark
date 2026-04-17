package com.benchmark.chains;
import com.benchmark.Shape;

// Depth 4: Chain4 -> L3 -> L2 -> L1 -> Shape
class Chain4Layer1 extends Shape          { @Override public double area() { return 0; } }
class Chain4Layer2 extends Chain4Layer1   { @Override public double area() { return super.area() + 0; } }
class Chain4Layer3 extends Chain4Layer2   { @Override public double area() { return super.area() + 0; } }

public class Chain4 extends Chain4Layer3 {
    private final double radius;
    public Chain4(double radius) { this.radius = radius; }

    @Override
    public double area() { return super.area() + Math.PI * radius * radius; }
}