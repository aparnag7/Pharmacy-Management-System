import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
	
	String name = "";
	int Customer_id = 0 ;
	long phone_number = 0;
	int number_of_purchases = 0;
	
	Customer(String name,int Cutomer_id, long phone_number, int number_of_purchases) {
		this.name= name;
		this.Customer_id = Customer_id;
		this.phone_number = phone_number;
		this.number_of_purchases = number_of_purchases;
	}
	
	Customer(int Customer_id, String name, int number_of_purchases){
		this.Customer_id = Customer_id;
		this.name = name;
		this.number_of_purchases = number_of_purchases;
	}
	
	void update_purchase() {
		this.number_of_purchases+=1;
		int id = this.Customer_id;
		//now update in db
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
			Statement statement = connection.createStatement();
			String query = "update customer set numberofpuchases= '"+this.number_of_purchases +"' where  customerid= '"+id+"'" ;
			statement.executeUpdate(query);
		}
		catch (Exception e) {
			System.out.println("Error in updating in db");
		}
		
	}
	
	public static Customer find_customer(int c_id) 
	{
		String c_name=null;
		int number_of_purchases=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
			Statement statement = connection.createStatement();
			String query = "select * from customer where customerid = '" + c_id + "'";
			ResultSet rs = statement.executeQuery(query);	
			while(rs.next()) {
				c_name = rs.getString("cname");
				number_of_purchases = rs.getInt("numberofpuchases");
			}
		}
		catch (Exception e) {
			System.out.println("Error in static method");
		}
		Customer cs = new Customer(c_id,c_name,number_of_purchases);
		return cs;
		
	}
	
	
}
