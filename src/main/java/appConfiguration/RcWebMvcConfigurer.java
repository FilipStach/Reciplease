package appConfiguration;

import java.beans.PropertyVetoException;
import java.util.Properties;


import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import components.UserData;


@ComponentScans({
    @ComponentScan("components"),
//    @ComponentScan("appConfiguration"),
    @ComponentScan("controllers"),
    @ComponentScan("dao"),
    @ComponentScan("services")
})
@Configuration
@EnableTransactionManagement
public class RcWebMvcConfigurer implements WebMvcConfigurer {
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
    private String url = "jdbc:mysql://localhost:3307/reciplease";
    private String username = "Filip";
    private String password = "Casio123@";
    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    @Bean
    public DriverManagerDataSource myDataSource() throws PropertyVetoException {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/reciplease?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("Casio123@");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan("components");
        sessionFactory.setAnnotatedClasses(UserData.class);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager TransactionManager() throws PropertyVetoException {
    	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.put(Environment.SHOW_SQL, "true");
        hibernateProperties.put(Environment.HBM2DDL_AUTO, "update"); 
        hibernateProperties.put("hibernate.current_session_context_class", "thread");
        return hibernateProperties;
    }
//    @Bean
//    public SessionFactory getSessionFactory() {
//    	SessionFactory sessionFactory;
//        Properties settings = new Properties();
//        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
//        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//        settings.put(Environment.URL, "jdbc:mysql://localhost:3307/reciplease?useSSL=false");
//        settings.put(Environment.USER, "root");
//        settings.put(Environment.PASS, "Casio123@");
//        settings.put(Environment.SHOW_SQL, "true");
//        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//        settings.put(Environment.HBM2DDL_AUTO, "update");   
//        configuration.setProperties(settings);
//        configuration.addAnnotatedClass(UserData.class);
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//            .applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        return sessionFactory;
//    }

}
