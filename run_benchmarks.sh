#!/bin/bash
# Runs 5 iterations of each benchmark configuration and saves results
# to runs/Second Round/Standard/ and runs/Second Round/JIT Disabled/
#
# Usage: ./run_benchmarks.sh
# Run from the project root (same directory as build.gradle)

set -e

JAR="build/libs/benchmarks.jar"
STANDARD_DIR="runs/Second Round/Standard"
NOJIT_DIR="runs/Second Round/JIT Disabled"

# Ensure output directories exist
mkdir -p "$STANDARD_DIR"
mkdir -p "$NOJIT_DIR"

# Build the benchmark jar first
echo "Building benchmark jar..."
./gradlew jmhJar
echo "Build complete."
echo ""

# --- Standard (JIT enabled) ---
echo "===== Running Standard (JIT enabled) ====="
for i in 1 2 3 4 5; do
    echo "  Standard run $i of 5..."
    java -jar "$JAR" "DispatchBenchmark" \
        > "$STANDARD_DIR/run${i}.txt" 2>&1
    echo "  Saved to $STANDARD_DIR/run${i}.txt"
done
echo ""

# --- JIT Disabled (-Xint) ---
echo "===== Running JIT Disabled (-Xint) ====="
for i in 1 2 3 4 5; do
    echo "  NoJIT run $i of 5..."
    java -jar "$JAR" "DispatchBenchmarkNoJIT" \
        > "$NOJIT_DIR/run${i}.txt" 2>&1
    echo "  Saved to $NOJIT_DIR/run${i}.txt"
done
echo ""

echo "All runs complete."
echo "Results saved to:"
echo "  $STANDARD_DIR"
echo "  $NOJIT_DIR"
