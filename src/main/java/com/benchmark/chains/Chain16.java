package com.benchmark.chains;
import com.benchmark.Shape;

// Depth 16: Chain16 -> L15 -> ... -> L1 -> Shape
class Chain16Layer1  extends Shape          { @Override public double area() { return 0; } }
class Chain16Layer2  extends Chain16Layer1  { @Override public double area() { return 0; } }
class Chain16Layer3  extends Chain16Layer2  { @Override public double area() { return 0; } }
class Chain16Layer4  extends Chain16Layer3  { @Override public double area() { return 0; } }
class Chain16Layer5  extends Chain16Layer4  { @Override public double area() { return 0; } }
class Chain16Layer6  extends Chain16Layer5  { @Override public double area() { return 0; } }
class Chain16Layer7  extends Chain16Layer6  { @Override public double area() { return 0; } }
class Chain16Layer8  extends Chain16Layer7  { @Override public double area() { return 0; } }
class Chain16Layer9  extends Chain16Layer8  { @Override public double area() { return 0; } }
class Chain16Layer10 extends Chain16Layer9  { @Override public double area() { return 0; } }
class Chain16Layer11 extends Chain16Layer10 { @Override public double area() { return 0; } }
class Chain16Layer12 extends Chain16Layer11 { @Override public double area() { return 0; } }
class Chain16Layer13 extends Chain16Layer12 { @Override public double area() { return 0; } }
class Chain16Layer14 extends Chain16Layer13 { @Override public double area() { return 0; } }
class Chain16Layer15 extends Chain16Layer14 { @Override public double area() { return 0; } }

public class Chain16 extends Chain16Layer15 {
    private final double radius;
    public Chain16(double radius) { this.radius = radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }
}
