package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBConnection {
	
	private static DBConnection databaseConnection;
	private Connection conn;
	private String url;
	private String dbName;
	private String driver;
	private String userName;
	private String password;
	
	public static void main(String[] args){
		new DBConnection();
	}
	
	private DBConnection(){
		url = "jdbc:mysql://localhost:3306/"; 
		dbName = "securde-mp";
		driver = "com.mysql.jdbc.Driver"; 
		userName = "root"; 
		password = "abc123";
		conn = null;
		
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName, userName, password);
			System.out.println("connection success");
		}
		catch(Exception e){
			System.out.println("no connection");
			e.printStackTrace();
		}
	}
	
	public static DBConnection getConnection(){
		if(databaseConnection == null){
			databaseConnection = new DBConnection();
		}
		return databaseConnection;
	}
	
	/* parameter: String query 
	 * returns: ResultSet      */
	public ResultSet query(String query) throws SQLException{
		Statement statement;
		statement = databaseConnection.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		
		return res;
	}

    public int command(String query) throws SQLException{
        Statement statement = databaseConnection.conn.createStatement();
        System.out.println(query);
        statement.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=statement.getGeneratedKeys();
        if(rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }
	
	public Connection getRawConnection(){
		return conn;
	}
	
	public void closeConnection(){
		try{
			databaseConnection.conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
}