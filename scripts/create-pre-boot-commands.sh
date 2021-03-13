echo "*************** Creating Pre Boot Commands for database connection ***************"

cat > pre-boot-commands.txt << ENDOFFILE
# create a database connection
create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.DataSource --property databaseName=$POSTGRES_DB:portNumber=0:user=$POSTGRES_USER:password=$POSTGRES_PASSWORD:url='jdbc:postgresql://database/$POSTGRES_DB' flyway
create-jdbc-resource --connectionpoolid flyway jdbc/_flyway
ENDOFFILE


echo "*************** Completed ***************"
