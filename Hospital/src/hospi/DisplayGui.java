package hospi;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class DisplayGui extends JFrame {
	JTextArea tArea;
	String pending="";

	DisplayGui(String v) throws SQLException{
		//at first we will open a connection to the database
		ConnectionD connect=new ConnectionD("Hospital","root","admin");
		Connection connection=connect.getConnection();
		Statement myStmt=connection.createStatement();
		//using the desired database 
		myStmt.execute("USE "+ connect.getDataBase());
		
		//preparing to accept the result 
		ResultSet myRs;
		//bloc to handle the desired data from the input of the user
		if(v.contentEquals("*")) {
			pending+="All"+"\n";
			myRs=myStmt.executeQuery("SELECT * FROM HOSP");
		}else {
			pending+=v+"\n";
			myRs=myStmt.executeQuery("SELECT * FROM HOSP WHERE TYPE='"+v+"'");
		}
		//we loop on the element has been selected from the database
		//we start with myRs.next because in the begining it's pointing to a null place
		while(myRs.next()) {
			//All of the classes has ID, Name and Age
			pending+=("ID: "+myRs.getInt("ID"))+", ";
			pending+=("Name: "+myRs.getString("Name"))+", ";
			pending+=("Age: "+myRs.getString("Age"))+", ";
			
			//switching between the specific type of the person 
			switch (myRs.getString("Type")) {
			case "Patient":
				pending+=("Date: "+myRs.getString("Date"))+", ";
				pending+=("Time: "+myRs.getString("Time"))+" ";
				break;
			case "SurgeryP":
				pending+=("Date: "+myRs.getString("Date"))+", ";
				pending+=("Time: "+myRs.getString("Time"))+", ";
				pending+=("Surgery Type: "+myRs.getString("Special"))+" ";
				break;
			case "TreatmentP":
				pending+=("Date: "+myRs.getString("Date"))+", ";
				pending+=("Time: "+myRs.getString("Time"))+", ";
				pending+=("Treatement Type: "+myRs.getString("Special"))+" ";
				break;
			case "Doctor":
				pending+=("Spec: "+myRs.getString("Special"))+" ";
				break;
			case "Nurse":
				pending+=("Department: "+myRs.getString("Special"))+" ";
				break;
			case "NightShift":
				pending+=("Shift: "+myRs.getString("Date"))+", ";
				pending+=("Time: "+myRs.getString("Time"))+", ";
				pending+=("Department: "+myRs.getString("Special"));
				break;
			case "DayShift":
				pending+=("Date: "+myRs.getString("Date"))+", ";
				pending+=("Time: "+myRs.getString("Time"))+", ";
				pending+=("Department: "+myRs.getString("Special"))+" ";

			}
			pending+="\n"+"\n";
		}
		tArea = new JTextArea(pending);
		tArea.setFont(new Font("Serif", Font.ITALIC, 13));
		tArea.setBackground(new Color(204, 238, 241)); // light blue
		// Wrap the JTextArea inside a JScrollPane
		JScrollPane tAreaScrollPane = new JScrollPane(tArea); //adding a scroll panel if the available doesn't fit in the frame
		tAreaScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//empty border around the panel 
		tAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Setup the content-pane of JFrame in BorderLayout
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout(5, 5));

		cp.add(tAreaScrollPane, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Displaying");
		setSize(350, 350);
		setLocationRelativeTo(null);//to position it in the center of the screen
		setVisible(true);


	}

}
