package hospi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Nurse extends Person {
	private int  ID;
	private String Department;

	Nurse(String name,String age,int ID,String Department){
		super(name,age);
		this.ID=ID;
		this.Department=Department;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
	
	//method to insert to data into the database
	@Override
	public void insert(Connection myCon)throws ClassNotFoundException, SQLException{
		String query="INSERT INTO HOSP(ID,Name,Age,Date,Time,Special,Type)" +
										"Values(?,?,?,?,?,?,?)";
		PreparedStatement prepared=myCon.prepareStatement(query);
		
		prepared.setInt(1, this.ID);
		prepared.setString(2, this.getName());
		prepared.setString(3,this.getAge());
		prepared.setString(4, null);
		prepared.setString(5, null);
		prepared.setString(6, this.Department);
		prepared.setString(7,"Nurse");
		
		prepared.execute();
	}
	
	
	@Override
	public void prtPerson() {
		super.prtPerson();
		System.out.println("ID: "+ID);
		System.out.println("Department: "+Department);
	}

	
}
