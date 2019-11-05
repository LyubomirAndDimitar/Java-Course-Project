package Java_BL;

public class travel_company {
	private  String ID_Travel_Company;
	private  String Name;
	private  String Address;
	private  String Phone;
	private  String Email;

	public travel_company() {}
	public travel_company(String iD_Travel_Company, String name, String address, String phone, String email) {
		this.ID_Travel_Company = iD_Travel_Company;
		this.Name = name;
	    this.Address = address;
		this.Phone = phone;
		this.Email = email;
	}

	public String getID_Travel_Company() {
		return this.ID_Travel_Company;
	}

	public void setID_Travel_Company(String iD_Travel_Company) {
		this.ID_Travel_Company = iD_Travel_Company;
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

}
