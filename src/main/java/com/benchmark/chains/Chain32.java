package com.benchmark.chains;
import com.benchmark.Shape;

// Depth 32: Chain32 -> L31 -> ... -> L1 -> Shape
class Chain32Layer1  extends Shape          { @Override public double area() { return 0; } }
class Chain32Layer2  extends Chain32Layer1  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer3  extends Chain32Layer2  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer4  extends Chain32Layer3  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer5  extends Chain32Layer4  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer6  extends Chain32Layer5  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer7  extends Chain32Layer6  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer8  extends Chain32Layer7  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer9  extends Chain32Layer8  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer10 extends Chain32Layer9  { @Override public double area() { return super.area() + 0; } }
class Chain32Layer11 extends Chain32Layer10 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer12 extends Chain32Layer11 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer13 extends Chain32Layer12 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer14 extends Chain32Layer13 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer15 extends Chain32Layer14 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer16 extends Chain32Layer15 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer17 extends Chain32Layer16 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer18 extends Chain32Layer17 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer19 extends Chain32Layer18 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer20 extends Chain32Layer19 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer21 extends Chain32Layer20 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer22 extends Chain32Layer21 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer23 extends Chain32Layer22 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer24 extends Chain32Layer23 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer25 extends Chain32Layer24 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer26 extends Chain32Layer25 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer27 extends Chain32Layer26 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer28 extends Chain32Layer27 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer29 extends Chain32Layer28 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer30 extends Chain32Layer29 { @Override public double area() { return super.area() + 0; } }
class Chain32Layer31 extends Chain32Layer30 { @Override public double area() { return super.area() + 0; } }

public class Chain32 extends Chain32Layer31 {
    private final double radius;
    public Chain32(double radius) { this.radius = radius; }

    @Override
    public double area() { return super.area() + Math.PI * radius * radius; }
}