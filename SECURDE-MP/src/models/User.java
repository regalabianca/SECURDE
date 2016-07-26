package models;

public class User {
	
	public static final String COL_USERID = "user_id";
	public static final String COL_FNAME = "first_name";
	public static final String COL_MINIT = "middle_initial";
	public static final String COL_LNAME = "last_name";
	public static final String COL_EMAIL = "email";
	public static final String COL_BILLING = "billing_id";
	public static final String COL_SHIPPING = "shipping_id";
	
	private int userid;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String email;
	private int billingAddress;
	private int shippingAddress;

	public User(String firstName, String middleInitial, String lastName, String email, int billingAddress, int shippingAddress){
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.email = email;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(int billingAddress) {
		this.billingAddress = billingAddress;
	}

	public int getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(int shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
}