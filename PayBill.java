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

public class PayBill extends JFrame implements ActionListener{

	private JButton butPayBill,butExit;
	private JLabel lblPatientID;
	private JTextField patientID;
	
	public PayBill(String name)
	{
		super(name);
		
		lblPatientID = new JLabel("Patient ID");
		patientID = new JTextField();
		butPayBill = new JButton("Pay Bill");
		butExit = new JButton("Back");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		butExit.addActionListener(this);
		butPayBill.addActionListener(this);
		
		lblPatientID.setBounds(30, 40, 100, 20);
		patientID.setBounds(110, 40, 100, 20);
		butPayBill.setBounds(110, 70, 120, 20);
		butExit.setBounds(220, 120, 60, 20);
		
		this.add(lblPatientID);
		this.add(patientID);
		this.add(butPayBill);
		this.add(butExit);
		
		this.setSize(300,180);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		PayBill g = new PayBill("Pay Bill");

	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butPayBill)
		{
			String id = patientID.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			if(d.payBill(id))
			{
				JFrame f1 = new JFrame("Pay Bill");
				f1.setSize(200,75);
				f1.setVisible(true);
				JLabel lbl = new JLabel("Bill paid Successfully");
				JPanel pan = new JPanel();
				f1.add(pan);
				pan.add(lbl);
			}
			else
			{
				JFrame f1 = new JFrame("Pay Bill");
				f1.setSize(200,75);
				f1.setVisible(true);
				JLabel lbl = new JLabel("Bill was not paid Successfully");
				JPanel pan = new JPanel();
				f1.add(pan);
				pan.add(lbl);
			}
		}
		else if(e.getSource() == butExit)
		{
			setVisible(false);
			dispose();
		}
	}

}
