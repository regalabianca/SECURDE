package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import modelAccess.UserDao;
import models.User;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		String firstName = user.getFirstName();
		String middleInitial = user.getMiddleInitial();
		String lastName = user.getLastName();
		String email = user.getEmail();
		int shippindId = user.getShippingAddress();
		int billingId = user.getBillingAddress();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + User.TABLE_USER + 
														"(" + User.COL_FNAME + " ," +
														User.COL_MINIT + " ," +
														User.COL_LNAME + " ," +
														User.COL_EMAIL + " ," +
														User.COL_SHIPPING + " ," +
														User.COL_BILLING + " )" + "VALUES(?,?,?,?,?,?);");
						
			ps.setString(1, firstName);
			ps.setString(2, middleInitial);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setInt(5, shippindId);
			ps.setInt(6, billingId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(int userId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + User.TABLE_USER + 
														" WHERE " + User.COL_USERID + " = ?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				User user = new User();
				user.setUserid(rs.getInt(User.COL_USERID));
				user.setFirstName(rs.getString(User.COL_FNAME));
				user.setMiddleInitial(rs.getString(User.COL_MINIT));
				user.setLastName(rs.getString(User.COL_LNAME));
				user.setEmail(rs.getString(User.COL_EMAIL));
				user.setShippingAddress(rs.getInt(User.COL_SHIPPING));
				user.setBillingAddress(rs.getInt(User.COL_BILLING));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		int userid = user.getUserid();
		String firstName = user.getFirstName();
		String middleInitial = user.getMiddleInitial();
		String lastName = user.getLastName();
		String email = user.getEmail();
		int billing = user.getBillingAddress();
		int shipping = user.getShippingAddress();
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + User.TABLE_USER + " SET " +  
														User.COL_FNAME + " =?," +
														User.COL_MINIT + " =?," +
														User.COL_LNAME + " =?," +
														User.COL_EMAIL + " =?," +
														User.COL_BILLING + " =?," +
														User.COL_SHIPPING + " =?," +
														" WHERE " + User.COL_USERID + "=?;");
			ps.setString(1, firstName);
			ps.setString(2, middleInitial);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setInt(5, billing);
			ps.setInt(6, shipping);
			ps.setInt(7, userid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + User.TABLE_USER + 
														" WHERE " + User.COL_USERID + "=?;");
			ps.setInt(1, userId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getIdOfUser(User user) {
		String firstName = user.getFirstName();
		String middleInitial = user.getMiddleInitial();
		String lastName = user.getLastName();
		String email = user.getEmail();
		int billing = user.getBillingAddress();
		int shipping = user.getShippingAddress();
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + User.TABLE_USER + " WHERE " +  
														User.COL_FNAME + " =? AND " +
														User.COL_MINIT + " =? AND " +
														User.COL_LNAME + " =? AND " +
														User.COL_EMAIL + " =? AND " +
														User.COL_BILLING + " =? AND " +
														User.COL_SHIPPING + "=?;");
			ps.setString(1, firstName);
			ps.setString(2, middleInitial);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setInt(5, billing);
			ps.setInt(6, shipping);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				return rs.getInt(User.COL_USERID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
