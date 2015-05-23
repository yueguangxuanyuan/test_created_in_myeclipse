package ToMysqlDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCon {
	public static void main(String[] args) {
        controlDatabase c = new controlDatabase();
        Connection connection = c.con;
        java.sql.Statement statement;
		ResultSet rs=null;
        try {
			statement = connection.createStatement();
			rs= statement.executeQuery("select * from staff");
			System.out.println(rs);
			while(rs.next()) System.out.println(rs.getString(3));
//			rs= statement.executeQuery("select count(*) from test1");
//			while(rs.next()) System.out.println(rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
