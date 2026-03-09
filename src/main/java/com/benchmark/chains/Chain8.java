package com.benchmark.chains;
import com.benchmark.Shape;

// Depth 8: Chain8 -> L7 -> L6 -> L5 -> L4 -> L3 -> L2 -> L1 -> Shape
class Chain8Layer1 extends Shape { @Override public double area() { return 0; } }
class Chain8Layer2 extends Chain8Layer1 { @Override public double area() { return 0; } }
class Chain8Layer3 extends Chain8Layer2 { @Override public double area() { return 0; } }
class Chain8Layer4 extends Chain8Layer3 { @Override public double area() { return 0; } }
class Chain8Layer5 extends Chain8Layer4 { @Override public double area() { return 0; } }
class Chain8Layer6 extends Chain8Layer5 { @Override public double area() { return 0; } }
class Chain8Layer7 extends Chain8Layer6 { @Override public double area() { return 0; } }

public class Chain8 extends Chain8Layer7 {
    private final double radius;
    public Chain8(double radius) { this.radius = radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }
}