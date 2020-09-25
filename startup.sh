#!/bin/bash
docker build -t creditcard:1.0 .
docker run -d -p 8090:8080 --name creditcard creditcard:1.0