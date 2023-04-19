package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import components.UserData;
import dao.UserDataDao;

@Component
public class UserDataService {
//	@Autowired
	UserDataDao userDataDao = new UserDataDao();
	
	
	
	public void addUser(UserData user)
	{
		userDataDao.addUser(user);
	}

	public List<UserData> getAllUsers()
	{
		return userDataDao.getAllUsers();
	}
	
	
	
//	public UserData getById(Long id)
//	{
//		return userDataDao.getUserById(id);
//	}
//	
//	
//	
//	public void updateEmp(UserData user)
//	{
//		userDataDao.updateUser(user);
//	}
//	
//	
//	
//	public void deleteUser(Long id)
//	{
//		userDataDao.deleteUser(id);
//	}
}
