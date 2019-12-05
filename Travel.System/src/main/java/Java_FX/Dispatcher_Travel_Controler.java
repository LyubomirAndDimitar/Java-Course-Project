package Java_FX;

import javafx.fxml.FXML;
import java.util.Date;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Dispatcher_Travel_Controler {
	private Connection conn = null;
	private PreparedStatement prstmt = null;
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
	    private TextField Pos;

	    @FXML
	    private TextField Type;

	    @FXML
	    private TextField Cashier;

	    @FXML
	    private TextField Number_Tickets;

	    @FXML
	    private Button E_ADD;

	   
	ObservableList<Travel> Oblist = FXCollections.observableArrayList();

	public void initialize(URL location, ResourceBundle resource) {

		try {
			String SQL = "SELECT *FROM travel";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(new Travel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));

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
	 
	   
	    void ADD(ActionEvent event) throws SQLException, ClassNotFoundException 
	    {		 
		/*	String DATE= Date.getText();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date date = simpleDateFormat.parse("12-01-2018");
				String username = this.username.getText();
				String password = this.password.getText();
				String address = this.address.getText();
				String email = this.email.getText();
				String phone = this.phone.getText();
				int role = Integer.parseInt(this.role.getText());
				int city = Integer.parseInt(this.city.getText());
				int manager_id = Integer.parseInt(this.manager_id.getText());

				// String Sql = "INSERT INTO users VALUES()";
				Window owner = addUserButton.getScene().getWindow();
				if (this.fullName.getText().isEmpty()) {
					AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your name");
					return;
				}
				if (this.email.getText().isEmpty()) {
					AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email id");
					return;
				}
				if (this.address.getText().isEmpty()) {
					AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
					return;
				}
				try {
					String SQL = "INSERT INTO user (Full_Name,User_Name,U_Password,Email,Address,Phone_Number,Role_ID,City_ID,Manager_ID) VALUES(?,?,?,?,?,?,?,?,?)";
					Connection conn = JDBC_Dao.getConnction();
					prstmt = (PreparedStatement) conn.prepareStatement(SQL);
					prstmt.setString(1, fullName);
					prstmt.setString(2, username);
					prstmt.setString(3, password);
					prstmt.setString(4, email);
					prstmt.setString(5, address);
					prstmt.setString(6, phone);
					prstmt.setInt(7, role);
					prstmt.setInt(8, city);
					prstmt.setInt(9, manager_id);
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
		}*/
	 }
}
