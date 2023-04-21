package dao;

import java.util.List;
import components.UserData;

public interface UserDataDao {
	public void addUser(UserData user);
	
	public List < UserData > getAllUsers();
	
	public void deleteUser(long id);
	
	public void updateUser(long id);
	
	public UserData getByEmail(String email);
}
