import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Delete {
	
	
   public static void main(String args [] )
{

		try {
		   String val= JOptionPane.showInputDialog(null, "Enter ID for Deletion");
		   int id = Integer.parseInt(val);
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
           String query="delete empl where id=?";
           String query1="delete dept where d_id=?";
           PreparedStatement pst;
           pst = con.prepareStatement(query);
           pst = con.prepareStatement(query1);
           pst.setInt(1, id);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"Deleted");
		}
	    catch (Exception e1) {
           // TODO Auto-generated catch block
           System.out.println(e1);
       }
}

}
