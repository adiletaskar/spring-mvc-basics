FROM openjdk

# Установите рабочую директорию в /app
WORKDIR /app

# Копируйте JAR-файл вашего приложения в контейнер
COPY target/ch9-ex2-0.0.1-SNAPSHOT.jar app.jar

# Определите порт, который ваше приложение будет слушать
EXPOSE 8080

# Команда для запуска вашего приложения
CMD ["java", "-jar", "app.jar"]
