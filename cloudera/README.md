## start

```bash
cd /home/ubuntu/cloudera

sudo docker run -d \
    --name cloudera \
    --hostname=quickstart.cloudera \
    --privileged=true \
    -t -i \
    -v /home/ubuntu/cloudera/keytab/:/keytab \
    -v /home/ubuntu/cloudera/CentOS-Base.repo:/etc/yum.repos.d/CentOS-Base.repo \
    -m 12G \
    -p 80:80 \
    -p 88:88 \
    -p 88:88/udp \
    -p 1004:1004 \
    -p 1006:1006 \
    -p 3306:3306 \
    -p 7180:7180 \
    -p 7337:7337 \
    -p 8020:8020 \
    -p 8022:8022 \
    -p 8030:8030 \
    -p 8031:8031 \
    -p 8032:8032 \
    -p 8033:8033 \
    -p 8088:8088 \
    -p 8090:8090 \
    -p 8888:8888 \
    -p 8990:8990 \
    -p 9083:9083 \
    -p 60010:60010 \
    -p 10000:10000 \
    -p 10002:10002 \
    -p 10020:10020 \
    -p 10033:10033 \
    -p 11000:11000 \
    -p 18088:18088 \
    -p 19888:19888 \
    -p 19890:19890 \
    -p 21050:21050 \
    -p 25010:25010 \
    -p 25020:25020 \
    -p 50070:50070 \
    -p 50111:50111 \
    -p 50470:50470 \
    cloudera/quickstart /usr/bin/docker-quickstart
```

service ntpd status
service ntpd start

sudo /home/cloudera/cloudera-manager --express --force
<!-- sudo service cloudera-scm-server restart -->

quickstart.cloudera:7180
127.0.0.1:7180

username: cloudera
password: cloudera

## kerberos

https://www.jianshu.com/p/1671396e9b02

```bash
cd /etc/yum.repos.d/
mkdir backup
mv cloudera* backup
mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
curl -k -o /etc/yum.repos.d/CentOS-Base.repo https://www.xmpan.com/Centos-6-Vault-Aliyun.repo

yum update

/home/cloudera/kerberos
````

/etc/krb5.conf
/var/kerberos/krb5kdc/kdc.conf

kinit -kt /keytab/cloudera-scm.admin@CLOUDERA.keytab cloudera-scm/admin

    * set up a working KDC.
    * checked that the KDC allows renewable tickets.
    * installed the client libraries.
    * created a proper account for Cloudera Manager.

Then, it will prompt you for the following details (accept defaults if not
specified here):

    KDC Type:                MIT KDC
    KDC Server Host:         quickstart.cloudera
    Kerberos Security Realm: CLOUDERA
    加密类型： rc4-hmac  aes128-cts
Later, it will prompt you for KDC account manager credentials:

    Username: cloudera-scm/admin (@ CLOUDERA)
    Password: cloudera

cloudera-scm/admin@CLOUDERA
cloudera

hive conf /etc/hive/conf       /usr/lib/hive
hadoop conf /etc/hadoop/conf
hbase conf /etc/hbase/conf
spark conf /etc/spark/conf
hue conf /etc/hue/conf
zookeper conf /etc/zookeper/conf


  [[database]]
    engine=mysql
    host=quickstart.cloudera
    port=3306
    user=hue
    password=cloudera
    name=hue

```bash
kadmin.local

listprincs

ktadd -k /keytab/cloudera-scm.admin@CLOUDERA.keytab -norandkey cloudera-scm/admin@CLOUDERA
ktadd -k /keytab/hbase.quickstart.cloudera@CLOUDERA.keytab -norandkey hbase/quickstart.cloudera@CLOUDERA
ktadd -k /keytab/hdfs.quickstart.cloudera@CLOUDERA.keytab -norandkey hdfs/quickstart.cloudera@CLOUDERA
ktadd -k /keytab/hive.quickstart.cloudera@CLOUDERA.keytab -norandkey hive/quickstart.cloudera@CLOUDERA
ktadd -k /keytab/hue.quickstart.cloudera@CLOUDERA.keytab -norandkey hue/quickstart.cloudera@CLOUDERA
ktadd -k /keytab/impala.quickstart.cloudera@CLOUDERA.keytab -norandkey impala/quickstart.cloudera@CLOUDERA
ktadd -k /keytab/spark.quickstart.cloudera@CLOUDERA.keytab -norandkey spark/quickstart.cloudera@CLOUDERA
ktadd -k /keytab/yarn.quickstart.cloudera@CLOUDERA.keytab -norandkey yarn/quickstart.cloudera@CLOUDERA
ktadd -k /keytab/solr.quickstart.cloudera@CLOUDERA.keytab -norandkey solr/quickstart.cloudera@CLOUDERA
```

chown -R ubuntu:ubuntu /home/ubuntu/cloudera/keytab

docker cp cloudera:/keytab/ /home/ubuntu/cloudera/