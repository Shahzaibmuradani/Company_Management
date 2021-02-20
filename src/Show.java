import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class Show {

	JFrame frame;
    private JLabel lblId;
    private JLabel lblNewLabel;
    private JLabel lblDepartment;
    JLabel lbl;
    private JLabel label;
    private JLabel label_1;
    private JTextField textField;
    JTextField textField_1;
    JTextField textField_2;
    JTextField textField_3;
    JTextField textField_4;
    JPasswordField passwordField;
    String val,name,d,pass,salary,age;
    int id,ag;
    JButton btnLogout;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show window = new Show();
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
	public Show() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 412, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblId = new JLabel("Id");
		lblId.setFont(new Font("Calibri", Font.BOLD, 15));
	    lblId.setBounds(117, 47, 23, 14);
	    frame.getContentPane().add(lblId);
	   
	    lblNewLabel = new JLabel("Name");
	    lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
	    lblNewLabel.setBounds(106, 80, 46, 14);
	    frame.getContentPane().add(lblNewLabel);
	    
	    lblDepartment = new JLabel("Department Number");
	    lblDepartment.setFont(new Font("Calibri", Font.BOLD, 15));
	    lblDepartment.setBounds(68, 109, 135, 14);
	    frame.getContentPane().add(lblDepartment);

        lbl = new JLabel("Password");
        lbl.setFont(new Font("Calibri", Font.BOLD, 15));
	    lbl.setBounds(99, 140, 66, 14);
	    frame.getContentPane().add(lbl);
	    
	    label = new JLabel("Salary");
	    label.setFont(new Font("Calibri", Font.BOLD, 15));
	    label.setBounds(110, 169, 39, 14);
	    frame.getContentPane().add(label);
	    
	    label_1 = new JLabel("Age");
	    label_1.setFont(new Font("Calibri", Font.BOLD, 15));
	    label_1.setBounds(115, 198, 28, 14);
	    frame.getContentPane().add(label_1);
	    
	    passwordField = new JPasswordField();
	    passwordField.setFont(new Font("Calibri", Font.BOLD, 15));
	    passwordField.setBounds(216, 136, 86, 20);
	    frame.getContentPane().add(passwordField);
	    
	    textField_3 = new JTextField();
	    textField_3.setFont(new Font("Calibri", Font.BOLD, 15));
	    textField_3.setBounds(216, 165, 86, 20);
	    frame.getContentPane().add(textField_3);
	    textField_3.setColumns(10);
	    
	    textField_4 = new JTextField();
	    textField_4.setFont(new Font("Calibri", Font.BOLD, 15));
	    textField_4.setBounds(216, 196, 86, 20);
	    frame.getContentPane().add(textField_4);
	    textField_4.setColumns(10);

	    
	    textField = new JTextField();
	    textField.setFont(new Font("Calibri", Font.BOLD, 15));
	    textField.setBounds(216, 44, 86, 20);
	    frame.getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setFont(new Font("Calibri", Font.BOLD, 15));
	    textField_1.setBounds(216, 75, 86, 20);
	    frame.getContentPane().add(textField_1);
	    textField_1.setColumns(10);
	    
	    textField_2 = new JTextField();
	    textField_2.setFont(new Font("Calibri", Font.BOLD, 15));
	    textField_2.setBounds(216, 106, 86, 20);
	    frame.getContentPane().add(textField_2);
	    textField_2.setColumns(10);
	    
	    getid();
	    
	    textField.setEnabled(false);
	    textField_2.setEnabled(false);
	    textField_3.setEnabled(false);
	    
	    JButton btnUpdate = new JButton("Update");
	    btnUpdate.setBackground(new Color(255, 228, 181));
	    btnUpdate.setFont(new Font("Calibri", Font.BOLD, 15));
	    btnUpdate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		update();
	    	}
	    });
	    btnUpdate.setBounds(86, 230, 89, 23);
	    frame.getContentPane().add(btnUpdate);
	    
	    btnLogout = new JButton("Logout");
	    btnLogout.setBackground(new Color(255, 228, 181));
	    btnLogout.setFont(new Font("Calibri", Font.BOLD, 15));
	    btnLogout.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		frame.dispose();
	    		JOptionPane.showMessageDialog(null,"Logout Successfully");
	    	}
	    });
	    btnLogout.setBounds(215, 230, 87, 23);
	    frame.getContentPane().add(btnLogout);
	    
	    JLabel lblProfile = new JLabel("Profile");
	    lblProfile.setFont(new Font("Calibri", Font.BOLD, 20));
	    lblProfile.setBounds(167, 8, 66, 23);
	    frame.getContentPane().add(lblProfile);	    
	}
	    
	    public void getid()
	    {
	    	String input = JOptionPane.showInputDialog("Enter Your Id");
	    	id = Integer.parseInt(input);
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
			    	   textField.setText(val);
			    	   textField_1.setText(name);
			    	   textField_2.setText(d);
			    	   textField_3.setText(salary);
			    	   textField_4.setText(age);
			    	   passwordField.setText(pass);
			    	 
			       }
			       con.close();

			 } catch (Exception e) {
			            // TODO Auto-generated catch block
			            System.out.println(e);
			 }
	  }
	    
	    public void update()
	    {
			try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
	            String query="update empl set id=?,first_name=?,d_no=?,password=?,salary=?,age=? where id="+id;
	            PreparedStatement pst = con.prepareStatement(query);
                
	            name = textField_1.getText();
	            d = textField_2.getText();
	            pass = passwordField.getText();
	            age = textField_4.getText();
	            ag = Integer.parseInt(age);
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
}
