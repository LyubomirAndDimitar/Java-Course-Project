package Java_Business_Logic;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) 
	{try{Connection conn=JDBC_Dao.getConnction();
	
		System.out.println("1");
	}
	catch (Exception e){
		System.out.println(0);
	}
		// TODO Auto-generated method stub

	}

}
