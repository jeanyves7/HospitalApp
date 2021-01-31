package hospi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionD {

	//private fields to the database
	private String DataBase;
	private String userName;
	private String pass;
	
	public void setDataBase(String dataBase) {
		DataBase = dataBase;
	}

	ConnectionD(String D,String U,String P){
		this.DataBase=D;
		this.pass=P;
		this.userName=U;
	}
	
	String getDataBase() {
		return this.DataBase;
	}
	
	// method to return the connection to the local database
	Connection getConnection() throws SQLException {
		//String to check time between the JVM and The database
		String check_time="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+check_time,userName,this.pass);
		return connection;
	}
}
