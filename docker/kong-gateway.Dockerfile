FROM kong:3.7.1

USER 0
RUN mkdir -p /kong/declarative/
COPY kong.yml /kong/declarative/kong-with-vars.yml
COPY --chown=kong:kong kong.yml /kong/declarative/
RUN cp /etc/kong/kong.conf.default /etc/kong/kong.conf

RUN apt update \
    && apt upgrade -y \
    && apt install gettext -y \
    && apt install bash -y \
    && apt install iputils-ping -y \
    && apt install curl -y
USER kong

COPY --chown=kong:kong ./docker/entrypoint-kong.sh /home/appuser/bin/
ENTRYPOINT ["bash", "/home/appuser/bin/entrypoint-kong.sh"]
CMD ["kong", "docker-start"]