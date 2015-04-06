package proj1;
import java.util.ArrayList;
import java.util.List;


public class patient {
	
    
    private String PatientName;
    private String DateOfBirth;
    private String PatientID;
    private String Password;
    private List<medication> medication;
    private List<doctor> doctor;
    private List<appointment> appointment;
    private bill bill;
    
    public patient( String ID, String DOB, String name, String Password, List<appointment> appointment, List<medication> medication, bill bill)
    {
        PatientName = name;
        DateOfBirth = DOB;
        PatientID = ID;
        Password = "password";
        this.medication = new ArrayList<medication>();
        this.doctor = new ArrayList<doctor>();
        this.appointment = appointment;
        this.bill = bill;
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
	
    //new
    public boolean addDoctorToPatient(doctor d)
    {
    	doctor.add(d);
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
	
}
