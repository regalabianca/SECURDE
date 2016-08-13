package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import modelAccess.CategoryDao;
import models.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category category) {
		String categoryName = category.getCategoryName();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + Category.TABLE_CATEGORY + 
														"(" + Category.COL_NAME + " )" + "VALUES(?);");
						
			ps.setString(1, categoryName);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Category getCategory(int categoryId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Category.TABLE_CATEGORY + 
														" WHERE " + Category.COL_CATEGORYID + " = ?");
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Category category = new Category();
				category.setCategoryId(rs.getInt(Category.COL_CATEGORYID));
				category.setCategoryName(rs.getString(Category.COL_NAME));
				return category;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateCategory(Category category) {
		String categoryName = category.getCategoryName();
		int categoryId = category.getCategoryId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Category.TABLE_CATEGORY + " SET " +  
														Category.COL_NAME + " =?" +
														" WHERE " + Category.COL_CATEGORYID + "=?;");
			ps.setString(1, categoryName);
			ps.setInt(2, categoryId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCategory(int categoryId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + Category.TABLE_CATEGORY + 
														" WHERE " + Category.COL_CATEGORYID + "=?;");
			ps.setInt(1, categoryId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
