package models;

public class Review {

	public static final String TABLE_REVIEW = "review";
	
	public static final String COL_REVIEWID = "review_id";
	public static final String COL_DESCRIPTION = "description";
	public static final String COL_PRODUCTID = "product_id";
	public static final String COL_ACCOUNTID = "account_id";
	
	private int reviewId;
	private String description;
	private int productId;
	private int accountId;
	
	public int getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
