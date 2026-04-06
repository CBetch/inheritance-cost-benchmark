package com.benchmark.chains;
import com.benchmark.Shape;

// Depth 64: Chain64 -> L63 -> ... -> L1 -> Shape
class Chain64Layer1  extends Shape { @Override public double area() { return 0; } }
class Chain64Layer2 extends Chain64Layer1 { @Override public double area() { return 0; } }
class Chain64Layer3 extends Chain64Layer2 { @Override public double area() { return 0; } }
class Chain64Layer4 extends Chain64Layer3 { @Override public double area() { return 0; } }
class Chain64Layer5 extends Chain64Layer4 { @Override public double area() { return 0; } }
class Chain64Layer6 extends Chain64Layer5 { @Override public double area() { return 0; } }
class Chain64Layer7 extends Chain64Layer6 { @Override public double area() { return 0; } }
class Chain64Layer8 extends Chain64Layer7 { @Override public double area() { return 0; } }
class Chain64Layer9 extends Chain64Layer8 { @Override public double area() { return 0; } }
class Chain64Layer10 extends Chain64Layer9 { @Override public double area() { return 0; } }
class Chain64Layer11 extends Chain64Layer10 { @Override public double area() { return 0; } }
class Chain64Layer12 extends Chain64Layer11 { @Override public double area() { return 0; } }
class Chain64Layer13 extends Chain64Layer12 { @Override public double area() { return 0; } }
class Chain64Layer14 extends Chain64Layer13 { @Override public double area() { return 0; } }
class Chain64Layer15 extends Chain64Layer14 { @Override public double area() { return 0; } }
class Chain64Layer16 extends Chain64Layer15 { @Override public double area() { return 0; } }
class Chain64Layer17 extends Chain64Layer16 { @Override public double area() { return 0; } }
class Chain64Layer18 extends Chain64Layer17 { @Override public double area() { return 0; } }
class Chain64Layer19 extends Chain64Layer18 { @Override public double area() { return 0; } }
class Chain64Layer20 extends Chain64Layer19 { @Override public double area() { return 0; } }
class Chain64Layer21 extends Chain64Layer20 { @Override public double area() { return 0; } }
class Chain64Layer22 extends Chain64Layer21 { @Override public double area() { return 0; } }
class Chain64Layer23 extends Chain64Layer22 { @Override public double area() { return 0; } }
class Chain64Layer24 extends Chain64Layer23 { @Override public double area() { return 0; } }
class Chain64Layer25 extends Chain64Layer24 { @Override public double area() { return 0; } }
class Chain64Layer26 extends Chain64Layer25 { @Override public double area() { return 0; } }
class Chain64Layer27 extends Chain64Layer26 { @Override public double area() { return 0; } }
class Chain64Layer28 extends Chain64Layer27 { @Override public double area() { return 0; } }
class Chain64Layer29 extends Chain64Layer28 { @Override public double area() { return 0; } }
class Chain64Layer30 extends Chain64Layer29 { @Override public double area() { return 0; } }
class Chain64Layer31 extends Chain64Layer30 { @Override public double area() { return 0; } }
class Chain64Layer32 extends Chain64Layer31 { @Override public double area() { return 0; } }
class Chain64Layer33 extends Chain64Layer32 { @Override public double area() { return 0; } }
class Chain64Layer34 extends Chain64Layer33 { @Override public double area() { return 0; } }
class Chain64Layer35 extends Chain64Layer34 { @Override public double area() { return 0; } }
class Chain64Layer36 extends Chain64Layer35 { @Override public double area() { return 0; } }
class Chain64Layer37 extends Chain64Layer36 { @Override public double area() { return 0; } }
class Chain64Layer38 extends Chain64Layer37 { @Override public double area() { return 0; } }
class Chain64Layer39 extends Chain64Layer38 { @Override public double area() { return 0; } }
class Chain64Layer40 extends Chain64Layer39 { @Override public double area() { return 0; } }
class Chain64Layer41 extends Chain64Layer40 { @Override public double area() { return 0; } }
class Chain64Layer42 extends Chain64Layer41 { @Override public double area() { return 0; } }
class Chain64Layer43 extends Chain64Layer42 { @Override public double area() { return 0; } }
class Chain64Layer44 extends Chain64Layer43 { @Override public double area() { return 0; } }
class Chain64Layer45 extends Chain64Layer44 { @Override public double area() { return 0; } }
class Chain64Layer46 extends Chain64Layer45 { @Override public double area() { return 0; } }
class Chain64Layer47 extends Chain64Layer46 { @Override public double area() { return 0; } }
class Chain64Layer48 extends Chain64Layer47 { @Override public double area() { return 0; } }
class Chain64Layer49 extends Chain64Layer48 { @Override public double area() { return 0; } }
class Chain64Layer50 extends Chain64Layer49 { @Override public double area() { return 0; } }
class Chain64Layer51 extends Chain64Layer50 { @Override public double area() { return 0; } }
class Chain64Layer52 extends Chain64Layer51 { @Override public double area() { return 0; } }
class Chain64Layer53 extends Chain64Layer52 { @Override public double area() { return 0; } }
class Chain64Layer54 extends Chain64Layer53 { @Override public double area() { return 0; } }
class Chain64Layer55 extends Chain64Layer54 { @Override public double area() { return 0; } }
class Chain64Layer56 extends Chain64Layer55 { @Override public double area() { return 0; } }
class Chain64Layer57 extends Chain64Layer56 { @Override public double area() { return 0; } }
class Chain64Layer58 extends Chain64Layer57 { @Override public double area() { return 0; } }
class Chain64Layer59 extends Chain64Layer58 { @Override public double area() { return 0; } }
class Chain64Layer60 extends Chain64Layer59 { @Override public double area() { return 0; } }
class Chain64Layer61 extends Chain64Layer60 { @Override public double area() { return 0; } }
class Chain64Layer62 extends Chain64Layer61 { @Override public double area() { return 0; } }
class Chain64Layer63 extends Chain64Layer62 { @Override public double area() { return 0; } }

public class Chain64 extends Chain64Layer63 {
    private final double radius;
    public Chain64(double radius) { this.radius = radius; }

    @Override
    public double area() { return Math.PI * radius * radius; }
}
