package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1500;databaseName=BTL_DP", "sa", "@Nguyenyen2k4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection con){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
	 public static void main(String[] args) {
	        System.out.println(getConnection());
	    }
}
