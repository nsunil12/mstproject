import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class InsertDynamic extends Frame implements ActionListener
{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1;
	InsertDynamic()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l1=new Label("Enter your roll number: ");
		t1=new TextField(30);
		l2=new Label("Enter your name: ");
		t2=new TextField(30);
		b1=new Button("Add");
		add(l1);
		
		add(t1);
		add(l2);
		add(t2);
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
			String sql="insert into yash values(?,?)";
			
			PreparedStatement pst=con.prepareStatement(sql);
			String roll=t1.getText();
			String name=t2.getText();
			pst.setString(1,roll);
			pst.setString(2,name);
			
			int no_effect=pst.executeUpdate();
			System.out.println("n rows"+no_effect);
		}
		catch(Exception ex){
			System.out.println(ex); }
	}

}
class InsertDynamic2 
{
	public static void main(String args[])
	{
		InsertDynamic d=new InsertDynamic();
		new InsertDynamic2(); 	
	}  
}

