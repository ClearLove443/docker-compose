## Create container with docker

### portainer

```bash
sudo docker volume create portainer_data
sudo docker run -d \
    --name portainer \
    -p 9000:9000 \
    --restart=always \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v portainer_data:/data \
    portainer/portainer-ce
```

### springboot

```bash
sudo docker run -d \
    --name springboot-demo \
    -p 9090:9090 \
    -v app.jar:/app.jar \
    openjdk \
    java -jar /app.jar
```

### nginx

```bash
sudo docker run -d \
    --name blog \
    -p '80:80' \
    -v /home/ubuntu/docker/blog/public:/usr/share/nginx/html \
    -v /home/ubuntu/docker/config/nginx/nginx.conf:/etc/nginx/nginx.conf:ro \
    nginx
```

### nodejs

```bash
sudo docker run -d \
    --name nodejs \
    -p '3000:3000' \
    -v /home/ubuntu/docker/acts-mdm-front/sample_api:/home/node/app \
    node \
    node /home/node/app/index.js
```

### hive

```bash
beeline -u 'jdbc:hive2://110.40.137.191:10000/testdb' -e 'show databases'
beeline -u 'jdbc:hive2://110.40.137.191:10000/testdb;principal=alluxio/wentjiang@HADOOP_COM' -e 'show databases' -e 'select * from employee'
```

### splunk

```bash
sudo docker run -d \
    --name splunk \
    -p 8000:8000 \
    -e "SPLUNK_START_ARGS=--accept-license" \
    -e "SPLUNK_PASSWORD=password" \
    splunk/splunk:latest
```

- Initial username && password

```yaml
username: admin
password: password
```

### mongo

```bash
sudo docker run -d \
    --name mongo \
    --restart always \
    -p 27017:27017 \
    -e MONGO_INITDB_ROOT_USERNAME=admin \
    -e MONGO_INITDB_ROOT_PASSWORD=123456 \
    -v /home/ubuntu/mongo/mongod.conf:/etc/mongod.conf \
    -v /home/ubuntu/ssl/ca.pem:/etc/ca.pem \
    -v /home/ubuntu/ssl/server.pem:/etc/server.pem \
    -v /home/ubuntu/ssl/client.pem:/etc/client.pem \
    mongo \
    --auth --config /etc/mongod.conf
```

### redis

```bash
sudo docker run -d \
    --name myredis \
    -p 6379:6379 \
    -v /home/ubuntu/docker/redis/config/redis.conf:/etc/redis/redis.conf \
    -v /home/ubuntu/docker/redis/data:/data:rw \
    --privileged=true \
    --appendonly yes \
    redis \
    redis-server /etc/redis/redis.conf \
```

### postgresql

```bash
sudo docker run -d \
    --name postgres \
    -p 5432:5432 \
    -e POSTGRES_PASSWORD=password \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v /home/ubuntu/docker/data/postgres/pgdata:/var/lib/postgresql/data \
    postgres
```

- Initial username && password

```yaml
username: postgres
password: password
```

- 还原

```bash
scp -P 1115 -r /d/docker/PostgreSql/dataBack/ ubuntu@127.0.0.1:/home/ubuntu/docker/data/postgres/
pg_restore -U postgres -d public public.dmp
```

- switch over to the postgres account

```bash
sudo -i -u postgres
```

- create user

```bash
createuser --interactive --pwprompt
```

### mysql

```bash
sudo docker run -itd \
    --name mysql \
    -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=my-secret-pw \
    mysql
```

- Initial username && password

```
username: root
password: my-secret-pw
```

### Sql Server

```bash
sudo docker run -d \
    --name SqlServer \
    -p 1433:1433 \
    -e 'ACCEPT_EULA=Y' \
    -e 'SA_PASSWORD=!SqlServer2' \
    mcr.microsoft.com/mssql/server:2019-CU11-ubuntu-20.04
```

- Initial username && password

```
username: sa
password: !SqlServer2
```

- 备份

```bash
sqlpackage.exe /TargetFile:"D:\docker\SQL Server\sqldb-coredx-runtime-ac-dev001.bacpac" /Action:Export /SourceServerName:"110.40.137.191" /SourceUser:"sa" /SourcePassword:"!SqlServer2" /SourceDatabaseName:"mdmDB"
```

- 还原

```bash
sqlpackage.exe /SourceFile:"D:\Project\WorkSpace_aeon\sqldb-coredx-runtime-ac-dev001.bacpac" /Action:Import /TargetServerName:"127.0.0.1" /TargetUser:"sa" /TargetPassword:"!SqlServer2" /TargetDatabaseName:"mdmDB"
```

### gitlab

```bash
sudo docker run -d \
    --name gitlab \
    -p 6100:443 \
    -p 6101:80 \
    -p 6102:22 \
    -v /home/gitlab/config:/etc/gitlab \
    -v /home/gitlab/logs:/var/log/gitlab \
    -v /home/gitlab/data:/var/opt/gitlab \
    gitlab/gitlab-ce
```

- Initial username && password

```bash
username: root
password:
sudo docker exec -it gitlab grep 'Password:' /etc/gitlab/initial_root_password
```

### jenkins

```bash
sudo docker run -d \
    --name jenkins \
    -p 8080:8080 -p 50000:50000 \
    -u root \
    -e JAVA_OPTS=-Duser.timezone=Asia/Shanghai \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v /usr/bin/docker:/usr/bin/docker \
    -v /opt/jenkins:/var/jenkins_home \
    -v /etc/localtime:/etc/localtime \
    -v /opt/software/apache-maven-3.8.2:/usr/local/maven \
    --restart=always \
    jenkins/jenkins:lts
```

- Initial username && password

```bash
username: admin
password:
sudo docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

### nexus

```bash
rm -rf /some/dir/nexus-data && mkdir /some/dir/nexus-data && chown -R 200 /some/dir/nexus-data
sudo docker run -d \
    --name nexus \
    -p 8081:8081 \
    -m 3072m \
    -e INSTALL4J_ADD_VM_PARAMS="-Xms4096m -Xmx4096m -XX:MaxDirectMemorySize=2703m -Djava.util.prefs.userRoot=/some-other-dir" \
    -v /some/dir/nexus-data:/nexus-data \
    sonatype/nexus3
```

- Initial username && password

```bash
username: admin
password:
sudo docker exec -it nexus cat /nexus-data/admin.password
```

### nacos(配置中心)

```bash
sudo docker run -d \
    --name nacos  \
    -p 8848:8848 \
    -e MODE=standalone \
    nacos/nacos-server
```

- Initial username && password

```bash
http://110.40.137.191:8848/nacos/

username: nacos
password: nacos
```

### ldap

```bash
sudo docker run -d \
    --name myldap_name \
    -p 389:389 \
    -p 636:636 \
    --network bridge \
    --hostname openldap-host \
    -e LDAP_ORGANISATION="example" \
    -e LDAP_DOMAIN="example.com" \
    -e LDAP_ADMIN_PASSWORD="123456" \
    osixia/openldap

sudo docker run -d \
    --name myldapadmin \
    --privileged \
    -p 8080:80 \
    --env PHPLDAPADMIN_HTTPS=false \
    --env PHPLDAPADMIN_LDAP_HOSTS=172.18.0.3 \
    --detach osixia/phpldapadmin
```

#### 参数说明

- –privileged 特权模式启动(使用该参数，container 内的 root 拥有真正的 root 权限。否则，container 内的 root 只是外部的一个普通用户权限。)
- –env PHPLDAPADMIN_HTTPS=false 禁用 HTTPS
- –env PHPLDAPADMIN_LDAP_HOSTS 配置 openLDAP 的 IP 或者域名，

- Initial username && password

```bash
http://110.40.137.191:8080

username: cn=admin,dc=example,dc=com
password: 123456
```

### keycloak

```bash
sudo docker run -d \
    --name keycloak \
    -p 8080:8080 \
    -p 8082:8082 \
    -p 9093:9092 \
    -e KEYCLOAK_USER=admin \
    -e KEYCLOAK_PASSWORD=admin \
    jboss/keycloak
```

- Initial username && password

```bash
# conncet to admin console
http://110.40.137.191:8080/auth/

Username: admin
Password: admin
```

- solve https requests problem

```bash
sudo docker exec -it keycloak bash
rm ~/keycloak.mv.db && cp /opt/jboss/keycloak/standalone/data/keycloak.mv.db ~/

export dir=/opt/jboss/keycloak/modules/system/layers/base/com/h2database/h2/main
java -cp "$dir/h2-1.4.197.jar:$H2DRIVERS:$CLASSPATH" org.h2.tools.Server -tcpAllowOthers -webAllowOthers -webPort 8082 "$@"

# connect h2 database
http://110.40.137.191:8082/
JDBC URL:
    jdbc:h2:tcp://110.40.137.191:9092/~/keycloak
User Name: sa
Password: sa
update REALM set ssl_required='NONE' where id = 'master';

cp ~/keycloak.mv.db /opt/jboss/keycloak/standalone/data/keycloak.mv.db
/opt/jboss/keycloak/bin/jboss-cli.sh --connect command=:reload
```
