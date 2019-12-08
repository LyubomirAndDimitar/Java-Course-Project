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

	public String getTravel_ID() {
		return travel_ID.get();
	}

	public void setTravel_ID(String ID) {
		this.travel_ID.set(ID);
	}

	public String getTravel_Date() {
		return travel_Date.get();
	}

	public void setTravel_Date(String Date) {
		this.travel_Date.set(Date);
	}

	public String getTravel_Destination() {
		return travel_Destination.get();
	}

	public void setTravel_Destination(String Destination) {
		this.travel_Destination.set(Destination);
	}

	public String getTravel_Price() {
		return travel_Price.get();
	}

	public void setTravel_Price(String Price) {
		this.travel_Price.set(Price);
	}

	public String getTravel_Pos() {
		return travel_Pos.get();
	}

	public void setTravel_Pos(String Pos) {
		this.travel_Pos.set(Pos);
	}

	public String getTravel_Type() {
		return travel_Type.get();
	}

	public void setTravel_Type(String Type) {
		this.travel_Type.set(Type);
	}

	public String getTravel_Cashier_ID() {
		return travel_Cashier_ID.get();
	}

	public void setTravel_Cashier_ID(String Cashier_ID) {
		this.travel_Cashier_ID.set(Cashier_ID);
	}

	public String getTravel_tickets_first() {
		return travel_tickets_first.get();
	}

	public void setTravel_tickets_first(String tickets_first) {
		this.travel_tickets_first.set(tickets_first);
	}

	public String getTravel_tickets_last() {
		return travel_tickets_last.get();
	}

	public void setTravel_tickets_last(String tickets_last) {
		this.travel_tickets_last.set(tickets_last);
	}

}
