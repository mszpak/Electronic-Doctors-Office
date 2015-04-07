package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proj1.electronicDoctorsOffice;

public class ScheduleAppointment extends JFrame implements ActionListener
{
		
		private JButton AddToDatabase,butReset,butExit;
		private JTextField appointmentTime;
		private JTextField ID;
		private JTextField date;
		private JLabel lblTime, lblID, lblDate;
		
		public ScheduleAppointment(String name)
		{
			super(name);
			AddToDatabase = new JButton("Add Appointment");
			butReset = new JButton("Reset");
			butExit = new JButton("Exit");
			appointmentTime = new JTextField();
			ID = new JTextField();
			date = new JTextField();
			lblTime = new JLabel("Appointment Time");
			lblID = new JLabel("ID");
			lblDate = new JLabel("Appointment Date");
			
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			AddToDatabase.addActionListener(this);
			butReset.addActionListener(this);
			butExit.addActionListener(this);
			
			lblTime.setBounds(10,10,120,20);
			lblID.setBounds(10,30,120,20);
			lblDate.setBounds(10,50,120,20);
			date.setBounds(140,50,80,20);
			appointmentTime.setBounds(140,10,160,20);
			ID.setBounds(140,30,160,20);

			
			AddToDatabase.setBounds(140, 80, 135, 20);
			butReset.setBounds(275, 80, 70, 20);
			butExit.setBounds(330, 180, 70, 20);
			
			this.add(AddToDatabase);
			this.add(butReset);
			this.add(butExit);
			this.add(appointmentTime);
			this.add(ID);
			this.add(date);
			this.add(lblTime);
			this.add(lblID);
			this.add(lblDate);
			
			this.setSize(450,250);
			this.setVisible(true);
		}

		public static void main(String[] args)
		{
			ScheduleAppointment m = new ScheduleAppointment("Add Appointment");
		}
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == AddToDatabase)
			{
				if(ID.getText().equals(null) || ID.getText().equals(""))
				{
					JFrame f1 = new JFrame("enter ID");
					f1.setSize(200,75);
					f1.setVisible(true);
					JLabel lbl = new JLabel("An appointment must have an ID");
					JPanel pan = new JPanel();
					f1.add(pan);
					pan.add(lbl);
				}
				else
				{
					String appID = ID.getText();
					String appTime = appointmentTime.getText();
					String appDate = date.getText();
					electronicDoctorsOffice d = new electronicDoctorsOffice();
					if(d.scheduleAppointment(appID, appTime, appDate))
					{
						JFrame f1 = new JFrame("Appointment Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The appointment was added successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
					else
					{
						JFrame f1 = new JFrame("Appointment Not Added");
						f1.setSize(200,75);
						f1.setVisible(true);
						JLabel lbl = new JLabel("The appointment was not added successfully");
						JPanel pan = new JPanel();
						f1.add(pan);
						pan.add(lbl);
					}
				}
			}
			
		}
}
