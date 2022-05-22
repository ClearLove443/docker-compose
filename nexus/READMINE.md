
## nexus

```bash
docker login 192.168.50.28:8082 -u admin -p 8d4be921-73f6-48a6-af02-e17f65081a4c
docker login onlyyounotothers.top:8082 -u admin -p 8d4be921-73f6-48a6-af02-e17f65081a4c
docker pull hello-world
docker pull 192.168.50.28:8082/hello-world

docker tag hello-world 192.168.50.28:8082/hello-world
docker push 192.168.50.28:8082/hello-world

/home/ubuntu/docker-push.sh imagename
```