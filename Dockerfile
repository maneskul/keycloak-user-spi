## Build provider
FROM maven:3.6.3-jdk-8 AS provider-rest
ENV MAVEN_CONFIG /var/maven/.m2
WORKDIR /project
COPY . .
RUN mvn -Duser.home=/var/maven clean package

## Keycloak

FROM jboss/keycloak:8.0.1
COPY --from=provider-rest /project/target/ /opt/jboss/keycloak/standalone/deployments/
COPY --from=provider-rest /project/cli/ /opt/jboss/startup-scripts/

ENTRYPOINT [ "/opt/jboss/tools/docker-entrypoint.sh" ]
CMD ["-b", "0.0.0.0"]