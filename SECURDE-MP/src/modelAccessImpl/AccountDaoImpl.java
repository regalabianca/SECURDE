package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import modelAccess.AccountDao;
import models.Account;
import models.Password;

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
	public boolean isPasswordValid (String password){
		int min = 8;
		int max = 30;
		int up, down, digit, special;
		up = down = digit = special = 0;
		
		int len = password.length();
		
		if(len >= min && len <= max){
			for(int i=0; i<len; i++){
				char c = password.charAt(i);
				if(Character.isUpperCase(c))
					up++;
				if(Character.isLowerCase(c))
					down++;
				if(Character.isDigit(c))
					digit++;
				if(c>=33 && c<=46 || c==64)
					special++;
			}
			if(up>0 && down>0 && digit>0 && special>0)
				return true;
		}
		return false;
	}
	
	@Override
	public int getType (int accountId){
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_ACCOUNTID + " = ?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
				return rs.getInt(Account.COL_TYPE);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -999;
	}
	
	public void updateLastAttempt(String username){
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Account.TABLE_ACCOUNT + " SET failedAttempts = failedAttempts + 1 "
														+ "WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Account addAccount(Account account, String password) {
		String username = account.getUsername();
		int type = account.getType();
		System.out.println("AccountDAO type: " + type);
		int userid = account.getUserId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps;
			if(type != 2 && type !=3){
				ps = con.prepareStatement("INSERT INTO " + Account.TABLE_ACCOUNT + 
														"(" + Account.COL_USERNAME + " ," +
														Account.COL_PASSWORD + " ," +
														Account.COL_TYPE + " ," +
														Account.COL_USERID + " )" + "VALUES(?,?,?,?);");
			}
			else{
				ps = con.prepareStatement("INSERT INTO " + Account.TABLE_ACCOUNT + 
						"(" + Account.COL_USERNAME + " ," +
						Account.COL_DEFAULTPASS + " ," +
						Account.COL_TYPE + " ," +
						Account.COL_USERID + " )" + "VALUES(?,?,?,?);");
			}
						
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, type);
			ps.setInt(4, userid);
			ps.executeUpdate();
			return account;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	public Account getAccount(String username) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Account account = new Account();
				account.setAccountId(rs.getInt(Account.COL_ACCOUNTID));
				account.setUsername(rs.getString(Account.COL_USERNAME));
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
	
	public String getPassword(String username) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Account account = new Account();
				account.setAccountId(rs.getInt(Account.COL_ACCOUNTID));
				account.setUsername(rs.getString(Account.COL_USERNAME));
				account.setType(rs.getInt(Account.COL_TYPE));
				account.setUserId(rs.getInt(Account.COL_USERID));
				return rs.getString(Account.COL_PASSWORD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getDefaultPassword(String username) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Account account = new Account();
				account.setAccountId(rs.getInt(Account.COL_ACCOUNTID));
				account.setUsername(rs.getString(Account.COL_USERNAME));
				account.setType(rs.getInt(Account.COL_TYPE));
				account.setUserId(rs.getInt(Account.COL_USERID));
				return rs.getString(Account.COL_DEFAULTPASS);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void updateAccount(Account account) {
		/*String username = account.getUsername();
		int type = account.getType();
		int userid = account.getUserId();
		int accountId = account.getAccountId();
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Account.TABLE_ACCOUNT + " SET " +  
														Account.COL_USERNAME + " =?," +
														Account.COL_PASSWORD + " =?," +
														Account.COL_TYPE + " =?," +
														Account.COL_USERID + " =?" +
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
		}*/
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

	@Override
	public int getAttempts(String username) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Account.TABLE_ACCOUNT + 
														" WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Account account = new Account();
				return rs.getInt(Account.COL_ATTEMPTS);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void setAttempts(String username) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Account.TABLE_ACCOUNT + " SET failedAttempts = 0 "
														+ "WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean setPassword(String username, String password) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Account.TABLE_ACCOUNT + " SET " + Account.COL_PASSWORD + "=? "
														+ "WHERE " + Account.COL_USERNAME + " = ?");
			ps.setString(1, password);
			ps.setString(2, username);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
