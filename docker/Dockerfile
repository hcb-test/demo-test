# 基于java镜像创建新镜像
FROM java:8
# 作者
MAINTAINER demo-test author
VOLUME /tmp
# 将jar包添加到容器中
COPY target/demo-test-0.0.1-SNAPSHOT.jar /usr/local/server/
# 运行jar包
ENTRYPOINT ["nohup","java","-jar","/usr/local/server/demo-test-0.0.1-SNAPSHOT.jar","&"]