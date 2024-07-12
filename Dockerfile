FROM tomcat:9.0-jdk8

ENV JAVA_OPTS="-Djava.awt.headless=true"

RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY target/goods-inventory.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]



