package Java_FX;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import JDBC.JDBC_Dao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CustemerControler {
	private Connection conn = null;
	private PreparedStatement prstmt = null;
	@FXML
	private TextField Name;

	@FXML
	private TextField Address;

	@FXML
	private TextField Phone;

	@FXML
	private TextField Num_ticetc;
	private static final String SQL_CUS = "INSERT INTO customer (Full_Name,Address,Phone_Number,Number_tickets)"
			+ " VALUES (?,?,?,?);";

	@FXML
	void Add(ActionEvent event) {

		String name = Name.getText();
		String address = Address.getText();
		String phone = Phone.getText();
		int num_t = Integer.parseInt(Num_ticetc.getText());

		try {
			conn = JDBC_Dao.getConnction();
			prstmt = (PreparedStatement) conn.prepareStatement(SQL_CUS);
			prstmt.setString(1, name);
			prstmt.setString(2, address);
			prstmt.setString(3, phone);
			prstmt.setInt(4, num_t);
			prstmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Insert suse");
		} catch (SQLException | HeadlessException ex) {
			JOptionPane.showMessageDialog(null, "Insert notsuse");
		}
	}

}
