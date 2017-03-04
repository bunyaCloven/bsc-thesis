package co.madran.beeride.integration.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class PropertiesConfiguration {
  @Bean
  public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer()
      throws IOException {
    final List<Resource> resources = new LinkedList<>();
    resources.addAll(Arrays.asList(new PathMatchingResourcePatternResolver()
        .getResources("classpath*:application.properties")));
    final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
    ppc.setLocations(resources.toArray(new Resource[] {}));

    return ppc;
  }
}
