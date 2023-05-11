import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Sign extends Frame implements ActionListener
{
	Label l1,l2,l3,l4;
	TextField t1,t2,t3,t4;
	Button b1,b2,b3;
	Sign() //Constructor
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		//setBackground(Color.YELLOW);
		l1=new Label("Enter your Roll number: ");
		t1=new TextField(30);
		l2=new Label("Enter your name: ");
		t2=new TextField(30);
		l3=new Label("College Name: ");
		t3=new TextField(30);
		l4=new Label("Year of Study: ");
		t4=new TextField(10);

		b1=new Button("SignUp");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Registered..");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("Connection Successfull..");
			String sql="insert into mysign values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			String roll=t1.getText();
			String name=t2.getText();
			String clg=t3.getText();
			String year=t4.getText();

			pst.setString(1,roll);
			pst.setString(2,name);
			pst.setString(3,clg);
			pst.setString(4,year);

			int no_effect=pst.executeUpdate();
			System.out.println(no_effect+" Updated");
					
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}
class Signup
{
	public static void main(String args[])
	{
		Sign s=new Sign();
	}
}