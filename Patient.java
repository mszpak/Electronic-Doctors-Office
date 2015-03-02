package proj1;
import java.util.ArrayList;
import java.util.List;


public class patient {
	
	private String PatientName;
	private String DateOfBirth;
	private String PatientID;
	//private List<medication> medication;
	//private List<doctor> doctor;
	//private List<appointment> appointment;
	
	public patient( String ID, String DOB, String name)
	{
		PatientName = name;
		DateOfBirth = DOB;
		PatientID = ID;
		//medication = new ArrayList<medication>();
		//doctor = new ArrayList<doctor>();
		//appointment = new ArrayList<appointment>();
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
