# Kafka
Firstly, ensure you have Docker installed and running.
## Initialize docker-compose
`docker-compose up -d --build`

## Init kafka-console-consumer
1. Open CMD
2. Run `kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <topic name> --from-beginning`. For example --topic click-events