package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelAccess.AccountDao;
import modelAccess.UserDao;
import modelAccessImpl.AccountDaoImpl;
import modelAccessImpl.UserDaoImpl;
import models.Account;
import models.User;

public class DBManager {
	
	DBConnection connection;
	AccountDao accountDao;
	UserDao userDao;
	
	public DBManager(){
		connection = DBConnection.getConnection();
		System.out.println("xxxxxxxx -- DBManager has been contacted! xo");
		accountDao = new AccountDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	public Account signup(User user, Account account){
		Account acc = null;
		
		boolean addSuccess = userDao.addUser(user);
		if (addSuccess){
			int userId = userDao.getIdOfUser(user);
			account.setUserId(userId);
			accountDao.addAccount(account);
			acc = login(accountDao.getAccount(account.getUserId()));
		}
	
		return acc;	
	}
	
	public Account login(Account account){
		String username = account.getUsername();
		String password = account.getPassword();
		
		Account acc = accountDao.getAccount(username, password);
		
		return acc;
	}
	
}