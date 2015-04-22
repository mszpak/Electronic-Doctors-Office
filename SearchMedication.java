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
import proj1.medication;
import proj1.patient;

public class SearchMedication extends JFrame implements ActionListener{

	private JButton butSearch,butExit;
	private JLabel lblMedicationID;
	private JTextField medicationID;
	
	public SearchMedication(String name)
	{
		super(name);
		
		lblMedicationID = new JLabel("Medication ID");
		medicationID = new JTextField();
		butSearch = new JButton("Search Medication");
		butExit = new JButton("Back");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		butExit.addActionListener(this);
		butSearch.addActionListener(this);
		
		lblMedicationID.setBounds(30, 40, 100, 20);
		medicationID.setBounds(110, 40, 100, 20);
		butSearch.setBounds(110, 70, 140, 20);
		butExit.setBounds(200, 120, 80, 20);
		
		this.add(lblMedicationID);
		this.add(medicationID);
		this.add(butSearch);
		this.add(butExit);
		
		this.setSize(300,180);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		SearchMedication g = new SearchMedication("Search Medication");

	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butSearch)
		{
			String id = medicationID.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			if(d.searchMedication(id) != null)
			{
				medication m = d.searchMedication(id);
				JFrame f1 = new JFrame("Medication Found");
				f1.setSize(400,400);
				f1.setVisible(true);
				JLabel name = new JLabel("Medication Name:");
				JLabel mid = new JLabel("Medication ID:");
				JLabel type = new JLabel("type:");
				
				JLabel lblName = new JLabel(m.getName());
				JLabel lblID = new JLabel(m.getID());
				JLabel lblType = new JLabel(m.getType());
				
				name.setBounds(60, 80, 100, 20);
				mid.setBounds(80, 80, 100, 20);
				type.setBounds(100, 80, 100, 20);
				
				lblName.setBounds(60,180,100,20);
				lblID.setBounds(80,180,100,20);
				lblType.setBounds(100,180,100,20);
				
				JPanel pan = new JPanel();
				f1.add(pan);
				pan.add(name);
				pan.add(mid);
				pan.add(type);
				pan.add(lblName);
				pan.add(lblID);
				pan.add(lblType);
				
			}
			else
			{
				JFrame f1 = new JFrame("Did not find medication");
				f1.setSize(200,75);
				f1.setVisible(true);
				JLabel lbl = new JLabel("Medication Could Not Be Found");
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