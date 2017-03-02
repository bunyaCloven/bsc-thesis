package co.madran.beeride.integration.config;

import co.madran.beeride.security.UserService;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class TestDatabaseConfig {

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    final EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);
    vendorAdapter.setShowSql(false);
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setDataSource(dataSource());
    factory.setJpaProperties(jpaProperties());
    return factory;
  }

  @Bean
  public DataSource dataSource() {
    final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    final EmbeddedDatabase dataSource = builder.setType(EmbeddedDatabaseType.H2)
        .generateUniqueName(true).build();
    return dataSource;
  }

  // @Bean
  // public DataSource dataSource() {
  // final DriverManagerDataSource dataSource = new DriverManagerDataSource();
  // dataSource.setDriverClassName("org.postgresql.Driver");
  // dataSource.setUrl("jdbc:postgresql://localhost/beeride");
  // dataSource.setUsername("postgres");
  // dataSource.setPassword("postgres");
  // return dataSource;
  // // jdbc:postgresql://{host}[:{port}]/[{database}]
  // }

  @Bean
  public DataSourceTransactionManager transactionManager() {
    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
        dataSource());
    return transactionManager;
  }

  @Bean
  public Properties jpaProperties() {
    final Properties properties = new Properties();
    properties.setProperty("eclipselink.weaving", "false");
    properties.setProperty("exclude-unlisted-classes", "false");
    return properties;
  }

  @Bean
  public UserDetailsService userService() {
    return new UserService();
  }
}
