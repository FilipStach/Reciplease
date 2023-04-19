package dao;

import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;



import components.UserData;
import jakarta.transaction.Transaction;
import lombok.NoArgsConstructor;

//@Component

public class UserDataDao {
//	@Autowired
	private static SessionFactory sessionFactory;
	public UserDataDao() {


//		this.hiberneteTemplate = new HibernateTemplate();
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3307/reciplease");
//        dataSource.setUsername("root");
//        dataSource.setPassword("Casio123@");
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//        properties.put("hibernate.hbm2ddl.auto", "update");
//        properties.put("hibernate.show_sql", "true");
//	    LocalSessionFactoryBuilder localSessionFactoryBean = new LocalSessionFactoryBuilder(dataSource);   
//	    localSessionFactoryBean.addProperties(properties);
//	    localSessionFactoryBean.addAnnotatedClass(UserData.class);
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        SessionFactory sessionFactory = localSessionFactoryBean.buildSessionFactory();
//        transactionManager.setSessionFactory(sessionFactory);
//	    this.hiberneteTemplate.setSessionFactory(sessionFactory);
		Configuration configuration = new Configuration();

        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3307/reciplease?useSSL=false");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "Casio123@");
        settings.put(Environment.SHOW_SQL, "true");

        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        settings.put(Environment.HBM2DDL_AUTO, "create-drop");

        configuration.setProperties(settings);

        configuration.addAnnotatedClass(UserData.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();

        this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	        
	}
	public void addUser(UserData userData) {
        org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(userData);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List < UserData > getAllUsers() {
        try (Session session = this.sessionFactory.openSession()) {
        	List <UserData> output = session.createQuery("from UserData", UserData.class).list();
        	for( UserData user : output) {
    			System.out.println(user.getPassword());
    		}
        	System.out.println(output.size());
            return output;
        }
    }
//	HibernateTemplate hiberneteTemplate;
	
	
//	@Transactional
//	public void addUser(UserData user)
//	{
//		hiberneteTemplate.save(user);
//	}
//	
//	public List<UserData> getAllUsers()
//	{
//		List<UserData> users = hiberneteTemplate.loadAll(UserData.class);
//		for( UserData user : users) {
//			System.out.println(user.getPassword());
//		}
//		List<UserData> ret = null;
//		return ret;
//	}
//	@Transactional
//	public UserData getUserById(Long id)
//	{
//		
//		
//		UserData user= hiberneteTemplate.get(UserData.class, id);
//		return user;
//	}
//	
//	
//	//update employee
//	
//	@Transactional
//	public void updateUser(UserData user)
//	{
//		hiberneteTemplate.update(user);
//	}
//	
//	
//	//delete employee
//	@Transactional
//	public void deleteUser(Long id)
//	{
//		hiberneteTemplate.delete(hiberneteTemplate.load(UserData.class, id));
//	}
}
