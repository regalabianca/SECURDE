package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import modelAccess.PurchaseDao;
import models.Product;
import models.Purchase;

public class PurchaseDaoImpl implements PurchaseDao {

	@Override
	public boolean addPurchase(Purchase purchase) {
		int quantity = purchase.getQuantity();
		int productId = purchase.getProductId();
		float unitPrice = purchase.getUnitPrice();
		float totalPrice = purchase.getTotalPrice();
		int transactionId = purchase.getTransactionId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + Purchase.TABLE_PURCHASE + 
														"(" + Purchase.COL_QUANTITY + " ," +
														Purchase.COL_PRODUCTID + " ," +
														Purchase.COL_UNITPRICE + " ," +
														Purchase.COL_TOTALPRICE + " ," +
														Purchase.COL_TRANSACTIONID + " )" + "VALUES(?,?,?,?,?);");
						
			ps.setInt(1, quantity);
			ps.setInt(2, productId);
			ps.setFloat(3, unitPrice);
			ps.setFloat(4, totalPrice);
			ps.setInt(5, transactionId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Purchase getPurchase(int purchaseId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Purchase.TABLE_PURCHASE + 
														" WHERE " + Purchase.COL_PURCHASEID + " = ?");
			ps.setInt(1, purchaseId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Purchase purchase = new Purchase();
				purchase.setPurchaseId(rs.getInt(Purchase.COL_PURCHASEID));
				purchase.setQuantity(rs.getInt(Purchase.COL_QUANTITY));
				purchase.setProductId(rs.getInt(Purchase.COL_PRODUCTID));
				purchase.setUnitPrice(rs.getFloat(Purchase.COL_UNITPRICE));
				purchase.setTotalPrice(rs.getFloat(Purchase.COL_TOTALPRICE));
				purchase.setTransactionId(rs.getInt(Purchase.COL_TRANSACTIONID));
				return purchase;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Purchase> getPurchases() {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT "+Purchase.COL_PURCHASEID +","+Product.COL_DESCRIPTION +","+Purchase.COL_QUANTITY+","
														+Purchase.TABLE_PURCHASE+"."+Purchase.COL_PRODUCTID+","+Purchase.COL_UNITPRICE+","+Purchase.COL_TOTALPRICE
														+ "," + Purchase.COL_TRANSACTIONID+","+Product.COL_CATEGORYID
														+" FROM " + Purchase.TABLE_PURCHASE+","+Product.TABLE_PRODUCT 
														+" WHERE purchase."+Purchase.COL_PRODUCTID +" = product."+ Product.COL_PRODUCTID);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Purchase purchase = new Purchase();
				purchase.setPurchaseId(rs.getInt(Purchase.COL_PURCHASEID));
				purchase.setQuantity(rs.getInt(Purchase.COL_QUANTITY));
				purchase.setProductId(rs.getInt(Purchase.COL_PRODUCTID));
				purchase.setUnitPrice(rs.getFloat(Purchase.COL_UNITPRICE));
				purchase.setTotalPrice(rs.getFloat(Purchase.COL_TOTALPRICE));
				purchase.setTransactionId(rs.getInt(Purchase.COL_TRANSACTIONID));
				purchase.setCategoryId(rs.getInt(Product.COL_CATEGORYID));
				purchase.setDescription(rs.getString(Product.COL_DESCRIPTION));
				purchases.add(purchase);
			}
			return purchases;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	} 
	
	public ArrayList<Purchase> getPurchasesCategory(int categoryId) {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT "+Purchase.COL_PURCHASEID+","+Product.COL_DESCRIPTION +","+Purchase.COL_QUANTITY+","
														+Purchase.TABLE_PURCHASE+"."+Purchase.COL_PRODUCTID+","+Purchase.COL_UNITPRICE+","+Purchase.COL_TOTALPRICE
														+ "," + Purchase.COL_TRANSACTIONID+","+Product.COL_CATEGORYID
														+" FROM " + Purchase.TABLE_PURCHASE+","+Product.TABLE_PRODUCT 
														+" WHERE purchase."+Purchase.COL_PRODUCTID +" = product."+ Product.COL_PRODUCTID+" AND product."
														+ Product.COL_CATEGORYID +" = ?");
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Purchase purchase = new Purchase();
				purchase.setPurchaseId(rs.getInt(Purchase.COL_PURCHASEID));
				purchase.setQuantity(rs.getInt(Purchase.COL_QUANTITY));
				purchase.setProductId(rs.getInt(Purchase.COL_PRODUCTID));
				purchase.setUnitPrice(rs.getFloat(Purchase.COL_UNITPRICE));
				purchase.setTotalPrice(rs.getFloat(Purchase.COL_TOTALPRICE));
				purchase.setTransactionId(rs.getInt(Purchase.COL_TRANSACTIONID));
				purchase.setCategoryId(rs.getInt(Product.COL_CATEGORYID));
				purchase.setDescription(rs.getString(Product.COL_DESCRIPTION));
				purchases.add(purchase);
			}
			return purchases;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	} 
	
	public ArrayList<Purchase> getPurchasesDescription(String description) {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT "+Purchase.COL_PURCHASEID+","+Product.COL_DESCRIPTION +","+Purchase.COL_QUANTITY+","
														+Purchase.TABLE_PURCHASE+"."+Purchase.COL_PRODUCTID+","+Purchase.COL_UNITPRICE+","+Purchase.COL_TOTALPRICE
														+ "," + Purchase.COL_TRANSACTIONID+","+Product.COL_CATEGORYID
														+" FROM " + Purchase.TABLE_PURCHASE+","+Product.TABLE_PRODUCT 
														+" WHERE purchase."+Purchase.COL_PRODUCTID +" = product."+ Product.COL_PRODUCTID +" AND product."
														+ Product.COL_DESCRIPTION +" LIKE ?");
			ps.setString(1, "%"+description+"%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Purchase purchase = new Purchase();
				purchase.setPurchaseId(rs.getInt(Purchase.COL_PURCHASEID));
				purchase.setQuantity(rs.getInt(Purchase.COL_QUANTITY));
				purchase.setProductId(rs.getInt(Purchase.COL_PRODUCTID));
				purchase.setUnitPrice(rs.getFloat(Purchase.COL_UNITPRICE));
				purchase.setTotalPrice(rs.getFloat(Purchase.COL_TOTALPRICE));
				purchase.setTransactionId(rs.getInt(Purchase.COL_TRANSACTIONID));
				purchase.setCategoryId(rs.getInt(Product.COL_CATEGORYID));
				purchase.setDescription(rs.getString(Product.COL_DESCRIPTION));
				purchases.add(purchase);
			}
			return purchases;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	} 
	
	@Override
	public ArrayList<Purchase> getPurchases(int purchaseId) {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT "+Purchase.COL_PURCHASEID +","+Product.COL_DESCRIPTION +","+Purchase.COL_QUANTITY+","
					+Purchase.TABLE_PURCHASE+"."+Purchase.COL_PRODUCTID+","+Purchase.COL_UNITPRICE+","+Purchase.COL_TOTALPRICE
					+ "," + Purchase.COL_TRANSACTIONID+","+Product.COL_CATEGORYID
					+" FROM " + Purchase.TABLE_PURCHASE+","+Product.TABLE_PRODUCT 
					+" WHERE purchase."+Purchase.COL_PRODUCTID +" = product."+ Product.COL_PRODUCTID + " AND " + Purchase.COL_PURCHASEID + " = ?");
			ps.setInt(1, purchaseId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Purchase purchase = new Purchase();
				purchase.setPurchaseId(rs.getInt(Purchase.COL_PURCHASEID));
				purchase.setQuantity(rs.getInt(Purchase.COL_QUANTITY));
				purchase.setProductId(rs.getInt(Purchase.COL_PRODUCTID));
				purchase.setUnitPrice(rs.getFloat(Purchase.COL_UNITPRICE));
				purchase.setTotalPrice(rs.getFloat(Purchase.COL_TOTALPRICE));
				purchase.setTransactionId(rs.getInt(Purchase.COL_TRANSACTIONID));
				purchase.setCategoryId(rs.getInt(Product.COL_CATEGORYID));
				purchase.setDescription(rs.getString(Product.COL_DESCRIPTION));
				purchases.add(purchase);
			}
			return purchases;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Purchase> getProductPurchases(int productId) {
		ArrayList<Purchase> purchases = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Purchase.TABLE_PURCHASE +
														" WHERE " + Purchase.COL_PRODUCTID + " = ?");
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Purchase purchase = new Purchase();
				purchase.setPurchaseId(rs.getInt(Purchase.COL_PURCHASEID));
				purchase.setQuantity(rs.getInt(Purchase.COL_QUANTITY));
				purchase.setProductId(rs.getInt(Purchase.COL_PRODUCTID));
				purchase.setUnitPrice(rs.getFloat(Purchase.COL_UNITPRICE));
				purchase.setTotalPrice(rs.getFloat(Purchase.COL_TOTALPRICE));
				purchase.setTransactionId(rs.getInt(Purchase.COL_TRANSACTIONID));
				purchases.add(purchase);
			}
			return purchases;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public void updatePurchase(Purchase purchase) {
		int quantity = purchase.getQuantity();
		int productId = purchase.getProductId();
		float unitPrice = purchase.getUnitPrice();
		float totalPrice = purchase.getTotalPrice();
		int transactionId = purchase.getTransactionId();
		int purchaseId = purchase.getPurchaseId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Purchase.TABLE_PURCHASE + " SET " +  
														Purchase.COL_QUANTITY + " =?," +
														Purchase.COL_PRODUCTID + "  =?," +
														Purchase.COL_UNITPRICE + "  =?," +
														Purchase.COL_TOTALPRICE + "  =?," +
														Purchase.COL_TRANSACTIONID + " =?" +
														" WHERE " + Purchase.COL_PURCHASEID + "=?;");
			ps.setInt(1, quantity);
			ps.setInt(2, productId);
			ps.setFloat(3, unitPrice);
			ps.setFloat(4, totalPrice);
			ps.setInt(5, transactionId);
			ps.setInt(6, purchaseId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletePurchase(int purchaseId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + Purchase.TABLE_PURCHASE + 
														" WHERE " + Purchase.COL_PURCHASEID + "=?;");
			ps.setInt(1, purchaseId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
