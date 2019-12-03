package Java_FX;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import JDBC.JDBC_Dao;
import Java_Business_Logic.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {

	@FXML
	private TextField UserName;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button submitButton;
	

	@FXML
	public void login(ActionEvent event) throws SQLException, ClassNotFoundException {

		Window owner = submitButton.getScene().getWindow();

		// System.out.println(emailIdField.getText());
		// System.out.println(passwordField.getText());

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

				Stage stage = new Stage();
				if (JDBC_Dao.ROLE == 1) {
					
					Parent root = FXMLLoader.load(getClass().getResource("/Admin.fxml"));
					stage.setScene(new Scene(root));
					//JDBC_Dao.getConnction();
					//dminController.A_Name.setText(JDBC_Dao.NAME_USER);
				}
					
				if (JDBC_Dao.ROLE == 3) {
					
					AdminController ac = new AdminController();
					 ac.A_Name.setText(JDBC_Dao.NAME_USER);
					Parent root = FXMLLoader.load(getClass().getResource("/DispatcherFXML.fxml"));
					stage.setScene(new Scene(root));
				}
				if (JDBC_Dao.ROLE == 4) {
					Parent root = FXMLLoader.load(getClass().getResource("/CashierFXML.fxml"));
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}