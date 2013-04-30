/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.ArtImpto;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ArtImptoRowMapper implements ParameterizedRowMapper<ArtImpto>
{
        @Override
	public ArtImpto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArtImpto row = new ArtImpto();                
                row.setImpuesto(rs.getString("IMPUESTO"));                
		return row;
	}
	
}