#!/bin/bash

BEARER_TOKEN_DIRECTORY="/home/ldavidso/tmp"
BEARER_TOKEN_FILE_NAME="bearer.txt"
BEARER_TOKEN_FILE_PATH="${BEARER_TOKEN_DIRECTORY}/${BEARER_TOKEN_FILE_NAME}"
mkdir -p $BEARER_TOKEN_DIRECTORY
touch $BEARER_TOKEN_FILE_PATH

source /home/ldavidso/.bashrc && \
    source /home/ldavidso/workspace/weather-platform/scripts/generate-jwt.sh > $BEARER_TOKEN_FILE_PATH && \
    docker cp $BEARER_TOKEN_FILE_PATH prometheus:/etc/prometheus/bearer.txt


