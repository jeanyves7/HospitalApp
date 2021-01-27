package hospi;

public class Medication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] p=new Person[10];
		p[0]=new Patient("Miled Massoud","20",1," 8/1/2021","10:00");
		p[1]=new SurgeryP("joy chahoud","21",2,"10/1/2021","11:15","leg surgery");
		p[2]=new TreatmentP("Antonio Karam","16",3,"21/1/2021","13:30","Pyhsio");
		p[3]=new Doctor("Eddy Massoud","29",4,"Heart");
		p[4]=new Nurse("Tonia Hajj","15",5,"Heart");
		p[5]=new NightShift("Maria Msallem","22",6,"Digestive system","MWF","16:00");
		p[6]=new DayShift("Maria flafel","21",7,"olfactive","21/1/2021","20:00");
		p[7]=new Doctor("Michelle Slem","30",8,"Nerve");
		p[8]=new Patient("Mario Aoun","19",9,"25/1/2021","00:00");
		p[9]=new Patient("Jack Chirak","45",10,"26/1/2021","14:30");
		
		for(int i=0;i<p.length;++i) {
			p[i].prtPerson();
			System.out.println("////////////////");
		}
				
		

	}

}
