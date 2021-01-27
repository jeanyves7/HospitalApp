package hospi;

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

	@Override
	public void prtPerson() {
		super.prtPerson();
		System.out.println("ID: "+ID);
		System.out.println("Department: "+Department);
	}

	
}
