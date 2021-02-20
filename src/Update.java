import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Update {

	JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblDepartmentNumber;
	private JTextField textField;
	private JTextField textField_1;
	int ag,id;
    String pass,name,d,salary,age;
    private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
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
	public Update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 355, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		lblNewLabel_1 = new JLabel("Salary");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(88, 26, 47, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblDepartmentNumber = new JLabel("Department Number");
		lblDepartmentNumber.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDepartmentNumber.setBounds(44, 63, 137, 14);
		frame.getContentPane().add(lblDepartmentNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD, 15));
		textField.setBounds(204, 22, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.BOLD, 15));
		textField_1.setBounds(204, 60, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		  String val= JOptionPane.showInputDialog(null, "Enter ID for Updation");
		   id = Integer.parseInt(val);
		   
		try {			 
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		       String query="select * from empl where id="+id;
		       PreparedStatement pst = con.prepareStatement(query);
		       ResultSet rs = pst.executeQuery(query);
		       if(rs.next())
		       {
		    	   val = rs.getString("ID");
		    	   name = rs.getString("First_name");
		    	   d = rs.getString("D_no");
		    	   pass = rs.getString("Password");
		    	   salary = rs.getString("Salary");
		    	   age = rs.getString("Age");
		    	   textField.setText(salary);
		    	   textField_1.setText(d);
		       }
		       con.close();

		 } catch (Exception e) {
		            // TODO Auto-generated catch block
		            System.out.println(e);
		 }				
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(255, 228, 181));
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		            String query="update empl set id=?,first_name=?,d_no=?,password=?,salary=?,age=? where id="+id;
		            PreparedStatement pst = con.prepareStatement(query);
                    
		            salary = textField.getText();
		            d = textField_1.getText();
		            pst.setInt(1, id);
		            pst.setString(2, name);
		            pst.setString(3, d);
		            pst.setString(4,pass);
		            pst.setString(5, salary);
		            pst.setInt(6, ag);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null,"Updated");
		            con.close();

		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		            System.out.println(e);
		        }
			}
		});
		btnUpdate.setBounds(202, 95, 89, 23);
		frame.getContentPane().add(btnUpdate);		
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 228, 181));
		btnBack.setFont(new Font("Calibri", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(68, 95, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
