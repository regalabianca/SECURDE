package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import modelAccess.AccountDao;
import models.Account;

public class AccountDaoImpl implements AccountDao {
	
	@Override
	public boolean checkIfUsernameExists (String username){
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean addAccount(Account account) {
		String username = account.getUsername();
		String password = account.getPassword();
		int type = account.getType();
		int userid = account.getUserId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + Account.TABLE_ACCOUNT + 
														"(" + Account.COL_USERNAME + " ," +
														Account.COL_PASSWORD + " ," +
														Account.COL_TYPE + " ," +
														Account.COL_USERID + " )" + "VALUES(?,?,?,?);");
						
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, type);
			ps.setInt(4, userid);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account getAccount(int userId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_USERID + " = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Account account = new Account();
				account.setAccountId(rs.getInt(Account.COL_ACCOUNTID));
				account.setUsername(rs.getString(Account.COL_USERNAME));
				account.setPassword(rs.getString(Account.COL_PASSWORD));
				account.setType(rs.getInt(Account.COL_TYPE));
				account.setUserId(rs.getInt(Account.COL_USERID));
				return account;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccount(String username, String password) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_USERNAME + " = ?"
														+ " AND " + Account.COL_PASSWORD + " = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Account account = new Account();
				account.setAccountId(rs.getInt(Account.COL_ACCOUNTID));
				account.setUsername(rs.getString(Account.COL_USERNAME));
				account.setPassword(rs.getString(Account.COL_PASSWORD));
				account.setType(rs.getInt(Account.COL_TYPE));
				account.setUserId(rs.getInt(Account.COL_USERID));
				return account;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateAccount(Account account) {
		String username = account.getUsername();
		String password = account.getPassword();
		int type = account.getType();
		int userid = account.getUserId();
		int accountId = account.getAccountId();
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Account.TABLE_ACCOUNT + " SET " +  
														Account.COL_USERNAME + " =?," +
														Account.COL_PASSWORD + " =?," +
														Account.COL_TYPE + " =?," +
														Account.COL_USERID + " =?," +
														" WHERE " + Account.COL_ACCOUNTID + "=?;");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, type);
			ps.setInt(4, userid);
			ps.setInt(5, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(int accountId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_ACCOUNTID + "=?;");
			ps.setInt(1, accountId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
