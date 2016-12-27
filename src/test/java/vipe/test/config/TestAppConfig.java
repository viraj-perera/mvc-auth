package vipe.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by viraj on 12/27/16.
 */
@Configuration
@PropertySource({"classpath:data-access.properties"})
@ComponentScan(basePackages = {"vipe.test.repository","vipe.test.model"})
public class TestAppConfig {

  @Autowired
  private Environment env;

  @Autowired
  private DataSource dataSource;

  @Bean(name = "dataSource")
  public DataSource dataSource() throws SQLException {
    org.springframework.jdbc.datasource.DriverManagerDataSource dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
    dataSource.setUrl(env.getProperty("jdbc.url"));
    dataSource.setUsername(env.getProperty("jdbc.username"));
    dataSource.setPassword(env.getProperty("jdbc.password"));
    return dataSource;
  }

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPersistenceUnitName("vtp_core");
    em.setPackagesToScan("com.rambutech.vtp.domain");
    em.setJpaVendorAdapter(jpaVendorAdaper());
    em.afterPropertiesSet();
    return em.getObject();
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdaper() {

    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
    hibernateJpaVendorAdapter.setShowSql(Boolean.TRUE);
    return hibernateJpaVendorAdapter;
  }

  @Bean(name = "transactionManager")
  public JpaTransactionManager jpaTransactionManager() {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
    return jpaTransactionManager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
