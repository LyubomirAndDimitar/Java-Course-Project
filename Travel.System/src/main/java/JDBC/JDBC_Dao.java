package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Dao {

	// Replace below database url, username and password with your actual database
	// credentials
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Travel_system?useSSL=false";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "@Lyubomir_Nakov";
	private static final String SELECT_QUERY = "SELECT * FROM users WHERE User_name = ? and U_Password = ?";
	private static final String SELECT_QUERY_SUPPORT = "SELECT * FROM users WHERE User_name = ?";
	public static int ROLE;
	public static String ID_USER;
	public static String NAME_USER;
	public static String PASSWORD;
	public static String USER_NAME;

	public static Connection getConnction() throws SQLException {
		Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		return connection;
	}

	public boolean validate(String User_name, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		// Step 1: Establishing a Connection and
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnction();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) {
			preparedStatement.setString(1, User_name);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				ID_USER = resultSet.getString("User_ID");
				NAME_USER = resultSet.getString("Full_Name");
				USER_NAME=resultSet.getString("User_Name");
				ROLE = resultSet.getInt("Role_ID");
				PASSWORD = resultSet.getString("U_Password");
				System.out.println(USER_NAME + " " + PASSWORD + " " + User_name + " " + password);
				if (USER_NAME.equals(User_name) && PASSWORD.equals(password)) {
					return true;
				} else {
					return false;
				}
			}

		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
		return false;
	}

	public boolean Support(String User_name) throws SQLException, ClassNotFoundException {
		// Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = getConnction();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_SUPPORT);) {
			preparedStatement.setString(1, User_name);

			// System.out.println(preparedStatement);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				ID_USER = resultSet.getString("User_ID");
				NAME_USER = resultSet.getString("Full_Name");
				ROLE = resultSet.getInt("Role_ID");
				return true;
			}

		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
		return false;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}