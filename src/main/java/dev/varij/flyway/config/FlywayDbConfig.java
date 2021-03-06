package dev.varij.flyway.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

@Singleton
@Startup
public class FlywayDbConfig {
  
  private static final Logger logger = Logger.getLogger(FlywayDbConfig.class.getName());
  
  @Resource(lookup = "jdbc/_flyway")
  private DataSource dataSource;
  
  @PostConstruct
  private void onStartup() {
    if (dataSource == null) {
      logger.log(Level.SEVERE, "No data source found to perform migrations");
      throw new EJBException("No data source found to perform migrations");
    }
    final Flyway flyway = Flyway
        .configure()
        .dataSource(dataSource)
        .load();
    
    flyway.migrate();
    
    
  }
  
}
