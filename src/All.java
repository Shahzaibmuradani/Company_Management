import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class All {

	JFrame frame;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					All window = new All();
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
	public All() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 583, 214);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 28, 545, 100);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		

		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		       String query="select id,first_name,d_no,d_name from empl,dept where d_no=d_id";
		       PreparedStatement pst = con.prepareStatement(query);
		       ResultSet rs = pst.executeQuery(query);
		       table.setModel(DbUtils.resultSetToTableModel(rs));
		       
		       btnBack = new JButton("Back");
		       btnBack.setBackground(new Color(255, 228, 181));
		       btnBack.setFont(new Font("Calibri", Font.BOLD, 15));
		       btnBack.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		frame.dispose();
		       	}
		       });
		       btnBack.setBounds(235, 141, 89, 23);
		       frame.getContentPane().add(btnBack);
		} catch (Exception e) {
	            // TODO Auto-generated catch block
	            System.out.println(e);
	 }
		
	}

}
