package Java_BL;

public class Customer {
	private  String ID_Customer;
	private  String Name;
	private  String Address;
	private  String Phone;
	private  String Email;
	
	
	public Customer() {}
	public Customer(String iD_Customer, String name, String address, String phone, String email) {
	
		this.ID_Customer = iD_Customer;
		this.Name = name;
		this.Address = address;
		this.Phone = phone;
		this.Email = email;
	}
	public String getID_Customer() {
		return ID_Customer;
	}
	public void setID_Customer(String iD_Customer) {
		this.ID_Customer = iD_Customer;
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
	
}
