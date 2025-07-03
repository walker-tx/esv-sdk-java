#!/bin/bash

# Script to test Gradle build in different OS containers
set -e

# Check if OS argument is provided
if [ $# -eq 0 ]; then
    echo "Usage: $0 [alpine|ubuntu]"
    echo "  alpine - Test with Alpine 3.21"
    echo "  ubuntu - Test with Ubuntu 22.04"
    exit 1
fi

OS_TYPE="$1"

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# Configuration based on OS type
case "$OS_TYPE" in
    "alpine")
        DOCKERFILE="$SCRIPT_DIR/alpine.dockerfile"
        IMAGE_NAME="alpine-gradle-test"
        CONTAINER_NAME="gradle-build-test-alpine"
        OS_DESCRIPTION="Alpine 3.21"
        ;;
    "ubuntu")
        DOCKERFILE="$SCRIPT_DIR/ubuntu.dockerfile"
        IMAGE_NAME="ubuntu-gradle-test"
        CONTAINER_NAME="gradle-build-test-ubuntu"
        OS_DESCRIPTION="Ubuntu 22.04"
        ;;
    *)
        echo "❌ Error: Unsupported OS type '$OS_TYPE'"
        echo "Supported options: alpine, ubuntu"
        exit 1
        ;;
esac

# Start timing
START_TIME=$(date +%s)

echo "🐳 Building Docker image with $OS_DESCRIPTION, OpenJDK 11, and Gradle 8.5..."
docker build -f "$DOCKERFILE" -t "$IMAGE_NAME" "$SCRIPT_DIR/.."

# Get image size
IMAGE_SIZE=$(docker images "$IMAGE_NAME" --format "{{.Size}}")
echo "📦 Image size: $IMAGE_SIZE"

echo "🚀 Running gradle build in container..."
if docker run --name "$CONTAINER_NAME" "$IMAGE_NAME"; then
    echo "✅ Build completed successfully!"
    BUILD_SUCCESS=true
else
    echo "❌ Build failed!"
    BUILD_SUCCESS=false
fi

# Calculate total time
END_TIME=$(date +%s)
TOTAL_TIME=$((END_TIME - START_TIME))
MINUTES=$((TOTAL_TIME / 60))
SECONDS=$((TOTAL_TIME % 60))

echo "⏱️  Total test time: ${MINUTES}m ${SECONDS}s"

echo "🧹 Cleaning up container..."
docker rm "$CONTAINER_NAME" 2>/dev/null || true

echo "🧹 Cleaning up image..."
docker rmi "$IMAGE_NAME" 2>/dev/null || true

if [ "$BUILD_SUCCESS" = true ]; then
    echo "🎉 $OS_DESCRIPTION compatibility test passed!"
    exit 0
else
    echo "💥 $OS_DESCRIPTION compatibility test failed!"
    exit 1
fi
