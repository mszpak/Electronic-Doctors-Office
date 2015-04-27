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

public class PatientMenu extends JFrame implements ActionListener
{
		private int x = 30;
		private int h = 20;
		private int w = 180;
		
		private JButton butAddDoctor,butAddMedication,butAddPatient,butRemovePatient,
		butGetPatientInfo,butEditBill,butViewBill,butViewAppList,butViewAppNotes,butSchedApp,
		butEditApp,butPayBill,butExit;
		
		ArrayList<JButton> butList = new ArrayList<JButton>();		
		public PatientMenu(String name)
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
			butEditApp = new JButton("Edit Appointment Notes");
			butPayBill = new JButton("Pay Bill");
			butExit = new JButton("Exit");
			
			butList.add(butViewBill);
			butList.add(butViewAppList);
			butList.add(butViewAppNotes);
			butList.add(butSchedApp);
			butList.add(butEditApp);
			butList.add(butPayBill);
			butList.add(butExit);
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			for(JButton b: butList)
			{
				b.addActionListener(this);
			}
			


			butViewBill.setBounds(x, 0, w, h);
			butViewAppList.setBounds(x, h, w, h);
			butViewAppNotes.setBounds(x, 2*h, w, h);
			butExit.setBounds(x, 3*h, w, h);
			
			for(JButton b: butList)
			{
				this.add(b);
			}
			
			this.setSize(250,7*h);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			PatientMenu m = new PatientMenu("Menu");
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
			else if(e.getSource() == butEditApp)
			{
				EditAppointmentNotes o = new EditAppointmentNotes("Edit Patient's Appointment Notes");
			}
			else if(e.getSource() == butExit)
			{
				
			}
			
		}
}
