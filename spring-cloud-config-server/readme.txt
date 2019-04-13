base url : http://localhost:8888/
Tutorial : https://cloud.spring.io/spring-cloud-static/spring-cloud-config/1.3.3.RELEASE/multi/multi__spring_cloud_config_server.html
http://localhost:8888/limits-service/default --> here limits-service is a file name inside git repo and default is a profile name
http://localhost:8888/limits-service/qa
http://localhost:8888/limits-service/qa

File format:
<file-name>-<profile>.properties
limits-service.properties - default profile
limits-service-dev.properties - dev profile
limits-service-qa.properties - qa profile

NOTE:
 GIT LOCAL : 
  Here git commit is not needed in case of local git repo, it will simply read and even any changes made in git local repo properties file then no need to restart or do any special treatment it will read the updated value without doing anything