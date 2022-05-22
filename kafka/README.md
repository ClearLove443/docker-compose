## Add environment variables
```bash
vim ~/.bashrc
export HOST_NAME=110.40.137.191(Replace with local address)
source ~/.bashrc
```

wsl
zookeeper-server-start.sh /root/clusters/kafka/bin/zookeeper.properties
kafka-server-start.sh /root/clusters/kafka/bin/server1.properties
kafka-server-start.sh /root/clusters/kafka/bin/server2.properties
kafka-server-start.sh /root/clusters/kafka/bin/server3.properties

rm -rf /root/clusters/tmp

kafka-ui
http://110.40.137.191:28080/