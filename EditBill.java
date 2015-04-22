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

public class EditBill extends JFrame implements ActionListener{

	private JButton butChangeBill,butViewCurrentBill,butExit;
	private JLabel lblPatientID, lblAmount, lblCurrentAmount;
	private JTextField patientID, amount;
	
	public EditBill(String name)
	{
		super(name);
		
		lblPatientID = new JLabel("Patient ID");
		lblCurrentAmount = new JLabel("unknown");
		lblCurrentAmount.setVisible(false);
		lblAmount = new JLabel("Amount");
		patientID = new JTextField();
		amount = new JTextField();
		butChangeBill = new JButton("Change Bill");
		butViewCurrentBill = new JButton("View Current Bill");
		butExit = new JButton("Back");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		butExit.addActionListener(this);
		butChangeBill.addActionListener(this);
		butViewCurrentBill.addActionListener(this);
		
		lblPatientID.setBounds(30, 40, 100, 20);
		patientID.setBounds(110, 40, 100, 20);
		lblAmount.setBounds(50, 60, 80, 20);
		amount.setBounds(110, 60, 40, 20);
		butViewCurrentBill.setBounds(110, 90, 130, 20);
		lblCurrentAmount.setBounds(200, 90, 50, 20);
		butChangeBill.setBounds(110, 110, 120, 20);
		butExit.setBounds(2600, 120, 60, 20);
		
		this.add(lblPatientID);
		this.add(patientID);
		this.add(butViewCurrentBill);
		this.add(lblCurrentAmount);
		this.add(amount);
		this.add(lblAmount);
		this.add(butChangeBill);
		this.add(butExit);
		
		this.setSize(400,400);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		EditBill b = new EditBill("Edit Bill");

	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butChangeBill)
		{
			String id = patientID.getText();
			String change = amount.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			d.editPatientBilling(id, change);
			
		}
		else if(e.getSource() == butViewCurrentBill)
		{
			String id = patientID.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			lblCurrentAmount.setText(d.viewBill(id));
			
		}
		else if(e.getSource() == butExit)
		{
			setVisible(false);
			dispose();
		}
	}

}
