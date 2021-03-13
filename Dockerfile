FROM payara/micro

COPY /target/flyway-1.0-SNAPSHOT.war $DEPLOY_DIR/flyway.war
COPY /pre-boot-commands.txt /opt/payara/pre-boot-commands.txt

CMD ["--deploymentdir", "/opt/payara/deployments","--prebootcommandfile", "pre-boot-commands.txt", "--nocluster"]
