# JavaRestAPIDocker
В данном проекте представлено клиент-серверное взаимодействие посредством RestAPI.
Проект построен на основе двух docker контейнеров в одной сети. 

Контейнер клиент предназначен для демонстрации сетевого взаимодействия.

Основная часть проекта реализована в контейнере сервера и позволяет обрабатывать HTTP запросы:
GET, POST, PUT, DELITE, что дает возможность получать, добавлять, изменять и удалять объекты типа Person.
Объект Person имеет 2 реализации: 
	- в первой версия имеет 4 поля - firstName, secondName, age, height;
	- вторая версия наслдована от первой и добавляет еще 2 поля workExperience, placeOfResidence.
Обращение к разным версиям происходит в зависимости от выбора url для api: 
 	- https://server:8443/api/v1/person;
	- https://server:8443/api/v2/person;

Программа RestAPI сервера сохраняет оба варианта в список объектов. В зависимости от выбранного профиля в переменных окружения сервер-контейнера,
хранение данных производится в памяти ("dev") или записывается в файл people.dat в операционной системы ("prod"), благодаря классу FileSystemResource, наследованному от Resource и позволяющего сохранять файл в любом месте операционной системы.
В случае записи в файл при следующем запуске данные из него десериализуются и добавляются к списку объектов.

В зависимости от выбранного значения переменной окружения "project.logger" через аннотацию @ConditionalOnProperty выбирается одна из имплантаций бина простейшего логера: default(задан по умолчанию), simple, detail.


Для развертывания проекта необходимо скачать директорию с Docker-compose и запустить в командной строке docker-compose сборку:
"docker-compose up"
После создания контейнеров запустить еще раз контейнер клиент:
"docker start clientRestApi"

После завершения сбои контейнеров в командой строке отобразится автоматические запросы от клиента к серверу.
В командной строке отобразятся записи об успешных выполненных запросах: по созданию (POST), запросу (GET), обновлению (PUT) и удалению (DELETE) объектов Person для версии 1 и 2.

Проверить работу сервера в контейнере можно следующими командами:  
1) получить значение Person по id:
curl -XGET http://localhost:8443/api/<версия v1 или v2>/person/<необходимый id>
2) внести новое значение Person:
curl -X POST http://localhost:8443/api/v1/person/  -H "Content-Type: application/json" -d {\"firstName\":\"Ivan\",\"secondName\":\"Ivanov\",\"age\":30,\"height\":182}
curl -X POST http://localhost:8443/api/v2/person/  -H "Content-Type: application/json" -d {\"firstName\":\"Ivan\",\"secondName\":\"Ivanov\",\"age\":30,\"height\":182,\"workExperience\":3,\"placeOfResidence\":\"Moscov\"}
3) удалить значение Person по id:
curl -X DELETE http://localhost:8443/api/<версия v1 или v2>/person/<необходимый id>
4)Заменить значение по id
curl -X PUT http://localhost:8443/api/<версия v1 или v2>/person/<необходимый id>  -H "Content-Type: application/json" -d {\"firstName\":\"Ivan\",\"secondName\":\"Ivanov\"}

К сожалению, реализовать mTLS не успел. Начались проблемы с клинтом и в отведенное время не уложился.

Ознакомиться с кодом программы:
- сервер:  https://github.com/wintermute767/SpringRestAPIServer 
- клиент:  https://github.com/wintermute767/SpringRestAPIClient
