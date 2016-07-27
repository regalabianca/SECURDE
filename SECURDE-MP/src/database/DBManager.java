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
		
		if(acc != null)
			System.out.println("[DBManager signup] ACCOUNT before return to servlet");
		else System.out.println("[DBManager signup] ACCOUNT NULL before return to servlet");
		
		return acc;	
	}
	
	public Account login(Account account){
		int userId = account.getUserId();
		String username = account.getUsername();
		String password = account.getPassword();
		int type = account.getType();
		
		Statement s = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			// get account
			s = connection.getRawConnection().createStatement();
			query = "SELECT * FROM account WHERE " +Account.COL_USERNAME+ " = '" +username+ "' AND " +Account.COL_PASSWORD+ " = '" +password+ "';";
			System.out.println("query = " +query);
			rs = s.executeQuery(query);
			
			if(rs.next()){
				account.setUserId(rs.getInt(Account.COL_USERID)); 
				account.setType(type = rs.getInt(Account.COL_TYPE));
			}else { // no result
				System.out.println("Entered rs empty after retrieving account");
				account = null;
			}	
		} catch (SQLException e) {e.printStackTrace();}
		
		if(account != null)
			System.out.println("[DBManager login] ACCOUNT before return to signup");
		else System.out.println("[DBManager login] ACCOUNT NULL before return to signup");
		
		return account;
	}
	
}