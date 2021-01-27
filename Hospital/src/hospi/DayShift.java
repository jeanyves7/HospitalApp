package hospi;

public class DayShift extends Nurse implements Hospital {
	private String Date;
	private String Time;
	
	DayShift(String name,String age,int ID,String Department,String da,String t){
		super(name,age,ID,Department);
		this.Date=da;
		this.Time=t;
	}
	
	
	@Override
	public void prtPerson() {
		super.prtPerson();
		System.out.println("Date: "+Date);
		System.out.println("Time: "+Time);
	}


	@Override
	public void getMedication() {
		// TODO Auto-generated method stub
		
	}
	
}
