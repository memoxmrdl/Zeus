/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.zmUsers;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class zmUsersRowMapper implements ParameterizedRowMapper<zmUsers>
{
        @Override
	public zmUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
		zmUsers row = new zmUsers();
		row.setUserId(rs.getString("user_id"));
                row.setName(rs.getString("name"));
                row.setTypeUser(rs.getString("type_user"));
                row.setNameAlias(rs.getString("name_alias"));
                row.setEmail(rs.getString("email"));
		return row;
	}
	
}
