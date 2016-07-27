package models;

public class Product {
	public static final String TABLE_PRODUCT = "product";
	
	public static final String COL_PRODUCTID = "product_id";
	public static final String COL_DESCRIPTION = "price";
	public static final String COL_PRICE = "price";
	public static final String COL_CATEGORYID = "category_id";
	
	private int productId;
	private String description;
	private float price;
	private int categoryId;
	
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
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
