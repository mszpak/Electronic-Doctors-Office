package proj1;
public class appointment{
    
    private String time;
    private String date;
    private String ID;
    private String notes;
    private int price;
    
    public appointment(String ID, String date, String TOD, String notes){
        
        time = TOD;
        this.date = date;
        this.ID = ID;
        this.notes = notes;
        this.price = 100;
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
    
    //new
    public int getPrice()
    {
    	return price;
    }
}