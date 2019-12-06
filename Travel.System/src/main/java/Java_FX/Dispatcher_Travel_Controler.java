package Java_FX;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.util.Date;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import JDBC.JDBC_Dao;
import Java_Business_Logic.Travel;
import Java_Business_Logic.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

public class Dispatcher_Travel_Controler implements Initializable {
	private Connection conn = null;
	private PreparedStatement prstmt = null;
	private ObservableList<String> Hours = FXCollections.observableArrayList("0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
	private ObservableList<String> Mins = FXCollections.observableArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
			"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
			"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");

	@FXML
	private TableView<Travel> Table_UTravel;

	@FXML
	private TableColumn<Travel, String> T_ID;

	@FXML
	private TableColumn<Travel, String> T_Date;

	@FXML
	private TableColumn<Travel, String> T_Destination;

	@FXML
	private TableColumn<Travel, String> T_Price;

	@FXML
	private TableColumn<Travel, String> T_Pos;

	@FXML
	private TableColumn<Travel, String> T_Type;

	@FXML
	private TableColumn<Travel, String> T_Casher;

	@FXML
	private TableColumn<Travel, String> T_Tickes_F;

	@FXML
	private TableColumn<Travel, String> T_Tickes_L;
	@FXML
	private TextField Distination;

	@FXML
	private TextField Price;

	@FXML
	private DatePicker Date;
	@FXML
	private TextField Time;
	@FXML
	private TextField Pos;

	@FXML
	private TextField Type;

	@FXML
	private TextField Cashier;

	@FXML
	private TextField Number_Tickets;

	@FXML
	private Button E_ADD;

	@FXML
	private ComboBox<String> hour;

	@FXML
	private ComboBox<String> mins;

	ObservableList<Travel> Oblist = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resource) {
		hour.setValue("--");
		hour.setItems(Hours);
		
		mins.setValue("--");
		mins.setItems(Mins);
		try {
			String SQL = "SELECT *FROM travel";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(
						new Travel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
								rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));

			}

			T_ID.setCellValueFactory(new PropertyValueFactory<Travel, String>("Travel_ID"));
			T_Date.setCellValueFactory(new PropertyValueFactory<Travel, String>("T_Date"));
			T_Destination.setCellValueFactory(new PropertyValueFactory<Travel, String>("Travel_Destination"));
			T_Price.setCellValueFactory(new PropertyValueFactory<Travel, String>("Price"));
			T_Pos.setCellValueFactory(new PropertyValueFactory<Travel, String>("Departion_Pos"));
			T_Type.setCellValueFactory(new PropertyValueFactory<Travel, String>("Travel_Type"));
			T_Casher.setCellValueFactory(new PropertyValueFactory<Travel, String>("Cashier_ID"));
			T_Tickes_F.setCellValueFactory(new PropertyValueFactory<Travel, String>("Number_tickets_sold"));
			T_Tickes_L.setCellValueFactory(new PropertyValueFactory<Travel, String>("Number_tickets_left"));

			Table_UTravel.setItems(Oblist);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@FXML

	void ADD(ActionEvent event) throws SQLException, ClassNotFoundException, ParseException {
		String DATE = Date.getPromptText();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
		String hours=hour.getValue();
		String min=mins.getValue();
		System.out.println(hours+":"+min);
		
		Date dates = simpleDateFormat.parse(DATE);
		String Travel_Destination = this.Distination.getText();
		double price = Double.parseDouble(Price.getText());
		int pos = Integer.parseInt(this.Pos.getText());
		String travel_type = this.Type.getText();

		int cashier = Integer.parseInt(this.Cashier.getText());
		int Number_tickets_f = Integer.parseInt(this.Number_Tickets.getText());
		int Number_tickets_l = 0;

		// String Sql = "INSERT INTO users VALUES()";
		/*
		 * Window owner = E_ADD.getScene().getWindow(); if
		 * (this.Date.getPromptText().isEmpty()) {
		 * AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		 * "Please enter your name"); return; } if
		 * (this.Distination.getText().isEmpty()) {
		 * AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		 * "Please enter your email id"); return; } if (this.Price.getText().isEmpty())
		 * { AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		 * "Please enter a password"); return; }
		 */
		try {
			String SQL = "INSERT INTO travel (T_Date,Travel_Destination,Price,Departion_Pos,Travel_Type,Cashier_ID,Number_tickets_sold,Number_tickets_left) VALUES(?,?,?,?,?,?,0,?)";
			Connection conn = JDBC_Dao.getConnction();
			prstmt = (PreparedStatement) conn.prepareStatement(SQL);
			prstmt.setDate(1, (java.sql.Date) dates);
			prstmt.setString(2, Travel_Destination);
			prstmt.setDouble(3, price);
			prstmt.setInt(4, pos);
			prstmt.setString(5, travel_type);
			prstmt.setInt(6, cashier);
			prstmt.setInt(8, Number_tickets_l);
			prstmt.executeUpdate();
			// JOptionPane.showMessageDialog(null, "Insert suse");
		} catch (SQLException | HeadlessException ex) {
			JOptionPane.showMessageDialog(null, "Insert notsuse");
		}
		// conn.createStatement().executeQuery(Sql);

		// Users user = new Users(rs.getString(1), rs.getString(2), rs.getString(3),
		// rs.getString(4), rs.getString(5),
		// rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
		// rs.getString(10));
		// Oblist.add(user);

	}
}
