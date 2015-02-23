public class appointment{
    
    private String time;
    private String date;
    
    public appointment(String TOD, String date){
        
        time = TOD;
        date = this.date;
    }
    
    public String getAppointment(){
        
        String thisAppointment = (date + "-" + time);
        return thisAppointment;
        
    }
}