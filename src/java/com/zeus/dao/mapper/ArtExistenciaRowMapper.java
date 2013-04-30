/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.ArtExistencia;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ArtExistenciaRowMapper implements ParameterizedRowMapper<ArtExistencia>
{
        @Override
	public ArtExistencia mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArtExistencia row = new ArtExistencia();                
                row.setExisActual(rs.getString("EXIS_ACTUAL"));
                row.setExisComprom(rs.getString("EXIS_COMPROM"));
                row.setExisDisp(rs.getString("EXIS_DISP"));
		return row;
	}
	
}