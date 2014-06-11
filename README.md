1. Run mvn jetty:run
2. type: 
http://localhost:8080/JacksonGuiceExample/web/users
http://localhost:8080/JacksonGuiceExample/web/users/1
http://localhost:8080/JacksonGuiceExample/web/users/numberOfUsers


Spring example - before - uncomment a Spring configuration in the web.xml
http://localhost:8080/JacksonGuiceExample/rest/sample/daniels


INSERT USER via Spring and REST
http://localhost:8080/JacksonGuiceExample/web/users/insert


	!!! Important - if you have running Apache Server (httpd) as a server/service - stop it
	in other way you get an error:
	[ERROR] client.JerseyClientGet Failed : HTTP error code : 404