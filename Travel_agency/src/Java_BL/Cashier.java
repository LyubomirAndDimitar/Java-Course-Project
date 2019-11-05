package Java_BL;

public class Cashier {
	private  String ID_Cashier;
	private  String Name;
	private  String Address;
	private  String Phone;
	private  String Email; 
	private  String User_Name;
	private  String Password;
	
	public Cashier() {}
	public Cashier(String iD_Cashier, String name, String address, String phone, String email, String user_Name,
			String password) {
		this.ID_Cashier = iD_Cashier;
		this.Name = name;
		this.Address = address;
		this.Phone = phone;
		this.Email = email;
		this.User_Name = user_Name;
		this.Password = password;
	}
	public String getID_Cashier() {
		return ID_Cashier;
	}
	public void setID_Cashier(String iD_Cashier) {
		this.ID_Cashier = iD_Cashier;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getAddress() {
		return this.Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getPhone() {
		return this.Phone;
	}
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	public String getEmail() {
		return this.Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getUser_Name() {
		return this.User_Name;
	}
	public void setUser_Name(String user_Name) {
		this.User_Name = user_Name;
	}
	public String getPassword() {
		return this.Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	
		
}
