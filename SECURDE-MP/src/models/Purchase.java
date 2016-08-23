package models;

public class Purchase {
	public static final String TABLE_PURCHASE = "purchase";
	
	public static final String COL_PURCHASEID = "purchase_id";
	public static final String COL_QUANTITY = "quantity";
	public static final String COL_PRODUCTID = "product_id";
	public static final String COL_UNITPRICE = "unit_price";
	public static final String COL_TOTALPRICE = "total_price";
	public static final String COL_TRANSACTIONID = "transaction_id";
	
	private int purchaseId;
	private int quantity;
	private int productId;
	private float unitPrice;
	private float totalPrice;
	private int transactionId;
	private int categoryId;
	private String description;
	
	public int getPurchaseId() {
		return purchaseId;
	}
	
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public float getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
