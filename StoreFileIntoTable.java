
import java.io.*;
import java.sql.*;

public class StoreFileIntoTable {

	public static void main(String[] args) {
		
		try {
			
			File f = new File("E:\\myfolder\\MISC\\Wpaper.jpg");
			
			FileInputStream fin = new FileInputStream(f);
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nec","nec");
			
			PreparedStatement ps = con.prepareStatement("insert into filedata values(?,?)");
			
			ps.setString(1, "f-1");
			
			ps.setBinaryStream(2, fin, fin.available());
			
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				
				System.out.println("Image Added Successfully ...");
			}
			
			
			
		} catch (Exception obj) {
			
			obj.printStackTrace();
		}
	}
}
