package modelAccess;

import models.Account;

public interface AccountDao {
	public boolean checkIfUsernameExists (String username);
	public boolean addAccount (Account account, String password);
	public Account getAccount (int accountId);
	public Account getAccount (String username);
	public void updateAccount (Account account);
	public void deleteAccount (int userId);
	public String getPassword (String username);
}
