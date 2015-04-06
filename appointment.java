package proj1;
public class appointment{
    
    private String time;
    private String date;
    private String ID;
    private String notes;
    private int price;
    private int apptNumber;

    
    public appointment(String ID, String date, String TOD, String notes){
        
        time = TOD;
        this.date = date;
        this.ID = ID;
        this.notes = notes;
        this.price = 100;
        this.apptNumber = patient.appointmentNumber;
        patient.appointmentNumber++;
    }
    
    public String getAppointment(){
        
        String thisAppointment = (date + "-" + time);
        return thisAppointment;
        
    }
    
    public String getTime()
    {
        return time;
    }
    public String getDate()
    {
        return date;
    }
    public String getID()
    {
        return ID;
    }
    public boolean setTime(String t)
    {
    	time = t;
    	return true;
    }
    public boolean setDate(String d)
    {
    	date = d;
    	return true;
    }
    
    //new
    public String getNotes()
    {
    	return notes;
    }
    
    public boolean setNotes(String n)
    {
    	notes = n;
    	return true;
    }
    
    //new
    public int getPrice()
    {
    	return price;
    }
    
    public int getApptNumber()
    {
    	return apptNumber;
    }
}