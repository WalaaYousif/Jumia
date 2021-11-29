### Setup

#### Run Steps:

1. Using Docker images or real physical servers.

```shell script
docker build -t jumia-backend .

docker network create jumia-network

docker-compose build

docker-compose up
```