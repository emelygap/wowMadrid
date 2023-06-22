# ![logo-no-background-tiny](https://github.com/emelygap/vinci/assets/99513510/d50e14b0-9706-459d-9d07-213a5a239746) wowMadrid

## Description
Web application on cultural and leisure activities in Madrid for the next 100 days.

## Technologies used
- Spring Boot 3.0.5 y Java 17
- Maven min version 3.6.1 
- Docker
- Zookeeper (wurstmeister/zookeeper image)
- Kafka (wurstmeister/kafka image)
- PostgreSQL (postgres:14.2-alpine)
- Python 3.10.6
- Flask
- Node v.18.16.0
- @angular/cli 16.0.2

## Installation
1. Start wowMadrid component.
```bash
cd \DockerPacks\wowMadrid
sudo docker compose up (Ubuntu)
docker-compose up (Windows)
```

## Usage
Open your browser on http://localhost:8080

![Captura desde 2023-06-09 22-10-30](https://github.com/emelygap/vinci/assets/99513510/7e1718d2-9b21-4a11-9739-e22d5b5f1871)

There is the option to view the events of a specific district. To do this, select a district from the dropdown and the table will be updated only with the events of that district.

As it is a PWA it can be installed on the computer, to do so we click on the installation icon that appears in the browser and a dialog alert will appear asking us if we want to install the application. Click on install and we will have the web application installed, ready to use offline.

![Captura desde 2023-06-09 22-34-22](https://github.com/emelygap/vinci/assets/99513510/80bb4f00-0554-42de-98da-14688f620845)
