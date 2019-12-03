package Java_Business_Logic;

public class UserCredentials {
	public static String UserName;
	public static String Password;
	public static String Name;
	public UserCredentials() {
	}

	public UserCredentials(String userName, String password) {
		UserName = userName;
		Password = password;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	//public User buildUser();
}
