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
		ConnectionD connect=new ConnectionD("Hospital","root","admin");
		Connection connection=connect.getConnection();
		Statement myStmt=connection.createStatement();
		myStmt.execute("USE "+ connect.getDataBase());
		ResultSet myRs;
		if(v.contentEquals("*")) {
			pending+="All"+"\n";
			myRs=myStmt.executeQuery("SELECT * FROM HOSP");
		}else {
			pending+=v+"\n";
			myRs=myStmt.executeQuery("SELECT * FROM HOSP WHERE TYPE='"+v+"'");
		}

		while(myRs.next()) {
			pending+=("ID: "+myRs.getInt("ID"))+", ";
			pending+=("Name: "+myRs.getString("Name"))+", ";
			pending+=("Age: "+myRs.getString("Age"))+", ";
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
		JScrollPane tAreaScrollPane = new JScrollPane(tArea);
		tAreaScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		tAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Setup the content-pane of JFrame in BorderLayout
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout(5, 5));

		cp.add(tAreaScrollPane, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("JTextComponent Demo");
		setSize(350, 350);
		setLocationRelativeTo(null);
		setVisible(true);


	}

}
