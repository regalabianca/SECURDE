package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DBConnection;
import models.Product;


public class LogDao {
	public static final String TABLE_PRODUCT = "log";
	
	public static final String COL_ACCOUTNID = "account_id";
	public static final String COL_IP = "ip_address";
	public static final String COL_ERROR = "error_codes";
	
	public boolean addLog(String ip, String message, int account_id){
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + TABLE_PRODUCT + 
														"(" + COL_ACCOUTNID + " ," +
														COL_IP + " ," +
														COL_ERROR + " )" + "VALUES(?,?,?);");
						
			ps.setInt(1, account_id);
			ps.setString(2, ip);
			ps.setString(3, message);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
