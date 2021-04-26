docker rm -vf $(docker ps -a -q)
docker rmi -f $(docker images -a -q)
docker build . -t itssoumen/sign-microservice
docker push itssoumen/sign-microservice