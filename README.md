# ddd-petstore
테스트 입니다;

#테스트 입니다.

## GitPod 접속
https://gitpod.io/#https://github.com/msa-school/ddd-petstore-level9-bounded-multi-model

- 접속 후 "Terminal > Terminal열기"

## 유틸리티 설치(httpie)

- httpie (curl / POSTMAN 대용)
```
pip install httpie
```

## Kafka 의 접속
### Docker Compose 이용 (도커 있을 때 강추)
1. Kafka 의 실행 (Docker Compose) (-d는 Background 모드)
    ```bash
    cd kafka
    docker-compose up -d     # docker-compose 가 모든 kafka 관련 리소스를 받고 실행할 때까지 기다림
    ```
2. Kafka 정상 실행 확인
   - window 환경에서는 GitBash에서 수행 
    ```bash
    $ cd /c/app/git-amf/amf42-class/kafka 
    $ docker-compose logs kafka | grep -i started    

    kafka-kafka-1  | [2022-04-21 22:07:03,262] INFO [KafkaServer id=1] started (kafka.server.KafkaServer)
    ```
3. Kafka consumer 접속 (powershell --> wsl)
    ```bash
    $ cd /mnt/c/app/git-amf/amf42-class/kafka
    $ docker-compose exec -it kafka /bin/bash   # kafka docker container 내부 shell 로 진입

    [appuser@e23fbf89f899 bin]$ cd /bin
    [appuser@e23fbf89f899 bin]$ ./kafka-console-consumer --bootstrap-server localhost:9092 --topic petstore
    ```

### 로컬 설치 (비추)
- Kafka Download
  ```bash
  wget https://dlcdn.apache.org/kafka/3.1.0/kafka_2.13-3.1.0.tgz
  tar -xf kafka_2.13-3.1.0.tgz
  ```

- Run Kafka
  ```bash
  cd kafka_2.13-3.1.0/
  bin/zookeeper-server-start.sh config/zookeeper.properties &
  bin/kafka-server-start.sh config/server.properties &
  ```

- Kafka Event 컨슈밍하기 (별도 터미널)
  ```
  cd kafka_2.13-3.1.0/
  bin/kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic petstore
  ```


## Kafka Event 송출/수신과 관련된 파일들
1. 설정관련
   - pom.xml
   - Application.java 의 @EnableBinding(KafkaProcessor.java)
   - kafka/KafkaProcessor.java
   - resources/application.yaml
2. 구현관련
   - AbstractEvent.java
   - PolicyHandler.java
   - domain event 들: PetReserved.java / PetUpdated.java

## Gateway 를 통한 진입점 통일(8080)

  ```bash
  cd gateway
  mvn spring-boot:run
  ```
서비스가 기동된 후, gateway 로 단일화된 주소로 접근이 가능함을 확인합니다:

```bash
http localhost:8088/pets         # service url of pet domain
http localhost:8088/cartItems    # service url of store domain
```


## Kubernetes 에 배포

## Docker 배포 관련

각 프로젝트 내에는 Dockerfile 이 포함되어있습니다. 이것을 빌드하기 위해서는 우선 maven 빌드로 jar 를 만들어준 후, jar 를 Dockerfile 로 다시 빌드해줍니다:

```
cd pet-store
mvn package -B
docker build -t <도커허브계정이름>/pet:v1 .
docker run <도커허브계정이름>/pet:v1

docker login
docker push <도커허브계정이름>/pet:v1 
```


### kafka 설치하기

#### Helm 

Helm(패키지 인스톨러) 설치
- Helm 3.x 설치(권장)
```bash
curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 > get_helm.sh
chmod 700 get_helm.sh
./get_helm.sh
```

#### Kafka 를 helm 으로 설치
```bash
helm repo update
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-kafka bitnami/kafka
```

