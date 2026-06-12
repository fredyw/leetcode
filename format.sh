#!/bin/bash
set -e

# Resolve script directory to allow running it from anywhere
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Suppress JDK native access warnings in the Gradle client launcher
export GRADLE_OPTS="--enable-native-access=ALL-UNNAMED"

echo "Formatting Java and Kotlin..."
"$DIR/gradlew" -p "$DIR" spotlessApply

echo "Formatting Rust..."
cargo fmt --manifest-path "$DIR/src/main/rust/Cargo.toml"

echo "Formatting SQL..."
uvx sqlfluff format "$DIR/src/main/sql" --dialect postgres || true

echo "All code formatted successfully!"
