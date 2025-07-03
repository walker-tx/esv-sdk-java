FROM alpine:3.21

# Install OpenJDK 11 and other dependencies
RUN apk update
RUN apk add --update --no-cache bash curl git wget
RUN apk add --update --no-cache openjdk11

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
