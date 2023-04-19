package appConfiguration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import components.UserData;
import components.UserRepository;
import dao.UserDataDao;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"components","controllers","dao", "services"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.repository")
public class RcWebMvcConfigurer implements WebMvcConfigurer {
	

	
	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
//	@Value("${spring.datasource.url}")
    private String url = "jdbc:mysql://localhost:3307/reciplease";

//    @Value("${spring.datasource.username}")
    private String username = "Filip";

//    @Value("${spring.datasource.password}")
    private String password = "Casio123@";

//    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SessionFactory getSessionFactory() {
    	LocalSessionFactoryBuilder localSessionFactoryBean = new LocalSessionFactoryBuilder(dataSource());   
    	localSessionFactoryBean.addProperties(hibernateProperties());
    	localSessionFactoryBean.addAnnotatedClass(UserData.class);
        return localSessionFactoryBean.buildSessionFactory() ;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory());
        return transactionManager;
    }
//    @Bean
//    public UserDataDao userDataDao() {
//    	System.out.println("I am using beans instead of Components");
//    	return new UserDataDao();
//    }
    @Bean
    public HibernateTemplate hibernateTemplate() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory( getSessionFactory());
        return hibernateTemplate;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        return properties;
    }
}
