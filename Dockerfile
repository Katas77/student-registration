# Базовый образ, содержащий Јата 17
FROM openjdk:17-oracle

#Директория приложения внутри контейнера
WORKDIR /app

# Копирование JAR-файла приложения в контейнер
COPY build/libs/StudentRegistration-0.0.1-SNAPSHOT.jar app.jar

#Команда docker build создает образы Docker из файла Dockerfile: docker build -t student-registration .
# Команда docker run запускает команду в новом контейнере, при необходимости извлекая образ и запуская контейнер: docker run student-registration

CMD ["java", "-jar", "app.jar"]


