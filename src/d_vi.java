import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class d_vi {

	JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					d_vi window = new d_vi();
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
	public d_vi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 363, 212);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 31, 279, 84);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBackground(new Color(255, 228, 181));
		btnBack.setFont(new Font("Calibri", Font.BOLD, 15));
		btnBack.setBounds(127, 136, 89, 23);
		frame.getContentPane().add(btnBack);
		
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		       String query="select * from dept";
		       PreparedStatement pst = con.prepareStatement(query);
		       ResultSet rs = pst.executeQuery(query);
		       table.setModel(DbUtils.resultSetToTableModel(rs));
		 } catch (Exception e) {
	            // TODO Auto-generated catch block
	            System.out.println(e);
	 }
		
	}
}
