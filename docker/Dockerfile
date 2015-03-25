FROM ubuntu
MAINTAINER <ach@tradeshift.com>

# RUN echo "deb http://archive.ubuntu.com/ubuntu precise main universe" > /etc/apt/sources.list
RUN apt-get update
RUN apt-get upgrade -y

EXPOSE 8080

RUN apt-get -y install openjdk-7-jre openjdk-7-jdk
RUN apt-get -y install curl
RUN apt-get -y install bash
RUN apt-get -y install unzip


# Install Jetty
ADD http://eclipse.org/downloads/download.php?file=/jetty/stable-8/dist/jetty-distribution-8.1.16.v20140903.tar.gz&r=1 /opt/jetty.tar.gz
RUN tar -xvf /opt/jetty.tar.gz -C /opt/
RUN rm /opt/jetty.tar.gz
RUN mv /opt/jetty-distribution-* /opt/jetty
RUN rm -rf /opt/jetty/webapps.demo
RUN useradd jetty -U -s /bin/false
RUN chown -R jetty:jetty /opt/jetty

ADD root.war /opt/jetty/webapps/

# Start Jetty, this is also the entry point
CMD cd /opt/jetty/ && java -jar start.jar