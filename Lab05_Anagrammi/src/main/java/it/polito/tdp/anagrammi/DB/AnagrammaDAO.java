package it.polito.tdp.anagrammi.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class AnagrammaDAO {

	
	public boolean isCorret(String string)
	{
		  String sql = "select nome , count(*) as tot " + 
					"from parola where nome= ? ";
		
			try {
				Connection conn = ConnectionDB.getConnection(); 
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, string); 
				ResultSet rs = st.executeQuery(); 
			
	
			
			while(rs.next())
			{
				int num= rs.getInt("tot"); 
				if(num ==0)
				{
				return false;}
				else
				{
				return true;}
		}
				
			} catch (SQLException e)
			{throw new RuntimeException(e);
			}
			
		return true;
	}
	


}
