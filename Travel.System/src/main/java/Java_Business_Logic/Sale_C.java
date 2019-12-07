package Java_Business_Logic;

import javafx.beans.property.SimpleStringProperty;

public class Sale_C {
	private SimpleStringProperty sale_ID;
	private SimpleStringProperty sale_Date;
	private SimpleStringProperty sale_Casher;
	private SimpleStringProperty sale_Travel;
	private SimpleStringProperty sale_Customer;
	
	 public Sale_C() {}

	public Sale_C(String sale_ID, String sale_Date, String sale_Casher,
			String sale_Travel, String sale_Customer) {
		super();
		this.sale_ID = new SimpleStringProperty(sale_ID);
		this.sale_Date = new SimpleStringProperty(sale_Date);
		this.sale_Casher = new SimpleStringProperty(sale_Casher);
		this.sale_Travel = new SimpleStringProperty(sale_Travel);
		this.sale_Customer =new SimpleStringProperty( sale_Customer);
	}

	public String getSale_ID() {
		return sale_ID.get();
	}

	public void setSale_ID(String sale_ID) {
		this.sale_ID.set(sale_ID);
	}

	public String getSale_Date() {
		return sale_Date.get();
	}

	public void setSale_Date(String sale_Date) {
		this.sale_Date.set(sale_Date);
	}

	public String getSale_Casher() {
		return sale_Casher.get();
	}

	public void setSale_Casher(String sale_Casher) {
		this.sale_Casher.set(sale_Casher); ;
	}

	public String getSale_Travel() {
		return sale_Travel.get();
	}

	public void setSale_Travel(String sale_Travel) {
		this.sale_Travel.set(sale_Travel) ;
	}

	public String getSale_Customer() {
		return sale_Customer.get();
	}

	public void setSale_Customer(String sale_Customer) {
		this.sale_Customer.set(sale_Customer);;
	}
	
}

