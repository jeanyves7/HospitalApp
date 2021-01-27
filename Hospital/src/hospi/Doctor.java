package hospi;

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
