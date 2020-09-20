#!/bin/bash
# Script to control docker operations
# Options - create to create and first run mongo bionic container
# start / stop to control operations of the container
command=$1
echo "Command chosen $command"
if [[ "$1" == "create" ]]; then
    echo "docker pull mongo:bionic" && \
    echo "docker run -d -v ~/data:/data/db --name mongodb-server -p 27017:27017 mongo:bionic" && \
    docker pull mongo:bionic && \
    docker run -d -e MONGO_INITDB_ROOT_USERNAME=admin \
      -e MONGO_INITDB_ROOT_PASSWORD=admin \
      --name mongodb-server -p 27017:27017 mongo:bionic
elif  [[ "$1" == "start" ]]; then
    echo "docker start mongodb-server" && \
    docker start mongodb-server
elif [[ "$1" == "stop" ]]; then
    echo "docker stop mongodb-server" && \
    docker stop mongodb-server
fi
