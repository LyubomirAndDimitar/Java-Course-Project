package Java_FX;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {
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

	@FXML
	void Support_A(ActionEvent event) {

	}

	@FXML
	void User_C_Query(ActionEvent event) {
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
