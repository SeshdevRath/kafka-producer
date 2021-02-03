# kafka-producer
Kafka producer example

Install Kafka
-------------
brew install Kafka  

To start zookeeper server
-------------------------
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

To start Kafka server
---------------------
kafka-server-start /usr/local/etc/kafka/server.properties

Create Topic
------------
kafka-topics --create --topic kafka-example --zookeeper localhost:2181 --replication-factor 1 --partitions 1 (if Kafka installed using brew)

bin/kafka-topics.sh --create --topic kafka-example --zookeeper localhost:2181 --replication-factor 1 --partitions 1(if installed manually)

To check Kafka list
-------------------
kafka-topics -list --zookeeper localhost:2181

To start consumer
-----------------
kafka-console-consumer --bootstrap-server localhost:9092 --topic kafka-example --from-beginning

To start producer
-----------------
kafka-console-producer --broker-list localhost:9092 --topic kafka-example
