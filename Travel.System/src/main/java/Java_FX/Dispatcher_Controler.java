package Java_FX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import JDBC.JDBC_Dao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Dispatcher_Controler implements Initializable {

	@FXML
	private Label Name_D;

	@FXML
	private Label ID_D;

	public void initialize(URL location, ResourceBundle resources) {
		Name_D.setText(JDBC_Dao.NAME_USER);
		ID_D.setText(JDBC_Dao.ID_USER);

	}

	@FXML
	public void Travel_Button(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/Dispacher_Travel.fxml"));
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void Queryr_Cashier(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/Query_My_Cashier.fxml"));
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
