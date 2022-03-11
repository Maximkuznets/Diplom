# Описание запуска тестов
***

1. Склонировать репозиторий с GIT HUB на ПК.
2. Открыть в Intelij IDEA проект Diplom.
3. Запустить контейнеры командой:  docker-compose up -d 
4. Запустить SUT:
- для БД MySQL запустить команду: java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app;

- для БД данных PostgreSQL запустить команду: java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres.
5. Запустить тесты командой: ./gradlew test
6. Сформировать отчет Allure Report, выполнив команду: ./gradlew allureServe