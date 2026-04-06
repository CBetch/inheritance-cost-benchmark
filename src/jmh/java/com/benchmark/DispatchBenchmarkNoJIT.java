package com.benchmark;

import com.benchmark.chains.Chain2;
import com.benchmark.chains.Chain4;
import com.benchmark.chains.Chain8;
import com.benchmark.chains.Chain16;
import com.benchmark.chains.Chain32;
import com.benchmark.chains.Chain64;
import com.benchmark.chains.Chain128;
import com.benchmark.chains.Chain256;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/*
 * Benchmarks comparing:
 *   1. Static method call (no dispatch)
 *   2. Single-level dynamic dispatch (monomorphic)
 *   3. Inheritance chain depth: 2, 4, 8, 16, 32 levels
 *
 * Run in two forks:
 *   - Default: HotSpot C2 with JIT enabled (standard production behavior)
 *   - NoJIT:   Interpreted-only mode (-Xint), disabling all JIT compilation
 *              so every virtual call goes through the vtable at runtime
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(
    value = 1,
    jvmArgsPrepend = {"-Xint"}   // Disable all JIT — interpreted-only mode
)
public class DispatchBenchmarkNoJIT {

    private static final double RADIUS = 5.0;

    private Shape mono;
    private Shape chain2;
    private Shape chain4;
    private Shape chain8;
    private Shape chain16;
    private Shape chain32;
    private Shape chain64;
    private Shape chain128;
    private Shape chain256;

    @Setup
    public void setup() {
        mono    = new Circle(RADIUS);
        chain2  = new Chain2(RADIUS);
        chain4  = new Chain4(RADIUS);
        chain8  = new Chain8(RADIUS);
        chain16 = new Chain16(RADIUS);
        chain32 = new Chain32(RADIUS);
        chain64  = new Chain64(RADIUS);
        chain128 = new Chain128(RADIUS);
        chain256 = new Chain256(RADIUS);
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

    @Benchmark
    public void chainDepth16(Blackhole bh) {
        bh.consume(chain16.area());
    }

    @Benchmark
    public void chainDepth32(Blackhole bh) {
        bh.consume(chain32.area());
    }

    @Benchmark
    public void chainDepth64(Blackhole bh) {
        bh.consume(chain64.area());
    }

    @Benchmark
    public void chainDepth128(Blackhole bh) {
        bh.consume(chain128.area());
    }

    @Benchmark
    public void chainDepth256(Blackhole bh) {
        bh.consume(chain256.area());
    }
}