import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		try {
			//------1.) load the driver---------
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//----------2.) create the connection object-----------
			String url="jdbc:mysql://localhost:3306/jdbcpractice";
			String user="root";
			String password="pooner";
			Connection conn=DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) {
				System.out.println("connection is established");
			}
			else {
				System.out.println("Connection failed!!!!!!!!!!!!!!!!!!!!");
			}
			
			
			//-------Create table-----------
//			Statement stmt=conn.createStatement();
//			String query="Create table users(id int(20) primary key auto_increment, name varchar(200), age int(30))";
//			int result=stmt.executeUpdate(query); 
			
			
			//----------insert into table using PreparedStatement--------------
//			String query="insert into users(name,age) values(?,?)";
//			PreparedStatement pstmt=conn.prepareStatement(query);
//			pstmt.setString(1,"vikas");
//			pstmt.setInt(2, 23);
			
			
			//-----------taking inputs dynamically------------------------------
//			Scanner scanner= new Scanner(System.in);
//			System.out.println("Enter name:");
//			String name=scanner.nextLine();
//			System.out.println("Enter age:");
//			int age=scanner.nextInt();
//			pstmt.setString(1,name);
//			pstmt.setInt(2, age);
//			int result=pstmt.executeUpdate();
			
			
			//-----------update records-------------
			String sql="update  users set name=? , age=? where id=?";
			PreparedStatement Pstmt=conn.prepareStatement(sql);
			Pstmt.setString(1,"Vikas Pooner");
			Pstmt.setInt(2, 23);
			Pstmt.setInt(3, 1);
			Pstmt.executeUpdate();
			
			conn.close(); 
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
