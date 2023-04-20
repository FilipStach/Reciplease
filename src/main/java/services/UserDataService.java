package services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import components.UserData;
import dao.UserDataDao;


@Service
public class UserDataService {
	@Autowired
	UserDataDao userDataDao;
	
	
	public void addUser(UserData user)
	{
		this.userDataDao.addUser(user);
	}

	public List<UserData> getAllUsers()
	{
		return this.userDataDao.getAllUsers();
	}
	public void deleteUser(long id) {
		this.userDataDao.deleteUser(id);
	}
	public void updateUser(long id) {
		this.userDataDao.updateUser(id);
	}
	
}
