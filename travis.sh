#!/bin/bash

set -e

./gradlew build
cd src/test/e2e-test-gradle
./gradlew build
