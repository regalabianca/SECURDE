package models;

public class Category {
	public static final String TABLE_CATEGORY = "category";
	
	public static final String COL_CATEGORYID = "category_id";
	public static final String COL_NAME = "name";
	
	private int categoryId;
	private String categoryName;
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
