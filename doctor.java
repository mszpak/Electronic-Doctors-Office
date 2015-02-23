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
    
    public getName(){
        
        return doctorName;
    }
    
    public getDOB(){
     
        return dateOfBirth;
    }
    
    public getID(){
        
        return doctorID;   
    }
    
}