import java.util.ArrayList;
import java.util.List;


public class Patient {
	
	private String PatientName;
	private String DateOfBirth;
	private String PatientID;
	private List<Medication> Medication;
	private List<Doctor> Doctor;
	private List<Appointment> Appointment;
	
	public Patient(String name, String DOB, String ID)
	{
		PatientName = name;
		DateOfBirth = DOB;
		PatientID = ID;
		Medication = new ArrayList<Medication>();
		Doctor = new ArrayList<Doctor>();
		Appointment = new ArrayList<Appointment>();
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
	
	
}
