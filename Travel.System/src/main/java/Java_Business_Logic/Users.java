package Java_Business_Logic;

public class Users {
	int uclid, U_Cl_Role, U_Cl_City, U_Cl_ManagerID;
	String U_Cl_Email, U_Cl_Name, U_Cl_Phone, U_Cl_UserName, U_Cl_Password, U_Cl_Addres;

	public Users() {
	}

	public Users(int uclid, String u_Cl_Name, String u_Cl_UserName, String u_Cl_Password, String u_Cl_Email,
			String u_Cl_Addres, String u_Cl_Phone, int u_Cl_Role, int u_Cl_City, int u_Cl_ManagerID) {

		this.uclid = uclid;
		U_Cl_Role = u_Cl_Role;
		U_Cl_City = u_Cl_City;
		U_Cl_ManagerID = u_Cl_ManagerID;
		U_Cl_Email = u_Cl_Email;
		U_Cl_Name = u_Cl_Name;
		U_Cl_Phone = u_Cl_Phone;
		U_Cl_UserName = u_Cl_UserName;
		U_Cl_Password = u_Cl_Password;
		U_Cl_Addres = u_Cl_Addres;
	}

	public int getU_Cl_ID() {
		return uclid;
	}

	public void setU_Cl_ID(int u_Cl_ID) {
		uclid = u_Cl_ID;
	}

	public String getU_Cl_Name() {
		return U_Cl_Name;
	}

	public void setU_Cl_Name(String u_Cl_Name) {
		U_Cl_Name = u_Cl_Name;
	}

	public String getU_Cl_UserName() {
		return U_Cl_UserName;
	}

	public void setU_Cl_UserName(String u_Cl_UserName) {
		U_Cl_UserName = u_Cl_UserName;
	}

	public String getU_Cl_Password() {
		return U_Cl_Password;
	}

	public void setU_Cl_Password(String u_Cl_Password) {
		U_Cl_Password = u_Cl_Password;
	}

	public String getU_Cl_Email() {
		return U_Cl_Email;
	}

	public void setU_Cl_Email(String u_Cl_Email) {
		U_Cl_Email = u_Cl_Email;
	}

	public String getU_Cl_Addres() {
		return U_Cl_Addres;
	}

	public void setU_Cl_Addres(String u_Cl_Addres) {
		U_Cl_Addres = u_Cl_Addres;
	}

	public String getU_Cl_Phone() {
		return U_Cl_Phone;
	}

	public void setU_Cl_Phone(String u_Cl_Phone) {
		U_Cl_Phone = u_Cl_Phone;
	}

	public int getU_Cl_Role() {
		return U_Cl_Role;
	}

	public void setU_Cl_Role(int u_Cl_Role) {
		U_Cl_Role = u_Cl_Role;
	}

	public int getU_Cl_City() {
		return U_Cl_City;
	}

	public void setU_Cl_City(int u_Cl_City) {
		U_Cl_City = u_Cl_City;
	}

	public int getU_Cl_ManagerID() {
		return U_Cl_ManagerID;
	}

	public void setU_Cl_ManagerID(int u_Cl_ManagerID) {
		U_Cl_ManagerID = u_Cl_ManagerID;
	}

}
