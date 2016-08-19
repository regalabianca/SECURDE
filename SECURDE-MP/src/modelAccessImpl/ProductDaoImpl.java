package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import modelAccess.ProductDao;
import models.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		String description = product.getDescription();
		float price = product.getPrice();
		int categoryId = product.getCategoryId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + Product.TABLE_PRODUCT + 
														"(" + Product.COL_DESCRIPTION + " ," +
														Product.COL_PRICE + " ," +
														Product.COL_CATEGORYID + " )" + "VALUES(?,?,?);");
						
			ps.setString(1, description);
			ps.setFloat(2, price);
			ps.setInt(3, categoryId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Product getProduct(int productId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Product.TABLE_PRODUCT + 
														" WHERE " + Product.COL_PRODUCTID + " = ?");
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Product product = new Product();
				product.setProductId(rs.getInt(Product.COL_PRODUCTID));
				product.setDescription(rs.getString(Product.COL_DESCRIPTION));
				product.setPrice(rs.getFloat(Product.COL_PRICE));
				product.setCategoryId(rs.getInt(Product.COL_CATEGORYID));
				return product;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Product> getProducts(int categoryId) {
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Product.TABLE_PRODUCT + 
														" WHERE " + Product.COL_CATEGORYID + " = ?");
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Product product = new Product();
				product.setProductId(rs.getInt(Product.COL_PRODUCTID));
				product.setDescription(rs.getString(Product.COL_DESCRIPTION));
				product.setPrice(rs.getFloat(Product.COL_PRICE));
				product.setCategoryId(rs.getInt(Product.COL_CATEGORYID));
				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Product> getSearchProducts(String search) {
		ArrayList<Product> products = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Product.TABLE_PRODUCT + 
														" WHERE " + Product.COL_DESCRIPTION + " LIKE ?");
			ps.setString(1, "%"+search+"%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Product product = new Product();
				product.setProductId(rs.getInt(Product.COL_PRODUCTID));
				product.setDescription(rs.getString(Product.COL_DESCRIPTION));
				product.setPrice(rs.getFloat(Product.COL_PRICE));
				product.setCategoryId(rs.getInt(Product.COL_CATEGORYID));
				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateProduct(Product product) {
		String description = product.getDescription();
		float price = product.getPrice();
		int categoryId = product.getCategoryId();
		int productId = product.getProductId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Product.TABLE_PRODUCT + " SET " +  
														Product.COL_DESCRIPTION + "  =?," +
														Product.COL_PRICE + "  =?," +
														Product.COL_CATEGORYID + " =?" +
														" WHERE " + Product.COL_PRODUCTID + "=?;");
			ps.setString(1, description);
			ps.setFloat(2, price);
			ps.setInt(3, categoryId);
			ps.setInt(4, productId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(int productId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + Product.TABLE_PRODUCT + 
														" WHERE " + Product.COL_PRODUCTID + "=?;");
			ps.setInt(1, productId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
