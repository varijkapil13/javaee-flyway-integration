# JavaEE Flyway Integration

A sample application that integrates [Flyway](https://flywaydb.org) with a JavaEE Application.

I use
a [Payara Micro Community Edition](https://www.payara.fish/products/payara-platform-community/)
server. But it can be ported to any JavaEE server with almost no extra work. Just remove the payara
dependencies from `pom.xml`.

## Deploy as docker instance

To deploy the project as a docker instance, run the following commands from project root folder

```shell
bash scripts/build-docker-image.sh
docker-compose up
```

This will start the docker containers for postgres and the java application. You can then access the
app on `localhost:8080/flyway`


