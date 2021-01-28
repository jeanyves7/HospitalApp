package hospi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionD {

	private String DataBase;
	private String userName;
	private String pass;
	
	ConnectionD(String D,String U,String P){
		this.DataBase=D;
		this.pass=P;
		this.userName=U;
	}
	
	String getDataBase() {
		return this.DataBase;
	}
	
	Connection getConnection() throws SQLException {
		String check_time="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+check_time,userName,this.pass);
		return connection;
	}
}
