import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Avg_depart {

	JFrame frame;
	private JTable table;
	private JTable table_1;
	private JLabel lblAverageSalaryOf;
	private JLabel label;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Avg_depart window = new Avg_depart();
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
	public Avg_depart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 450, 291);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 414, 85);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(62, 168, 313, 37);
	    frame.getContentPane().add(scrollPane_1);
	       
	    table_1 = new JTable();
	    scrollPane_1.setViewportView(table_1);
	       
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		       String query="select d_name,avg(salary),sum(salary) from empl,dept where empl.d_no=dept.d_id group by d_name";
		       String query1="select avg(salary) AS Average_Salary,sum(salary) AS Total_Salary from empl";
		       PreparedStatement pst = con.prepareStatement(query);
		       ResultSet rs = pst.executeQuery(query);
		       table.setModel(DbUtils.resultSetToTableModel(rs));
		       
		       PreparedStatement pst1 = con.prepareStatement(query1);
		       ResultSet rs1 = pst1.executeQuery(query1);
		       table_1.setModel(DbUtils.resultSetToTableModel(rs1));
		       
		       lblAverageSalaryOf = new JLabel("Average and Total Salaries of Each Department");
		       lblAverageSalaryOf.setFont(new Font("Calibri", Font.BOLD, 15));
		       lblAverageSalaryOf.setBounds(70, 18, 294, 14);
		       frame.getContentPane().add(lblAverageSalaryOf);
		       
		       label = new JLabel("Average and Total Salaries");
		       label.setFont(new Font("Calibri", Font.BOLD, 15));
		       label.setBounds(135, 144, 170, 14);
		       frame.getContentPane().add(label);
		       
		       btnBack = new JButton("Back");
		       btnBack.setBackground(new Color(255, 228, 181));
		       btnBack.setFont(new Font("Calibri", Font.BOLD, 15));
		       btnBack.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		frame.dispose();
		       	}
		       });
		       btnBack.setBounds(171, 218, 89, 23);
		       frame.getContentPane().add(btnBack);
		 } catch (Exception e) {
	            // TODO Auto-generated catch block
	            System.out.println(e);
	 }
		       		
	}
}
