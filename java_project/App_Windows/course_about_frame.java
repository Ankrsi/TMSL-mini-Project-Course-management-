package App_Windows;

import App_Windows.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;

public class course_about_frame
{	
	public course_about_frame(String name) 
	{
		JFrame frame = new JFrame("About Course");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setLayout(null);
		
		JLabel lbl_Course_Name = new JLabel("Course Name");
		lbl_Course_Name.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_Course_Name.setForeground(Color.RED);
		lbl_Course_Name.setBounds(10, 79, 140, 14);
		frame.add(lbl_Course_Name);
		
		JTextField tf_cName = new JTextField();
		tf_cName.setEditable(false);
		tf_cName.setBounds(194, 76, 200, 20);
		frame.add(tf_cName);
		
		JLabel lbl_Course_duration = new JLabel("Duration");
		lbl_Course_duration.setForeground(Color.RED);
		lbl_Course_duration.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_Course_duration.setBounds(10, 121, 140, 14);
		frame.add(lbl_Course_duration);
		
		JTextField tf_cDuration = new JTextField();
		tf_cDuration.setEditable(false);
		tf_cDuration.setBounds(194, 118, 200, 20);
		frame.add(tf_cDuration);
		
		JLabel lbl_instructor_name = new JLabel("Instructor's Name ");
		lbl_instructor_name.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_instructor_name.setForeground(Color.RED);
		lbl_instructor_name.setBounds(10, 204, 140, 14);
		frame.add(lbl_instructor_name);
		
		JTextField tf_instrName = new JTextField();
		tf_instrName.setEditable(false);
		tf_instrName.setBounds(194, 201, 200, 20);
		frame.add(tf_instrName);
		
		JLabel lbl_instructor_about = new JLabel("About the Instructor");
		lbl_instructor_about.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_instructor_about.setForeground(Color.RED);
		lbl_instructor_about.setBounds(10, 243, 140, 14);
		frame.add(lbl_instructor_about);
		
		JTextArea tA_instrAbout = new JTextArea();
		tA_instrAbout.setWrapStyleWord(true);
		tA_instrAbout.setLineWrap(true);
		tA_instrAbout.setEditable(false);
		tA_instrAbout.setBounds(194, 238, 300, 100);
		frame.add(tA_instrAbout);
		
		JLabel lbl_Course_fee = new JLabel("Course Fee");
		lbl_Course_fee.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_Course_fee.setForeground(Color.RED);
		lbl_Course_fee.setBounds(10, 161, 140, 14);
		frame.add(lbl_Course_fee);
		
		JTextField tf_cFee = new JTextField();
		tf_cFee.setEditable(false);
		tf_cFee.setBounds(194, 158, 200, 20);
		frame.add(tf_cFee);
		
		JLabel lbl_COURSE_DETAILS =new JLabel("Course Details");
		lbl_COURSE_DETAILS.setForeground(new Color(85, 107, 47));
		lbl_COURSE_DETAILS.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_COURSE_DETAILS.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lbl_COURSE_DETAILS.setBounds(121, 11, 267, 34);
		frame.add(lbl_COURSE_DETAILS);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				course_list_frame cf = new course_list_frame(null);
			}
		});
		
		btn_back.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btn_back.setBounds(485, 11, 89, 23);
	
		frame.add(btn_back);
		frame.setVisible(true);
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","anish");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(String.format("select * from courses where course_name='%s'",name));
			if(result.next()) 
			{
				tf_cName.setText(result.getString("course_name"));
				tf_cDuration.setText(result.getString("course_duration"));
				tf_cFee.setText(result.getString("fee"));
				tf_instrName.setText(result.getString("instructor"));
				tA_instrAbout.setText(result.getString("about"));
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		course_about_frame about_frame = new course_about_frame(null);
	}
}
