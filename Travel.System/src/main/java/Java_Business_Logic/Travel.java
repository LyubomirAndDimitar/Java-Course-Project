package Java_Business_Logic;

import javafx.beans.property.SimpleStringProperty;

public class Travel {
	private SimpleStringProperty travel_ID;
	private SimpleStringProperty travel_Date;
	private SimpleStringProperty travel_Destination;
	private SimpleStringProperty travel_Price;
	private SimpleStringProperty travel_Pos;
	private SimpleStringProperty travel_Type;
	private SimpleStringProperty travel_Cashier_ID;
	private SimpleStringProperty travel_tickets_first;
	private SimpleStringProperty travel_tickets_last;

	public Travel() {
	}

	public Travel(String ID, String Date, String Destination, String Price, String Pos, String Type, String Cashier_ID,
			String tickets_first, String tickets_last) {

		this.travel_ID = new SimpleStringProperty(ID);
		this.travel_Date = new SimpleStringProperty(Date);
		this.travel_Destination = new SimpleStringProperty(Destination);
		this.travel_Price = new SimpleStringProperty(Price);
		this.travel_Pos = new SimpleStringProperty(Pos);
		this.travel_Type = new SimpleStringProperty(Type);
		this.travel_Cashier_ID = new SimpleStringProperty(Cashier_ID);
		this.travel_tickets_first = new SimpleStringProperty(tickets_first);
		this.travel_tickets_last = new SimpleStringProperty(tickets_last);

	}

	public Travel(String ID, String Date, String Destination, String Price, String Pos, String Type,
			String tickets_first, String tickets_last) {

		this.travel_ID = new SimpleStringProperty(ID);
		this.travel_Date = new SimpleStringProperty(Date);
		this.travel_Destination = new SimpleStringProperty(Destination);
		this.travel_Price = new SimpleStringProperty(Price);
		this.travel_Pos = new SimpleStringProperty(Pos);
		this.travel_Type = new SimpleStringProperty(Type);
		this.travel_tickets_first = new SimpleStringProperty(tickets_first);
		this.travel_tickets_last = new SimpleStringProperty(tickets_last);

	}

	public String getUser_ID() {
		return travel_ID.get();
	}

	public void setUser_ID(String ID) {
		this.travel_ID.set(ID);
	}

	public String getUser_Name() {
		return travel_Date.get();
	}

	public void setUser_Name(String Date) {
		this.travel_Date.set(Date);
	}

	public String getUser_UserName() {
		return travel_Destination.get();
	}

	public void setUser_UserName(String Destination) {
		this.travel_Destination.set(Destination);
	}

	public String getUser_Password() {
		return travel_Price.get();
	}

	public void setUser_Password(String Price) {
		this.travel_Price.set(Price);
	}

	public String getUser_Addres() {
		return travel_Pos.get();
	}

	public void setUser_Addres(String Pos) {
		this.travel_Pos.set(Pos);
	}

	public String getUser_Email() {
		return travel_Type.get();
	}

	public void setUser_Email(String Type) {
		this.travel_Type.set(Type);
	}

	public String getUser_Phone() {
		return travel_Cashier_ID.get();
	}

	public void setUser_Phone(String Cashier_ID) {
		this.travel_Cashier_ID.set(Cashier_ID);
	}

	public String getUser_Role() {
		return travel_tickets_first.get();
	}

	public void setUser_Role(String tickets_first) {
		this.travel_tickets_first.set(tickets_first);
	}

	public String getUser_City() {
		return travel_tickets_last.get();
	}

	public void setUser_City(String tickets_last) {
		this.travel_tickets_last.set(tickets_last);
	}

}
