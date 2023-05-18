FROM eclipse-temurin:11
LABEL maintainer="Team Dev Comunidad Digital Comercial"
LABEL dominio="DOMAINWS"
RUN JAVA_HOME=/opt/java/openjdk

EXPOSE ${PORT}

COPY /target/ahl-ms-detalle-periodo-hl-java-1.0-SNAPSHOT.jar /opt/app
CMD ["java","-jar","/opt/app/ahl-ms-detalle-periodo-hl-java-1.0-SNAPSHOT.jar"]