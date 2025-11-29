# ---- build stage ----
FROM maven:3.10-jdk-17 AS build
WORKDIR /workspace

# copy chỉ phần cần thiết để maven cache dependencies
COPY pom.xml .
COPY zzz-start/pom.xml zzz-start/
# copy parent + module poms nếu multi-module: (nếu còn các module khác thay đổi, copy them too)
COPY zzz-application/pom.xml zzz-application/
COPY zzz-domain/pom.xml zzz-domain/
COPY zzz-infrastructure/pom.xml zzz-infrastructure/
COPY zzz-controller/pom.xml zzz-controller/

# download dependencies (speeds up layer caching)
RUN mvn -B -DskipTests=true -pl zzz-start -am dependency:go-offline

# copy full source
COPY . .

# build only the zzz-start module (skip tests for faster dev build)
RUN mvn -B -DskipTests=true -pl zzz-start -am package

# ---- runtime stage ----
FROM eclipse-temurin:17-jre
ARG JAR_FILE=/workspace/zzz-start/target/*.jar
# create app user
RUN addgroup --system app && adduser --system --ingroup app app
WORKDIR /app

# copy jar
COPY --from=build ${JAR_FILE} app.jar

# create directory for external configs (Spring Boot loads /config by default)
RUN mkdir -p /config

# run
USER app
ENTRYPOINT ["java","-jar","/app/app.jar"]
