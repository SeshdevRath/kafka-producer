# kafka-producer
Kafka producer example

STEPS
=====
-> Start zookeeper server

-> Create and start a kafka server

-> Create a topic

-> Start producer for the topic

-> Add KafkaListeners in your project to consume the required produced topic


Install Kafka
-------------
brew install Kafka  

To start zookeeper server
-------------------------
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

To start Kafka server or broker
-------------------------------
kafka-server-start /usr/local/etc/kafka/server.properties

To create another broker
------------------------
-> Create another server.properties file with different name

	Ex. Server-1.properties
  
	cp /usr/local/etc/kafka/server.properties  /usr/local/etc/kafka/server-1.properties 
  
	vim /usr/local/etc/kafka/server-1.properties
	
	set
  
		broker.id=1(other than existing broker ids)
    
		listeners=PLAINTEXT://:9093 (different port other than existing server properties)
    
		log.dirs=/usr/local/var/lib/kafka-logs-1(other than existing log file)

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
