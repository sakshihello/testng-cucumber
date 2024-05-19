package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTest {

	static final String dburl="jdbc:mysql://localhost:3306/world";
    static final String user="root";
	static final String pass="root";
	static final String qry="select * from city";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
Connection c=DriverManager.getConnection(dburl, user, pass);
Statement st=c.createStatement();
ResultSet r=st.executeQuery(qry);
while(r.next())
{
	System.out.println(r.getString("District"));
}

		
	}

	

}
