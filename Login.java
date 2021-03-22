import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Login
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Login");
		
		JButton button =new JButton("click");
		JTextField text1 =new JTextField();
		JTextField text2 =new JTextField();
		JLabel label1 = new JLabel("Username");
		JLabel label2 = new JLabel("Passward");
		
		label1.setBounds(50,100,220,30);
		label2.setBounds(50,150,220,30);
		text1.setBounds(120,100,220,30);
		text2.setBounds(120,150,220,30);
		button.setBounds(130,200,100,40);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String value1=text1.getText();
				String value2=text2.getText();
				if(value1.isEmpty() || value2.isEmpty())
				{
					System.out.println("Enter Username and Passward");
				}
				else
				{
					try
					{
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","enter_sql_passward");
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(String.format("select * from login where user_id = '%s'",value1));
						if(rs.next())
						{
							if(value1.equals(rs.getString("user_id")) && value2.equals(rs.getString("passwd")))
							{
								System.out.println(rs.getString("user_id")+" ,"+rs.getString("passwd"));
							}
							else
							{
								System.out.println("check user_id and pasword");
							}
						}
						else
						{
							System.out.println("register now");
						}
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					
				}
			}
		});
		
		frame.add(label1);
		frame.add(label2);
		frame.add(text1);
		frame.add(text2);
		frame.add(button);
		
		frame.setSize(400,500);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
} 