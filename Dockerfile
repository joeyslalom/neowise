FROM adoptopenjdk:11-jdk-hotspot as builder
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"
WORKDIR work
COPY . ./
RUN ./gradlew bootJar

FROM adoptopenjdk:11-jre-hotspot as extractor
WORKDIR application
ARG JAR_FILE=work/build/libs/*.jar
COPY --from=builder ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=extractor application/dependencies/ ./
COPY --from=extractor application/spring-boot-loader/ ./
COPY --from=extractor application/snapshot-dependencies/ ./
COPY --from=extractor application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]