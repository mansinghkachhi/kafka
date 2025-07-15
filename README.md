
# Kafka Payment App

This project demonstrates a simple payment processing system using Apache Kafka for messaging. It consists of two Spring Boot microservices: a Producer and a Consumer, along with a Docker Compose setup for running Kafka locally.

## Project Structure

- **producer/**: Spring Boot application that produces (sends) payment events to Kafka.
- **consumer/**: Spring Boot application that consumes (receives) payment events from Kafka.
- **kafka-payment-app/docker-compose.yml**: Docker Compose file to run a local Kafka broker using Bitnami's Kafka image.

## Getting Started

### Prerequisites
- Java 17 or later
- Maven
- Docker & Docker Compose

### Running Kafka Locally

1. Navigate to the `kafka-payment-app` directory:
   ```powershell
   cd kafka-payment-app
   ```
2. Start Kafka using Docker Compose:
   ```powershell
   docker-compose up -d
   ```
   This will start a Kafka broker on `localhost:9092`.

### Building and Running the Producer

1. Navigate to the `producer` directory:
   ```powershell
   cd ../producer
   ```
2. Build the application:
   ```powershell
   ./mvnw clean package
   ```
3. Run the application:
   ```powershell
   ./mvnw spring-boot:run
   ```

### Building and Running the Consumer

1. Navigate to the `consumer` directory:
   ```powershell
   cd ../consumer
   ```
2. Build the application:
   ```powershell
   ./mvnw clean package
   ```
3. Run the application:
   ```powershell
   ./mvnw spring-boot:run
   ```

## How It Works

- The **Producer** exposes REST endpoints to create payment events, which are published to a Kafka topic.
- The **Consumer** listens to the Kafka topic and processes incoming payment events.

## Configuration

- Kafka connection settings are defined in each service's `src/main/resources/application.yaml`.
- The Kafka broker is available at `localhost:9092` as configured in `docker-compose.yml`.

## Useful Commands

- Stop Kafka:
  ```powershell
  docker-compose down
  ```
- View Kafka container logs:
  ```powershell
  docker logs kafka
  ```

## References
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Apache Kafka](https://kafka.apache.org/)
- [Bitnami Kafka Docker Image](https://hub.docker.com/r/bitnami/kafka)

---

**Note:** Ensure Kafka is running before starting the producer and consumer services.
