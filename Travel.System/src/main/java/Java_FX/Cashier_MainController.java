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

public class Cashier_MainController implements Initializable {
	@FXML
	private Label C_Name;

	@FXML
	private Label C_ID;

	@FXML
	void QueryAndSale(ActionEvent event) {
		Stage stage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/Cashier_AddNewSale.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void initialize(URL location, ResourceBundle resource) {
		C_Name.setText(JDBC_Dao.NAME_USER);
		C_ID.setText(JDBC_Dao.ID_USER);
	}

	@FXML
	void Query_my_sales(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Cashier_ListOfSales.fxml"));
		stage.setScene(new Scene(root));
		stage.show();
	}
}
