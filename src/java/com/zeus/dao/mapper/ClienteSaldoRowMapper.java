/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.ClienteSaldo;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ClienteSaldoRowMapper implements ParameterizedRowMapper<ClienteSaldo>
{
        @Override
	public ClienteSaldo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClienteSaldo row = new ClienteSaldo();                
                row.setSaldoCxc(rs.getString("SALDO_CXC"));
                row.setSaldoAnticipos(rs.getString("SALDO_ANTICIPOS"));
		return row;
	}
	
}