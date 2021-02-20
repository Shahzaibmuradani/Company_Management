import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;


public class login {

	JFrame frame;
	private JTextField textField;
	JRadioButton radioButton_1;
	JRadioButton radioButton;
	int flag=0,id;
	String val;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(500, 250, 381, 215);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		textField = new JTextField();
		textField.setBounds(171, 66, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("User ID");
		lblId.setFont(new Font("Calibri", Font.BOLD, 15));
		lblId.setBounds(95, 69, 45, 14);
		frame.getContentPane().add(lblId);
		
		JLabel label = new JLabel("Password");
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(89, 104, 61, 14);
		frame.getContentPane().add(label);
		
		radioButton = new JRadioButton("Admin");
		radioButton.setBackground(Color.WHITE);
		radioButton.setFont(new Font("Calibri", Font.BOLD, 15));
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag=1;
								
				radioButton.setEnabled(false);
				radioButton_1.setSelected(false);
				radioButton_1.setEnabled(true);
			}
		});
		radioButton.setBounds(106, 20, 67, 23);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("User");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setFont(new Font("Calibri", Font.BOLD, 15));
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=2;
				
				radioButton_1.setEnabled(false);
				radioButton.setSelected(false);
				radioButton.setEnabled(true);
				
			}
		});
		radioButton_1.setBounds(191, 21, 55, 23);
		frame.getContentPane().add(radioButton_1);
		
		JButton btnLogIn = new JButton("Login");
		btnLogIn.setBackground(new Color(255, 228, 181));
		btnLogIn.setFont(new Font("Calibri", Font.BOLD, 15));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flag==1)
				{
				admin();
				textField.setText("");
				passwordField.setText("");
				}
				else if (flag==2)
				{
				user();
				textField.setText("");
				passwordField.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select Admin/User First");
				}
			}
		});
		btnLogIn.setBounds(168, 142, 89, 23);
		frame.getContentPane().add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 101, 86, 20);
		frame.getContentPane().add(passwordField);
	
	}
    public void user()	
 {
	if (flag==2 )
	{
		try {
			   String pass = passwordField.getText();
			   String val = textField.getText();
			   id = Integer.parseInt(val);
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		       String query="select * from empl where id="+id+" and password='"+pass+"'";
		       PreparedStatement pst = con.prepareStatement(query);
		       ResultSet rs = pst.executeQuery(query);
		       if(rs.next())
		       {
		    	   val = rs.getString("ID");
		    	   pass = rs.getString("Password");
		    	   String input = JOptionPane.showInputDialog(null, "Login Sucessfully\n\n\"Press y or Y For View/Update\"\n");
		    	   if (input.contains("y") || input.contains("Y"))
		    	   {
		    		   Show window = new Show();
		    		   window.frame.setVisible(true);
		    		   
		    	   }
		    	   else
		    	   {
		    		   input = JOptionPane.showInputDialog(null,"Invalid\n\n\"Press y or Y For View/Update\"\n");
		    		   Show window = new Show();
		    		   window.frame.setVisible(true);
		    	   }
		       }
		       else
		       {
		    	   JOptionPane.showMessageDialog(null,"Incorrect ID or Password");
		       }
		       con.close();

		 } catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"Incorrect ID or Password");
		 }
	}
	else
	{
		  JOptionPane.showMessageDialog(null,"Incorrect ID or Password");
	}
}
	public void admin()
	
{	
	if (flag==1 )
	{
		if (textField.getText().contains("test") && passwordField.getText().contains("test"))
		{
			JOptionPane.showMessageDialog(null,"Login Sucessfully");
			Admin window = new Admin();
			window.frame.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Incorrect ID or Password");
		}
	}
	else if (flag==2 || textField.getText()=="test" || passwordField.getText()=="test" )
	{
		JOptionPane.showMessageDialog(null,"You Selected the Wrong Option");
	}
  }
	
}