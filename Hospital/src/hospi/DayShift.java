package hospi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DayShift extends Nurse implements Hospital {
	private String Date;
	private String Time;
	
	DayShift(String name,String age,int ID,String Department,String da,String t){
		super(name,age,ID,Department);
		this.Date=da;
		this.Time=t;
	}
	
	
	//method to insert to data into the database
	@Override
	public void insert(Connection myCon)throws ClassNotFoundException, SQLException{
		String query="INSERT INTO HOSP(ID,Name,Age,Date,Time,Special,Type)" +
										"Values(?,?,?,?,?,?,?)";
		PreparedStatement prepared=myCon.prepareStatement(query);
		
		prepared.setInt(1, this.getID());
		prepared.setString(2, this.getName());
		prepared.setString(3,this.getAge());
		prepared.setString(4, this.Date);
		prepared.setString(5, this.Time);
		prepared.setString(6, this.getDepartment());
		prepared.setString(7,"DayShift");
		
		prepared.execute();
	}
	
	//we override this method from person to print the specific requirements
	@Override
	public void prtPerson() {
		//printing the basic of a person
		super.prtPerson();
		//addinfg the special fields
		System.out.println("Date: "+Date);
		System.out.println("Time: "+Time);
	}


	@Override
	public void getMedication() {
		// TODO Auto-generated method stub
		
	}
	
}
