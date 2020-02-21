FROM java:8

VOLUME /tmp

ADD *.jar app.jar

RUN sh -c 'touch /app.jar' && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo 'Asia/Shanghai' >/etc/timezone

ENV JAVA_OPTS=""

CMD exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar