package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

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
				USER_NAME = resultSet.getString("User_Name");
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

	private static int N_T_E;
	private static int N_T_S;
	private static int C_T;

	private static boolean Trav_T(int tr) {
		String trStr=((Integer)tr).toString();
		String SELECT_T = "select Number_tickets_sold,Number_tickets_left from travel WHERE Travel_ID=" + trStr +";" ;
		try (Connection connection = getConnction();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_T);) {
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				N_T_E = Integer.parseInt(resultSet.getString("Number_tickets_sold"));
				N_T_S = Integer.parseInt(resultSet.getString("Number_tickets_left"));
				if (N_T_S != 0) {
					return true;
				} else
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static boolean Cus_T(int customer) {
		String cusStr=((Integer)customer).toString();
		String SELECT_C = "select Number_tickets from customer WHERE Customer_ID=" + cusStr+";";
		try (Connection connection = getConnction();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_C);) {
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				C_T = Integer.parseInt(resultSet.getString("Number_tickets"));

				if (C_T != 0) {
					return true;
				} else
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static void Update_Travel(int Travel_tickets) throws SQLException {
		String UPDATE_TRAVEL = "update travel SET  Number_tickets_sold=" + N_T_E + " ,Number_tickets_left= " + N_T_S
				+ "WHERE Travel_ID= " + Travel_tickets;
		try (Connection conn = getConnction(); Statement prstmt = (Statement) conn.createStatement();) {

			prstmt.executeUpdate(UPDATE_TRAVEL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void Update_Custemer(int Custemer_tickets) throws SQLException {
		String UPDATE_CUSTEMER = "update customer SET  Number_tickets=" + C_T + " WHERE Customer_ID="
				+ Custemer_tickets;
		try (Connection conn = getConnction(); Statement stmt = (Statement) conn.createStatement();) {

			stmt.executeUpdate(UPDATE_CUSTEMER);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Updates(int Travel_tickets, int Customer_tickets) throws SQLException {
		try {
			boolean Trav = Trav_T(Travel_tickets);
			boolean Cus = Cus_T(Customer_tickets);
			if (Trav && Cus) {
				N_T_S--;
				N_T_E++;
				C_T--;
				Update_Travel(Travel_tickets);
				Update_Custemer(Customer_tickets);
				System.out.println(N_T_E + "/" + N_T_S + "/" + C_T);
				// return true;
			} else if (Trav == false) {
				JOptionPane.showMessageDialog(null, "No travel tickets");
				// return false;
			} else if (Cus == false) {
				JOptionPane.showMessageDialog(null, "No customer tickets");
				// return false;
			} else {
				JOptionPane.showMessageDialog(null, "No travel and customer tickets");
				// return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return false;
	}
}