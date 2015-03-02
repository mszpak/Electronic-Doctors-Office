package proj1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSupport { 
	
	private Connection connection=null;

	public boolean writePatient(patient p){
		boolean returnValue=true;
		//we are using the try/catch block to determine if there was an error. //the boolean returnValue starts out as true and will only be set to //false if there is an SQL error (exception).
		try {
			connection=this.getConnection();
			// Define the insert query for the basic student data
			String qs = "INSERT INTO patient VALUES ('"+p.getID()+"',"+"'"+p.getDOB() +"'"+","+"'"+p.getName()+"'"+")";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(qs);

			stmt.close();
			connection.close(); } catch (SQLException sqle){
				returnValue=false; sqle.printStackTrace(); while (sqle != null) {
					String logMessage = "\n SQL Error: "+ sqle.getMessage() + "\n\t\t"+
							"Error code: "+sqle.getErrorCode() +
							"\n\t\t"+
							"SQLState: "+sqle.getSQLState()+"\n";
					System.out.println(logMessage);
				}
				sqle = sqle.getNextException(); }
		return returnValue;
	}
	
	public boolean registerUser(String ID, String PW, int position){
		boolean returnValue=true;
		//we are using the try/catch block to determine if there was an error. //the boolean returnValue starts out as true and will only be set to //false if there is an SQL error (exception).
		try {
			connection=this.getConnection();
			// Define the insert query for the basic student data
			String qs = "INSERT INTO users VALUES ('"+ID+"',"+"'"+PW+"'"+","+"'"+position+"'"+")";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(qs);

			stmt.close();
			connection.close(); } catch (SQLException sqle){
				returnValue=false; sqle.printStackTrace(); while (sqle != null) {
					String logMessage = "\n SQL Error: "+ sqle.getMessage() + "\n\t\t"+
							"Error code: "+sqle.getErrorCode() +
							"\n\t\t"+
							"SQLState: "+sqle.getSQLState()+"\n";
					System.out.println(logMessage);
				}
				sqle = sqle.getNextException(); }
		return returnValue;
	}
	
	public int getAuthority(String ID){
		//we are using the try/catch block to determine if there was an error. //the boolean returnValue starts out as true and will only be set to //false if there is an SQL error (exception).
		int authority=0;
		try {
			connection=this.getConnection();
		
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users where ID='"+ID+"'");
			if(rs.next())
			{
				authority = rs.getInt(3);
			}

			stmt.close();
			connection.close(); } catch (SQLException sqle){
				sqle.printStackTrace(); while (sqle != null) {
					String logMessage = "\n SQL Error: "+ sqle.getMessage() + "\n\t\t"+
							"Error code: "+sqle.getErrorCode() +
							"\n\t\t"+
							"SQLState: "+sqle.getSQLState()+"\n";
					System.out.println(logMessage);
					
				}
				sqle = sqle.getNextException(); 
				return -1;
				}
		return authority;
	}
	
	public boolean userExists(String ID){
		//we are using the try/catch block to determine if there was an error. //the boolean returnValue starts out as true and will only be set to //false if there is an SQL error (exception).
		boolean ret = false;
		try {
			connection=this.getConnection();
		
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users where ID='"+ID+"'");
			if(rs.next())
			{
				return true;
			}

			stmt.close();
			connection.close(); } catch (SQLException sqle){
				sqle.printStackTrace(); while (sqle != null) {
					String logMessage = "\n SQL Error: "+ sqle.getMessage() + "\n\t\t"+
							"Error code: "+sqle.getErrorCode() +
							"\n\t\t"+
							"SQLState: "+sqle.getSQLState()+"\n";
					System.out.println(logMessage);
					
				}
				sqle = sqle.getNextException(); 
				}
		return ret;
	}
	
	public boolean login(String ID, String PW){
		boolean returnValue=true;
		//we are using the try/catch block to determine if there was an error. //the boolean returnValue starts out as true and will only be set to //false if there is an SQL error (exception).
		try {
			connection=this.getConnection();
		
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users where ID='"+ID+"'");
			if(rs.next())
			{
				if(PW.equals(rs.getString(2)))
				{
					System.out.println("Welcome! "+ID);
					return true;
				}
				else
				{
					System.out.println("ID or PW is wrong");
					return false;
				}
			}

			stmt.close();
			connection.close(); } catch (SQLException sqle){
				returnValue=false; sqle.printStackTrace(); while (sqle != null) {
					String logMessage = "\n SQL Error: "+ sqle.getMessage() + "\n\t\t"+
							"Error code: "+sqle.getErrorCode() +
							"\n\t\t"+
							"SQLState: "+sqle.getSQLState()+"\n";
					System.out.println(logMessage);
				}
				sqle = sqle.getNextException(); }
		return returnValue;
	}
	

	
	private Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 // Loads database name of a m3ysql database into url
			 // localhost says that it is on the current machine and test says that the // name of the database is test.
			 String url = "jdbc:mysql://localhost/coms362";//test is the name of the database used to run the code
		// We have to establish a jdbc connection to the database
		connection = DriverManager.getConnection (url, "root", "root");// you will need to change the password to // match the one you set up when you downloaded
		// and installed MySQL.
	}
	catch(ClassNotFoundException nfe){
		connection=null;
	}
	catch(SQLException sqle){
		connection=null;	
	}
		 return connection;
	}
}
	