package models;

public class Category {
	public static final String COL_ID = "";
	public static final String COL_NAME = "";
	
	private int id;
	private String name;
	
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
