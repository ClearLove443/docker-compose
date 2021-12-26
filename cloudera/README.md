## start

sudo /home/cloudera/cloudera-manager --express --force
sudo service cloudera-scm-server restart

## kerberos
/etc/krb5.conf

kinit -kt /etc/yum.repos.d/hdfs.keytab hdfs/quickstart.cloudera@CLOUDERA

    * set up a working KDC.
    * checked that the KDC allows renewable tickets.
    * installed the client libraries.
    * created a proper account for Cloudera Manager.

Then, it will prompt you for the following details (accept defaults if not
specified here):

    KDC Type:                MIT KDC
    KDC Server Host:         quickstart.cloudera
    Kerberos Security Realm: CLOUDERA

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

