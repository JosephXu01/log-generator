# First stage: complete build environment
FROM maven:3.5.0-jdk-8-alpine AS builder
WORKDIR /app
COPY . /app
# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/
# package jar
#COPY settings.xml /usr/share/maven/conf/
RUN mvn package -Dmaven.test.skip=true

# Second stage: minimal runtime environment
FROM openjdk:8-jre-alpine
# copy jar from the first stage
COPY --from=builder /app/target/*.jar /app.jar
RUN echo "Asia/Shanghai" > /etc/timezone
# run jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]