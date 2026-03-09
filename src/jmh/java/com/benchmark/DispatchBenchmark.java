package com.benchmark;

import com.benchmark.chains.Chain2;
import com.benchmark.chains.Chain4;
import com.benchmark.chains.Chain8;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/*
 * Benchmarks comparing:
 *   1. Static method call (no dispatch)
 *   2. Single-level dynamic dispatch (monomorphic)
 *   3. Inheritance chain depth: 2, 4, 8 levels
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 25, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class DispatchBenchmark {

    private static final double RADIUS = 5.0;

    private Shape mono;
    private Shape chain2;
    private Shape chain4;
    private Shape chain8;

    @Setup
    public void setup() {
        mono   = new Circle(RADIUS);
        chain2 = new Chain2(RADIUS);
        chain4 = new Chain4(RADIUS);
        chain8 = new Chain8(RADIUS);
    }

    // 1. Baseline: static call, no dispatch
    @Benchmark
    public void staticCall(Blackhole bh) {
        bh.consume(CircleStatic.area(RADIUS));
    }

    // 2. Single-level dynamic dispatch invoked through superclass reference
    @Benchmark
    public void dispatch1Layer_mono(Blackhole bh) {
        bh.consume(mono.area());
    }

    // 3. Chain depth comparison — all invoked through superclass reference
    @Benchmark
    public void chainDepth2(Blackhole bh) {
        bh.consume(chain2.area());
    }

    @Benchmark
    public void chainDepth4(Blackhole bh) {
        bh.consume(chain4.area());
    }

    @Benchmark
    public void chainDepth8(Blackhole bh) {
        bh.consume(chain8.area());
    }
}