package App_Windows;

import App_Windows.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

public class main_window
{
	public  main_window()
	{
		JFrame main_frame = new JFrame("TECOSOURA");
		JButton btn_newUser = new JButton("New User");
		JButton btn_existingUser = new JButton("Already a user");
		btn_newUser.setBounds(93, 75, 218, 23);
		btn_existingUser.setBounds(93, 132, 218, 23);
		main_frame.add(btn_newUser);
		main_frame.add(btn_existingUser);
		btn_existingUser.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_existingUser.setForeground(Color.BLACK);
		btn_existingUser.setBackground(Color.RED);
		btn_existingUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				main_frame.setVisible(false);
				Login loginf = new Login();
				loginf.login();
			}
		});
		btn_newUser.setForeground(Color.BLACK);
		btn_newUser.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_newUser.setBackground(Color.RED);
		btn_newUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				main_frame.setVisible(false);
				new_user_frame nu = new new_user_frame();
				
			}
		});
		main_frame.getContentPane().setBackground(Color.CYAN);
		main_frame.getContentPane().setLayout(null);
		main_frame.setBounds(100, 100, 450, 300);
		main_frame.setVisible(true);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		main_window main_win = new main_window();
	}
}
