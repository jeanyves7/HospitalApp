package hospi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurgeryP  extends Patient implements Hospital {
	private String SurgeryType;
	
	public SurgeryP(String name,String age,int ID,String Date,String Time,String st) {
		super(name,age,ID,Date,Time);
		this.SurgeryType=st;
	}
	
	
	
	@Override
	public void prtPacient() {
		super.prtPacient();
		System.out.println("Surgery Type: "+this.SurgeryType);
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
		prepared.setString(4, this.getDate());
		prepared.setString(5, this.getTime());
		prepared.setString(6, this.SurgeryType);
		prepared.setString(7,"SurgeryP");
		
		prepared.execute();
	}
	
	public String getSurgeryType() {
		return SurgeryType;
	}

	public void setSurgeryType(String surgeryType) {
		SurgeryType = surgeryType;
	}

	@Override
	public void getMedication() {
		// TODO Auto-generated method stub
		
	}
}
