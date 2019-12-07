package Java_FX;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import JDBC.JDBC_Dao;
import Java_Business_Logic.Sale_C;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SaleControler implements Initializable {

    @FXML
    private TableView<Sale_C> Table_Sale;

    @FXML
    private TableColumn<Sale_C, String> Sale_ID;

    @FXML
    private TableColumn<Sale_C, String> Data_Sale;

    @FXML
    private TableColumn<Sale_C, String> Cashier;

    @FXML
    private TableColumn<Sale_C, String> Travel;

    @FXML
    private TableColumn<Sale_C, String> Customer;
    ObservableList<Sale_C> Oblist = FXCollections.observableArrayList();
    private void For_Table() {
		try {
			String SQL = "SELECT *FROM sale";
			Connection conn = JDBC_Dao.getConnction();
			ResultSet rs = conn.createStatement().executeQuery(SQL);
			while (rs.next()) {
				Oblist.add(new Sale_C(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

			}

			Sale_ID.setCellValueFactory(new PropertyValueFactory<Sale_C, String>("sale_ID"));
			Data_Sale.setCellValueFactory(new PropertyValueFactory<Sale_C, String>("sale_Date"));
			Cashier.setCellValueFactory(new PropertyValueFactory<Sale_C, String>("sale_Casher"));
			Travel.setCellValueFactory(new PropertyValueFactory<Sale_C, String>("sale_Travel"));
			Customer.setCellValueFactory(new PropertyValueFactory<Sale_C, String>("sale_Customer"));
Table_Sale.setItems(Oblist);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void initialize(URL location, ResourceBundle resource) {
		For_Table();
	}
	
}

