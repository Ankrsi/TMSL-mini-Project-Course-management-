package App_Windows;

import App_Windows.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.Color;

public class add_course
{
	public add_course()
	{
		JFrame add_frame = new JFrame("Add Course");
		
		JLabel course_name = new JLabel("Course Name");
		course_name.setForeground(Color.RED);
		course_name.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		course_name.setBounds(10, 30, 150, 20);
		add_frame.add(course_name);
		
		JTextField tf_course = new JTextField();
		tf_course.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_course.setBounds(315, 30, 350, 25);
		add_frame.add(tf_course);
		
		JLabel lbl_Duration_add = new JLabel("Course Duration");
		lbl_Duration_add.setForeground(Color.RED);
		lbl_Duration_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_Duration_add.setBounds(10, 77, 150, 20);
		add_frame.add(lbl_Duration_add);
		
		JTextField tf_Duration = new JTextField();
		tf_Duration.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_Duration.setBounds(315, 76, 350, 25);
		add_frame.add(tf_Duration);
		
		JLabel lbl_Instructor_add = new JLabel("Instructor");
		lbl_Instructor_add.setForeground(Color.RED);
		lbl_Instructor_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_Instructor_add.setBounds(10, 128, 150, 14);
		add_frame.add(lbl_Instructor_add);
			
		JTextField tf_Instructor = new JTextField();
		tf_Instructor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_Instructor.setBounds(315, 127, 350, 25);
		add_frame.add(tf_Instructor);
		
		JLabel lbl_Fee_add = new JLabel("Fee");
		lbl_Fee_add.setForeground(Color.RED);
		lbl_Fee_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_Fee_add.setBounds(10, 180, 150, 14);
		add_frame.add(lbl_Fee_add);
			
		JTextField tf_Fee = new JTextField();
		tf_Fee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_Fee.setBounds(315, 178, 350, 25);
		add_frame.add(tf_Fee);
		
		JLabel lbl_About_add = new JLabel("About");
		lbl_About_add.setForeground(Color.RED);
		lbl_About_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_About_add.setBounds(10, 230, 150, 14);
		add_frame.add(lbl_About_add);
			
		JTextField tf_About = new JTextField();
		tf_About.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_About.setBounds(315, 228, 350, 25);
		add_frame.add(tf_About);
		
		JButton btn_create_user = new JButton("Add Now");
		btn_create_user.setForeground(Color.RED);
		btn_create_user.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_create_user.setBounds(480, 360, 187, 23);
		add_frame.add(btn_create_user);
		btn_create_user.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String course = tf_course.getText();
				String duration = tf_Duration.getText();
				String instructor = tf_Instructor.getText();
				String fee = tf_Fee.getText();
				String about = tf_About.getText();
				if(course.equals("") || duration.equals("") || instructor.equals("") || fee.equals("") || about.equals("")) 
				{
					System.out.println("Fields cannot be null");
				}
				else 
				{
					try
					{
						//Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","anish");
						Statement st = conn.createStatement();
						int result = st.executeUpdate(String.format("insert into courses values ('%s','%s','%s','%s','%s')",course,duration,instructor,fee,about));
						if(result > 0)
						{
							JOptionPane.showMessageDialog(null," User added successfully");
							tf_course.setText("");
							tf_Duration.setText("");
							tf_Instructor.setText("");
							tf_Fee.setText("");
							tf_About.setText("");
						}
						else 
						{
							System.out.println("Insertion failed");
						}
					}	
					catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}		
				}
			}
		});
		
		JButton btn_reset = new JButton("Reset");
		btn_reset.setForeground(Color.RED);
		btn_reset.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_reset.setBounds(10, 360, 89, 23);
		add_frame.add(btn_reset);
		btn_reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf_course.setText("");
				tf_Duration.setText("");
				tf_Instructor.setText("");
				tf_Fee.setText("");
				tf_About.setText("");
			}
		});
		JButton btn_back = new JButton("Back");
		btn_back.setForeground(Color.RED);
		btn_back.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_back.setBounds(250, 360, 89, 23);
		add_frame.add(btn_back);
		btn_back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				add_frame.dispose();
				course_list_frame m = new course_list_frame(null);
			}
		});
		
		add_frame.setSize(750,450);
		add_frame.setLocationRelativeTo(null);
		add_frame.setBackground(Color.CYAN);
		add_frame.setLayout(null);
		add_frame.setVisible(true);
		add_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add_frame.getContentPane().setBackground(Color.CYAN);
	}
	public static void main(String args[])
	{
		add_course add_f = new add_course();
	}
}