/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.RolClave;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class RolClaveRowMapper implements ParameterizedRowMapper<RolClave>
{
        @Override
	public RolClave mapRow(ResultSet rs, int rowNum) throws SQLException {
		RolClave row = new RolClave();
                row.setRolId(rs.getString("ROL_ID"));
                //row.setClave(rs.getString("CLAVE"));
		return row;
	}
	
}

