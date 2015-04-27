package Graphics;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class DoctorMenu extends JFrame implements ActionListener
{
		private int x = 140;
		private int h = 20;
		private int w = 180;
		
		private JButton butAddDoctor,butAddMedication,butAddPatient,butRemovePatient,
		butGetPatientInfo,butEditBill,butViewBill,butViewAppList,butViewAppNotes,butSchedApp,
		butAddMedToP,butEditApp,butAddDocToP,butListDoctorPatient,butPayBill,butSearchP,butSearchM,butCompleteM,
		butAddPtoDoc,butDeleteDoc,butExit;
		
		ArrayList<JButton> butList = new ArrayList<JButton>();		
		public DoctorMenu(String name)
		{
			super(name);
			
			butAddDoctor = new JButton("Add Doctor");
			butAddMedication = new JButton("Add Medication");
			butAddPatient = new JButton("Add Patient");
			butRemovePatient = new JButton("Remove Patient");
			butGetPatientInfo = new JButton("Get Patient Info");
			butEditBill = new JButton("Edit Bill");
			butViewBill = new JButton("View Bill");
			butViewAppList = new JButton("View Appointment List");
			butViewAppNotes = new JButton("View Appointment Notes");
			butSchedApp = new JButton("Schedule Appointment");
			butAddMedToP = new JButton("Add Medication to Patient");
			butEditApp = new JButton("Edit Appointment Notes");
			butAddDocToP = new JButton("Add Doctor to Patient");
			butListDoctorPatient = new JButton("Get Doctors Patients");
			butPayBill = new JButton("Pay Bill");
			butSearchP = new JButton("Search Patient");
			butSearchM = new JButton("Search Medication");
			butCompleteM = new JButton("Complete Medication");
			butAddPtoDoc = new JButton("Add Patient to Doctor");
			butDeleteDoc = new JButton("Delete Doc from Patient");
			butExit = new JButton("Exit");
			
			butList.add(butAddDoctor);
			butList.add(butAddMedication);
			butList.add(butAddPatient);
			butList.add(butRemovePatient);
			butList.add(butGetPatientInfo);
			butList.add(butEditBill);
			butList.add(butViewBill);
			butList.add(butViewAppList);
			butList.add(butViewAppNotes);
			butList.add(butSchedApp);
			butList.add(butAddMedToP);
			butList.add(butEditApp);
			butList.add(butAddDocToP);
			butList.add(butListDoctorPatient);
			butList.add(butPayBill);
			butList.add(butSearchP);
			butList.add(butSearchM);
			butList.add(butCompleteM);
			butList.add(butAddPtoDoc);
			butList.add(butDeleteDoc);
			butList.add(butExit);
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			for(JButton b: butList)
			{
				b.addActionListener(this);
			}
			
			butAddDoctor.setBounds(x, 0, w, h);
			butAddMedication.setBounds(x, h, w, h);
			butAddPatient.setBounds(x, 2*h, w, h);
			butRemovePatient.setBounds(x, 3*h, w, h);
			butGetPatientInfo.setBounds(x, 4*h, w, h);
			butEditBill.setBounds(x, 5*h, w, h);
			butViewBill.setBounds(x, 6*h, w, h);
			butViewAppList.setBounds(x, 7*h, w, h);
			butViewAppNotes.setBounds(x, 8*h, w, h);
			butSchedApp.setBounds(x, 9*h, w, h);
			butAddMedToP.setBounds(x, 10*h, w, h);
			butEditApp.setBounds(x, 11*h, w, h);
			butAddDocToP.setBounds(x, 12*h, w, h);
			butListDoctorPatient.setBounds(x, 13*h, w, h);
			butPayBill.setBounds(x, 14*h, w, h);
			butSearchP.setBounds(x, 15*h, w, h);
			butSearchM.setBounds(x, 16*h, w, h);
			butCompleteM.setBounds(x, 17*h, w, h);
			butAddPtoDoc.setBounds(x, 18*h, w, h);
			butDeleteDoc.setBounds(x, 19*h, w, h);
			butExit.setBounds(x, 20*h, w, h);
			
			for(JButton b: butList)
			{
				this.add(b);
			}
			
			this.setSize(450,24*h);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			DoctorMenu m = new DoctorMenu("Menu");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == butAddDoctor)
			{
				AddDoctor d = new AddDoctor("Add a Doctor");
			}
			else if(e.getSource() == butAddMedication)
			{
				AddMedication m = new AddMedication("Add a Medication");
			}
			else if(e.getSource() == butAddPatient)
			{
				AddPatient p = new AddPatient("Add a Patient");
			}
			else if(e.getSource() == butRemovePatient)
			{
				RemovePatient r = new RemovePatient("Remove Patient");
			}
			else if(e.getSource() == butGetPatientInfo)
			{
				GetPatientInfo g = new GetPatientInfo("Get Patient Info");
			}
			else if(e.getSource() == butEditBill)
			{
				EditBill edit = new EditBill("Edit Patient Bill");
			}
			else if(e.getSource() == butViewBill)
			{
				ViewBill b = new ViewBill("View Patient Bill");
			}
			else if(e.getSource() == butViewAppList)
			{
				ViewAppointmentList a = new ViewAppointmentList("Get Appointment List");
			}
			else if(e.getSource() == butViewAppNotes)
			{
				ViewAppointmentNotes n = new ViewAppointmentNotes("View Appointment Notes");
			}
			else if(e.getSource() == butSchedApp)
			{
				ScheduleAppointment s = new ScheduleAppointment("Schedule an Appointment");
			}
			else if(e.getSource() == butAddMedToP)
			{
				AddMedicationToPatient m = new AddMedicationToPatient("Add medication to Patient");
			}
			else if(e.getSource() == butEditApp)
			{
				EditAppointmentNotes o = new EditAppointmentNotes("Edit Patient's Appointment Notes");
			}
			else if(e.getSource() == butAddDocToP)
			{
				AddDoctorToPatient p = new AddDoctorToPatient("Add a Doctor to a Patient");
			}
			else if(e.getSource() == butListDoctorPatient)
			{
				ListDoctorsPatients l = new ListDoctorsPatients("List a Doctor's patients");
			}
			else if(e.getSource() == butPayBill)
			{
				PayBill m = new PayBill("Pay Bill");
			}
			else if(e.getSource() == butSearchP)
			{
				SearchPatient l = new SearchPatient("Get a Patient");
			}
			else if(e.getSource() == butSearchM)
			{
				SearchMedication s = new SearchMedication("Get a Medication");
			}
			else if(e.getSource() == butCompleteM)
			{
				CompleteMedication s = new CompleteMedication("Complete a Medication");
			}
			else if(e.getSource() == butAddPtoDoc)
			{
				AddPatientToDoctor s = new AddPatientToDoctor("Add a patient to a doctor");
			}
			else if(e.getSource() == butDeleteDoc)
			{
				DeleteDoctorFromPatient s = new DeleteDoctorFromPatient("Delete a Doctor from Patient");
			}
			else if(e.getSource() == butExit)
			{
				
			}
			
		}
}
