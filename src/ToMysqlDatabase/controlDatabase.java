package ToMysqlDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class controlDatabase {

	public static void main(String[] args) {
		Date d1 = new Date();
		controlDatabase c = new controlDatabase();
		Date d2 = new Date();
		System.out.println("连接耗时: " + (d2.getTime() - d1.getTime()) + " 毫秒");

		Statement statement;
		try {
			Date d0 = new Date();
			statement = c.con.createStatement();
			Date d = new Date();
			System.out.println("创建语句耗时: " + (d.getTime() - d0.getTime())
					+ " 毫秒");
			Date d3 = new Date();
//			statement.execute("delete from user");
			ResultSet resultSet = statement.executeQuery("select * from user");
			if (resultSet != null && resultSet.next()&&!resultSet.isAfterLast()) {
				do {
                    System.out.println(resultSet.getString("input"));
					resultSet.next();
				} while (!resultSet.isAfterLast());
			} else {
				System.out.println("查询结果集失败");
			}
			Date d4 = new Date();
			long time = d4.getTime() - d3.getTime();
			System.out.println("查询耗时: " + time + " 毫秒");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询失败");
			e.printStackTrace();
		}
	}

	Connection con;

	public controlDatabase() {
		String driver = "com.mysql.jdbc.Driver";
		// String url="jdbc:mysql://localhost:3306/database_homework_b";
		String url = "jdbc:mysql://138.128.211.169:3306/statistic";
		String user = "root";
		String password = "yueguang";

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void select() {
		Statement statement;
		try {
			Date d0 = new Date();
			statement = con.createStatement();
			Date d = new Date();
			System.out.println("创建语句耗时: " + (d.getTime() - d0.getTime())
					+ " 毫秒");
			Date d1 = new Date();
			statement.execute("select * from test1 where id='1999001'");
			Date d2 = new Date();
			long time = d2.getTime() - d1.getTime();
			System.out.println("查询耗时: " + time + " 毫秒");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("查询失败");
	}

	public void insert() {
		try {
			if (con == null || con.isClosed()) {
				System.out.println("database con broke");
				return;
			}
			String[] col1List = { "Mike", "Bob", "Jack", "Alice", "Cathy",
					"Ann", "Betty", "Cindy", "Mary", "Jane" };
			char[] col2List = { 'a', 'b', 'c', 'd', 'e' };
			long time = 0;
			for (int i = 0; i < 10; i++) {
				Statement statement = con.createStatement();
				StringBuilder sql = new StringBuilder(
						"insert into test1 (`col1`,`col2`,`col3`) values");
				for (int j = 0; j < 100000; j++) {
					if (j != 0) {
						sql.append(",");
					}
					String col1 = "'"
							+ col1List[(int) (Math.random() * (col1List.length - 1))]
							+ "'";
					String col2 = "'"
							+ col2List[(int) (Math.random() * (col2List.length - 1))]
							+ col2List[(int) (Math.random() * (col2List.length - 1))]
							+ col2List[(int) (Math.random() * (col2List.length - 1))]
							+ col2List[(int) (Math.random() * (col2List.length - 1))]
							+ col2List[(int) (Math.random() * (col2List.length - 1))]
							+ "'";
					int col3 = (1 + (int) (Math.random() * 999));
					sql.append("(" + col1 + "," + col2 + "," + col3 + ")");
				}
				Date d1 = new Date();
				statement.executeUpdate(sql.toString());
				Date d2 = new Date();
				time += d2.getTime() - d1.getTime();
			}
			System.out.println("耗时: " + time + " 毫秒");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
