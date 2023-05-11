import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Deleted extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1;
	Button b1;
	Deleted()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		setBackground(Color.YELLOW);
		l1=new Label("Enter your roll number: ");
		t1=new TextField(30);
		b1=new Button("Deleted");
		l2=new Label("Deletion Successfull..");
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
			String sql="delete from yash where EID=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			String roll=t1.getText();
			pst.setString(1,roll);
			int no_effect=pst.executeUpdate();
			System.out.println(no_effect+" Del successfull...");
			add(l2);
		}
		catch(Exception ex){
			System.out.println(ex); }
	}

}
class Del
{
	public static void main(String args[])
	{
		Deleted dl=new Deleted(); 	
	}   
}

