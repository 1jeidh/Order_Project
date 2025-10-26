# ====== BUILD STAGE ======
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Tạo thư mục làm việc
WORKDIR /app

# Copy toàn bộ project (chứ không chỉ module con)
COPY ../../ /app

# Build toàn bộ project
RUN mvn -f /app/pom.xml clean package -DskipTests

# ====== RUNTIME STAGE ======
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy jar của module order-container đã build
COPY --from=build /app/order-container/target/order-container-1.0.0.jar app.jar

EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]
