import java.sql.*;
import java.awt.*;
class AgeCalu
{
	public static void main(String args[])
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Registered...");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
			System.out.println("Connection successfull..");
			String sql="{?=call agecal(?)}";
			CallableStatement cstmt=con.prepareCall(sql);
			cstmt.setInt(2,103);
			cstmt.registerOutParameter(1,Types.INTEGER);
			cstmt.execute();
			System.out.println("age is "+cstmt.getInt(1));
		}catch(Exception e){
			System.out.println(e);
			}
	}
}