package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import components.UserData;
import jakarta.persistence.Query;

@Repository
public class UserDataDaoImpl implements UserDataDao {
		@Autowired
		private SessionFactory sessionFactory;

	public void addUser(UserData user) {
		Session currentSession = sessionFactory.getCurrentSession();
		org.hibernate.Transaction transaction = currentSession.beginTransaction();
		currentSession.save(user);
		transaction.commit();
	}
    public List < UserData > getAllUsers() {
        try (Session session = this.sessionFactory.openSession()) {
        	List <UserData> output = session.createQuery("from UserData", UserData.class).list();
            return output;
        }
    }
    public void deleteUser(long id) {
    	org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            UserData userToDelete = session.get(UserData.class, id);
            if (userToDelete != null) {
            	session.delete(userToDelete);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateUser(long id) {
    	org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            UserData userToUpdate = session.get(UserData.class, id);
            if (userToUpdate != null) {
                userToUpdate.setEmail("laptop@wp.pl");
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public UserData getByEmail(String email) {
    	org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List <UserData> output = session.createQuery("from UserData", UserData.class).list();
        	for(UserData user : output) {
    			if(user.getEmail().equals(email) ) {
    				session.close();
    				return user;
    			}
    		}
        	session.close();
        	return null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    	return null;
    }
    public UserData getByUserName(String userName) {
    	org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List <UserData> output = session.createQuery("from UserData", UserData.class).list();
        	for(UserData user : output) {
    			if(user.getUserName().equals(userName) ) {
    				session.close();
    				return user;
    			}
    		}
        	session.close();
        	return null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    	return null;
    }
}

//public void addUser(UserData user) {
//System.out.println("Starting adding");
//Session currentSession = sessionFactory.getCurrentSession();
//currentSession.persist(user);
//}
//public List < UserData > getAllUsers() {
//Session currentSession = sessionFactory.getCurrentSession();
//List <UserData> output = currentSession.createQuery("from UserData", UserData.class).list();
//for( UserData user : output) {
//System.out.println(user.getPassword());
//}
//System.out.println(output.size());
//return output;
//}
//
//public void deleteUser(long id) {
//System.out.println("I am deleting user");
//Session currentSession = sessionFactory.getCurrentSession();
//UserData userToDelete = currentSession.get(UserData.class, id);
//if (userToDelete != null) {
//currentSession.delete(userToDelete);
//}    
//}
//
//public void updateUser(long id) {
//Session currentSession = sessionFactory.getCurrentSession();
//UserData userToUpdate = currentSession.get(UserData.class, id);
//if (userToUpdate != null) {
//userToUpdate.setEmail("komputer@wp.pl");
//}
//}
//
//}
