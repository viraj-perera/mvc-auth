package vipe.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(value = {BusinessConfig.class, PersistenceConfig.class, SecurityConfiguration.class})
public class RootApplicationContextConfig {

}
