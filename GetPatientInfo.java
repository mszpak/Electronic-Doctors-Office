package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class GetPatientInfo extends JFrame implements ActionListener{

	private JButton butGetPatient,butExit;
	private JLabel lblPatientID;
	private JTextField patientID;
	
	public GetPatientInfo(String name)
	{
		super(name);
		
		lblPatientID = new JLabel("Patient ID");
		patientID = new JTextField();
		butGetPatient = new JButton("Get Patient Info");
		butExit = new JButton("Back");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		butExit.addActionListener(this);
		butGetPatient.addActionListener(this);
		
		lblPatientID.setBounds(30, 40, 100, 20);
		patientID.setBounds(110, 40, 100, 20);
		butGetPatient.setBounds(110, 70, 120, 20);
		butExit.setBounds(220, 120, 60, 20);
		
		this.add(lblPatientID);
		this.add(patientID);
		this.add(butGetPatient);
		this.add(butExit);
		
		this.setSize(300,180);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		GetPatientInfo g = new GetPatientInfo("Get Patient Info");

	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butGetPatient)
		{
			String id = patientID.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			String patientInfo = d.printPatientInfo(id);
			JFrame f1 = new JFrame("Patient Info");
			f1.setSize(200,75);
			f1.setVisible(true);
			JLabel lbl = new JLabel(patientInfo);
			JPanel pan = new JPanel();
			f1.add(pan);
			pan.add(lbl);
		}
		
	}

}
