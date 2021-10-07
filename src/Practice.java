import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Practice {
	
	
	public static void main(String[] args) {
		
		try {
			//------1.) load the driver---------
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//----------2.) create the connection object-----------
			String url="jdbc:mysql://localhost:3306/pollsforall";
			String user="root";
			String password="pooner";
			Connection conn=DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) {
				System.out.println("connection is established");
			}
			else {
				System.out.println("Connection failed!!!!!!!!!!!!!!!!!!!!");
			}
			//-------3.) Create statement object-----------
			Statement stmt=conn.createStatement();
			
			//--------4.) execute the query-----------------
			String query="select * from users";
			ResultSet set=stmt.executeQuery(query);
			
			//---------5.) process the data--------------------
			while(set.next()) {
				int id=set.getInt(1);
				String email=set.getString(1);
				System.out.println("Id: "+id+"  Email: "+ email);
				
			}
			
			//----------6.) close the connection---------------
			conn.close(); 
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
