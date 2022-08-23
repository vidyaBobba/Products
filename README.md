#1.git clone https://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@github.com/vidyaBobba/justHi

2. cd /jusHi

3. touch Dockerfile -creating the docker file

4. vi Dockerfile - ediitng the docker file

FROM openjdk:12-alpine

COPY justJar.jar /test.jar

CMD ["java", "-jar", "/test.jar"]

5. docker build -t hi:latest . 

6.docker run -p 8023:8080 docker_image_name

