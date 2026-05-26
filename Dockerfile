# Stage 1: build with sbt
FROM sbtscala/scala-sbt:eclipse-temurin-17.0.14_7_1.10.7_3.3.5 AS builder
WORKDIR /app
COPY build.sbt ./
COPY src ./src
RUN sbt stage

# Stage 2: lightweight runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/universal/stage /app
CMD ["./bin/pegasus-website"]