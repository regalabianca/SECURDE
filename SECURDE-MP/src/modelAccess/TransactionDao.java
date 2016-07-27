package modelAccess;

import models.Transaction;

public interface TransactionDao {
	public boolean addTransaction (Transaction transaction);
	public Transaction getTransaction (int transactionId);
	public void updateTransaction (Transaction transaction);
	public void deleteTransaction (int transactionId);
}
