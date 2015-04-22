package proj1;

import java.util.ArrayList;
import java.util.List;

public class doctor{
    
    private String doctorName;
    private String dateOfBirth;
    private String doctorID;
    private String special;
    private String location;
    private List<patient> patients;
    
    
    public doctor(String ID, String DOB, String name, String special, String location, List<patient> patients)
    {
        doctorName = name;
        dateOfBirth = DOB;
        doctorID = ID;
        this.special = special;
        this.location = location;
        this.patients = patients;
    }
    
    public String getName(){
        
        return doctorName;
    }
    
    public String getDOB(){
        
        return dateOfBirth;
    }
    
    public String getID(){
        
        return doctorID;
    }
    
    public String getSpecial(){
        
        return special;
    }
    
    public String getLocation(){
        
        return location;
    }
    
    public List<patient> getPatients()
    {
    	return patients;
    }
    
    public String listPatients()
    {
    	String patients = "";
    	List<patient> p = getPatients();
    	for(int i = 0; i < p.size(); i++)
    	{
    		String temp = p.get(i).getID();
    		patients = patients + temp + '\n';
    	}
    	return patients;
    }
    
    public boolean addPatient(patient p)
    {
    	patients.add(p);
    	return true;
    }
    
}