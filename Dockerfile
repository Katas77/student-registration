# Базовый образ, содержащий Јата 17
FROM openjdk:17-oracle

#Директория приложения внутри контейнера
WORKDIR /app

# Копирование JAR-файла приложения в контейнер
COPY build/libs/StudentRegistration-0.0.1-SNAPSHOT.jar app.jar

#Команда docker build создает образы Docker из файла Dockerfile: docker build -t student-registration .
# Команда docker run запускает команду в новом контейнере, при необходимости извлекая образ и запуская контейнер: docker run student-registration
# docker run -it student-registration
CMD ["java", "-jar", "app.jar"]


#( в терминалеPS C:\Users\krp77\IdeaProjects\socketserver>  docker build -t socket-client .)
#(PS C:\Users\krp77\IdeaProjects\socketserver>  docker run socket-client  )

# docker container ls
# docker container ls -a
# docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' fa0ad4b31d4d
# docker image ls
#  docker image rm student-registration -f                             (dell image)

# docker network create spring-socket-network

