# The Cost of Inheritance — JMH Benchmark Suite

Benchmarks the runtime overhead of dynamic dispatch in Java, comparing:
- Static method calls (zero dispatch)
- Single-level dynamic dispatch invoked through a superclass reference
- Inheritance chain depth: 2, 4, 8 levels

## Dependencies

- Java 21+
- Gradle (wrapper included — no install needed)

## Build

```bash
./gradlew build
```

## Run All Benchmarks

```bash
./gradlew clean jmh
```

Results are saved to `build/results/jmh-results.csv`.

## Expected Output

JMH prints a table like:

```
Benchmark                              Mode  Cnt  Score   Error  Units
DispatchBenchmark.staticCall           avgt   20  1.791 ± 0.029  ns/op
DispatchBenchmark.dispatch1Layer_mono  avgt   20  3.076 ± 0.030  ns/op
DispatchBenchmark.chainDepth2          avgt   20  3.230 ± 0.079  ns/op
DispatchBenchmark.chainDepth4          avgt   20  3.139 ± 0.043  ns/op
DispatchBenchmark.chainDepth8          avgt   20  3.107 ± 0.026  ns/op
```

## Key Design Notes

**Blackhole**: JMH's `Blackhole.consume()` prevents dead-code elimination — without
it the JIT could remove the entire computation since results are unused.

**Superclass reference**: All dynamic dispatch benchmarks invoke `area()` through a
`Shape` reference, forcing runtime vtable lookup rather than a compile-time static call.

**Chain depth**: Each `ChainN` class has N-1 intermediate classes, all overriding
`area()`. This tests whether vtable lookup cost grows with chain depth (it does not
in HotSpot — the dispatch mechanism itself is the bottleneck, not the depth).

## Project Structure

```
src/
  main/java/com/benchmark/
    Shape.java            # abstract base class
    Circle.java           # 1-layer concrete subclass
    CircleStatic.java     # final class, static method (baseline)
    chains/
      Chain2.java         # 2-level inheritance chain
      Chain4.java         # 4-level inheritance chain
      Chain8.java         # 8-level inheritance chain
  jmh/java/com/benchmark/
    DispatchBenchmark.java  # all JMH benchmarks
```

## Experimentation

Experimentation was run in a controlled environment, showcased in the `/runs` folder.

### Environment

| Property | Value |
|---|---|
| **Cloud** | AWS EC2 |
| **Instance Type** | m7i-flex.large |
| **OS** | Ubuntu 24.04.3 LTS (Noble Numbat) |
| **Kernel** | 6.14.0-1018-aws |
| **CPU** | Intel Xeon Platinum 8488C |
| **Cores** | 1 core, 2 threads (hyperthreaded) |
| **Hypervisor** | KVM (full virtualization) |
| **RAM** | 7.6 GiB |
| **JVM** | OpenJDK 21.0.10 (mixed mode) |
| **Build Tool** | Gradle |
| **Benchmark Harness** | JMH |
| **Warmup** | 3 × 1s iterations |
| **Measurement** | 100 × 1s iterations |
| **Fork** | 1 |
| **Benchmark Mode** | AverageTime (ns/op) |

> Note: Results were collected on a shared KVM virtual machine. Absolute nanosecond values may reflect hypervisor noise; relative comparisons between dispatch depths demonstrate stable computation variance
and repeated trials demonstrate reliable results.