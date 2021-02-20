import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Admin {

	JFrame frame;
	JButton Logout;
	JTextField textField_1,textField_2,textField_3,textField_4,passwordField;
	int id;
	String salary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 390, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("Add");
		button.setBackground(new Color(255, 228, 181));
		button.setFont(new Font("Calibri", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert window = new Insert();
				window.frame.setVisible(true);
			}
		});
		button.setBounds(20, 72, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.setBackground(new Color(255, 228, 181));
		button_1.setFont(new Font("Calibri", Font.BOLD, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete.main(null);
			}
		});
		button_1.setBounds(204, 108, 89, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(new Color(255, 228, 181));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				Update window = new Update();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(21, 107, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 228, 181));
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 15));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(null,"Logout Sucessfully");
			}
		});
		btnLogout.setBounds(143, 219, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View window = new View();
				window.frame.setVisible(true);
			}
		});
		btnView.setBackground(new Color(255, 228, 181));
		btnView.setFont(new Font("Calibri", Font.BOLD, 15));
		btnView.setBounds(20, 36, 89, 23);
		frame.getContentPane().add(btnView);
		
		JButton btnViewEmployeesDepartment = new JButton("View Employee's Department");
		btnViewEmployeesDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All window = new All();
				window.frame.setVisible(true);
			}
		});
		btnViewEmployeesDepartment.setBackground(new Color(255, 228, 181));
		btnViewEmployeesDepartment.setFont(new Font("Calibri", Font.BOLD, 15));
		btnViewEmployeesDepartment.setBounds(134, 36, 226, 23);
		frame.getContentPane().add(btnViewEmployeesDepartment);
		
		JButton button_2 = new JButton("Total and Average Salaries");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Avg_depart window = new Avg_depart();
				window.frame.setVisible(true);
			}
		});
		button_2.setBackground(new Color(255, 228, 181));
		button_2.setFont(new Font("Calibri", Font.BOLD, 15));
		button_2.setBounds(135, 72, 224, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Add");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d_in window = new d_in();
				window.frame.setVisible(true);
			}
		});
		button_3.setFont(new Font("Calibri", Font.BOLD, 15));
		button_3.setBackground(new Color(255, 228, 181));
		button_3.setBounds(102, 180, 68, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Update");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d_up window = new d_up();
				window.frame.setVisible(true);
			}
		});
		button_4.setFont(new Font("Calibri", Font.BOLD, 15));
		button_4.setBackground(new Color(255, 228, 181));
		button_4.setBounds(182, 180, 80, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Delete");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete.main(null);
			}
		});
		button_5.setFont(new Font("Calibri", Font.BOLD, 15));
		button_5.setBackground(new Color(255, 228, 181));
		button_5.setBounds(272, 179, 79, 23);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("View");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d_vi window = new d_vi();
				window.frame.setVisible(true);
			}
		});
		button_6.setFont(new Font("Calibri", Font.BOLD, 15));
		button_6.setBackground(new Color(255, 228, 181));
		button_6.setBounds(23, 180, 68, 23);
		frame.getContentPane().add(button_6);
		
		JLabel lblDepartmentsInformation = new JLabel("Departments' Information");
		lblDepartmentsInformation.setForeground(new Color(0, 0, 255));
		lblDepartmentsInformation.setFont(new Font("Calibri", Font.BOLD, 17));
		lblDepartmentsInformation.setBounds(93, 149, 196, 19);
		frame.getContentPane().add(lblDepartmentsInformation);
		
		JLabel label = new JLabel("Employees' Information");
		label.setForeground(new Color(0, 0, 255));
		label.setFont(new Font("Calibri", Font.BOLD, 17));
		label.setBounds(100, 9, 175, 19);
		frame.getContentPane().add(label);
	}
}
