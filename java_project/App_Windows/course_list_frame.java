package App_Windows;

import App_Windows.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class course_list_frame
{
	public course_list_frame(String name)
	{
		JFrame list_f = new JFrame("Course List");
		DefaultListModel<String> add_list = new DefaultListModel<>();
		JList list = new JList(add_list);
		list.setBounds(20,60,530,350);
		JButton back_button = new JButton("Back");
		back_button.setBounds(10,8,60,40);
		back_button.setForeground(Color.RED);
		back_button.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		back_button.setBackground(Color.CYAN);
		back_button.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		back_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				list_f.dispose();
				Login l = new Login();
				l.login();
			}
		});
		
		
		JButton btn_add_course = new JButton("Add course");
		btn_add_course.setBounds(480, 14,100, 20);
		btn_add_course.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				list_f.dispose();
				add_course l = new add_course();
			}
		});
		
		
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","anish");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("select course_name from courses");
			while(result.next())
			{
				add_list.addElement(result.getString("course_name"));
			}
	    }	
		catch(Exception ex)
	    {
			System.out.println(ex.getMessage());
		}
		JButton show_button = new JButton("Show Course");
		show_button.setBounds(220, 420, 120, 30);
		show_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				list_f.setVisible(false);
				String s = String.valueOf(list.getSelectedValue());
				course_about_frame about = new course_about_frame(s);
				
			}
        });
		
		JLabel lbl_student = new JLabel("Student ID");
		lbl_student.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lbl_student.setForeground(Color.RED);
		lbl_student.setBounds(100, 11, 186, 27);
		list_f.add(lbl_student);
		
		JLabel lbl_student_name = new JLabel(name);
		lbl_student_name.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lbl_student_name.setForeground(Color.RED);
		lbl_student_name.setBounds(180, 11, 186, 27);
		list_f.add(lbl_student_name);
		
		list_f.add(list);
		list_f.add(back_button);
		list_f.add(btn_add_course);
		list_f.add(show_button);
		list_f.setLayout(null);
        list_f.setSize(600, 500);
        list_f.getContentPane().setBackground(Color.CYAN);
        list_f.setLocationRelativeTo(null);
        list_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list_f.setVisible(true);
		
		
	}
	public static void main(String []args)
	{
		course_list_frame cl = new course_list_frame(null);
	}
}