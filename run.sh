#!/bin/bash

#mvn package -Dmaven.test.skip=true

docker build -f "./Dockerfile" . -t "challenge-app"
#
docker tag challenge-app challenge-app:dev
#
cd docker-compose
#
docker-compose -f docker-compose.yml up -d
