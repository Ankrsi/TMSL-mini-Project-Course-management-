package App_Windows;

import App_Windows.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.Color;

public class new_user_frame
{
	public new_user_frame()
	{
		JFrame new_user_frame = new JFrame("Registration");
		
		JLabel lbl_name_add = new JLabel("Name");
		lbl_name_add.setForeground(Color.RED);
		lbl_name_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_name_add.setBounds(10, 30, 150, 20);
		new_user_frame.add(lbl_name_add);
		
		JTextField tf_name = new JTextField();
		tf_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_name.setBounds(315, 30, 350, 25);
		new_user_frame.add(tf_name);
		
		JLabel lbl_phNo_add = new JLabel("Phone number");
		lbl_phNo_add.setForeground(Color.RED);
		lbl_phNo_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_phNo_add.setBounds(10, 77, 150, 20);
		new_user_frame.add(lbl_phNo_add);
		
		JTextField tf_phNo = new JTextField();
		tf_phNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_phNo.setBounds(315, 76, 350, 25);
		new_user_frame.add(tf_phNo);
		
		JLabel lbl_uid_add = new JLabel("user-id");
		lbl_uid_add.setForeground(Color.RED);
		lbl_uid_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_uid_add.setBounds(10, 128, 150, 14);
		new_user_frame.add(lbl_uid_add);
			
		JTextField tf_uid = new JTextField();
		tf_uid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_uid.setBounds(315, 127, 350, 25);
		new_user_frame.add(tf_uid);
		
		JLabel lbl_password_add = new JLabel("Password");
		lbl_password_add.setForeground(Color.RED);
		lbl_password_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_password_add.setBounds(10, 180, 150, 14);
		new_user_frame.add(lbl_password_add);
			
		JPasswordField tf_pass = new JPasswordField();
		tf_pass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_pass.setBounds(315, 178, 350, 25);
		new_user_frame.add(tf_pass);
		
		JButton btn_create_user = new JButton("Create account");
		btn_create_user.setForeground(Color.RED);
		btn_create_user.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_create_user.setBounds(480, 360, 187, 23);
		new_user_frame.add(btn_create_user);
		btn_create_user.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String name = tf_name.getText();
				String phNo = tf_phNo.getText();
				String uid = tf_uid.getText();
				String password = tf_pass.getText();
				if(name.equals("") || phNo.equals("") || uid.equals("") || password.equals("")) 
				{
					System.out.println("Fields cannot be null");
				}
				else 
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","anish");
						Statement st = conn.createStatement();
						int result = st.executeUpdate(String.format("insert into login values ('%s','%s','%s','%s')",name,uid,password,phNo));
						if(result > 0)
						{
							JOptionPane.showMessageDialog(null," User added successfully");
							course_list_frame cl = new course_list_frame(null);
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
		new_user_frame.add(btn_reset);
		btn_reset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf_name.setText("");
				tf_phNo.setText("");
				tf_uid.setText("");
				tf_pass.setText("");	
			}
		});
		JButton btn_back = new JButton("Back");
		btn_back.setForeground(Color.RED);
		btn_back.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_back.setBounds(250, 360, 89, 23);
		new_user_frame.add(btn_back);
		btn_back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				main_window m = new main_window();
				new_user_frame.dispose();
			}
		});
		
		new_user_frame.setSize(750,450);
		new_user_frame.setLocationRelativeTo(null);
		new_user_frame.setBackground(Color.CYAN);
		new_user_frame.setLayout(null);
		new_user_frame.setVisible(true);
		new_user_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new_user_frame.getContentPane().setBackground(Color.CYAN);
	}
	public static void main(String args[])
	{
		new_user_frame nuf = new new_user_frame();
	}
}
