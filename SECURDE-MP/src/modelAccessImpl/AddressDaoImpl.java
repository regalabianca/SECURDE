package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import modelAccess.AddressDao;
import models.Address;

public class AddressDaoImpl implements AddressDao {

	@Override
	public boolean addAddress(Address address) {
		int houseNum = address.getHouseNum();
		String street = address.getStreet();
		String subdivision = address.getSubdivision();
		String city = address.getCity();
		String postalCode = address.getPostalCode();
		String country = address.getCountry();
		int type = address.getType();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + Address.TABLE_ADDRESS + 
														"(" + Address.COL_HOUSENUM + " ," +
														Address.COL_STREET + " ," +
														Address.COL_SUBDIVISION + " ," +
														Address.COL_CITY + " ," +
														Address.COL_POSTAL + " ," +
														Address.COL_COUNTRY + " ," +
														Address.COL_TYPE + " )" + "VALUES(?,?,?,?,?,?,?);");
						
			ps.setInt(1, houseNum);
			ps.setString(2, street);
			ps.setString(3, subdivision);
			ps.setString(4, city);
			ps.setString(5, postalCode);
			ps.setString(6, country);
			ps.setInt(7, type);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Address getAddress(int addressId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Address.TABLE_ADDRESS + 
														" WHERE " + Address.COL_ADDRESSID + " = ?");
			ps.setInt(1, addressId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Address address = new Address();
				address.setAddressid(rs.getInt(Address.COL_ADDRESSID));
				address.setHouseNum(rs.getInt(Address.COL_HOUSENUM));
				address.setStreet(rs.getString(Address.COL_STREET));
				address.setSubdivision(rs.getString(Address.COL_SUBDIVISION));
				address.setCity(rs.getString(Address.COL_CITY));
				address.setPostalCode(rs.getString(Address.COL_POSTAL));
				address.setCountry(rs.getString(Address.COL_COUNTRY));
				address.setType(rs.getInt(Address.COL_TYPE));
				return address;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; 
	}

	@Override
	public void updateAddress(Address address) {
		int houseNum = address.getHouseNum();
		String street = address.getStreet();
		String subdivision = address.getSubdivision();
		String city = address.getCity();
		String postalCode = address.getPostalCode();
		String country = address.getCountry();
		int type = address.getType();
		int addressId = address.getAddressid();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Address.TABLE_ADDRESS + " SET " +  
														Address.COL_HOUSENUM + " =?," +
														Address.COL_STREET + "  =?," +
														Address.COL_SUBDIVISION + " =?," +
														Address.COL_CITY + "  =?," +
														Address.COL_POSTAL + "  =?," +
														Address.COL_COUNTRY + "  =?," +
														Address.COL_TYPE + " =?," +
														" WHERE " + Address.COL_ADDRESSID + "=?;");
			ps.setInt(1, houseNum);
			ps.setString(2, street);
			ps.setString(3, subdivision);
			ps.setString(4, city);
			ps.setString(5, postalCode);
			ps.setString(6, country);
			ps.setInt(7, type);
			ps.setInt(8, addressId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAddress(int addressId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + Address.TABLE_ADDRESS + 
														" WHERE " + Address.COL_ADDRESSID + "=?;");
			ps.setInt(1, addressId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
