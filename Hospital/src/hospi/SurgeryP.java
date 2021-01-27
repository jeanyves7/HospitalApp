package hospi;

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
