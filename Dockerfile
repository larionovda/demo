
# Используем образ OpenJDK 20 для запуска приложения
FROM eclipse-temurin:20-jdk

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл сборки JAR в контейнер
COPY demo_one/target/demo_one-0.0.1-SNAPSHOT.jar app.jar

# Указываем порт, который будет открыт в контейнере
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]