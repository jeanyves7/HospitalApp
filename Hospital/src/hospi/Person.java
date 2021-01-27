package hospi;

import java.sql.Connection;
import java.sql.SQLException;

public class Person {
		private String name;
		private String age;
		
		//constructor 
		public Person(String name,String age){
			this.name=name;
			this.age=age;
		}
		public void prtPerson() {
			System.out.println("name: "+name);
			System.out.println("age: "+age);
		}
		
		
		public void insert(Connection myCon)throws ClassNotFoundException, SQLException{
			
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		
}
