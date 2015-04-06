package proj1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSupport { 
	
	private Connection connection=null;

    public boolean writePatient(patient p){
        boolean returnValue=true;
        try {
            connection=this.getConnection();
            
            String qs = "INSERT INTO patient VALUES ('"+p.getID()+"',"+"'"+p.getDOB() +"'"+","+"'"+p.getName()+"'"+",'"+p.getPW()+"'"+",'"+p.getDoctorID()+"'"+")";
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
    
    public boolean deletePatient(String ID){
        boolean returnValue=true;
        try {
            connection=this.getConnection();
            
            String qs = "DELETE FROM patient WHERE ID='"+ID+"'";
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
    
    
    public boolean writeDoctor(doctor d){
        boolean returnValue=true;
        try {
            connection=this.getConnection();
            
            String qs = "INSERT INTO doctor VALUES ('"+d.getID()+"',"+"'"+d.getDOB() +"'"+","+"'"+d.getName()+"'"+","+"'"+d.getSpecial()+"'"+","+"'"+d.getLocation()+"'"+")";
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
    
    public boolean writeMedication(medication m){
        boolean returnValue=true;
        try {
            connection=this.getConnection();
            
            String qs = "INSERT INTO medication VALUES ('"+m.getID()+"',"+"'"+m.getName() +"'"+","+"'"+m.getType()+"')";
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
    
    public patient getPatientInfo(String ID)
    {
        patient p=null;
        try {
            connection=this.getConnection();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from patient where ID='"+ID+"'");
            
            Statement stmtAppoint = connection.createStatement();
            Statement stmtMed = connection.createStatement();
            Statement stmtBill = connection.createStatement();
            
            if(rs.next())
            {
                ResultSet rsAppoint = stmtAppoint.executeQuery("select * from appointment where ID = '"+ID+"' order by ID");
                
                List<appointment> a = new ArrayList<appointment>();
                
                ResultSet rsMed = stmtMed.executeQuery("select * from medication where ID = '"+ID+"' order by ID");
                List<medication> m = new ArrayList<medication>();
                
                ResultSet rsBill = stmtBill.executeQuery("select * from bill where ID = '"+ID+"'");
                bill b = null;
    
                if(rsBill.next())
                {
                    b = new bill(ID, rsBill.getString(2));
                }
                
                
                if(ID.equals(rs.getString(1)))
                {
                    while(rsAppoint.next())
                    {
                        a.add(new appointment(rsAppoint.getString(1),rsAppoint.getString(2),rsAppoint.getString(3),rsAppoint.getString(4)));
                    }
                    
                    while(rsMed.next())
                    {
                        m.add(new medication(rsMed.getString(1),rsMed.getString(1),rsMed.getString(1)));
                    }
                    
                    
                    p = new patient(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),a, m, b);
                    p.addDoctorToPatient(rs.getString(5));
                }
                else
                {
                    System.out.println("Wrong ID");
                    p = null;
                }
            }
            
            stmt.close();
            stmtAppoint.close();
            stmtMed.close();
            
            connection.close(); } catch (SQLException sqle){
                sqle.printStackTrace(); while (sqle != null) {
                    String logMessage = "\n SQL Error: "+ sqle.getMessage() + "\n\t\t"+
                    "Error code: "+sqle.getErrorCode() +
                    "\n\t\t"+
                    "SQLState: "+sqle.getSQLState()+"\n";
                    System.out.println(logMessage);
                    sqle = sqle.getNextException();
                }
                
                
            }
        
        return p;
    }
    
    public boolean putPatient(patient p)
    {
        try {
            connection=this.getConnection();
            
            Statement stmt = connection.createStatement();
            Statement stmtAppoint = connection.createStatement();
            Statement stmtMed = connection.createStatement();
            Statement stmtBill = connection.createStatement();
            
            String qs = "UPDATE patient SET ID='"+p.getID()+"',"+"DOB='"+p.getDOB() +"'"+","+"name='"+p.getName()+"'"+",password='"+p.getPW()+"'"+",DoctorId='"+p.getDoctorID()+"'";
            stmt.executeUpdate(qs);
            if(p.getAppointment()!=null)
            {
                for(int i=0; i<p.getAppointment().size(); i++)
                {
                    qs = "insert into appointment values ('"+p.getAppointment().get(i).getID()+"',"+"'"+p.getAppointment().get(i).getDate() +"'"+","+"'"+p.getAppointment().get(i).getTime()+"'"+")";
                    stmtAppoint.executeUpdate(qs);
                    
                }
            }
            
            if(p.getMedication()!=null)
            {
                for(int i=0; i<p.getMedication().size(); i++)
                {
                    qs = "insert into medication values ('"+p.getID()+"',"+"'"+p.getMedication().get(i).getName() +"')";
                    stmtMed.executeUpdate(qs);
                    
                }
            }
            
            qs = "insert into bill values ('"+p.getBill().getID()+"',"+"'"+p.getBill().viewBill() +"') ON DUPLICATE KEY UPDATE amount="+p.getBill().viewBill();
            stmtBill.executeUpdate(qs);
            
            
            stmt.close();
            stmtAppoint.close();
            stmtMed.close();
            stmtBill.close();
            
            connection.close(); } catch (SQLException sqle){
                sqle.printStackTrace(); while (sqle != null) {
                    String logMessage = "\n SQL Error: "+ sqle.getMessage() + "\n\t\t"+
                    "Error code: "+sqle.getErrorCode() +
                    "\n\t\t"+
                    "SQLState: "+sqle.getSQLState()+"\n";
                    System.out.println(logMessage);
                    sqle = sqle.getNextException(); 
                }
                
                
            }
        
        return true;
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
	