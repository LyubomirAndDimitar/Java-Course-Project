package Java_Business_Logic;

import javafx.beans.property.SimpleStringProperty;

public class User {
	private SimpleStringProperty user_ID;
	private SimpleStringProperty user_Name;
	private SimpleStringProperty user_UserName;
	private SimpleStringProperty user_Password;
	private SimpleStringProperty user_Addres;
	private SimpleStringProperty user_Email;
	private SimpleStringProperty user_Phone;
	private SimpleStringProperty user_Role;
	private SimpleStringProperty user_City;
	private SimpleStringProperty user_ManagerID;

	public User() {
	}

	public User(String username, String password) {
		user_UserName.setValue(username);
		user_Password.setValue(password);

	}

	public User(String ID, String Name, String UserName, String Password, String Addres, String Email, String Phone,
			String Role, String City, String ManagerID) {
		this.user_ID = new SimpleStringProperty(ID);
		this.user_Name = new SimpleStringProperty(Name);
		this.user_UserName = new SimpleStringProperty(UserName);
		this.user_Password = new SimpleStringProperty(Password);
		this.user_Addres = new SimpleStringProperty(Addres);
		this.user_Email = new SimpleStringProperty(Email);
		this.user_Phone = new SimpleStringProperty(Phone);
		this.user_Role = new SimpleStringProperty(Role);
		this.user_City = new SimpleStringProperty(City);
		this.user_ManagerID = new SimpleStringProperty(ManagerID);
	}

	public User(String ID, String Name, String Phone, String Addres, String Email, String City) {
		this.user_ID = new SimpleStringProperty(ID);
		this.user_Name = new SimpleStringProperty(Name);
		this.user_Addres = new SimpleStringProperty(Addres);
		this.user_Email = new SimpleStringProperty(Email);
		this.user_Phone = new SimpleStringProperty(Phone);
		this.user_City = new SimpleStringProperty(City);
	}

	public String getUser_ID() {
		return user_ID.get();
	}

	public void setUser_ID(String ID) {
		this.user_ID.set(ID);
	}

	public String getUser_Name() {
		return user_Name.get();
	}

	public void setUser_Name(String Name) {
		this.user_Name.set(Name);
	}

	public String getUser_UserName() {
		return user_UserName.get();
	}

	public void setUser_UserName(String UserName) {
		this.user_UserName.set(UserName);
	}

	public String getUser_Password() {
		return user_Password.get();
	}

	public void setUser_Password(String Password) {
		this.user_Password.set(Password);
	}

	public String getUser_Addres() {
		return user_Addres.get();
	}

	public void setUser_Addres(String Addres) {
		this.user_Addres.set(Addres);
	}

	public String getUser_Email() {
		return user_Email.get();
	}

	public void setUser_Email(String Email) {
		this.user_Email.set(Email);
	}

	public String getUser_Phone() {
		return user_Phone.get();
	}

	public void setUser_Phone(String Phone) {
		this.user_Phone.set(Phone);
	}

	public String getUser_Role() {
		return user_Role.get();
	}

	public void setUser_Role(String Role) {
		this.user_Role.set(Role);
		;
	}

	public String getUser_City() {
		return user_City.get();
	}

	public void setUser_City(String City) {
		this.user_City.set(City);
	}

	public String getUser_ManagerID() {
		return user_ManagerID.get();
	}

	public void setUser_ManagerID(String ManagerID) {
		this.user_ManagerID.set(ManagerID);
	}

}
