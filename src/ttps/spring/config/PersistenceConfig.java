package ttps.spring.config;


import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "ttps.spring" }, transactionManagerRef="transactionManager")
public class PersistenceConfig {

	private static final String MODEL_PACKAGE = "ttps.spring";
	
	
	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] {MODEL_PACKAGE});
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setJpaProperties(additionalProperties());
		return emf;		
	}
		
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("Marta_159");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/javaTTPS?useSSL=false");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return driverManagerDataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(emf);
		return jpaTransactionManager;
	}
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return jpaTransactionManager;
	}
	
	
	
	private Properties additionalProperties() {
		Properties properties = new Properties();		
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.default_schema", "javaTTPS");
		return properties;
	}
		
}
