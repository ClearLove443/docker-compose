
## registry
```bash
# http vim /etc/docker/daemon.json
export host=192.168.50.28:5000
export host=192.168.2.10:5000

# https(nginx 代理有问题 frp 可以正常使用)
export host=registry.onlyyounotothers.top:11080

export image=nginx

docker tag ${image} ${host}/${image}
docker push ${host}/${image}
docker rmi ${host}/${image}
docker pull ${host}/${image}
curl ${host}/v2/_catalog
curl https://${host}/v2/_catalog

docker rmi $(docker images --format "{{.Repository}}"| grep 192.168.50.28)

# rm registry image
sudo rm -rf /home/ubuntu/docker-compose/registry/data/docker/registry/v2/repositories/${image}
cd /home/ubuntu/docker-compose/registry
sudo docker-compose restart registry
```