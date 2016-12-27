package vipe.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceConfig.class, JPAConfig.class})
public class PersistenceConfig {
}
