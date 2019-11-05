package Java_BL;

import java.sql.Date;

public class Travel {
private int ID_Travel;
private Date date;
private int Number_tickets;
private double Price;
private int Departion_Pos;

public Travel() {
	// TODO Auto-generated constructor stub
}

public Travel(int iD_Travel, Date date, int number_tickets, double price, int departion_Pos) {
	ID_Travel = iD_Travel;
	this.date = date;
	Number_tickets = number_tickets;
	Price = price;
	Departion_Pos = departion_Pos;
}

public int getID_Travel() {
	return this.ID_Travel;
}

public void setID_Travel(int iD_Travel) {
	this.ID_Travel = iD_Travel;
}

public Date getDate() {
	return this.date;
}

public void setDate(Date date) {
	this.date = date;
}

public int getNumber_tickets() {
	return this.Number_tickets;
}

public void setNumber_tickets(int number_tickets) {
	this.Number_tickets = number_tickets;
}

public double getPrice() {
	return this.Price;
}

public void setPrice(double price) {
	this.Price = price;
}

public int getDepartion_Pos() {
	return this.Departion_Pos;
}

public void setDepartion_Pos(int departion_Pos) {
	this.Departion_Pos = departion_Pos;
}



}
