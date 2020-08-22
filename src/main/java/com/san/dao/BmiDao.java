
 
package com.san.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper; 
import com.san.beans.Facts;

public class BmiDao {

	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public List<Facts> getFacts(){    
		String sql = "select * from nutrition";
		List<Facts> factList=template.query(sql, new ResultSetExtractor<List<Facts>>() {

			public List<Facts> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
				List<Facts> factsList=new ArrayList<Facts>();
				while(rs.next()) {
					
					Facts fact=new Facts();
					fact.setId(rs.getInt(1));
					fact.setUpperLimit(rs.getInt(2));
					fact.setLowerLimit(rs.getInt(3));
					factsList.add(fact);
				}
				return factsList;
			}
			
		});
		return factList;
	}   
}
