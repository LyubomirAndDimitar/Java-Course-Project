package Java_FX;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import JDBC.JDBC_Dao;
import Java_Business_Logic.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table_User implements Initializable {
	public static void Res() throws SQLException {
		ObservableList<Users> Oblist = FXCollections.observableArrayList();
		String SQL = "SELECT *FROM users";
		Connection conn = JDBC_Dao.getConnction();
		ResultSet rs = conn.createStatement().executeQuery(SQL);
		while (rs.next()) {
			Oblist.add(new Users(rs.getInt("U_Cl_ID"), rs.getString("U_Cl_Name"), rs.getString("U_Cl_Phone"),
					rs.getString("U_Cl_UserName"), rs.getString("U_Cl_Password"), rs.getString("U_Cl_Email"),
					rs.getString("U_Cl_Addres"), rs.getInt("U_Cl_Role"), rs.getInt("U_Cl_City"),
					rs.getInt("U_Cl_ManagerID")));
		}
		for(int i=0;i<Oblist.size();i++) {
			System.out.println(Oblist.get(i));
		}
	}
	@FXML
	private TableView<Users> U_Table;
	@FXML
	private TableColumn<Users, String> U_C_ID;

	@FXML
	private TableColumn<Users, String> U_C_Name;

	@FXML
	private TableColumn<Users, String> U_C_Phone;

	@FXML
	private TableColumn<Users, String> U_C_UserName;

	@FXML
	private TableColumn<Users, String> U_C_Password;

	@FXML
	private TableColumn<Users, String> U_C_Email;

	@FXML
	private TableColumn<Users, String> U_C_Addres;

	@FXML
	private TableColumn<Users, String> U_C_Role;

	@FXML
	private TableColumn<Users, String> U_C_City;

	@FXML
	private TableColumn<Users, String> U_C_ManagerID;

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
	ObservableList<Users> Oblist = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resoyrce) {

		/*try {
			String SQL = "SELECT *FROM users";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(new Users(rs.getInt("U_Cl_ID"), rs.getString("U_Cl_Name"), rs.getString("U_Cl_Phone"),
						rs.getString("U_Cl_UserName"), rs.getString("U_Cl_Password"), rs.getString("U_Cl_Email"),
						rs.getString("U_Cl_Addres"), rs.getInt("U_Cl_Role"), rs.getInt("U_Cl_City"),
						rs.getInt("U_Cl_ManagerID")));
			
			}
			for(int i=0;i<Oblist.size();i++) {
				Oblist.get(i);
			}
			U_C_ID.setCellValueFactory(new PropertyValueFactory<Users, String>("U_ID"));
			U_C_Name.setCellValueFactory(new PropertyValueFactory<Users, String>("U_Name"));
			U_C_Phone.setCellValueFactory(new PropertyValueFactory<Users, String>("U_Phone"));
			U_C_UserName.setCellValueFactory(new PropertyValueFactory<Users, String>("U_UserName"));
			U_C_Password.setCellValueFactory(new PropertyValueFactory<Users, String>("U_Password"));
			U_C_Email.setCellValueFactory(new PropertyValueFactory<Users, String>("U_Email"));
			U_C_Addres.setCellValueFactory(new PropertyValueFactory<Users, String>("U_Addres"));
			U_C_Role.setCellValueFactory(new PropertyValueFactory<Users, String>("U_Role"));
			U_C_City.setCellValueFactory(new PropertyValueFactory<Users, String>("U_City"));
			U_C_ManagerID.setCellValueFactory(new PropertyValueFactory<Users, String>("U_ManagerID"));
			U_Table.setItems(Oblist);
		} catch (SQLException e) {

			e.printStackTrace();
		}*/

	}
}
