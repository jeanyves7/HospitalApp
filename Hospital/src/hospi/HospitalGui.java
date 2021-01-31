package hospi;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

@SuppressWarnings("serial")
public class HospitalGui extends JFrame {

	JLabel display;

	/** Constructor to setup the GUI */
	public HospitalGui() {
		// A menu-bar contains menus. A menu contains menu-items 
		JMenuBar menuBar;   //  menu-bar
		JMenu menu;         // each menu in the menu-bar
		JMenuItem menuItem; // an item in a menu

		menuBar = new JMenuBar();

		// Add_Patient Menu
		menu = new JMenu("ADD");
		menu.setMnemonic(KeyEvent.VK_A);  // alt short-cut key
		menuBar.add(menu);  // the menu-bar adds this menu

		menuItem = new JMenuItem("Patient", KeyEvent.VK_P);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new InputGui("");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		menuItem = new JMenuItem("SurgeryP", KeyEvent.VK_S);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new InputGui("Surgery");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		menuItem = new JMenuItem("TreatmentP", KeyEvent.VK_T);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new InputGui("Treat");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Display Menu
		menu = new JMenu("Display");
		menu.setMnemonic(KeyEvent.VK_B);  // short-cut key
		menuBar.add(menu);  // the menu bar adds this menu

		// we are now adding the items to the display menu
		
		menuItem = new JMenuItem("All", KeyEvent.VK_A);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("*");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		menuItem = new JMenuItem("Patient", KeyEvent.VK_P);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("Patient");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		menuItem = new JMenuItem("SurgeryP", KeyEvent.VK_P);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("SurgeryP");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});


		menuItem = new JMenuItem("TreatmentP", KeyEvent.VK_P);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("TreatmentP");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});

		menuItem = new JMenuItem("Doctor", KeyEvent.VK_D);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("Doctor");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		menuItem = new JMenuItem("Nurse", KeyEvent.VK_N);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("Nurse");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		menuItem = new JMenuItem("NightShift", KeyEvent.VK_I);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("NightShift");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuItem = new JMenuItem("DayShift", KeyEvent.VK_Y);
		menu.add(menuItem); // the menu adds this item
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new DisplayGui("DayShift");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		setJMenuBar(menuBar);  // "this" JFrame sets its menu-bar

		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		display = new JLabel("Welcome to HAU", 10);
		cp.add(display);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hospital  App");
		setSize(300, 100);
		setLocationRelativeTo(null); // when we run it, the position of the frame in the center
		setVisible(true);
	}

	/** The entry main() method */
	public static void main(String[] args) {
		// we run the GUI on  event-dispatching thread for thread safety
		// GUI using swing and  awt
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new HospitalGui(); // Let the constructor do the job
			}
		});
	}
}
