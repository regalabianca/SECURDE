package models;

public class Product {
	public static final String COL_PRODUCTID = "";
	public static final String COL_DESCRIPTION = "";
	public static final String COL_PRICE = "";
	
	private int productId;
	private String description;
	private float price;
	
	public Product(String description, float price ) {
		this.description = description;
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
}
