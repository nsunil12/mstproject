import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class CallprocedEx
{

	public static void main(String args[])
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Registered...");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("Connection successfull..");
			String sql="{call myprod(?,?,?,?)}";
			CallableStatement cstmt=con.prepareCall(sql);
			cstmt.setInt(1,102);
			cstmt.setString(2,"subbu");
			cstmt.setString(3,"ECE");
			cstmt.setString(4,"02-02-2023");
			cstmt.execute();
			System.out.println("Successfull Executed...");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}