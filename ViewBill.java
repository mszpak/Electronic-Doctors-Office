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

public class ViewBill extends JFrame implements ActionListener{

	private JButton butViewBill,butExit;
	private JLabel lblPatientID;
	private JTextField patientID;
	
	public ViewBill(String name)
	{
		super(name);
		
		lblPatientID = new JLabel("Patient ID");
		patientID = new JTextField();
		butViewBill = new JButton("View Bill");
		butExit = new JButton("Back");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		butExit.addActionListener(this);
		butViewBill.addActionListener(this);
		
		lblPatientID.setBounds(30, 40, 100, 20);
		patientID.setBounds(110, 40, 100, 20);
		butViewBill.setBounds(110, 70, 120, 20);
		butExit.setBounds(220, 120, 60, 20);
		
		this.add(lblPatientID);
		this.add(patientID);
		this.add(butViewBill);
		this.add(butExit);
		
		this.setSize(300,180);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		GetPatientInfo g = new GetPatientInfo("Get Patient Info");

	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butViewBill)
		{
			String id = patientID.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			String patientInfo = d.viewBill(id);
			JFrame f1 = new JFrame("Patient Info");
			f1.setSize(200,75);
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
