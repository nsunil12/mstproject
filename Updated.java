import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class UpdateDynamic extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b1;
	UpdateDynamic()
	{
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		l1=new Label("Enter your Roll number: ");
		t1=new TextField(30);
		l2=new Label("Enter new name: ");
		t2=new TextField(30);
		b1=new Button("Update");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		b1.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Registered..");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("Connection successfull..");
			String sql="update yash set ENAME=? where EID=?";
			PreparedStatement pst=con.prepareStatement(sql);
			String roll=t1.getText();
			String name=t2.getText();
			pst.setString(1,name);
			pst.setString(2,roll);
			int no_effect=pst.executeUpdate();
			System.out.println(no_effect+" updated");
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}
class Updated
{
	public static void main(String args[])
	{
		UpdateDynamic up=new UpdateDynamic();
	}
}