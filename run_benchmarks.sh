#!/bin/bash
# Runs 5 iterations of each of three benchmark configurations:
#   - Standard (full JIT)
#   - JIT Disabled (-Xint)
#   - Inlining Disabled (-XX:-Inline)
#
# Usage: ./run_benchmarks.sh
# Run from the project root (same directory as build.gradle)

set -e

JAR="build/libs/inheritance-cost-benchmark-1.0-jmh.jar"
STANDARD_DIR="runs/SuperChaining/Standard"
NOJIT_DIR="runs/SuperChaining/JIT Disabled"
NOINLINE_DIR="runs/SuperChaining/Inlining Disabled"

mkdir -p "$STANDARD_DIR"
mkdir -p "$NOJIT_DIR"
mkdir -p "$NOINLINE_DIR"

echo "Building benchmark jar..."
./gradlew jmhJar
echo "Build complete."
echo ""

# --- Standard (full JIT) ---
echo "===== Running Standard (JIT enabled) ====="
for i in 1 2 3 4 5; do
    echo "  Standard run $i of 5..."
    java -jar "$JAR" "DispatchBenchmark" 2>&1 | tee "$STANDARD_DIR/run${i}.txt"
    echo "  Saved to $STANDARD_DIR/run${i}.txt"
done
echo ""

# --- JIT Disabled (-Xint) ---
echo "===== Running JIT Disabled (-Xint) ====="
for i in 1 2 3 4 5; do
    echo "  JIT Disabled run $i of 5..."
    java -jar "$JAR" "DispatchBenchmarkNoJIT" 2>&1 | tee "$NOJIT_DIR/run${i}.txt"
    echo "  Saved to $NOJIT_DIR/run${i}.txt"
done
echo ""

# --- Inlining Disabled (-XX:-Inline) ---
echo "===== Running Inlining Disabled (-XX:-Inline) ====="
for i in 1 2 3 4 5; do
    echo "  Inlining Disabled run $i of 5..."
    java -jar "$JAR" "DispatchBenchmarkNoInline" 2>&1 | tee "$NOINLINE_DIR/run${i}.txt"
    echo "  Saved to $NOINLINE_DIR/run${i}.txt"
done
echo ""

echo "All runs complete."
echo "Results saved to:"
echo "  $STANDARD_DIR"
echo "  $NOJIT_DIR"
echo "  $NOINLINE_DIR"