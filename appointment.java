package proj1;
public class appointment{
    
    private String time;
    private String date;
    private String ID;
    
    public appointment(String ID, String date, String TOD){
        
        time = TOD;
        this.date = date;
        this.ID = ID;
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
}