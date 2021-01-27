package hospi;

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

	public String getTreatmentType() {
		return TreatmentType;
	}

	public void setTreatmentType(String treatmentType) {
		TreatmentType = treatmentType;
	}
}
