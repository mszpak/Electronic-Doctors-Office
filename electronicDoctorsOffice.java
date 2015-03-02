package proj1;
public class electronicDoctorsOffice {
    
    private DatabaseSupport ds = null;
    
    public electronicDoctorsOffice()
    {
    	
    }
    
    public boolean addPatient(String ID, String DOB, String Name)
    {
        patient p1 = new patient(ID, DOB, Name ,"password", null, null, null);
        registerUser(ID, p1.getPW(), 0);
        return this.getDatabaseSupportInstance().writePatient(p1);
    }
    
    public boolean deletePatient(String ID)
    {
        return this.getDatabaseSupportInstance().deletePatient(ID);
    }
    
    public boolean addDoctor(String ID, String DOB, String Name, String special, String location)
    {
        doctor d = new doctor(ID,DOB,Name,special,location);
        return this.getDatabaseSupportInstance().writeDoctor(d);
    }
    
    public boolean registerUser(String ID, String PW, int position)
    {
        return this.getDatabaseSupportInstance().registerUser(ID, PW, position);
    }
    
    public boolean login(String ID, String PW)
    {
        return this.getDatabaseSupportInstance().login(ID, PW);
    }
    
    public boolean scheduleAppointment(String ID, String time, String date)
    {
        patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
        p.addAppointment(new appointment(ID, time, date));
        this.getDatabaseSupportInstance().putPatient(p);
        return true;
    }
    
    public boolean assignMedication(String ID, String name)
    {
        patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
        p.addMedication(new medication(ID, name));
        this.getDatabaseSupportInstance().putPatient(p);
        return true;
    }
    
    public String viewBill(String ID)
    {
        patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
        return p.viewBill();
    }
    
    private DatabaseSupport getDatabaseSupportInstance()
    {
        if(ds==null)
        {
            ds = new DatabaseSupport();
        }
        return ds;
    }
    
}