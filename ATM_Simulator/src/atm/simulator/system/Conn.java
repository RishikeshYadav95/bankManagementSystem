package atm.simulator.system;

import java.sql.*;
import com.mysql.*;

public class Conn
{	
	Connection c;
	Statement s;
	public Conn () 
	{
		try
		{
			c = DriverManager.getConnection("jdbc:mysql:///bank_management_system", "root", "root");
			s = c.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}
	}
	
}