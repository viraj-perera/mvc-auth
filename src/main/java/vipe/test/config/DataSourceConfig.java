package vipe.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    /**
     * Mail datasource used by the application with the JNDI name "java:/vtpCore"
     * @return
     */
    @Bean(name = "dataSource")
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
        dataSource.setJndiName("java:/mvcAuthTest");
        dataSource.setExpectedType(DataSource.class);
        return dataSource;
    }
}
