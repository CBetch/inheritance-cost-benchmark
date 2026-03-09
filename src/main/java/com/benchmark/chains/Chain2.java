package com.benchmark.chains;
import com.benchmark.Shape;

// Depth 2: Chain2 -> L1 -> Shape
class Chain2Layer1 extends Shape { @Override public double area() { return 0; } }

public class Chain2 extends Chain2Layer1 {
    private final double radius;
    public Chain2(double radius) { this.radius = radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }
}