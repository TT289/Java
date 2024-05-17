package buoi7;

import java.sql.*;

public class add {
	public static Connection getCon() 
	
	{
		
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=book;user=sa;password=123");
            return conn;
            
          

            
            
        } catch (Exception e) {
            System.out.println(e);
        }
		return null;
		
} 
}