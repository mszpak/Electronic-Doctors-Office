package proj1;
public class doctor{
    
    private String doctorName;
    private String dateOfBirth;
    private String doctorID;
    
    
    public doctor(String name, String DOB, String ID)
    {
        doctorName = name;
        dateOfBirth = DOB;
        doctorID = ID;
        
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
    
}