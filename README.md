# Система мониторинга с использованием Spring Kafka

## Описание:

Система мониторинга, отслеживающая работу различных компонентов приложения с помощью Spring Kafka.
Система включает в себя Producer для отправки метрик, Consumer для их обработки и анализа, а также REST API для просмотра метрик.

## Реализация:

### Producer Service:

Микросервис `Metrics Producer` отслеживает и собирает
метрики работы приложения и отправляет их в Kafka топик `metrics-topic`.

Реализовано API для взаимодействия с микросервисом: `POST /metrics`.
Отправка метрик работы приложения в формате JSON. Метрики могут
включать информацию о производительности, использовании ресурсов, ошибках и т.д.

### Consumer Service:

Микросервис `Metrics Consumer` принимает метрики из Kafka
топика `metrics-topic` и сохраняет в базе данных для
последующего анализа.

Реализован REST API в микросервисе `Metrics Consumer` для просмотра метрик:<br>
`GET /metrics`: Получение списка всех метрик.<br>
`GET /metrics/{id}`: Получение конкретной метрики по ее идентификатору.

## Сборка
 [docker-compose.yml](docker-compose.yml) - подготавливает все сервисы для работы
 приложения совместно с Zookeeper, Apache Kafka и PostgreSQL

 Сборка и запуск осуществляется командой:

```
docker compose up --build
```

## Стек
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white "Java 17")
![Maven](https://img.shields.io/badge/Maven-green.svg?style=for-the-badge&logo=mockito&logoColor=white "Maven")
![Spring](https://img.shields.io/badge/Spring-blueviolet.svg?style=for-the-badge&logo=spring&logoColor=white "Spring")
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![GitHub](https://img.shields.io/badge/git-%23121011.svg?style=for-the-badge&logo=github&logoColor=white "Git")

* Язык: *Java 17*
* Автоматизация сборки: *Maven*
* Фреймворк: *Spring*
* База данных: *PostgreSQL*
* Контроль версий: *Git*
* Spring Kafka
* Swagger
* Docker

## Взаимодействие с REST-сервисом

- Доступен Swagger-UI во время работы приложения:

- Producer (http://localhost:8081/swagger-ui/index.html#/)
- Consumer (http://localhost:8082/swagger-ui/index.html#/)