package models;

public class Account {
	
	public static final String TABLE_ACCOUNT = "account";
	
	public static final String COL_ACCOUNTID = "account_id";
	public static final String COL_USERID = "user_id";
	public static final String COL_USERNAME = "username";
	public static final String COL_PASSWORD = "password";
	public static final String COL_TYPE = "type";
	public static final String COL_ATTEMPTS = "failedAttempts";
	
	private int userId;
	private String username;
	private int type;
	private int accountId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
