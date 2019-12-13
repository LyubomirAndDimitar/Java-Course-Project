package Java_FX;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import JDBC.JDBC_Dao;
import Java_Business_Logic.Sale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Cashier_ListOfSalesController implements Initializable {

    @FXML
    private TableView<Sale> Table_Sale;

    @FXML
    private TableColumn<Sale, String> Sale_ID;

    @FXML
    private TableColumn<Sale, String> Data_Sale;

    @FXML
    private TableColumn<Sale, String> Cashier;
    
    @FXML
    private TableColumn<Sale, String> Travel;

    @FXML
    private TableColumn<Sale, String> Customer;
    ObservableList<Sale> Oblist = FXCollections.observableArrayList();
    private void For_Table() {
		try {
			String SQL = "SELECT *FROM sale";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(new Sale(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

			}

			Sale_ID.setCellValueFactory(new PropertyValueFactory<Sale, String>("sale_ID"));
			Data_Sale.setCellValueFactory(new PropertyValueFactory<Sale, String>("sale_Date"));
			Cashier.setCellValueFactory(new PropertyValueFactory<Sale, String>("sale_Casher"));
			Travel.setCellValueFactory(new PropertyValueFactory<Sale, String>("sale_Travel"));
			Customer.setCellValueFactory(new PropertyValueFactory<Sale, String>("sale_Customer"));
Table_Sale.setItems(Oblist);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void initialize(URL location, ResourceBundle resource) {
		For_Table();
	}
	
}

