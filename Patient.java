package proj1;
import java.util.ArrayList;
import java.util.List;


public class patient {
	
    
    private String PatientName;
    private String DateOfBirth;
    private String PatientID;
    private String Password;
    private List<medication> medication;
    private String doctorID;
    private List<appointment> appointment;
    private bill bill;
    private String medicalAttribute;
    static int appointmentNumber = 0;
    
    public patient( String ID, String DOB, String name, String Password, List<appointment> appointment, List<medication> medication, bill bill)
    {
        PatientName = name;
        DateOfBirth = DOB;
        PatientID = ID;
        Password = "password";
        this.medication = new ArrayList<medication>();
        this.doctorID = "";
        this.appointment = appointment;
        this.bill = bill;
        medicalAttribute = "none";
    }
    
    public patient(String ID, String DOB, String name)
    {
    	PatientName = name;
    	DateOfBirth = DOB;
    	PatientID = ID;
    }
    
    /**
     * @return the name
     */
    public String getName()
    {
        return PatientName;
    }
    
    /**
     * @return DOB
     */
    public String getDOB()
    {
        return DateOfBirth;
    }
    
    /**
     * @return ID
     */
    public String getID()
    {
        return PatientID;
    }
    
    /**
     * @return Password
     */
    public String getPW()
    {
        return Password;
    }
    
    public List<appointment> getAppointment()
    {
        return appointment;
    }
    
    public List<appointment> addAppointment(appointment a)
    {
        appointment.add(a);
        return appointment;
    }
    
    public boolean replaceAppointmentList(List<appointment> a)
    {
    	appointment = a;
    	return true;
    }
    
    
    public List<medication> getMedication()
    {
        return medication;
    }
    
    public List<medication> addMedication(medication a)
    {
        medication.add(a);
        return medication;
    }
    
    public bill getBill()
    {
        return bill;
    }
    
    public boolean editBill(bill b)
    {
    	bill = b;
    	return true;
    }
    
    public String viewBill()
    {
        return bill.viewBill();
    }
    
    public String printInfo()
    {
    	return "ID: "+PatientID+", Name: "+PatientName+", Date of birth: "+DateOfBirth;
    }
    
    public String getDoctorID()
    {
    	return doctorID;
    }
	
    public boolean addDoctorToPatient(String doctorID)
    {
    	this.doctorID = doctorID;
		return true;
    	
    }

    //new
	public String viewApptNotes()
	{
		List<appointment> a = getAppointment();
		String notes = "";
		for(int i = 0; i < a.size(); i++){
			String temp = a.get(i).getNotes();
			notes = notes + temp + '\n';
		}
		return notes;
		
	}
	
	//new
	public String viewApptHistory()
	{
		List<appointment> a = getAppointment();
		String appointments = "";
		for(int i = 0; i < a.size(); i++){
			String ID = a.get(i).getID();
			String Date = a.get(i).getDate();
			String time = a.get(i).getTime();
			String temp = ID + " " + Date + " " + time + '\n';
			appointments = appointments + temp;
		}
		return appointments;
	}
	
	public boolean setMedicalAttribute(String med)
	{
		medicalAttribute = med;
		return true;
	}
	
	public String getMedicalAttribute()
	{
		return medicalAttribute;
	}
	
	public boolean deleteAppointment(String appID)
	{
		for(int i=0; i<appointment.size(); i++)
		{
			if(appointment.get(i).getID().equals(appID))
			{
				appointment.remove(i);
			}
		}
		return true;
	}
	
	public boolean deleteMedication(String name)
	{
		for(int i=0; i<medication.size(); i++)
		{
			if(medication.get(i).getName().equals(name))
			{
				appointment.remove(i);
			}
		}
		return true;
	}
	
	public boolean deleteDoctor(String dID)
	{
		doctorID = "none";
		return true;
	}
}
