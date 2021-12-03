#FROM openjdk:11
FROM openjdk:11-ea-11-jre-slim
LABEL maintainer="Ederson Ferreira <ederson.dev@gmail.com>"

ARG PATH_FILE_JAR
ARG NEW_NAME_FILE_JAR

ENV name_file_jar=$NEW_NAME_FILE_JAR

VOLUME /tmp

ADD $PATH_FILE_JAR $NEW_NAME_FILE_JAR

COPY docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh

ENTRYPOINT ["/docker-entrypoint.sh"]