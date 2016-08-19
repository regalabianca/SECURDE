package database;

import java.util.ArrayList;

import modelAccess.AccountDao;
import modelAccess.ProductDao;
import modelAccess.PurchaseDao;
import modelAccess.TransactionDao;
import modelAccess.UserDao;
import modelAccessImpl.AccountDaoImpl;
import modelAccessImpl.ProductDaoImpl;
import modelAccessImpl.PurchaseDaoImpl;
import modelAccessImpl.TransactionDaoImpl;
import modelAccessImpl.UserDaoImpl;
import models.Account;
import models.Product;
import models.Purchase;
import models.Transaction;
import models.User;

public class DBManager {
	
	DBConnection connection;
	AccountDao accountDao;
	UserDao userDao;
	ProductDao productDao;
	
	public DBManager(){
		connection = DBConnection.getConnection();
		System.out.println("xxxxxxxx -- DBManager has been contacted! xo");
		accountDao = new AccountDaoImpl();
		userDao = new UserDaoImpl();
		productDao = new ProductDaoImpl();
	}
	
	public Account signup(User user, Account account, String password){
		Account acc = null;
		
		boolean usernameExists = accountDao.checkIfUsernameExists(account.getUsername());
		
		if(!usernameExists){
			boolean addSuccess = userDao.addUser(user);
			System.out.println("addSuccess = " +addSuccess);
			if (addSuccess){
				int userId = userDao.getIdOfUser(user);
				account.setUserId(userId);
				System.out.println("account = "+account);
				System.out.println("password = "+password);
				return accountDao.addAccount(account, password);
			}
		}
		
		return null;	
	}
	
	public String getPassword(String username){
		return accountDao.getPassword(username);
	}
	
	public Account login(String username){
		
		Account acc = accountDao.getAccount(username);
		
		return acc;
	}
	
	public boolean checkIfValidForReview(int accountId, int productId){
		
		boolean valid = false;
		
		ArrayList<Purchase> purch = new ArrayList<>();
		ArrayList<Integer> trans = new ArrayList<>();
		
		PurchaseDao pd = new PurchaseDaoImpl();
		purch = pd.getProductPurchases(productId);
		
		for(int i=0; i<purch.size(); i++)
			trans.add(purch.get(i).getTransactionId());
		
		TransactionDao td = new TransactionDaoImpl();
		
		for(int i=0; i<trans.size();i++){
			Transaction t = new Transaction();
			t = td.getTransaction(trans.get(i));
			if(t.getAccountId() == accountId){
				valid = true;
				break;
			}
		}
		
		return valid;
	}
	
	public int getAttempts(String username){
		return accountDao.getAttempts(username);
	}

	public void setAttempts(String username) {
		accountDao.setAttempts(username);
	}

	public void increaseAttempts(String username) {
		accountDao.updateLastAttempt(username);
	}
	
}