FROM amazoncorretto:21-alpine

# Debug port
EXPOSE 8010
# Server port
EXPOSE 8080

COPY --chown=appuser:appuser ./docker/entrypoint.sh /home/appuser/bin/
COPY ./target /app
WORKDIR /app
ENTRYPOINT ["bash", "/home/appuser/bin/entrypoint.sh"]