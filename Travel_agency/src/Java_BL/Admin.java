package Java_BL;

public class Admin {
	private  String ID_Admin;
	private  String Name;
	private  String Address;
	private  String Phone;
	private  String Email; 
	private  String User_Name;
	private  String Password;
	
	public Admin() {}
	public Admin(String iD_Admin, String name, String address, String phone, String email, String user_Name,
			String password) {
		this.ID_Admin = iD_Admin;
		this.Name = name;
		this.Address = address;
		this.Phone = phone;
		this.Email = email;
		this.User_Name = user_Name;
		this.Password = password;
	}
	
	public String getID_Admin() {
		return ID_Admin;
	}
	public void setID_Admin(String iD_Admin) {
		this.ID_Admin = iD_Admin;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		this.User_Name = user_Name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	
}