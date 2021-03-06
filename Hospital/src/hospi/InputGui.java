package hospi;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

@SuppressWarnings("serial")
public class InputGui extends JFrame {
	// Private variables of the GUI components
	JTextField NField; //name
	JTextField AField; //age
	JTextField IField; // id
	JTextField DField; // date
	JTextField TField; // time
	JTextField VField; // the special value of a type
	JTextArea tArea;
	Person p; // a person so we can save it
	JFormattedTextField formattedField;


	/** Constructor to set up all the GUI components 
	 * @throws SQLException */
	public InputGui(String v) throws SQLException {
		
		//getting the connection to the database
		ConnectionD connect=new ConnectionD("Hospital","root","admin");
		Connection connection=connect.getConnection();
		Statement myStmt=connection.createStatement();
		myStmt.execute("USE "+ connect.getDataBase());


		// JPanel for the text fields
		JPanel tfPanel = new JPanel(new GridLayout(6, 2, 10, 2));
		tfPanel.setBorder(BorderFactory.createTitledBorder("Add Patient: "));

		// Regular text field (Row 1)
		tfPanel.add(new JLabel("  Name: "));
		NField = new JTextField(10);
		tfPanel.add(NField);


		// Name field (Row 2)
		tfPanel.add(new JLabel("  Age: "));
		AField = new JTextField(10);
		tfPanel.add(AField);

		// Id field (Row 3)
		tfPanel.add(new JLabel("  ID"));
		IField=new JTextField(10);
		tfPanel.add(IField);

		// Date field (Row 4)
		tfPanel.add(new JLabel("  Date"));
		TField=new JTextField(20);
		tfPanel.add(TField);

		//Time field(Row 5)
		tfPanel.add(new JLabel("  Time"));
		DField=new JTextField(20);
		tfPanel.add(DField);

		// Special value field (Row 6)
		if(v.contains("Surgery")) {
			tfPanel.add(new JLabel("  Surgery Type"));
			VField=new JTextField(20);
			tfPanel.add(VField);
		}else if(v.contains("Treat")) {
			tfPanel.add(new JLabel("  Treatment Type"));
			VField=new JTextField(20);
			tfPanel.add(VField);
		}

		//a button to handle the insertion to the database
		JButton btn = new JButton("ADD");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)  {
				String text=IField.getText();
				int Id = Integer.parseInt(text);
				switch (v) {
				case "":
					
					p=new Patient(NField.getText(),AField.getText(),Id,DField.getText(),TField.getText());
					try {
						p.insert(connection);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
					break;
				case "Surgery":
					p=new SurgeryP(NField.getText(),AField.getText(),Id,DField.getText(),TField.getText(),VField.getText());
					try {
						p.insert(connection);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					VField.setText("");
					break;
				case "Treat":
					p=new TreatmentP(NField.getText(),AField.getText(),Id,DField.getText(),TField.getText(),VField.getText());
					try {
						p.insert(connection);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					VField.setText("");
				}
				//when we click on add we want to reset the fields to empty
				NField.setText("");
				AField.setText("");
				IField.setText("");
				DField.setText("");
				TField.setText("");
				
			}	

		});

		// Setup the content-pane of JFrame in BorderLayout
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout(5, 5));
		cp.add(tfPanel, BorderLayout.NORTH);
		cp.add(btn,BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // dispose on close means that we only want to close this specific frame and not all of them
		setTitle("Add Patient");
		setSize(350, 350);
		setLocationRelativeTo(null); // to center the frame in the center of the screen
		setVisible(true);
	}
}
