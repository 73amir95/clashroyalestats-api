FROM ubuntu:latest
LABEL authors="Amir"

ENTRYPOINT ["top", "-b"]