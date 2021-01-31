package hospi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NightShift extends Nurse implements Hospital {

	private String Shift;
	private String Time;
	
	NightShift(String name,String age,int ID,String Department,String sh,String t){
		super(name,age,ID,Department);
		this.Shift=sh;
		this.Time=t;
	}
	
	@Override
	public void prtPerson() {
		super.prtPerson();
		System.out.println("Shift: "+Shift);
		System.out.println("Time: "+Time);
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
		prepared.setString(4, this.Shift);
		prepared.setString(5, this.Time);
		prepared.setString(6, this.getDepartment());
		prepared.setString(7,"NightShift");
		
		prepared.execute();
	}
	
	
	public String getShift() {
		return Shift;
	}

	public void setShift(String shift) {
		Shift = shift;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	@Override
	public void getMedication() {
		// TODO Auto-generated method stub

	}

}
