package jp.co.solxyz.lessons.posting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 抽象化されたDAO
 * @author HISATO
 *
 */
public class AbstractDao {

	private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/posting?useSSL=false";
	private static final String user = "root";
	private static final String password = "root";

	/**
	 * コネクション取得
	 * @return コネクション
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		return DriverManager.getConnection(CONNECTION_STRING, user, password);
	}

}
