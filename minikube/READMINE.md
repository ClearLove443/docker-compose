## minikube
- windows 默认 https

### virtualbox
```bash
ssh ubuntu@192.168.2.73

### wsl2 virtualbox ubuntu 用户执行
sudo rm -rf /tmp/*
sudo sysctl net/netfilter/nf_conntrack_max=131072
sudo sysctl fs.protected_regular=0
sudo minikube start --force --driver=docker
sudo minikube kubectl -- get pods -A
sudo kubectl logs -p kube-proxy-26r76 -n kube-system
sudo minikube dashboard

// wsl2 不需要 virtualbox 需要
sudo kubectl proxy --port=8001 --address='192.168.2.73' --accept-hosts='^.*' &
http://192.168.2.73:8001/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/#/settings?namespace=default

sudo sysctl fs.protected_regular=0
sudo minikube stop

sudo minikube delete

minikube image pull onlyyounotothers.top:10082/nginx:latest
minikube dashboard
minikube kubectl cluster-info
kubectl cluster-info

minikube logs
minikube service list
minikube service kube-nginx999 --url
minikube service kubernetes-dashboard -n kubernetes-dashboard --url

kubectl create deployment hello-minikube --image=192.168.50.28:8082/nginx:latest
```