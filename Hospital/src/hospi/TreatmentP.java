package hospi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TreatmentP extends Patient implements Hospital{
	private String TreatmentType;
	
	TreatmentP(String name,String age,int ID,String Date,String Time,String tt){
		super(name,age,ID,Date,Time);
		this.TreatmentType=tt;
	}
	
	@Override
	public void prtPacient() {
		super.prtPacient();
		System.out.println("Treatment Type: "+this.TreatmentType);
	}
	
	@Override
	public void getMedication() {
		// TODO Auto-generated method stub
		
	}


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
		prepared.setString(6, this.TreatmentType);
		prepared.setString(7,"TreatmentP");
		
		prepared.execute();
	}
	
	public String getTreatmentType() {
		return TreatmentType;
	}

	public void setTreatmentType(String treatmentType) {
		TreatmentType = treatmentType;
	}
}
