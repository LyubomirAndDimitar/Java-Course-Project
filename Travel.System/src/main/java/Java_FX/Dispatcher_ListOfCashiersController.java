package Java_FX;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import JDBC.JDBC_Dao;
import Java_Business_Logic.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Dispatcher_ListOfCashiersController implements Initializable {
	@FXML
	private TableView<User> Table_Cashier;
	@FXML
	private TableColumn<User, String> ID_Cashier;

	@FXML
	private TableColumn<User, String> Name_Cashier;

	@FXML
	private TableColumn<User, String> Phone_Cashier;

	@FXML
	private TableColumn<User, String> Address_Cashier;

	@FXML
	private TableColumn<User, String> Email_Cashier;

	@FXML
	private TableColumn<User, String> City__Cashier;

	ObservableList<User> Oblist = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resource) {

		try {
			String SQL = "SELECT users.User_ID,users.Full_Name,users.Phone_Number,users.Address,users.Email,city.City_Name "
					+ "FROM users " + "JOIN city " + "ON users.City_ID=city.City_ID" + "  WHERE Manager_ID="
					+ JDBC_Dao.ID_USER;
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));

			}

			ID_Cashier.setCellValueFactory(new PropertyValueFactory<User, String>("user_ID"));
			Name_Cashier.setCellValueFactory(new PropertyValueFactory<User, String>("user_Name"));
			Phone_Cashier.setCellValueFactory(new PropertyValueFactory<User, String>("user_Phone"));
			Address_Cashier.setCellValueFactory(new PropertyValueFactory<User, String>("user_Addres"));
			Email_Cashier.setCellValueFactory(new PropertyValueFactory<User, String>("user_Email"));
			City__Cashier.setCellValueFactory(new PropertyValueFactory<User, String>("user_City"));
			Table_Cashier.setItems(Oblist);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
