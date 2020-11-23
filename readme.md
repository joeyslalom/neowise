# Neowise

Spring Boot project
GKE

# Steps

1. [start.spring.io](https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.3.2.RELEASE&packaging=jar&jvmVersion=11&groupId=com.slalom&artifactId=neowise&name=neowise&description=Demo%20project%20for%20Spring%20Boot&packageName=com.slalom.neowise&dependencies=web,actuator,cloud-gcp)
    * [Git Info](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/html/howto.html#howto-git-info)
    * [Build Info](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/gradle-plugin/reference/html/#integrating-with-actuator-build-info)
    * [Layered Jars](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/gradle-plugin/reference/html/#packaging-layered-jars)
    * [Dockerfile](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#writing-the-dockerfile)
2.  Update Spring Boot app for GKE
    * By default, use [GCP Logging](https://cloud.spring.io/spring-cloud-static/spring-cloud-gcp/1.2.3.RELEASE/reference/html/#stackdriver-logging), which outputs [Structured JSON logs](https://cloud.google.com/logging/docs/structured-logging).
        * Use the `local` Spring Boot Profile to have normal log output, e.g., `SPRING_PROFILES_ACTIVE=local ./gradlew bootRun`
    * Enable graceful shutdown and liveness/readiness probes in [Spring Boot 2.3](https://spring.io/blog/2020/03/25/liveness-and-readiness-probes-with-spring-boot)

