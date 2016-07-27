package modelAccess;

import models.Account;

public interface AccountDao {
	public boolean addAccount (Account account);
	public Account getAccount (int accountId);
	public void updateAccount (Account account);
	public void deleteAccount (int userId);
}
