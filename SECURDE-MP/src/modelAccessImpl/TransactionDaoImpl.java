package modelAccessImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import modelAccess.TransactionDao;
import models.Transaction;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public boolean addTransaction(Transaction transaction) {
		int accountId = transaction.getAccountId();
		int creditCard = transaction.getCreditCard();
		float totalPrice = transaction.getTotalPrice();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO " + Transaction.TABLE_TRANSACTION + 
														"(" + Transaction.COL_ACCOUNTID + " ," +
														Transaction.COL_CREDIT + " ," +
														Transaction.COL_TOTAL + " )" + "VALUES(?,?,?);");
						
			ps.setInt(1, accountId);
			ps.setInt(2, creditCard);
			ps.setFloat(3, totalPrice);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Transaction getTransaction(int transactionId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Transaction.TABLE_TRANSACTION + 
														" WHERE " + Transaction.COL_TRANSACTIONID + " = ?");
			ps.setInt(1, transactionId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				Transaction transaction = new Transaction();
				transaction.setTransactionId(rs.getInt(Transaction.COL_TRANSACTIONID));
				transaction.setAccountId(rs.getInt(Transaction.COL_ACCOUNTID));
				transaction.setCreditCard(rs.getInt(Transaction.COL_CREDIT));
				transaction.setTotalPrice(rs.getFloat(Transaction.COL_TOTAL));
				return transaction;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Transaction> getTransactions(int accountId) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM " + Transaction.TABLE_TRANSACTION + 
														" WHERE " + Transaction.COL_ACCOUNTID + " = ?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Transaction transaction = new Transaction();
				transaction.setTransactionId(rs.getInt(Transaction.COL_TRANSACTIONID));
				transaction.setAccountId(rs.getInt(Transaction.COL_ACCOUNTID));
				transaction.setCreditCard(rs.getInt(Transaction.COL_CREDIT));
				transaction.setTotalPrice(rs.getFloat(Transaction.COL_TOTAL));
				transactions.add(transaction);
			}
			return transactions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		int accountId = transaction.getAccountId();
		int creditCard = transaction.getCreditCard();
		float totalPrice = transaction.getTotalPrice();
		int transactionId = transaction.getTransactionId();
		
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE " + Transaction.TABLE_TRANSACTION + " SET " +  
														Transaction.COL_ACCOUNTID + "  =?," +
														Transaction.COL_CREDIT + "  =?," +
														Transaction.COL_TOTAL + " =?" +
														" WHERE " + Transaction.COL_TRANSACTIONID + "=?;");
			ps.setInt(1, accountId);
			ps.setInt(2, creditCard);
			ps.setFloat(3, totalPrice);
			ps.setInt(8, transactionId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTransaction(int transactionId) {
		try {
			Connection con = DBConnection.getConnection().getRawConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM " + Transaction.TABLE_TRANSACTION + 
														" WHERE " + Transaction.COL_TRANSACTIONID + "=?;");
			ps.setInt(1, transactionId);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
