import java.awt.*;
import java.sql.*;
class Functionsqlex
{
	public static void main(String args[])
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("Registered...");

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			//System.out.println("connection successfull...@@");

			String sql="{?=call cal77(?,?)}";
			CallableStatement cstmt=con.prepareCall(sql);
			cstmt.setInt(2,36);
			cstmt.setInt(3,9);
			cstmt.registerOutParameter(1,Types.INTEGER);
			cstmt.execute();
			System.out.println("Add the 36 and 9 is "+cstmt.getInt(1));

			//System.out.println("Execution Successfull...");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}