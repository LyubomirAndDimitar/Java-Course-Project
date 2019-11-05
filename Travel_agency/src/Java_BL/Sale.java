package Java_BL;

import java.sql.Date;


public class Sale {
	private int ID_Sale;
	private Date Data;
	public Sale() {}
	public Sale(int iD_Sale, Date data) {
		this.ID_Sale = iD_Sale;
		this.Data = data;
	}

	public int getID_Sale() {
		return ID_Sale;
	}

	public void setID_Sale(int iD_Sale) {
		ID_Sale = iD_Sale;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}
	
	
}
