/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.ListaArticulos;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ListaArticulosRowMapper implements ParameterizedRowMapper<ListaArticulos>
{
        @Override
	public ListaArticulos mapRow(ResultSet rs, int rowNum) throws SQLException {
		ListaArticulos row = new ListaArticulos();                
                row.setArticuloId(rs.getLong("ARTICULO_ID"));
                row.setNombreArticulo(rs.getString("NOMBRE_ARTICULO"));
                row.setLineaArticuloId(rs.getLong("LINEA_ARTICULO_ID"));
                row.setNombreLineaArticulo(rs.getString("NOMBRE_LINEA_ARTICULO"));
                row.setUnidadMedida(rs.getString("UNIDAD_MEDIDA"));
                row.setClaveArticulo(rs.getString("CLAVE_ARTICULO"));
                row.setEsAlmacenable(rs.getString("ES_ALMACENABLE"));
                row.setEsJuego(rs.getString("ES_JUEGO"));
                row.setEstatus(rs.getString("ESTATUS"));
                row.setGrupoLineaId(rs.getLong("GRUPO_LINEA_ID"));
                row.setNombreGrupoLinea(rs.getString("NOMBRE_GRUPO_LINEA"));
		return row;
	}
	
}