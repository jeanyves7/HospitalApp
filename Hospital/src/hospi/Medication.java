package hospi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Medication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {


		//Establishing connection with mysql via localhost  port number:3306 to the database schema demo and checking the timing zone 

		//PLEASE NOTE THAT: database name: Hospital  // User: root // Password : admin
		//Feel free to chose the database name of your choice
		//If you need to modify any of these parameters:
		String database_name="Hospital";
		String User="root";
		String Password="admin";
		ConnectionD connect=new ConnectionD(database_name,User,Password);

		//this string serve to check time of the sql and java console application 
		String check_time="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		
		
		Connection connection=connect.getConnection();
		Statement myStmt=connection.createStatement();

		//Create the database if it doesn't exists
		myStmt.execute("CREATE DATABASE IF NOT EXISTS "+ database_name );
		//use the chosen database
		myStmt.execute("USE "+ database_name);


		//Drop the tables if they exists
		String if_exists_Hosp="DROP TABLE IF EXISTS HOSP";
		myStmt.executeUpdate(if_exists_Hosp);

		//creating the new  Hospital table
		String CREATE_TABLE_HOSP="CREATE TABLE HOSP("+
				"ID INT NOT NULL,"+
				"Name VARCHAR(1000),"+
				"Age Varchar(10),"+
				"Date Varchar(100),"+
				"Time Varchar(100),"+
				"Special Varchar(1000),"+
				"Type Varchar(1000),"+
				"PRIMARY KEY (ID))";
		myStmt.executeUpdate(CREATE_TABLE_HOSP);


		Person[] p=new Person[10];
		p[0]=new Patient("Miled Massoud","20",1," 8/1/2021","10:00");
		p[1]=new SurgeryP("joy chahoud","21",2,"10/1/2021","11:15","leg surgery");
		p[2]=new TreatmentP("Antonio Karam","16",3,"21/1/2021","13:30","Pyhsio");
		p[3]=new Doctor("Eddy Massoud","29",4,"Heart");
		p[4]=new Nurse("Tonia Hajj","15",5,"Heart");
		p[5]=new NightShift("Maria Msallem","22",6,"Digestive system","MWF","16:00");
		p[6]=new DayShift("Maria flafel","21",7,"olfactive","21/1/2021","20:00");
		p[7]=new Doctor("Michelle Slem","30",8,"Nerve");
		p[8]=new Patient("Mario Aoun","19",9,"25/1/2021","00:00");
		p[9]=new Patient("Jack Chirak","45",10,"26/1/2021","14:30");

		p[0].setAge("99");
		p[1].setName("Marco Polo");
		
		for(int i=0;i<p.length;++i) {
			p[i].prtPerson();
			
			System.out.println("////////////////");
			p[i].insert(connection);
		}
		

		String[] types=new String[7];
		types[0]="Patient";
		types[1]="SurgeryP";
		types[2]="TreatmentP";
		types[3]="Doctor";
		types[4]="Nurse";
		types[5]="NightShift";
		types[6]="DayShift";
		
		
		System.out.println("Displaying now the array by type from the dataBase");
		for(int i=0;i<types.length;++i) {
			 display(myStmt,types[i]);
		}
	}
	
	//method to display the contents regarding their types
    public static void display (Statement myStmt,String type)throws ClassNotFoundException, SQLException { 
    	ResultSet myRs=myStmt.executeQuery("SELECT * FROM HOSP WHERE TYPE='"+type+"'");
    	System.out.println("Type: "+type);
    	System.out.println("///////\\\\\\\\");
    	while(myRs.next()) {
    		System.out.println("ID: "+myRs.getInt("ID"));
    		System.out.println("Name: "+myRs.getString("Name"));
    		System.out.println("Age: "+myRs.getString("Age"));
    		switch (myRs.getString("Type")) {
    		case "Patient":
    			System.out.println("Date: "+myRs.getString("Date"));
    			System.out.println("Time: "+myRs.getString("Time"));
    			break;
    		case "SurgeryP":
    			System.out.println("Date: "+myRs.getString("Date"));
    			System.out.println("Time: "+myRs.getString("Time"));
    			System.out.println("Surgery Type: "+myRs.getString("Special"));
    			break;
    		case "TreatmentP":
    			System.out.println("Date: "+myRs.getString("Date"));
    			System.out.println("Time: "+myRs.getString("Time"));
    			System.out.println("Treatement Type: "+myRs.getString("Special"));
    			break;
    		case "Doctor":
    			System.out.println("Spec: "+myRs.getString("Special"));
    			break;
    		case "Nurse":
    			System.out.println("Department: "+myRs.getString("Special"));
    			break;
    		case "NightShift":
    			System.out.println("Shift: "+myRs.getString("Date"));
    			System.out.println("Time: "+myRs.getString("Time"));
    			System.out.println("Department: "+myRs.getString("Special"));
    			break;
    		case "DayShift":
    			System.out.println("Date: "+myRs.getString("Date"));
    			System.out.println("Time: "+myRs.getString("Time"));
    			System.out.println("Department: "+myRs.getString("Special"));
    			
    		}
    		System.out.println("||||||||||||||");
    	}
		
    }
			
			
			
			
			
			
			

}