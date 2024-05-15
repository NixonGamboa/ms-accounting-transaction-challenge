FROM openjdk:17-oracle

RUN mkdir home/app

COPY runner/app-service/build/libs/ms-accounting-transactions.jar ./home/app

WORKDIR ./home/app

EXPOSE 8084

CMD ["java", "-jar", "ms-accounting-transactions.jar"]
