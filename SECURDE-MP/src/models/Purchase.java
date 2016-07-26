package models;

public class Purchase {
	public static final String COL_PURCHASEID = "";
	public static final String COL_QUANTITY = "";
	public static final String COL_PRODUCTID = "";
	public static final String COL_UNITPRICE = "";
	public static final String COL_TOTALPRICE = "";
	
	private int purchaseId;
	private int quantity;
	private int productId;
	private float unitPrice;
	private float totalPrice;
	
	public Purchase(int quantity, int productId, float unitPrice, float totalPrice) {
		this.quantity = quantity;
		this.productId = productId;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	
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
}
