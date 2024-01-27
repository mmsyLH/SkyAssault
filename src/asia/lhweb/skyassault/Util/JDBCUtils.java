package asia.lhweb.skyassault.Util;

import java.sql.*;

/**
 * jdbcutils
 *
 * @author 罗汉
 * @version 1.0 这是一个工具类，完成 mysql的连接和关闭资源
 * @date 2024/01/25
 */
public class JDBCUtils {
	private static final String USER = "root";
	private static final String PWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/oto231210skyassault?useUnicode=true&characterEncoding=UTF-8";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws SQLException {
		JDBCUtils.getConnection();
		System.out.println("ok");
	}
	/**
	 * 驱动的注册
	 */
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到数据库的连接
	 *
	 * @return : 返回数据库的连接
	 * @throws SQLException : SQL的异常
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PWD);
	}

	/**
	 * 关闭所有打开的资源
	 *
	 * @param connection : 连接的对象
	 * @param statement  : 执行SQL语句的对象
	 * @throws SQLException
	 */
	public static void close(Connection connection, Statement statement) throws SQLException {
		close(connection,statement,null);
	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
