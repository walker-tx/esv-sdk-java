FROM ubuntu:22.04

# Avoid interactive prompts during package installation
ENV DEBIAN_FRONTEND=noninteractive

# Install OpenJDK 11 and other dependencies
RUN apt-get update && \
    apt-get install -y --no-install-recommends bash curl git wget unzip  && \
    apt-get install -y openjdk-11-jdk && \
    rm -rf /var/lib/apt/lists/*

# Install Gradle 8.5
RUN wget https://services.gradle.org/distributions/gradle-8.5-bin.zip -P /tmp \
    && unzip -d /opt/gradle /tmp/gradle-8.5-bin.zip \
    && rm /tmp/gradle-8.5-bin.zip

# Set Gradle environment
ENV GRADLE_HOME=/opt/gradle/gradle-8.5
ENV PATH="$GRADLE_HOME/bin:$PATH"

# Set working directory
WORKDIR /app

# Copy the repository contents (from parent directory)
COPY ../ .

# Run gradle build
CMD ["gradle", "build", "--no-daemon"]
