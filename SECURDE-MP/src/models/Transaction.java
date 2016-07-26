package models;

public class Transaction {

	public static final String COL_ID = "";
	public static final String COL_UID = "";
	public static final String COL_CREDIT = "";
	public static final String COL_TOTAL = "";
	
	private int id;
	private int userId;
	private int creditCard;
	private int totalPrice;
	
	public Transaction(int id, int userId, int creditCard, int totalPrice) {
		this.id = id;
		this.userId = userId;
		this.creditCard = creditCard;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getCreditCard() {
		return creditCard;
	}
	
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
