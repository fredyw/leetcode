#!/bin/bash

set -ueo pipefail

./gradlew spotlessApply
cargo fmt --manifest-path src/main/rust/Cargo.toml
