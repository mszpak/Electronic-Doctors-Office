package Graphics;

import java.awt.Component;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;
import proj1.patient;

public class ListDoctorsPatients extends JFrame implements ActionListener{

	private JButton butSearch,butExit;
	private JLabel lblDoctorID;
	private JTextField doctorID;
	
	public ListDoctorsPatients(String name)
	{
		super(name);
		
		lblDoctorID = new JLabel("Doctor ID");
		doctorID = new JTextField();
		butSearch = new JButton("Search Doctor");
		butExit = new JButton("Back");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		butExit.addActionListener(this);
		butSearch.addActionListener(this);
		
		lblDoctorID.setBounds(30, 40, 100, 20);
		doctorID.setBounds(110, 40, 100, 20);
		butSearch.setBounds(110, 70, 120, 20);
		butExit.setBounds(220, 120, 60, 20);
		
		this.add(lblDoctorID);
		this.add(doctorID);
		this.add(butSearch);
		this.add(butExit);
		
		this.setSize(300,180);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		SearchPatient g = new SearchPatient("Search Doctor");

	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == butSearch)
		{
			String id = doctorID.getText();
			electronicDoctorsOffice d = new electronicDoctorsOffice();
			if(!(d.searchDoctor(id) == null))
			{
			    List<patient> list = d.listDoctorsPatients(id);
			    for(int i=0; i < list.size(); ++i)
			    {
					patient p = list.get(i);
					JFrame f1 = new JFrame("Patient Found");
					f1.setSize(400,400);
					f1.setVisible(true);
					JLabel name = new JLabel("Patient Name:");
					JLabel pid = new JLabel("Patient ID:");
					JLabel dob = new JLabel("Patient DOB:");
					JLabel pw = new JLabel("Patient PW:");
					
					JLabel lblName = new JLabel(p.getName());
					JLabel lblID = new JLabel(p.getID());
					JLabel lblBirth = new JLabel(p.getDOB());
					JLabel lblPW = new JLabel(p.getPW());
					
					name.setBounds(60, 80, 100, 20);
					pid.setBounds(80, 80, 100, 20);
					dob.setBounds(100, 80, 100, 20);
					pw.setBounds(120, 80, 100, 20);
					
					lblName.setBounds(60,180,100,20);
					lblID.setBounds(80,180,100,20);
					lblBirth.setBounds(100,180,100,20);
					lblPW.setBounds(120,180,100,20);
					
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(name);
					pan.add(pid);
					pan.add(dob);
					pan.add(pw);
					pan.add(lblName);
					pan.add(lblID);
					pan.add(lblBirth);
					pan.add(lblPW);
			    }
			}
			else
			{
				JFrame f1 = new JFrame("Did not find doctor");
				f1.setSize(200,75);
				f1.setVisible(true);
				JLabel lbl = new JLabel("Doctor Could Not Be Found");
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
