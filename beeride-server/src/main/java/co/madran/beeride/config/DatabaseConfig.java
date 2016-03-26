package co.madran.beeride.config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import co.madran.beeride.security.UserService;

@Configuration
public class DatabaseConfig {
	@Autowired
	private Environment environment;

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
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource
				.setUrl("jdbc:postgresql://beeride.crvevuorggnu.eu-central-1.rds.amazonaws.com/beeride?useUnicode=yes&amp;characterEncoding=UTF-8");
		dataSource.setUsername("bunya");
		dataSource.setPassword("candan99");
		return dataSource;
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

	@Bean
	public EmbeddedServletContainerFactory tomcat() {
		TomcatEmbeddedServletContainerFactory tomcat;
		tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.setPort(environment.getProperty("server.port", Integer.class));
		tomcat.setSessionTimeout(10, TimeUnit.MINUTES);
		return tomcat;
	}
}
