

## 生成 http 认证文件

```bash
mkdir auth

docker run --rm \
    --entrypoint htpasswd \
    httpd:alpine \
    -Bbn 'Krc0eYtMGo3RN7gEZa55vUA4y4Q8md82' '30Kz7L4rEtBSvx568bHClAUw2W3O8pgy' > auth/nginx.htpasswd
```

```bash

# Google Cloud Shell

 https://ssh.cloud.google.com/

# Login to Docker Hub
export DOCKER_USERNAME=onlyyounotothers
export host=docker.io
docker login -u $DOCKER_USERNAME -p @199407307034 ${host}

export image=cluster-apache-spark
export version=3.4.0
docker build -t $image:$version .
docker tag ${image}:$version ${host}/${DOCKER_USERNAME}/${image}:$version
docker push ${host}/${DOCKER_USERNAME}/${image}:$version
docker rmi ${host}/${DOCKER_USERNAME}/${image}:$version

export host=registry.cn-hangzhou.aliyuncs.com
docker login -u tb53994388 -p 'Ac?9b1;KtP' registry.cn-hangzhou.aliyuncs.com

addprinc mongodb/kdc@HADOOP.COM
# http vim /etc/docker/daemon.json
export host=192.168.50.28:5000
export host=192.168.2.10:5000

# https(nginx 代理有问题 frp 可以正常使用)
export host=registry.onlyyounotothers.top:10443

docker login ${host} -u Krc0eYtMGo3RN7gEZa55vUA4y4Q8md82 -p 30Kz7L4rEtBSvx568bHClAUw2W3O8pgy
docker logout ${host}

export image=cluster-apache-spark

docker tag ${image} ${host}/${image}
docker push ${host}/${image}
docker rmi ${host}/${image}
docker pull ${host}/${image}
curl ${host}/v2/_catalog
curl https://${host}/v2/_catalog

curl https://${host}/v2/_catalog -H 'Authorization: Basic S3JjMGVZdE1HbzNSTjdnRVphNTV2VUE0eTRROG1kODI6MzBLejdMNHJFdEJTdng1NjhiSENsQVV3MlczTzhwZ3k='

echo https://${host}/v2/_catalog

docker rmi $(docker images --format "{{.Repository}}"| grep 192.168.50.28)

# rm registry image
sudo rm -rf /home/ubuntu/docker-compose/registry/data/docker/registry/v2/repositories/${image}
cd /home/ubuntu/docker-compose/registry && sudo docker-compose restart registry
```


