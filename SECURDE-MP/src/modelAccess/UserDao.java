package modelAccess;

import models.User;

public interface UserDao {
	public boolean addUser (User user);
	public User getUser (int userId);
	public void updateUser (User user);
	public void deleteUser (int userId);
	public int getIdOfUser (User user);
}
