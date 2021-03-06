package Java_FX;

import java.io.IOException;
import java.sql.SQLException;
import JDBC.JDBC_Dao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Login_Controller {

	@FXML
	private TextField UserName;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button submitButton;

	@FXML
	public void login(ActionEvent event) throws SQLException, ClassNotFoundException {

		Window owner = submitButton.getScene().getWindow();

		if (UserName.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email id");
			return;
		}
		if (passwordField.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
			return;
		}

		String emailId = UserName.getText();
		String password = passwordField.getText();

		JDBC_Dao jdbcDao = new JDBC_Dao();
		boolean flag = jdbcDao.validate(emailId, password);

		if (!flag) {
			infoBox("Please enter correct Email and Password", null, "Failed");
		} else {
			// infoBox("Login Successful!", null, "Failed");//

			try {
				int ROLE = JDBC_Dao.ROLE;
				System.out.println(ROLE);
				Stage stage = new Stage();
				if (ROLE == 1) {
					Parent root = FXMLLoader.load(getClass().getResource("/Admin_Main.fxml"));
					stage.setScene(new Scene(root));
					// JDBC_Dao.getConnction();
					// dminController.A_Name.setText(JDBC_Dao.NAME_USER);
				}

				if (ROLE == 3) {

					Parent root = FXMLLoader.load(getClass().getResource("/Dispatcher_Main.fxml"));
					stage.setScene(new Scene(root));
				}
				if (ROLE == 4) {
					Parent root = FXMLLoader.load(getClass().getResource("/Cashier_Main.fxml"));
					stage.setScene(new Scene(root));
				}
				stage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}
			// stage.setTitle("Registration Form FXML Application");
			// stage.setScene(new Scene(root, 500, 650));

		}
	}

	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}

	private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

}