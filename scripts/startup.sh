#!/bin/bash

source /home/ldavidso/.bashrc && \
    cd /home/ldavidso/workspace/weather-platform/ && \
    docker compose --profile gateway --profile service up