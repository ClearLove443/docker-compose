#docker build --file Dockerfile --tag aeon-hr-front:v1.0 resources
#docker build . --tag aeon-hr-front:v1.0
#docker run -d --name aeon-hr-front -p 8080:80 -p 8000:8000 aeon-hr-front:v1.0
FROM nginx:latest

## 镜像工作目录
RUN echo 1: $PWD
WORKDIR /tmp/front_work_dir
RUN echo 2: $PWD
COPY ../dist ./

COPY app.conf /etc/nginx/conf.d