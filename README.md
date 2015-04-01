# Backend-Tech-Challenge

<b>Part 1</b>

A dockerized 'Hello World' web service with the following input/output

curl http://localhost:8080/hello?name=$name must produce: {"Message": { "content": "hello $name"}}
It uses the following technologies:

<b>Technologies</b>
<ul>
  <li>Java</li>
  <li>Maven for building to a war file</li>
  <li>Jetty for webserver</li>
  <li>Jersey for REST interface</li>
  <li>It has a HelloWorldResource exposing the REST api and a HelloWorldService, that performs the logic.</li>
  <li>Spring for injecting a singleton HelloService into the HelloResource</li>
  <li>JAX RS / Jackson for serializing objects</li>
  <li>Built as a docker image using a Dockerfile starting with FROM ubuntu:trusty, and run as a docker container.</li>
</ul>

<b>Need to install</b>(if not on linux)
<ul>
<li>Boot2docker</li>
</ul>

<b>RUN</b> Boot2docker and Add commands
<ul>
<li>boot2docker init</li>
<li>boot2docker start</li>
<li>eval "$(boot2docker shellinit)"</li>
<li>then on the project directory</li>
<li>mvn clean package (will take some time to create the docker image)</li>
<li>docker run -p 80:8080 tradeshift/codechallenge</li>
<li>After the jetty runs just go to
http://<b>(Insert the IP from the boot2docker logs--without port)</b>/hello?name=taso</li>
</ul>


---------------------------------------------------------------------------------------

<b>Part 2</b>

<ul>
<li>The messages are stored now in a postgres database</li>
<li>The database is accessed using Spring JDBC</li>
<li>The project build runs JUnit tests using Mockito for mock objects</li>
<li>Test coverage must be measuerd using Jacoco, and if the line coverage falls below 60%, the build must fail.</li>
</ul>

<b>RUN</b> Boot2docker and Add commands
<ul>
<li>Run a postgres image:</li>
<li>docker run --name some-postgres -e POSTGRES_PASSWORD=password -e POSTGRES_USER=messagesdb -d postgres</li>
<li>Link the webservice image with the postgres
<li>docker run -p 80:8080 --link some-postgres:db tradeshift/codechallenge</li>
<li>Add a name to DB:</li>
<li>curl -X POST http://{Insert the IP from the boot2docker logs--without port}/messages/names/$name</li>
<li>Get 10 recent results from DB</li>
<li>curl -X GET http://{Insert the IP from the boot2docker logs--without port}/messages/recent</li>
</ul>
