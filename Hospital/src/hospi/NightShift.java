package hospi;

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
