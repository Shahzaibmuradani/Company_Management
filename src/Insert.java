import java.awt.EventQueue;

import javax.swing.JFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;

public class Insert {

	JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert window = new Insert();
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
	public Insert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 386, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 59, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 93, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(106, 62, 51, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Department Number");
		label_1.setFont(new Font("Calibri", Font.BOLD, 15));
		label_1.setBounds(53, 96, 138, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnSave = new JButton("Insert");
		btnSave.setBackground(new Color(255, 228, 181));
		btnSave.setFont(new Font("Calibri", Font.BOLD, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=14;
				id++;
				String name = textField_1.getText();
				String d = textField_2.getText();
				String pass = passwordField.getText();
				String salary = textField_3.getText(); 
				String age =  textField_4.getText();
				int sal = Integer.parseInt(salary);
				int ag = Integer.parseInt(age);
	
				try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		            String query="insert into empl values(?,?,?,?,?,?)";
		            PreparedStatement pst = con.prepareStatement(query);
		            
		            pst.setInt(1, id);
		            pst.setString(2, name);
		            pst.setString(3, d);
		            pst.setString(4, pass);
		            pst.setInt(5, sal);
		            pst.setInt(6, ag);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null,"Inserted");
				}
			    catch (Exception e1) {
		            // TODO Auto-generated catch block
		            System.out.println(e1);
		        }
			}
		});
		btnSave.setBounds(200, 227, 86, 23);
		frame.getContentPane().add(btnSave);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 228, 181));
		btnBack.setFont(new Font("Calibri", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(78, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		
		label_2 = new JLabel("Password");
		label_2.setFont(new Font("Calibri", Font.BOLD, 15));
		label_2.setBounds(97, 130, 60, 14);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("Salary");
		label_3.setFont(new Font("Calibri", Font.BOLD, 15));
		label_3.setBounds(106, 163, 39, 14);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("Age");
		label_4.setFont(new Font("Calibri", Font.BOLD, 15));
		label_4.setBounds(111, 195, 33, 14);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(200, 160, 86, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(200, 192, 86, 20);
		frame.getContentPane().add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 126, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Basic Information");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNewLabel.setBounds(128, 20, 136, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
