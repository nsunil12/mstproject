import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;
import java.util.*;
class Search extends Frame implements ActionListener
{
	Label l1;
	TextField t1,t2;
	Button b1;
	Search() //Constructor
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l1=new Label("Enter roll number: ");
		t1=new TextField(20);
		b1=new Button("Search");
		t2=new TextField(20);
		add(l1);
		add(t1);
		add(b1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Registered...");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("Connection successfull...");
			String sql="select * from yash where EID=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			//Read input from textfield
			String num=t1.getText();
			//int num=Integer.parseInt(t1.getText());
			pst.setString(1,num);
			ResultSet rs=pst.executeQuery();
			add(t2);
			int x=0; //Checks the records exited or not
			while(rs.next())
			{	
				//System.out.println("\n");
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
				//t1.setText(rs.getString(1));

				//Display name(column2) on textfield2
				t2.setText(rs.getString(2));
				x++;
			}
			if(x==0)
			{
				t2.setText("record not found");
				//System.out.println("record not found");
				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}			
	}
	
}
class SearchDemo2
{
	public static void main(String args[])
	{
		Search s=new Search();
	}
}