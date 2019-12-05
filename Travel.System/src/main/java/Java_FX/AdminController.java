package Java_FX;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import JDBC.JDBC_Dao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
//import jdk.nashorn.internal.scripts.JD;
import javafx.stage.Window;

public class AdminController implements Initializable {
	@FXML
	private Button U_C_Query;

	@FXML
	private Label A_Name;

	@FXML
	private Label A_ID;

	@FXML
	private TextField A_Support;

	@FXML
	private Button Support_ID;

	public Label getA_Name() {
		return A_Name;
	}

	/*
	 * public void setA_Name(Label a_Name) { A_Name = a_Name; }
	 * 
	 * public Label getA_ID() { return A_ID; }
	 * 
	 * public void setA_ID(Label a_ID) { A_ID = a_ID; }
	 * 
	 * public String name = JDBC_Dao.NAME_USER;
	 * 
	 */
	// System.out.println(name);
	// A_Name.setText(JDBC_Dao.NAME_USER);
	public void initialize(URL location, ResourceBundle resources) {
		A_Name.setText(JDBC_Dao.NAME_USER);
		A_ID.setText(JDBC_Dao.ID_USER);

	}

	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();
	}

	@FXML
	void Support_A(ActionEvent event) throws ClassNotFoundException, SQLException {
		Window owner = Support_ID.getScene().getWindow();

		if (A_Support.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter User name");
			return;
		}
		JDBC_Dao jdbcDao = new JDBC_Dao();
		boolean flag = jdbcDao.Support(A_Support.getText());

		if (!flag) {
			infoBox("Please enter correct User name", null, "Failed");
		} else {
			// infoBox("Login Successful!", null, "Failed");//

			try {

				Stage stage = new Stage();
				if (JDBC_Dao.ROLE == 1) {
					Parent root = FXMLLoader.load(getClass().getResource("/Admin.fxml"));
					stage.setScene(new Scene(root));
					// JDBC_Dao.getConnction();
					// dminController.A_Name.setText(JDBC_Dao.NAME_USER);
				}

				if (JDBC_Dao.ROLE == 3) {

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
		}
	}

	private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

	@FXML
	void User_C_Query(ActionEvent event) {
		// A_Name.setText);

		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/CreateUser.fxml"));
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
