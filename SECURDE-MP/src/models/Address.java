package models;

public class Address {
	
	public static final String TABLE_ADDRESS = "address";
	
	public static String COL_ADDRESSID = "address_id";
	public static String COL_HOUSENUM = "house_num";
	public static String COL_STREET = "street";
	public static String COL_SUBDIVISION = "subdivision";
	public static String COL_CITY = "city";
	public static String COL_POSTAL = "postal_code";
	public static String COL_COUNTRY = "country";
	public static String COL_TYPE = "type";
	public static String COL_USERID = "user_id";
	
	private int addressid;
	private int houseNum;
	private String street;
	private String subdivision;
	private String city;
	private String postalCode;
	private String country;
	private int userId;
	private int type;
	
	public int getAddressid() {
		return addressid;
	}
	
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	
	public int getHouseNum() {
		return houseNum;
	}
	
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getSubdivision() {
		return subdivision;
	}
	
	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}