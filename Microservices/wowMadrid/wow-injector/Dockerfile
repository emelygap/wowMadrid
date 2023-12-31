FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean install -DskipTests


FROM openjdk:17-alpine AS deploy
EXPOSE 8080
VOLUME ["/opt/wow-injector"]

RUN addgroup -S spring && adduser -S spring -G spring
RUN apk update && apk add --no-cache snappy

USER spring
COPY --from=builder /app/target/wow-injector*.jar /opt/wow-injector/app.jar

CMD ["java", "-jar", \
 "-Dorg.xerial.snappy.use.systemlib=true",\
 "-Dorg.xerial.snappy.lib.path=/usr/lib/libsnappyjava.so",\
 "--add-opens=java.base/java.nio=ALL-UNNAMED",\
 "--add-opens=java.base/sun.nio.ch=ALL-UNNAMED",\
 "--add-opens=java.base/sun.nio.cs=ALL-UNNAMED",\
 "/opt/wow-injector/app.jar"\
]