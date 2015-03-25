# Backend-Tech-Challenge

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
