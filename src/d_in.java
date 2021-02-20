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
import java.awt.Font;
import java.awt.Color;

public class d_in {

	JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					d_in window = new d_in();
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
	public d_in() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 352, 233);
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
		
		JLabel label = new JLabel("Department Number");
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(47, 62, 138, 20);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Department Name");
		label_1.setFont(new Font("Calibri", Font.BOLD, 15));
		label_1.setBounds(53, 96, 138, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnSave = new JButton("Insert");
		btnSave.setBackground(new Color(255, 228, 181));
		btnSave.setFont(new Font("Calibri", Font.BOLD, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField_1.getText();
				String d_name = textField_2.getText();
				try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		            String query="insert into dept values(?,?)";
		            PreparedStatement pst = con.prepareStatement(query);
		        
		            pst.setString(1, id);
		            pst.setString(2, d_name);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null,"Inserted");
				}
			    catch (Exception e1) {
		            // TODO Auto-generated catch block
		            System.out.println(e1);
		        }
			}
		});
		btnSave.setBounds(184, 140, 86, 23);
		frame.getContentPane().add(btnSave);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 228, 181));
		btnBack.setFont(new Font("Calibri", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(72, 140, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Basic Information");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNewLabel.setBounds(104, 20, 136, 18);
		frame.getContentPane().add(lblNewLabel);
	}
}
