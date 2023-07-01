## minikube

```sh
# ubuntu user
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar demo-0.0.1-SNAPSHOT.jar

docker export redis > redis.tar
docker import redis.tar - redis:latest
cat redis.tar | docker import - docker.io/redis:latest
cat stable.tgz | docker import - docker.io/kicbase/stable:v0.0.39

minikube delete
rm -rf ~/.minikube
minikube start
# minikube start --image-mirror-country='cn' --base-image="kicbase/stable:v0.0.39"
# minikube start --image-mirror-country='cn' --image-repository='auto'
minikube start --driver=podman --container-runtime=cri-o --image-mirror-country='cn' --base-image="docker.io/kicbase/stable:v0.0.39"

kill -9 $(lsof -i:8001 -t)
kubectl proxy --port=8001 --address='192.168.2.202' --accept-hosts='^.*' &
minikube dashboard
http://192.168.2.202:8001/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/#/settings?namespace=default

```
https://blog.csdn.net/TinyJian/article/details/109699420

## Kubernets deploy

```sh
kubectl create -f demo-1.yaml --validate=false
kubectl apply -f demo-1.yaml --validate=false
kubectl delete namespace wanyang3
```

## 使用本地景象

https://www.cnblogs.com/xiao2/p/16047455.html

```sh
# General
minikube image build -t <IMAGE_NAME> .
# Example
minikube image build -t huwanyang168/demo:0.0.1 .
minikube image ls
```

## 访问service

```sh
# kubectl 版本需要1.3以上  external:internal
kubectl port-forward service/demo-hwy-1 8081:8080 -n wanyang3 --address='0.0.0.0'

kubectl port-forward service/portainer-agent 9001:9001 -n portainer --address='0.0.0.0'
```

## configmap

### create from directory

```sh
mkdir -p configure-pod-container/configmap/
wget https://kubernetes.io/examples/configmap/game.properties -O configure-pod-container/configmap/game.properties
wget https://kubernetes.io/examples/configmap/ui.properties -O configure-pod-container/configmap/ui.properties
kubectl delete configmap game-config
kubectl create configmap game-config --from-file=configure-pod-container/configmap/
kubectl describe configmaps game-config
```

## apply vs create

https://spacelift.io/blog/kubectl-apply-vs-create

## ingress

### 国内
minikube addons enable ingress --image-mirror-country='cn'
https://jasonkayzk.github.io/2021/05/30/%E5%9B%BD%E5%86%85%E5%9C%A8minikube%E4%B8%AD%E6%B7%BB%E5%8A%A0ingress-nginx%E6%8F%92%E4%BB%B6/

https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/