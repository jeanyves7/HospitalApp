package hospi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Patient extends Person implements Hospital {
	private int ID;
	private String Date;
	private String Time;
	
	public Patient(String name,String age,int ID,String Date,String Time) {
		super(name,age);
		this.ID=ID;
		this.Date=Date;
		this.Time=Time;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	@Override 
	public void prtPerson() {
		this.prtPacient();
	}
	
	@Override
	public void insert(Connection myCon)throws ClassNotFoundException, SQLException{
		String query="INSERT INTO HOSP(ID,Name,Age,Date,Time,Special,Type)" +
										"Values(?,?,?,?,?,?,?)";
		PreparedStatement prepared=myCon.prepareStatement(query);
		
		prepared.setInt(1, this.ID);
		prepared.setString(2, this.getName());
		prepared.setString(3,this.getAge());
		prepared.setString(4, this.Date);
		prepared.setString(5, this.Time);
		prepared.setString(6, null);
		prepared.setString(7,"Patient");
		
		prepared.execute();
	}
	
	 void prtPacient() {
		super.prtPerson();
		System.out.println("ID: "+ID);
		System.out.println("Date :"+Date);
		System.out.println("Time: "+Time);
	}
	
	@Override
	public void getMedication() {
		// TODO Auto-generated method stub
		
	}
	
}
