package proj1;

import java.util.ArrayList;
import java.util.List;

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
        doctor d = new doctor(ID,DOB,Name,special,location, null);
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
        p.addAppointment(new appointment(ID, time, date, "", ID+date));
        this.getDatabaseSupportInstance().putPatient(p);
        return true;
    }
    
    public boolean assignMedication(String ID, String name, String type)
    {
        patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
        p.addMedication(new medication(ID, name, type));
        this.getDatabaseSupportInstance().putPatient(p);
        return true;
    }
    
    public String viewBill(String ID)
    {
        patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
        return p.viewBill();
    }
    
    public String printPatientInfo(String ID)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
    	return p.printInfo();
    }
    
    public boolean editPatientBilling(String ID, String amount)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
    	bill b = new bill(p.getBill().getID(), amount);
    	p.editBill(b);
    	this.getDatabaseSupportInstance().putPatient(p);
        return true;
    }
    
    public boolean rescheduleAppointment(String ID, String aID, String Date, String Time)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
    	List<appointment> a = p.getAppointment();
    	int exists = 0;
    	for(int i=0; i<a.size(); i++)
    	{
    		if(a.get(i).getappID().equals(aID))
    		{
    			a.get(i).setDate(Date);
    			a.get(i).setTime(Time);
    			exists = 1;
    		}

    	
    	}
    	if(exists == 0)
    	{
    		a.add(new appointment(ID, Date, Time, "", aID));

    	}
    	p.replaceAppointmentList(a);
    	this.getDatabaseSupportInstance().putPatient(p);
    	return true;
    }
    
   
    public boolean addDoctorToPatient(String doctorID, String patientID)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(patientID);
    	p.addDoctorToPatient(doctorID);
    	this.getDatabaseSupportInstance().putPatient(p);
		return true;
    	
    }
    

    public String viewAppointmentNotes(String patientID)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(patientID);
    	
    	return p.viewApptNotes();
    }
    
 
    public String viewAppointmentHistory(String patientID)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(patientID);
    	
    	return p.viewApptHistory();
    }
    
  
    public String calculateBill(String patientID)
    {
    	int billTotal = 0;
    	String calculated = "You owe: ";
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(patientID);
    	List<appointment> a = p.getAppointment();
    	for(int i = 0; i < a.size(); i++)
    	{
    		billTotal = billTotal + a.get(i).getPrice();
    	}
    	return calculated + "$" + billTotal;
    }
    
    //do this
    public boolean editPatientMedicalAttributes(String patientID, String medicalAttributes)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(patientID);
    	p.setMedicalAttribute(medicalAttributes);
    
    	this.getDatabaseSupportInstance().putPatient(p);
        return true;
    	
    }
    
    //do this
    public boolean editPatientNotes(String patientID, String aID ,String notes)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(patientID);
    	List<appointment> a = p.getAppointment();
    	for(int i=0; i<a.size(); i++)
    	{
    		if(a.get(i).getappID().equals(aID))
    		{
    			a.get(i).editNote(notes);
    		}
    	}
    	p.replaceAppointmentList(a);
    	this.getDatabaseSupportInstance().putPatient(p);
    	return true;
    }
    
    public boolean addMedication(String ID, String Name, String type)
    {
    	medication m = new medication(ID,Name,type);
        return this.getDatabaseSupportInstance().writeMedication(m);
    }
    
    public boolean payBill(String ID)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
    	bill b = new bill(p.getBill().getID(), "0");
    	p.editBill(b);
    	this.getDatabaseSupportInstance().putPatient(p);
        return true;
    }
    
    public doctor searchDoctor(String ID)
    {
    	return this.getDatabaseSupportInstance().getDoctor(ID);
    }
    
    public patient searchPatient(String ID)
    {
    	return this.getDatabaseSupportInstance().getPatientInfo(ID);
    }
    
    public medication searchMedication(String name)
    {
    	return this.getDatabaseSupportInstance().getMedication(name);
    }
    
    public boolean deleteAppointment(String pID, String aID)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(pID);
    	p.deleteAppointment(aID);
    	this.getDatabaseSupportInstance().putPatient(p);
    	return true;
    }

    public boolean completeMedication(String ID, String name)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(ID);
    	p.deleteMedication(name);
    	this.getDatabaseSupportInstance().putPatient(p);
    	return true;
    }
    
    public List<patient> listDoctorsPatients(String ID)
    {
    	doctor d = this.getDatabaseSupportInstance().getDoctor(ID);
    	return d.getPatients();
    }
    
    public boolean deleteDoctorFromPatient(String dID, String pID)
    {
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(pID);
    	p.deleteDoctor(dID);
    	this.getDatabaseSupportInstance().putPatient(p);
    	return true;
    }
    
    public boolean addPatientToDoctor(String dID, String pID)
    {
    	doctor d = this.getDatabaseSupportInstance().getDoctor(dID);
    	patient p = this.getDatabaseSupportInstance().getPatientInfo(pID);
    	d.addPatient(p);
    	this.getDatabaseSupportInstance().writeDoctor(d);
    	return true;
    }
    
    public DatabaseSupport getDatabaseSupportInstance()
    {
        if(ds==null)
        {
            ds = new DatabaseSupport();
        }
        return ds;
    }

	public int getAuthority(String id) {
		 return this.getDatabaseSupportInstance().getAuthority(id);
	}

	public boolean userExists(String patientID) {
		return this.getDatabaseSupportInstance().userExists(patientID);
	}
    
}