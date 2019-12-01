package Java_FX;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import JDBC.JDBC_Dao;
import Java_Business_Logic.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table_User implements Initializable {

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

		try {
			String SQL = "SELECT *FROM users";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(
						new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
								rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));

			}
			/*
			 * for(int i=0;i<Oblist.size();i++) { Oblist.get(i).; }
			 */
			U_C_ID.setCellValueFactory(new PropertyValueFactory<Users, String>("user_ID"));
			U_C_Name.setCellValueFactory(new PropertyValueFactory<Users, String>("user_Name"));
			U_C_UserName.setCellValueFactory(new PropertyValueFactory<Users, String>("user_UserName"));
			U_C_Password.setCellValueFactory(new PropertyValueFactory<Users, String>("user_Password"));
			U_C_Addres.setCellValueFactory(new PropertyValueFactory<Users, String>("user_Addres"));
			U_C_Phone.setCellValueFactory(new PropertyValueFactory<Users, String>("user_Phone"));
			U_C_Email.setCellValueFactory(new PropertyValueFactory<Users, String>("user_Email"));
			U_C_Role.setCellValueFactory(new PropertyValueFactory<Users, String>("user_Role"));
			U_C_City.setCellValueFactory(new PropertyValueFactory<Users, String>("user_City"));
			U_C_ManagerID.setCellValueFactory(new PropertyValueFactory<Users, String>("user_ManagerID"));
			U_Table.setItems(Oblist);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/*@FXML
	private Button b_add;

	@FXML
	void add(ActionEvent event) {
		Connection conn;
		try {
			conn = JDBC_Dao.getConnction();

			String Sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?)";

			// conn.createStatement().executeQuery(Sql);
			String full_name = U_FullName.getText();
			String user_name = U_UserName.getText();
			String password = U_Password.getText();
			String address = U_Address.getText();
			String email = U_Email.getText();
			String phone = U_Phone.getText();
			int role = Integer.parseInt(U_Role.getText());
			int city = Integer.parseInt(U_City.getText());
			int manager = Integer.parseInt(U_Manager.getText());
			PreparedStatement prstmt = (PreparedStatement) conn.prepareStatement(Sql);
			prstmt.setString(1, full_name);
			prstmt.setString(2, user_name);
			prstmt.setString(3, password);
			prstmt.setString(4, email);
			prstmt.setString(5, address);
			prstmt.setString(6, phone);
			prstmt.setInt(7, role);
			prstmt.setInt(8, city);
			prstmt.setInt(9, manager);
			prstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 * Users user = new Users(rs.getString(1), rs.getString(2), rs.getString(3),
		 * rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
		 * rs.getString(8), rs.getString(9), rs.getString(10)); Oblist.add(user);
		 */
	}


