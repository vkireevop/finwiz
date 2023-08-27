FROM maven:3.9.3-amazoncorretto-20 as builder

WORKDIR /app

COPY . /app/.

RUN mvn -f /app/pom.xml eclipse:clean package -D maven.test.skip=true 

FROM eclipse-temurin:20-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/*.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "/app/*.jar"]