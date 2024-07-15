import java.sql.*;
import java.util.Scanner;

public class StoreDataUsingBatchUpdate {

	public static void main(String[] args) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Order ID : ");
			
			String order_id = sc.nextLine();
			
			System.out.println("Customer ID : ");
			
			String cid = sc.nextLine();
			
			System.out.println("Product Name : ");
			
			String prod_name = sc.nextLine();
			
			System.out.println("Enter Quantity : ");
			
			int qty = sc.nextInt();
			
			System.out.println("Enter Total : ");
			
			double total = sc.nextDouble();
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "nec" , "nec");
			
			PreparedStatement ps = con.prepareStatement("insert into orders values(?,?,?,?,?)");
			
			ps.setString(1, order_id);
			
			ps.setString(2, cid);
			
			ps.setString(3, prod_name);
			
			ps.setInt(4, qty);
			
			ps.setDouble(5, total);
			
			
			int res = ps.executeUpdate();
			
			if(res > 0) {
				
				System.out.println("Data Added Successfully...");
			}
			
			
		} catch (Exception obj) {
			
			obj.printStackTrace();
		}
	}
}
