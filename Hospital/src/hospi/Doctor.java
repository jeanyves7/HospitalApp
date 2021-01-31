package hospi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Doctor extends Person implements Hospital {
	private int ID;
	private String Spec;
	
	Doctor(String name,String age,int ID,String Spec){
		super(name,age);
		this.ID=ID;
		this.Spec=Spec;
	}
	
	
	@Override
	public void prtPerson() {
		super.prtPerson();
		System.out.println("ID: "+ID);
		System.out.println("Specialisation: "+Spec);
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
		prepared.setString(4, null);
		prepared.setString(5, null);
		prepared.setString(6, this.Spec);
		prepared.setString(7,"Doctor");
		
		prepared.execute();
	}
	
	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public String getSpec() {
		return Spec;
	}



	public void setSpec(String spec) {
		Spec = spec;
	}



	@Override
	public void getMedication() {
		// TODO Auto-generated method stub
		
	}
	
	
}
