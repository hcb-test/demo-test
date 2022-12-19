# 基于java镜像创建新镜像
FROM daocloud.io/library/java:8u40-b09
# 作者
MAINTAINER demo-test author
# 将jar包添加到容器中
COPY demo-test-0.0.1-SNAPSHOT.jar /usr/local/jenkins_deploy_test/
WORKDIR /usr/local/jenkins_deploy_test
# 运行jar包
ENTRYPOINT ["nohup","java","-jar","/usr/local/jenkins_deploy_test/docker/demo-test-0.0.1-SNAPSHOT.jar","&"]