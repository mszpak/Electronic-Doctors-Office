package Graphics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class ViewAppointmentNotes extends JFrame implements ActionListener{

	private JButton butViewApp,butExit;
	private JLabel lblPatientID;
	private JTextField patientID;
	
	public ViewAppointmentNotes(String name)
	{
		super(name);
		
		lblPatientID = new JLabel("Patient ID");
		patientID = new JTextField();
		butViewApp = new JButton("View Appointment Notes");
		butExit = new JButton("Back");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		butExit.addActionListener(this);
		butViewApp.addActionListener(this);
		
		lblPatientID.setBounds(30, 40, 100, 20);
		patientID.setBounds(110, 40, 100, 20);
		butViewApp.setBounds(80, 70, 180, 20);
		butExit.setBounds(220, 120, 60, 20);
		
		this.add(lblPatientID);
		this.add(patientID);
		this.add(butViewApp);
		this.add(butExit);
		
		this.setSize(300,180);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ViewAppointmentNotes v = new ViewAppointmentNotes("Get Appointment Info");

	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butViewApp)
		{
			String id = patientID.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			String patientInfo = d.viewAppointmentNotes(id);
			JFrame f1 = new JFrame("View Appointment Notes");
			f1.setSize(300,200);
			f1.setVisible(true);
			JLabel lbl = new JLabel(patientInfo);
			JPanel pan = new JPanel();
			f1.add(pan);
			pan.add(lbl);
		}
		else if(e.getSource() == butExit)
		{
			setVisible(false);
			dispose();
		}
		
	}

}
