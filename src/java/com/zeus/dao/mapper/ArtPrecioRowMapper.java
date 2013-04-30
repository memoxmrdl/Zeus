/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.ArtPrecio;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ArtPrecioRowMapper implements ParameterizedRowMapper<ArtPrecio>
{
        @Override
	public ArtPrecio mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArtPrecio row = new ArtPrecio();                
                row.setPrecioUnitario(rs.getString("PRECIO_UNITARIO"));
                row.setNombrePrecio(rs.getString("NOMBRE_PRECIO"));
		return row;
	}
	
}