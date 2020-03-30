FROM  adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine

LABEL maintener="hisato@solxyz.co.jp"

RUN adduser -S tomcat \
    && echo "tomcat ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers \
    && echo 'tomcat:tomcat' | chpasswd

EXPOSE 8080

ENV TOMCAT_VERSION 9.0.10
ENV DEPLOY_DIR /maven

USER root

# Install required packages
RUN apk add git maven curl \
 # Get and Unpack Tomcat
 && curl http://archive.apache.org/dist/tomcat/tomcat-9/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz -o /tmp/catalina.tar.gz \
 && tar xzf /tmp/catalina.tar.gz -C /opt \
 && ln -s /opt/apache-tomcat-${TOMCAT_VERSION} /opt/tomcat \
 && chown -R tomcat /opt/tomcat /opt/apache-tomcat-${TOMCAT_VERSION} \
 && rm /tmp/catalina.tar.gz

# Add roles
# ADD tomcat-users.xml /opt/apache-tomcat-${TOMCAT_VERSION}/conf/

# Startup script
# ADD deploy-and-run.sh /opt/apache-tomcat-${TOMCAT_VERSION}/bin/
# RUN chmod 755 /opt/apache-tomcat-${TOMCAT_VERSION}/bin/deploy-and-run.sh \
#  && rm -rf /opt/tomcat/webapps/examples /opt/tomcat/webapps/docs  \
#  && chmod go+rx /opt/tomcat/conf /opt/apache-tomcat-${TOMCAT_VERSION}/conf \
#  && chmod -R go+r /opt/tomcat/conf /opt/apache-tomcat-${TOMCAT_VERSION}/conf \
#  && chgrp -R 0 /opt/tomcat/webapps \
#  && chmod -R g=u /opt/tomcat/webapps

VOLUME [ "/opt/tomcat/logs", "/opt/tomcat/work", "/opt/tomcat/temp"]

ENV CATALINA_HOME /opt/tomcat
ENV PATH $PATH:$CATALINA_HOME/bin

# CMD /opt/tomcat/bin/deploy-and-run.sh

# USER tomcat

# ENTRYPOINT [ "/opt/tomcat/bin/catalina.sh", "run" ]
