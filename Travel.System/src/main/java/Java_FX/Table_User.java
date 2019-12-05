package Java_FX;

import java.awt.HeadlessException;

import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import JDBC.JDBC_Dao;
import Java_Business_Logic.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

// Petq Ivanova,Petq,Petq_passswodd,Petq_60@gmail.com,Plovdiv mladost 5,0876532154,3,6,8
public class Table_User implements Initializable {

	private Connection conn = null;
	private PreparedStatement prstmt = null;
	@FXML
	private TableView<User> U_Table;
	@FXML
	private TableColumn<User, String> U_C_ID;

	@FXML
	private TableColumn<User, String> U_C_Name;

	@FXML
	private TableColumn<User, String> U_C_Phone;

	@FXML
	private TableColumn<User, String> U_C_UserName;

	@FXML
	private TableColumn<User, String> U_C_Password;

	@FXML
	private TableColumn<User, String> U_C_Email;

	@FXML
	private TableColumn<User, String> U_C_Addres;

	@FXML
	private TableColumn<User, String> U_C_Role;

	@FXML
	private TableColumn<User, String> U_C_City;

	@FXML
	private TableColumn<User, String> U_C_ManagerID;

	@FXML
	private TextField U_FullName;

	@FXML
	private TextField U_UserName;

	@FXML
	private TextField U_Password;

	@FXML
	private TextField U_Email;

	@FXML
	private TextField U_Address;

	@FXML
	private TextField U_Phone;

	@FXML
	private TextField U_Role;

	@FXML
	private TextField U_City;

	@FXML
	private TextField U_Manager;

	@FXML
	private Button addUserButton;
	private static final String SQL = "INSERT INTO users (Full_Name,User_Name,U_Password,Email,Address,Phone_Number,Role_ID,City_ID,Manager_ID)"
			+ " VALUES (?,?,?,?,?,?,?,?,?);";

	@FXML
	public void add(ActionEvent event) throws SQLException, ClassNotFoundException {

		String full_name = U_FullName.getText();
		String user_name = U_UserName.getText();
		String password = U_Password.getText();
		String address = U_Address.getText();
		String email = U_Email.getText();
		String phone = U_Phone.getText();
		int role = Integer.parseInt(U_Role.getText());
		int city = Integer.parseInt(U_City.getText());
		int manager = Integer.parseInt(U_Manager.getText());

		// String Sql = "INSERT INTO users VALUES()";
		Window owner = addUserButton.getScene().getWindow();
		if (U_FullName.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter name");
			return;
		}
		if (U_Email.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter  email ");
			return;
		}
		if (U_Address.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter  address");
			return;
		}
		if (U_City.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter  City");
			return;
		}
		if (U_Role.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter Role");
			return;
		}
		try {
			conn = JDBC_Dao.getConnction();
			prstmt = (PreparedStatement) conn.prepareStatement(SQL);
			prstmt.setString(1, full_name);
			prstmt.setString(2, user_name);
			prstmt.setString(3, password);
			prstmt.setString(4, email);
			prstmt.setString(5, address);
			prstmt.setString(6, phone);
			prstmt.setInt(7, role);
			prstmt.setInt(8, city);
			prstmt.setInt(9, manager);
			prstmt.executeUpdate();
			
			// JOptionPane.showMessageDialog(null, "Insert suse");
		} catch (SQLException | HeadlessException ex) {
			JOptionPane.showMessageDialog(null, "Insert notsuse");
		} // //
		conn.createStatement().executeUpdate(SQL);

		// Users user = new Users(rs.getString(1), rs.getString(2), rs.getString(3),
		// rs.getString(4), rs.getString(5), // rs.getString(6), rs.getString(7),
		// rs.getString(8), rs.getString(9), rs.getString(10)); // Oblist.add(user);

	}

	/*
	 * @FXML public void addUser(ActionEvent event) throws SQLException,
	 * ClassNotFoundException, IOException { Stage stage = new Stage(); Parent root
	 * = FXMLLoader.load(getClass().getResource("/AddUser.fxml"));
	 * stage.setScene(new Scene(root)); stage.show(); }
	 */
	ObservableList<User> Oblist = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resource) {

		try {
			String SQL = "SELECT *FROM users";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));

			}

			U_C_ID.setCellValueFactory(new PropertyValueFactory<User, String>("user_ID"));
			U_C_Name.setCellValueFactory(new PropertyValueFactory<User, String>("user_Name"));
			U_C_UserName.setCellValueFactory(new PropertyValueFactory<User, String>("user_UserName"));
			U_C_Password.setCellValueFactory(new PropertyValueFactory<User, String>("user_Password"));
			U_C_Addres.setCellValueFactory(new PropertyValueFactory<User, String>("user_Addres"));
			U_C_Phone.setCellValueFactory(new PropertyValueFactory<User, String>("user_Phone"));
			U_C_Email.setCellValueFactory(new PropertyValueFactory<User, String>("user_Email"));
			U_C_Role.setCellValueFactory(new PropertyValueFactory<User, String>("user_Role"));
			U_C_City.setCellValueFactory(new PropertyValueFactory<User, String>("user_City"));
			U_C_ManagerID.setCellValueFactory(new PropertyValueFactory<User, String>("user_ManagerID"));
			U_Table.setItems(Oblist);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}