package Java_FX;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import JDBC.JDBC_Dao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class AddUserController {
	private PreparedStatement prstmt = null;
	@FXML
	private Button addUserButton;

	@FXML
	private TextField fullName;

	@FXML
	private TextField password;

	@FXML
	private TextField manager_id;

	@FXML
	private TextField city;

	@FXML
	private TextField role;

	@FXML
	private TextField address;

	@FXML
	private TextField phone;

	@FXML
	private TextField username;

	@FXML
	private TextField email;

	@FXML
	void addUser(ActionEvent event) throws SQLException, ClassNotFoundException {

		String fullName = this.fullName.getText();
		String username = this.username.getText();
		String password = this.password.getText();
		String address = this.address.getText();
		String email = this.email.getText();
		String phone = this.phone.getText();
		int role = Integer.parseInt(this.role.getText());
		int city = Integer.parseInt(this.city.getText());
		int manager_id = Integer.parseInt(this.manager_id.getText());

		// String Sql = "INSERT INTO users VALUES()";
		Window owner = addUserButton.getScene().getWindow();
		if (this.fullName.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your name");
			return;
		}
		if (this.email.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email id");
			return;
		}
		if (this.address.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
			return;
		}
		try {
			String SQL = "INSERT INTO user (Full_Name,User_Name,U_Password,Email,Address,Phone_Number,Role_ID,City_ID,Manager_ID) VALUES(?,?,?,?,?,?,?,?,?)";
			Connection conn = JDBC_Dao.getConnction();
			prstmt = (PreparedStatement) conn.prepareStatement(SQL);
			prstmt.setString(1, fullName);
			prstmt.setString(2, username);
			prstmt.setString(3, password);
			prstmt.setString(4, email);
			prstmt.setString(5, address);
			prstmt.setString(6, phone);
			prstmt.setInt(7, role);
			prstmt.setInt(8, city);
			prstmt.setInt(9, manager_id);
			prstmt.executeUpdate();
			// JOptionPane.showMessageDialog(null, "Insert suse");
		} catch (SQLException | HeadlessException ex) {
			JOptionPane.showMessageDialog(null, "Insert notsuse");
		}
		// conn.createStatement().executeQuery(Sql);

		// Users user = new Users(rs.getString(1), rs.getString(2), rs.getString(3),
		// rs.getString(4), rs.getString(5),
		// rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
		// rs.getString(10));
		// Oblist.add(user);

	}
}
