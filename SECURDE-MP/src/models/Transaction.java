package models;

public class Transaction {

	public static final String TABLE_TRANSACTION = "transaction";
	
	public static final String COL_TRANSACTIONID = "transaction_id";
	public static final String COL_ACCOUNTID = "account_id";
	public static final String COL_CREDIT = "";
	public static final String COL_TOTAL = "total_price";
	
	private int transactionId;
	private int accountId;
	private int creditCard;
	private float totalPrice;

	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public int getCreditCard() {
		return creditCard;
	}
	
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
