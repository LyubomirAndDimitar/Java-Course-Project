package JDBC_Package;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import Java_BL.Travel;

import Java_BL.*;

public class JDBC_CLASS {
//admin
	
	private static final String TABLE_ADMIN="admin";
	private static final String COLUMN_ID_ADMIN="ID_Admin";
	private static final String COLUMN_NAME_ADMIN="Name";
	private static final String COLUMN_ADDRESS_ADMIN="Address";
	private static final String COLUMN_PHONE_ADMIN="Phone";
	private static final String COLUMN_EMAIL_ADMIN="Email"; 
	private static final String COLUMN_USER_NAME_ADMIN="User_Name";
	private static final String COLUMN_PASSWORD_ADMIN="Password";
//cashier
	private static final String TABLE_CASHIRR="cashier";
	private static final String COLUMN_ID_CASHIER="ID_Cashier";
	private static final String COLUMN_NAME_CASHIER="Name";
	private static final String COLUMN_ADDRESS_CASHIER="Address";
	private static final String COLUMN_PHONE_CASHIER="Phone";
	private static final String COLUMN_EMAIL_CASHIER="Email"; 
	private static final String COLUMN_ID_CITY_CASHIER="ID_City";
	private static final String COLUMN_ID_DISPATCHER_CASHIER="ID_Dispatcher";
	private static final String COLUMN_USER_NAME_CASHIER="User_Name";
	private static final String COLUMN_PASSWORD_CASHIER="Password";
	
	//customer
	private static final String TABLE_CUSTOMOR="customer";
	private static final String COLUMN_ID_CUSTOMOR="ID_customer";
	private static final String COLUMN_NAME_CUSTOMOR="Name";
	private static final String COLUMN_ADDRESS_CUSTOMOR="Address";
	private static final String COLUMN_PHONE_CUSTOMOR="Phone";
	private static final String COLUMN_EMAIL_CUSTOMOR="Email"; 
//dispatcher
	private static final String TABLE_DISPATCHER="dispatcher";
	private static final String COLUMN_ID_DISPATCHER="ID_Dispatcher";
	private static final String COLUMN_NAME_DISPATCHER="Name";
	private static final String COLUMN_ADDRESS_DISPATCHER="Address";
	private static final String COLUMN_PHONE_DISPATCHER="Phone";
	private static final String COLUMN_EMAIL_DISPATCHER="Email"; 
	private static final String COLUM_TRAVEL_COMPANY_DISPATCHER ="ID_Travel_Company";
	private static final String COLUMN_USER_NAME_DISPATCHER="User_Name";
	private static final String COLUMN_PASSWORD_DISPATCHER="Password";
//sale
	private static final String TABLE_SALE="sale";
	private static final String COLUMN_ID_SALE="ID_Sele";
	private static final String COLUMN_NAME_DATA_SALE="Data";
	private static final String COLUMN_ID_TRAVEL_SALE="ID_Travel";
//travel
	private static final String TABLE_TRAVEL="travel";
	private static final String COLUMN_ID_TRAVEL="ID_travel";
	private static final String COLUMN_DATE="Date";
	private static final String COLUMN_NUMBER_TICKETS="Number_tickets";
	private static final String COLUMN_PRICE="Price";
	private static final String COLUMN_DEPARTION_POS="Departion_Pos"; 
//travel_company
	private static final String TABLE_TRAVEL_COMPANY="travel_company";
	private static final String COLUMN_ID_TRAVEL_COMPANY="ID_customer";
	private static final String COLUMN_NAME_TRAVEL_COMPANY="Name";
	private static final String COLUMN_ADDRESS_TRAVEL_COMPANY="Address";
	private static final String COLUMN_PHONE_TRAVEL_COMPANY="Phone";
	private static final String COLUMN_EMAIL_TRAVEL_COMPANY="Email"; 
  //city
	private static final String TABLE_CITY="city";
	private static final String COLUMN_ID_CITY="ID_City";
	private static final String COLUMN_CITY="city";
	
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="@Lyubomir_Nakov_17621733";
	private static final String DB_URL="jdbc:mysql://localhost:3306/mys?useSSL=false";
	private Connection CONN ;
	public boolean Open() {
	try {
		CONN =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		//Statement STMT=CONN.createStatement();
		return true;
		//ResultSet myRs=STMT.executeQuery("select *from employees ");
		}
	catch(SQLException e) {
		return false;
		}
	}
	public void close() {
		try {
			CONN.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public List<Travel> queryTravel() {
		Statement statement=null;
		ResultSet results=null;
		try {
			statement=CONN.createStatement();
			results=statement.executeQuery("SELECT * FROM"+TABLE_TRAVEL);
			List<Travel> travel_list = new ArrayList<Travel>();
			while(results.next()) {
				Travel tr= new Travel();
				tr.setDate(results.getDate(COLUMN_DATE));
				tr.setNumber_tickets(results.getInt(COLUMN_NUMBER_TICKETS));
				tr.setDepartion_Pos(results.getInt(COLUMN_DEPARTION_POS));
				tr.setPrice(results.getDouble(COLUMN_PRICE));
				travel_list.add(tr);
			}
			return travel_list;
		}
		catch(SQLException e) {
		
		}
		finally {
			try {
				if(statement !=null) {
					statement.close();
				}
			}
			catch(SQLException sqlex) {
				
			}
		}
		return null;
		
	}
	

}
