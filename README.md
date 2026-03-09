# The Cost of Inheritance — JMH Benchmark Suite

Benchmarks the runtime overhead of dynamic dispatch in Java, comparing:
- Static method calls (zero dispatch)
- Monomorphic dispatch (single concrete type — JIT may devirtualize)
- Megamorphic dispatch (3+ types at one call site — true vtable overhead)
- Inheritance chain depth: 1, 2, 4, 8 levels

## Dependencies

- Java 21+
- Gradle (wrapper included — no install needed)

## Build

```bash
./gradlew build
```

## Run All Benchmarks

```bash
./gradlew jmh
```

Results are saved to `build/results/jmh-results.csv`.

## Run a Specific Benchmark

```bash
./gradlew jmh --jmh-include="staticCall"
./gradlew jmh --jmh-include="dispatch"
./gradlew jmh --jmh-include="chain"
```

## Expected Output

JMH prints a table like:

```
Benchmark                         Mode  Cnt   Score   Error  Units
DispatchBenchmark.staticCall      avgt    5   1.234 ± 0.010  ns/op
DispatchBenchmark.dispatch1Layer_mono  avgt  5  1.245 ± 0.012  ns/op
DispatchBenchmark.dispatch1Layer_mega  avgt  5  3.891 ± 0.034  ns/op
DispatchBenchmark.chainDepth2     avgt    5   3.902 ± 0.028  ns/op
DispatchBenchmark.chainDepth4     avgt    5   3.918 ± 0.031  ns/op
DispatchBenchmark.chainDepth8     avgt    5   3.924 ± 0.029  ns/op
```

## Key Design Notes

**Megamorphic call sites**: The `dispatch1Layer_mega` benchmark mixes 3 concrete
types at the same call site. This defeats the JVM's devirtualization optimization
and forces true vtable lookup. Compare this to `dispatch1Layer_mono` where the JIT
may inline the call entirely.

**Blackhole**: JMH's `Blackhole.consume()` prevents dead-code elimination — without
it the JIT could remove the entire computation since results are unused.

**Chain depth**: Each `ChainN` class has N-1 intermediate classes, all overriding
`area()`. This tests whether vtable lookup cost grows with chain depth (it generally
does not in HotSpot, but confirms that the dispatch itself is the bottleneck).

## Project Structure

```
src/
  main/java/com/benchmark/
    Shape.java          # abstract base class
    Circle1.java        # 1-layer concrete subclass
    CircleStatic.java   # final class, static method (baseline)
    chains/
      Chain2.java       # 2-level inheritance chain
      Chain4.java       # 4-level inheritance chain
      Chain8.java       # 8-level inheritance chain
  jmh/java/com/benchmark/
    DispatchBenchmark.java  # all JMH benchmarks
```
