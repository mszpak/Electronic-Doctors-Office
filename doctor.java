package proj1;
public class doctor{
    
    private String doctorName;
    private String dateOfBirth;
    private String doctorID;
    private String special;
    private String location;
    
    
    public doctor(String ID, String DOB, String name, String special, String location)
    {
        doctorName = name;
        dateOfBirth = DOB;
        doctorID = ID;
        this.special = special;
        this.location = location;
        
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
    
}