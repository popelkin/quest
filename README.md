<h2>Simple quest web application</h2>

User should enter his name on the start of the game.

![alt text](/readme/1670841151179.jpg)
![alt text](/readme/1670841160209.jpg)
![alt text](/readme/1670841242174.jpg)
![alt text](/readme/1670841254957.jpg)
![alt text](/readme/1670841264691.jpg)
![alt text](/readme/1670841321035.jpg)

>The goal of the game is to reach success final location

<h3><a>Building: </a></h3>

```$ docker build -t quest .```

<h3 ><a>Launch:</a></h3>

```$ docker run -p 1111:8080 quest```

link: ```localhost:8080```

<h3 ><a>Class description</a></h3>
>root of the project:
- ```main``` - application code directory
-  ```test``` - test code directory

>```main/java/com/javarush/popelo/quest```:
- ```domain``` - contains the main object classes
- ```repository``` - contains classes of repositories
- ```service``` - contains the business logic of the application
- ```servlet``` - servlets classes

also, at the root of the package are classes:

- ```AppContextListener``` - loads application data
- ```GameInitializer``` - contains application content

>```main/resources``` contain: log4j2.xml
>

>```src/main/webapp/WEB-INF/jsp```:
- ```error.jsp``` - error page
- ```footer.jsp``` - main HTML template footer
- ```header.jsp``` - main HTML template header
- ```index.jsp``` - start page
- ```point.jsp``` - main game page
  
<h3><a>Technologies</a></h3>

- Maven
- UI: JSP, JSTL, Bootstrap, CSS
- Tests: JUnit5, Mockito
- lib's: apache-commons, lombok

