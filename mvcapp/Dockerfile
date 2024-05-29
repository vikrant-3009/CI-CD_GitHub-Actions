FROM tomcat:8.5-jdk17-corretto

ARG ARTIFACTORY_USERNAME
ARG ARTIFACTORY_PASSWORD
ARG ARTIFACTORY_URL

RUN curl -u "${ARTIFACTORY_USERNAME}:${ARTIFACTORY_PASSWORD}" \
    -o /usr/local/tomcat/webapps/mvcapp.war \
    "${ARTIFACTORY_URL}/calculator-app/dev/mvcapp.war"