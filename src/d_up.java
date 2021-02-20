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

public class d_up {

	JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblDepartmentNumber;
	private JTextField textField;
	private JTextField textField_1;
	int id;
    String name,val;
    private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					d_up window = new d_up();
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
	public d_up() {
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
	
		lblNewLabel_1 = new JLabel("Department Number");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1.setBounds(38, 26, 143, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblDepartmentNumber = new JLabel("Department Name");
		lblDepartmentNumber.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDepartmentNumber.setBounds(44, 63, 126, 14);
		frame.getContentPane().add(lblDepartmentNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD, 15));
		textField.setBounds(211, 22, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.BOLD, 15));
		textField_1.setBounds(186, 60, 143, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		val= JOptionPane.showInputDialog(null, "Enter ID for Updation");
		
		try {
			   
			   id = Integer.parseInt(val);
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		       String query="select * from dept where d_id="+id;
		       PreparedStatement pst = con.prepareStatement(query);
		       ResultSet rs = pst.executeQuery(query);
		       if(rs.next())
		       {
		    	   val = rs.getString("D_id");
		    	   name = rs.getString("D_name");
		    	   textField.setText(val);
		    	   textField_1.setText(name);
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
		            String query="update dept set d_id=?,d_name=? where d_id="+id;
		            PreparedStatement pst = con.prepareStatement(query);
                    
		            val = textField.getText();
		            name = textField_1.getText();
		            id = Integer.parseInt(val);
		            pst.setInt(1, id);
		            pst.setString(2, name);
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
