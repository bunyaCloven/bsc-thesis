package co.madran.beeride.integration;

import co.madran.beeride.integration.config.TestDatabaseConfig;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(ClasspathSuite.class)
@ContextConfiguration(classes = { TestDatabaseConfig.class })
public class TestSuite {

}
