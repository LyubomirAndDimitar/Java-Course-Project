package Java_FX;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import JDBC.JDBC_Dao;
import Java_Business_Logic.Travel;
import Java_Business_Logic.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

public class Query_Sale_Controler {
	private Connection conn = null;
	private PreparedStatement prstmt = null;
	@FXML
	private TableView<Travel> Table_Travel;

	@FXML
	private TableColumn<Travel, String> ID;

	@FXML
	private TableColumn<Travel, String> Date;

	@FXML
	private TableColumn<Travel, String> DEstination;

	@FXML
	private TableColumn<Travel, String> Price;

	@FXML
	private TableColumn<Travel, String> Pos;

	@FXML
	private TableColumn<Travel, String> Type;

	@FXML
	private TableColumn<Travel, String> N_T_F;

	@FXML
	private TableColumn<Travel, String> N_T_L;

	@FXML
	private TextField Travel_ID;

	@FXML
	private TextField Custemer_ID;
	ObservableList<Travel> Oblist = FXCollections.observableArrayList();

	private void For_Table() {
		try {
			String SQL = "SELECT *FROM travel";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(new Travel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));

			}

			ID.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_ID"));
			Date.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_Date"));
			DEstination.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_Destination"));
			Price.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_Price"));
			Pos.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_Pos"));
			Type.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_Type"));
			N_T_F.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_tickets_first"));
			N_T_L.setCellValueFactory(new PropertyValueFactory<Travel, String>("travel_tickets_last"));

			Table_Travel.setItems(Oblist);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void initialize(URL location, ResourceBundle resource) {
		For_Table();
	}
	
	@FXML
	void New_Custemer(ActionEvent event) {

	}

	private static final String SQL = "INSERT INTO sale (Date_hour,Cashier,Travel,Customer)" + " VALUES (?,?,?,?);";
	 private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	@FXML
	void Sale(ActionEvent event) {
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 String times=timestamp.toString();
		int Cashierid=Integer.parseInt(JDBC_Dao.ID_USER);
		int Travelid = Integer.parseInt(Travel_ID.getText());
		int Custemerid = Integer.parseInt(Custemer_ID.getText());

		try {
			conn = JDBC_Dao.getConnction();
			prstmt = (PreparedStatement) conn.prepareStatement(SQL);
			prstmt.setString(1,times);
			prstmt.setInt(2, Cashierid);
			prstmt.setInt(3,Travelid);
			prstmt.setInt(4,Custemerid);
			prstmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Insert suse");
		} catch (SQLException | HeadlessException ex) {
			JOptionPane.showMessageDialog(null, "Insert notsuse");
		}
	}

}
