package modelAccess;

import java.util.ArrayList;

import models.Transaction;

public interface TransactionDao {
	public boolean addTransaction (Transaction transaction);
	public Transaction getTransaction (int transactionId);
	public ArrayList<Transaction> getTransactions (int accountId);
	public void updateTransaction (Transaction transaction);
	public void deleteTransaction (int transactionId);
}