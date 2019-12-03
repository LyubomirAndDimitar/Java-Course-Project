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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import jdk.nashorn.internal.scripts.JD;

public class AdminController implements Initializable{
	@FXML
	private Button U_C_Query;

	@FXML Label A_Name;

	@FXML
	private Label A_ID;

	@FXML
	private TextField A_Support;

	@FXML
	private Button Support_ID;
	
	public Label getA_Name() {
		return A_Name;
	}

	/*public void setA_Name(Label a_Name) {
		A_Name = a_Name;
	}

	public Label getA_ID() {
		return A_ID;
	}

	public void setA_ID(Label a_ID) {
		A_ID = a_ID;
	}

	public String name = JDBC_Dao.NAME_USER;
	
*/
		//System.out.println(name);
		//A_Name.setText(JDBC_Dao.NAME_USER);
	

	@FXML
	void Support_A(ActionEvent event) {

	}
	
	//public void initialize() {
	  //  A_Name.setText(JDBC_Dao.NAME_USER);
	//}
	@FXML
	void User_C_Query(ActionEvent event) {
		//A_Name.setText);
		
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/CreateUser.fxml"));
			stage.setScene(new Scene(root));
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
