# План автоматизации
***

## Перечень автоматизируемых сценариев
### Позитивные сценарии
* Ввод валидных данных при оплате по дебетовой карте - успех.
* Ввод валидных данных через получения кредита - успех.
* Ввод валидных данных при оплате по дебетовой карте, на карте недостаточно средств - операция отклонена
* Ввод валидных данных через получение кредита - операция отклонена.
### Негативные сценарии
* Ввод невалидных данных при оплате по дебетовой карте - появляется сообщение об ошибке ввода данных.
* Ввод невалидных данных при оплате через получение кредита - появляется сообщение об ошибке ввода данных.

для тестирования негативных сценариев будут использованы сценарии:
* оставить поля данных пустыми - появляется сообщение об ошибке: Не заполнены поля ввода данных.
* ввод в поле Номер карты 15 символов - появляется сообщение об ошибке: Введены неверные данные карты.
* ввод номера месяца больше 12: 14 - появляется сообщение об ошибке: Введен некорректный месяц.
* ввод неверного года: 2040 - появляется сообщение об ошибке: Введен некорректный год.
* ввод неверного кода CVС: 12 - появляется сообщение об ошибке: Введен некорректный код.
* ввод в поле Имя пользователя цифр - появляется сообщение об ошибке: Введено некорректное имя пользователя, в поле ввода не допускается использования цифр.


## Перечень используемых инструментов
* Intellij IDEA - популярная среда разработки для Java.
* JUnit5 - популярный фреймворк для модульного тестирования на Java.
* Faker - генерация недостающих данных для тестирования.
* Lombok - библиотека для сокращения стандартного кода в классах Java
* Selenide - популярный фреймворк для автоматизированного тестирования
* GitHub - крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки
* Docker - проект с открытым исходным кодом для автоматизации развертывания приложений в виде переносимых автономных контейнеров, выполняемых в облаке или локальной среде.
* Allure Report - фреймворк для сбора данных и построения отчетов о тестировании кода


## Перечень и описание возможных рисков при автоматизации
* Сложность настройки окружения, развертывание Docker на ОС
* сложность написания тестов и увеличение трудозатрпат при автоматизации
## Интервальная оценка с учётом рисков (в часах)
* подготовка окружения, анализ данных - 15 час.
* Написание автотестов и тестирование - 60 час.
* Формирование и анализ отчетов - 5 час
## План сдачи работ
* Написание автотестов, тестирование - до 02.03.22
* Подготовка отчётных документов по итогам тестирования - до 03.03.22 
