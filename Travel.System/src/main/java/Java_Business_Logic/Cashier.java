package Java_Business_Logic;

public class Cashier {
	private String Name;
	private String User_Name;
	private String Password;
	private String Address;
	private String Phone_number;
	private String Role;
	private String City;

	public Cashier() 
	{}

	public Cashier(String name, String user_Name, String password, String address, String phone_number, String role,
			String city) {

		Name = name;
		User_Name = user_Name;
		Password = password;
		Address = address;
		Phone_number = phone_number;
		Role = role;
		City = city;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

}
