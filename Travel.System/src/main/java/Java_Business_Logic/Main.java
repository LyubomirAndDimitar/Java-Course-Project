package Java_Business_Logic;
//import Java_FX.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.JDBC_Dao;
import Java_Business_Logic.*;
import Java_FX.Table_User;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
		primaryStage.setTitle("Registration Form FXML Application");
		primaryStage.setScene(new Scene(root, 1500, 650));
		primaryStage.show();

	}

	public static void main(String args[]) throws SQLException {
		// String version = System.getProperty("java.version");
		// Label l = new Label ("Hello, JavaFX 11, running on "+version);
		// System.out.println(l);
		launch(args);
		ObservableList<Users> Oblist = FXCollections.observableArrayList();
		String SQL = "SELECT *FROM users";
		Connection conn = JDBC_Dao.getConnction();
		ResultSet rs = conn.createStatement().executeQuery(SQL);

		while (rs.next()) {
			Oblist.add(new Users(rs.getInt("USER_ID"), rs.getString("Full_Name"), rs.getString("User_Name"),
					rs.getString("U_Password"), rs.getString("Email"), rs.getString("Address"),
					rs.getString("Phone_Number"), rs.getInt("Role_ID"), rs.getInt("City_ID"), rs.getInt("Manager_ID")));
		}
		for (int i = 0; i < Oblist.size(); i++) {
			System.out.print(Oblist.get(i).getU_Cl_ID()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_Name()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_UserName()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_Password()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_Email()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_Addres()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_Phone()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_Role()+" ,");
			System.out.print(Oblist.get(i).getU_Cl_City()+" ,");
			System.out.println(Oblist.get(i).getU_Cl_ManagerID());
		}

	}

}