package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Account;
import models.User;

public class DBManager {
	
	DBConnection connection;
	
	public DBManager(){
		connection = DBConnection.getConnection();
		System.out.println("xxxxxxxx -- DBManager has been contacted! xo");
	}
	
	public Account signup(User user, Account account){
		
		// from user
		String fname = user.getFirstName();
		String minit = user.getMiddleInitial();
		String lname = user.getLastName();
		String email = user.getEmail();
		int billingId = user.getBillingAddress();
		int shippingId = user.getShippingAddress();
		
		// from account
		String username = account.getUsername();
		String password = account.getPassword();
		int type = account.getType();
		
		Account acc = null;
		Statement s = null;
		ResultSet rs = null;
		String query = "";
		int result = 0;
		int user_id = -999;
		
		// save to user table
		try {
			s = connection.getRawConnection().createStatement();
			query = "INSERT INTO user (" +User.COL_FNAME+ ", " +User.COL_MINIT+ ", " +User.COL_LNAME+ ", " +User.COL_EMAIL+ ", " +User.COL_BILLING+ ", " +User.COL_SHIPPING+ ") VALUES ('"
	                +fname+ "', '" +minit+ "', '" +lname+ "', '" +email+ "', '" +billingId+ "', '" +shippingId+ "');";
			System.out.println("query = " + query );
			result = s.executeUpdate(query);
		} catch (SQLException e) {e.printStackTrace();}
		
		if (result > 0){
			try {			
				s = connection.getRawConnection().createStatement();
				
				// get user_id
				query = "SELECT " +User.COL_USERID+ " FROM user WHERE " 
						+User.COL_FNAME+ " = '" +fname+ "' AND " +User.COL_MINIT+ " = '" +minit+ "' AND " +User.COL_LNAME+ " = '" +lname+ "' AND " 
						+User.COL_EMAIL+ " = '" +email+ "' AND " +User.COL_BILLING+ " = '" +billingId+ "' AND " +User.COL_SHIPPING+ " = '" +shippingId+ "';";
				System.out.println("query = "+query);
				rs = s.executeQuery(query);
				
				if(rs.next())
					user_id = rs.getInt(User.COL_USERID);
				
				// insert into account table
				query = "INSERT INTO account (" +Account.COL_USERNAME+ ", " +Account.COL_PASSWORD+ ", " +Account.COL_TYPE+ ", " +Account.COL_USERID+ ") VALUES ('"
						+username+ "', '" +password+ "', '" +type+ "', '" +user_id+ "');";
				System.out.println( "query = " + query );
				result = s.executeUpdate(query);
				
				if(result > 0)
					acc = login(new Account(user_id, username, password, type));
				else{
					// delete entry from user table because there is an error in account
					query = "DELETE FROM user WHERE " +User.COL_USERID+ " = '" +user_id+ "';";
					s.executeUpdate(query);
				}
			} catch (SQLException e) {e.printStackTrace();}
		} 
		
		if(acc != null)
			System.out.println("[DBManager signup] ACCOUNT before return to servlet");
		else System.out.println("[DBManager signup] ACCOUNT NULL before return to servlet");
		
		return acc;	
		
//		// from account
//		String username = account.getUsername();
//		String password = account.getPassword();
//		int type = account.getType();
//		
//		// from user
//		String fname = user.getFirstName();
//		String minit = user.getMiddleInitial();
//		String lname = user.getLastName();
//		String email = user.getEmail();
//		int billingId = user.getBillingAddress();
//		int shippingId = user.getShippingAddress();
//		
//		Account acc = null;
//		Statement s = null;
//		String query = "";
//		int result = 0;
//		
//		// save to account table
//		try {
//			s = connection.getRawConnection().createStatement();
//			query = "INSERT INTO account (" +Account.COL_USERNAME+ ", " +Account.COL_PASSWORD+ ", " + Account.COL_TYPE+ ") VALUES ('"
//					+ username + "', '" + password + "', '" +type+ "');";
//			System.out.println( "query = " + query );
//			result = s.executeUpdate(query);
//		} catch (SQLException e) {e.printStackTrace();}
//		
//		// save to user table
//		if (result > 0){
//			try {
//				s = connection.getRawConnection().createStatement();
//				query = "INSERT INTO user (" +User.COL_FNAME+ ", " +User.COL_MINIT+ ", " +User.COL_LNAME+ ", " +User.COL_EMAIL+ ", " +User.COL_BILLING+ ", " +User.COL_SHIPPING+ ") VALUES ('"
//		                + fname + "', '" + minit + "', '" + lname + "', '" +email+ "', '" + billingId + "', '" +shippingId+ "');";
//				System.out.println("query = " + query );
//				result = s.executeUpdate(query);
//								
//				acc = login(new Account(username, password, type));
//			} catch (SQLException e) {e.printStackTrace();}
//		}
//		
//		if(acc != null)
//			System.out.println("[DBManager signup] ACCOUNT before return to servlet");
//		else System.out.println("[DBManager signup] ACCOUNT NULL before return to servlet");
//		
//		return acc;	
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
		
//		int userId = -999;
//		String username = account.getUsername();
//		String password = account.getPassword();
//		int type = account.getType();
//		
//		Statement s = null;
//		ResultSet rs = null;
//		String query = "";
//		
//		try {
//			// get account
//			s = connection.getRawConnection().createStatement();
//			query = "SELECT " +Account.COL_USERID+ " FROM user WHERE username = '" +username+ "';";
//			System.out.println("query = " +query);
//			rs = s.executeQuery(query);
//			
//			// if account exists
//			if (rs.next()){
//				// get and set userId of account 
//				userId = rs.getInt(Account.COL_USERID);
//				account.setUserId(userId);
//				
//				query = "UPDATE account SET " +Account.COL_USERID+ " = '" +userId+ "' WHERE " +Account.COL_USERNAME+ " = '" +username+ "';";
//				int ok = s.executeUpdate(query);
//				
//				if(ok > 0)
//					System.out.println("UPDATED user_id = "+userId);
//				else System.out.println("NO USER ID UPDATED");
//				
//				query = "SELECT * FROM account WHERE " +Account.COL_USERID+ " = '" +userId+ "' AND " +Account.COL_USERNAME+ " = '" +username+ "'"
//						+ " AND " +Account.COL_PASSWORD+ " = '" +password+ "' AND " +Account.COL_TYPE+ " = '" +type+ "';";
//				System.out.println("query = " + query );
//				rs = s.executeQuery(query);
//			
//				if(!rs.next())
//					account = null;
//			}else{
//				account = null;
//			}
//				
//		} catch (SQLException e) {e.printStackTrace();}
//		
//		if(account != null)
//			System.out.println("[DBManager login] ACCOUNT before return to signup");
//		else System.out.println("[DBManager login] ACCOUNT NULL before return to signup");
//		
//		return account;
	}
	
}