package models;

public class Account {
	
	public static final String COL_USERID = "user_id";
	public static final String COL_USERNAME = "username";
	public static final String COL_PASSWORD = "password";
	public static final String COL_TYPE = "type";

	private int userId;
	private String username;
	private String password;
	private int type;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account(String username, String password, int type) {
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
	public Account(int userId, String username, String password, int type) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.type = type;
	}
	
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
}
