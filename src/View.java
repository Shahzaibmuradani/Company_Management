import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class View {

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
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 250, 508, 198);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 472, 100);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
		       String query="select * from empl";
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
		       btnBack.setBounds(202, 123, 89, 23);
		       frame.getContentPane().add(btnBack);       
		 } catch (Exception e) {
	            // TODO Auto-generated catch block
	            System.out.println(e);
	 }
	}
}
