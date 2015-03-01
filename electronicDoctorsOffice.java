public class electronicDoctorsOffice {
    
    private DatabaseSupport ds = null;
    
    public electronicDoctorsOffice()
    {
    	
    }
    
    public boolean addPatient(String ID, String DOB, String Name)
    {
    	patient p = new patient(ID, DOB, Name);
    	return this.getDatabaseSupportInstance().writePatient(p);
    }
    
    public boolean registerUser(String ID, String PW, int position)
    {
    	return this.getDatabaseSupportInstance().registerUser(ID, PW, position);
    }
    
    public boolean login(String ID, String PW)
    {
    	return this.getDatabaseSupportInstance().login(ID, PW);
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