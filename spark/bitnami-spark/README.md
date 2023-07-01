# ref

https://hub.docker.com/r/bitnami/spark/

https://dev.to/mvillarrealb/creating-a-spark-standalone-cluster-with-docker-and-docker-compose-2021-update-6l4

# Setting up an Apache Spark Cluster

A Apache Spark cluster can easily be setup with the default docker-compose.yml file from the root of this repo. The docker-compose includes two different services, spark-master and spark-worker.

By default, when you deploy the docker-compose file you will get an Apache Spark cluster with 1 master and 1 worker.

If you want N workers, all you need to do is start the docker-compose deployment with the following command:

```sh
docker-compose up -d --scale spark-worker=3
```