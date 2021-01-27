package hospi;

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
