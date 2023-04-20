package dao;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import components.UserData;

@Service
public class UserDataDao {
		@Autowired
		private SessionFactory sessionFactory;
		
//		public UserDataDao() {
//		Configuration configuration = new Configuration();
//
//        Properties settings = new Properties();
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
//        this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);        
//	}
//	public void addUser(UserData userData) {
//		
//		System.out.println("Im in");
//		System.out.println("Im out");
//        org.hibernate.Transaction transaction = null;
//        try (Session session = this.sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//            session.save(userData);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//		@Transactional
		public void addUser(UserData user) {
		Session currentSession = sessionFactory.openSession();
//		org.hibernate.Transaction transaction = currentSession.beginTransaction();
//		System.out.println(user.getEmail());
		currentSession.save(user);
//		transaction.commit();
	}
	@Transactional
	public List < UserData > getAllUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
    	List <UserData> output = currentSession.createQuery("from UserData", UserData.class).list();
    	for( UserData user : output) {
			System.out.println(user.getPassword());
		}
    	System.out.println(output.size());
        return output;
    }
	@Transactional
    public void deleteUser(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
        UserData userToDelete = currentSession.get(UserData.class, id);
        if (userToDelete != null) {
        	currentSession.delete(userToDelete);
        }    
    }
	@Transactional
    public void updateUser(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
        UserData userToUpdate = currentSession.get(UserData.class, id);
        if (userToUpdate != null) {
            userToUpdate.setEmail("komputer@wp.pl");
        }
    }

}
//    public List < UserData > getAllUsers() {
//        try (Session session = this.sessionFactory.openSession()) {
//        	List <UserData> output = session.createQuery("from UserData", UserData.class).list();
//        	for( UserData user : output) {
//    			System.out.println(user.getPassword());
//    		}
//        	System.out.println(output.size());
//            return output;
//        }
//    }
//    public void deleteUser(long id) {
//    	org.hibernate.Transaction transaction = null;
//        try (Session session = this.sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//            UserData userToDelete = session.get(UserData.class, id);
//            if (userToDelete != null) {
//            	System.out.println("Problem with deleting");
//            	session.delete(userToDelete);
//            	System.out.println("Problem with saving");
//                transaction.commit();
//            }
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//    public void updateUser(long id) {
//    	org.hibernate.Transaction transaction = null;
//        try (Session session = this.sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//            UserData userToUpdate = session.get(UserData.class, id);
//            if (userToUpdate != null) {
//                userToUpdate.setEmail("filip25092000@wp.pl");
//                transaction.commit();
//            }
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//}
