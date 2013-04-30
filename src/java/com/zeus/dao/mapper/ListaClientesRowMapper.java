/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.zeus.domain.ListaClientes;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class ListaClientesRowMapper implements ParameterizedRowMapper<ListaClientes>
{
        @Override
	public ListaClientes mapRow(ResultSet rs, int rowNum) throws SQLException {
		ListaClientes row = new ListaClientes();
                row.setClienteId(rs.getString("CLIENTE_ID"));
                row.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                row.setContacto1(rs.getString("CONTACTO1"));
                row.setContacto2(rs.getString("CONTACTO2"));
                row.setEstatus(rs.getString("ESTATUS"));
                row.setLimiteCredito(rs.getString("LIMITE_CREDITO"));
                row.setMonedaId(rs.getString("MONEDA_ID"));
                row.setNombreMoneda(rs.getString("NOMBRE_MONEDA"));
                row.setCondPagoId(rs.getString("COND_PAGO_ID"));
                row.setNombreCondPago(rs.getString("NOMBRE_COND_PAGO"));
                row.setTipoClienteId(rs.getString("TIPO_CLIENTE_ID"));
                row.setNombreTipoCliente(rs.getString("NOMBRE_TIPO_CLIENTE"));
                row.setZonaClienteId(rs.getString("ZONA_CLIENTE_ID"));
                row.setNombreZonaCliente(rs.getString("NOMBRE_ZONA_CLIENTE"));
                row.setCobradorId(rs.getString("COBRADOR_ID"));
                row.setNombreCobrador(rs.getString("NOMBRE_COBRADOR"));
                row.setVendedorId(rs.getString("VENDEDOR_ID"));
                row.setNombreVendedor(rs.getString("NOMBRE_VENDEDOR"));
                row.setClaveCliente(rs.getString("CLAVE_CLIENTE"));
		return row;
	}
	
}

