FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/universal/stage /app
CMD ["./bin/zio-http-render"]