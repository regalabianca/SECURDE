package database;

import java.util.ArrayList;

import modelAccess.AccountDao;
import modelAccess.ProductDao;
import modelAccess.UserDao;
import modelAccessImpl.AccountDaoImpl;
import modelAccessImpl.ProductDaoImpl;
import modelAccessImpl.UserDaoImpl;
import models.Account;
import models.Product;
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
	
	public Account signup(User user, Account account){
		Account acc = null;
		
		boolean usernameExists = accountDao.checkIfUsernameExists(account.getUsername());
		
		if(!usernameExists){
			boolean addSuccess = userDao.addUser(user);
			System.out.println("addSuccess = " +addSuccess);
			if (addSuccess){
				int userId = userDao.getIdOfUser(user);
				account.setUserId(userId);
				accountDao.addAccount(account);
				acc = login(accountDao.getAccount(account.getUserId()));
			}
		}
		
		return acc;	
	}
	
	public Account login(Account account){
		String username = account.getUsername();
		String password = account.getPassword();
		
		Account acc = accountDao.getAccount(username, password);
		
		return acc;
	}
	
	public ArrayList<Product> getProducts(int categoryId){
		return productDao.getProducts(categoryId);
	}
	
	public boolean addProduct(Product product){
		return productDao.addProduct(product);
	}
	
	public void updateProduct(Product product){
		productDao.updateProduct(product);
	}
	
	public void deleteProduct(int productId){
		productDao.deleteProduct(productId);
	}
	
}