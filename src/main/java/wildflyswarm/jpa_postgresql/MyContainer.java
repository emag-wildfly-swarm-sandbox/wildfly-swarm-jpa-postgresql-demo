package wildflyswarm.jpa_postgresql;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jpa.postgresql.PostgreSQLJPAFraction;

public class MyContainer {

  public static Container newContainer() throws Exception {
    Container container = new Container();

    container.fraction(new DatasourcesFraction()
        .jdbcDriver("postgresql", (d) -> {
          d.driverClassName("org.postgresql.Driver");
          d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
          d.driverModuleName("org.postgresql");
        })
        .dataSource("MyDS", (ds) -> {
          ds.driverName("postgresql");
          ds.connectionUrl("jdbc:postgresql://localhost:5432/test");
          ds.userName("postgres");
          ds.password("postgres");
        })
    );

    container.fraction(new PostgreSQLJPAFraction()
        .inhibitDefaultDatasource()
        .defaultDatasource("jboss/datasources/MyDS")
    );

    return container;
  }
}
