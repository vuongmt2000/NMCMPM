/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;


import java.sql.ResultSet;
import model.Statistical;

public class StatisticalMapper implements RowMapper<Statistical>{

   
        @Override
    public Statistical mapRow(ResultSet rs) {
		try {
			Statistical st = new Statistical();
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
                        st.setQuantity(rs.getInt("quantity"));
                        st.setStatus(rs.getInt("broken_quantity"));
                        st.setUnit(rs.getString("unitl"));
                        st.setRoom("Phòng " + rs.getInt("floor")  + "." + rs.getInt("number_floor")); 
                        
			return st;
		} catch (Exception e) {
			return null;
		} //To change body of generated methods, choose Tools | Templates.
       
}
}

