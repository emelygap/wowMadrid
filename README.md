# Vinci Project
This experience try to provide a framework in which students can develop project integrated in a microservices architecture using theirselves developments or other provided components like other Microservices or Docker Packs.

## Business Cases

| Name  | Development Team | Description | Docker Packs | Microservices |
|---|---|---|---|---|
| [Kafkiano](BusinessCases/Kafkiano) | Carlos Caño (<carlos.cano@hpecds.com>) | Integration of basic producer and consumer with Kafka. | [Kafka](DockerPacks/Kafka)  | [MockProducerKafka](Microservices/MockProducerKafka), [MockConsumerKafka](Microservices/MockConsumerKafka) |
| [Covid19](BusinessCases/Covid19) | Luis Roset (<luis.roset@hpecds.com>) | Recovery and analysis of information related to Covid19. |  |  |
| [Trainifit](BusinessCases/Trainifit) | Alberto Caño (<acanoa01@estudiantes.unileon.es>) | Gym platform. | [Trainifit](DockerPacks/Trainifit),  [TrainifitClient](DockerPacks/TrainifitClient)|[ApiGateway](Microservices/ApiGateway), [RoutinesManager](Microservices/RoutinesManager), [EurekaServer](Microservices/EurekaServer)|
| [CDTiempo](BusinessCases/CDTiempo) | Iván Sánchez (<isancr00@estudiantes.unileon.es>) | Sunrise + weather?. |[CDTiempo](DockerPacks/CDTiempo) 
| [wowMadrid](BusinessCases/wowMadrid) | Emely Aguilar (<emelygape@gmail.com>) | Web application on cultural and leisure activities in Madrid for the next 100 days. | [wowMadrid](DockerPacks/wowMadrid)  | [wowMadridMicroservices](Microservices/wowMadrid) |


## Catalog Components
### Docker Packs
| Name  | Development Team | Description | Business Case |
|---|---|---|---|
| [Kafka](DockerPacks/Kafka) | Carlos Caño (<carlos.cano@hpecds.com>) | Basic Kafka environment. | [Kafkiano](BusinessCases/Kafkiano) |
| [Trainifit](DockerPacks/Trainifit) | Alberto Caño (<acanoa01@estudiantes.unileon.es>) | Gym manager application (back). | [Trainifit](BusinessCases/Trainifit) |
| [TrainifitClient](DockerPacks/TrainifitClient) | Alberto Caño (<acanoa01@estudiantes.unileon.es>) | Gym manager application (front). | [Trainifit](BusinessCases/Trainifit) |
| [CDTiempo](DockerPacks/CDTiempo) | Iván Sánchez (<isancr00@estudiantes.unileon.es>) | Sunrise + weather?. |[CDTiempo](BusinessCases/CDTiempo) |
| [wowMadrid](DockerPacks/wowMadrid) | Emely Aguilar (<emelygape@gmail.com>) | Dockers...(modificar) | [wowMadrid](BusinessCases/wowMadrid) |


### Microservices
| Name  | Development Team | Description | Business Case |
|---|---|---|---|
| [MockProducerKafka](Microservices/MockProducerKafka) | Carlos Caño (<carlos.cano@hpecds.com>)| Produce mock message to inject on Kafka. | [Kafkiano](BusinessCases/Kafkiano) |
| [MockConsumerKafka](Microservices/MockConsumerKafka) | Carlos Caño (<carlos.cano@hpecds.com>) | Consume mock message from Kafka. | [Kafkiano](BusinessCases/Kafkiano) |
| [ApiGateway](Microservices/ApiGateway) | Alberto Caño (<acanoa01@estudiantes.unileon.es>)| Rest API for Trainifit. | [Trainifit](BusinessCases/Trainifit) |
| [EurekaServer](Microservices/EurekaServer) | Alberto Caño (<acanoa01@estudiantes.unileon.es>) | Instance of a Eureka server. | [Trainifit](BusinessCases/Trainifit) |
| [RoutinesManager](Microservices/RoutinesManager) | Alberto Caño (<acanoa01@estudiantes.unileon.es>) | Microservice to manage all routines from an user. | [Trainifit](BusinessCases/Trainifit) |
| [wowMadridMicrosevices](Microservices/wowMadridMicroservices) | Emely Aguilar (<emelygape@gmail.com>) | wowMadrid Microservices. | [wowMadrid](BusinessCases/wowMadrid) |
