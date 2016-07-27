package models;

public class Address {
	
	public static final String TABLE_ADDRESS = "address";
	
	public static String COL_ADDRESSID = "";
	public static String COL_HOUSENUM = "";
	public static String COL_STREET = "";
	public static String COL_SUBDIVISION = "";
	public static String COL_CITY = "";
	public static String COL_POSTAL = "";
	public static String COL_COUNTRY = "";
	public static String COL_TYPE = "";
	
	private int addressid;
	private int houseNum;
	private String street;
	private String subdivision;
	private String city;
	private String postalCode;
	private String country;
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
}