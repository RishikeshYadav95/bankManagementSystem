package atm.simulator.system;

import java.sql.*;
import com.mysql.*;

public class Conn
{	
	Connection c;
	Statement s;
	public Conn ()
	{	
		String username = "root";
		String password = "root";
		try
		{
			c = DriverManager.getConnection("jdbc:mysql:///bank_management_system", username, password);
			s = c.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
	}
	
}