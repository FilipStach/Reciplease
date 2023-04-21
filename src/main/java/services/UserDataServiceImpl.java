package services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import components.UserData;
import dao.UserDataDao;
import dao.UserDataDaoImpl;


@Service
public class UserDataServiceImpl implements UserDataService {
	@Autowired
	UserDataDao userDataDao;
	
	@Transactional
	public void addUser(UserData user)
	{
		userDataDao.addUser(user);
	}
	@Transactional
	public List<UserData> getAllUsers()
	{
		return this.userDataDao.getAllUsers();
	}
	@Transactional
	public void deleteUser(long id) {
		this.userDataDao.deleteUser(id);
	}
	@Transactional
	public void updateUser(long id) {
		this.userDataDao.updateUser(id);
	}
	@Transactional
	public UserData getByEmail(String email){
		return this.userDataDao.getByEmail(email);
	}
	
}
