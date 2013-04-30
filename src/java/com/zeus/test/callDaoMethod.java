/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.test;

import com.zeus.MsjError.ReportError;
import com.google.gson.Gson;
import com.zeus.classObj.*;
import com.zeus.dao.*;
import com.zeus.dao.mapper.*;
import com.zeus.domain.*;
import java.sql.SQLException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Guillermo
 */
public class callDaoMethod {    
    
    ReportError Send;
    
    public String GetListaArticulos(String args, String conn) throws Exception {        
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson(); 
        argsListaArticulos params = new argsListaArticulos();
        Conn conn1 = new Conn();
               
        if(args == null) {
            params.estatus = null;
            params.grupo_linea_id = null;
            params.linea_articulo_id = null;
        } else {
            params = gson.fromJson(args, argsListaArticulos.class);                                                           
                    
            if("null".equals(params.estatus) || "".equals(params.estatus)) {
                params.estatus = null;
            }
            
            if("null".equals(params.grupo_linea_id) || "".equals(params.grupo_linea_id)) {
                params.grupo_linea_id = null;
            }
            
            if("null".equals(params.linea_articulo_id) || "".equals(params.linea_articulo_id)) {
                params.linea_articulo_id = null;
            }
            
        }
            
        conn1 = gson.fromJson(conn, Conn.class);

        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                       
        List<ListaArticulos> la = null;        
        try {
            la = queryDao.GetListaArticulos(params.estatus, params.linea_articulo_id, params.grupo_linea_id, null);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        ListaArticulosResponse laResponse = new ListaArticulosResponse();
        laResponse.setListaArticulos(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getListaArticulos());
        return result;               
    }
    
    public String GetArtExistencia(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();        
        argsArtExistencia params = new argsArtExistencia();
        Conn conn1 = new Conn();
        
        if(args == null) {
            throw new Exception("articulo_id, almacen_id no deben ser nulos");
        } else {
            params = gson.fromJson(args, argsArtExistencia.class);
                
            if(params.almacen_id == null) {
                throw new Exception("almacen_id no debe ser nulo");
            }
            
            if(params.articulo_id == null) {
                throw new Exception("articulo_id no debe ser nulo");
            }
            
            if(("".equals(params.almacen_id) || "null".equals(params.almacen_id))||("".equals(params.articulo_id) || "null".equals(params.articulo_id))) {
                throw new Exception("articulod_id, almacen_id no deben ser nulos");
            }            
        }
            
        conn1 = gson.fromJson(conn, Conn.class);
        
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                       
        List<ArtExistencia> la = null;        
        try {
            la = queryDao.GetArtExistencia(params.articulo_id, params.almacen_id);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        ArtExistenciaResponse laResponse = new ArtExistenciaResponse();
        laResponse.setArtExistencia(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getArtExistencia());
        return result;
    }
    
    public String GetArtPrecio(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();        
        argsArtPrecio params = new argsArtPrecio();
        Conn conn1 = new Conn();
        
        if(args == null) {
            throw new Exception("articulod_id no debe ser nulo");
        } else {
            params = gson.fromJson(args, argsArtPrecio.class);
            
            if(params.articulo_id == null) {
                throw new Exception("articulo_id no debe ser nulo");
            }
            
            if("".equals(params.articulo_id) || "null".equals(params.articulo_id)) {
                throw new Exception("articulod_id no debe ser nulo");
            }
        
            if(params.fecha_venta == null || "null".equals(params.fecha_venta)) {
                Date ahora = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("dd.MM.yyyy");            
                params.fecha_venta = formateador.format(ahora);
            }
        }
            
        conn1 = gson.fromJson(conn, Conn.class);
              
        
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                       
        List<ArtPrecio> la = null;        
        try {
            la = queryDao.GetArtPrecio(params.articulo_id, params.cliente_id, params.fecha_venta, params.moneda_dest_id);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        ArtPrecioResponse laResponse = new ArtPrecioResponse();
        laResponse.setArtPrecio(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getArtPrecio());
        return result;
    }
    
    public String GetArticulo(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();     
        argsArticulo params = new argsArticulo();
        Conn conn1 = new Conn();
        
        if(args == null) {
            throw new Exception("articulo_id no debe ser nulo");
        } else {
            params = gson.fromJson(args, argsArticulo.class);
            
            if(params.articulo_id == null) {
                throw new Exception("articulo_id no debe ser nulo");
            }
            
            if("".equals(params.articulo_id) || "null".equals(params.articulo_id)) {
                throw new Exception("articulod_id no debe ser nulo");
            }
        }
            
        conn1 = gson.fromJson(conn, Conn.class);       
                      
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                       
        List<ListaArticulos> la = null;        
        try {
            la = queryDao.GetListaArticulos(null, null, null, params.articulo_id);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        ListaArticulosResponse laResponse = new ListaArticulosResponse();
        laResponse.setListaArticulos(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getListaArticulos());
        return result; 
    }
    
    public String GetArtImpto(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();         
        argsArtImpto params = new argsArtImpto();
        Conn conn1 = new Conn();
        
        if(args == null) {
            throw new Exception("articulo_id, cliente_id no deben ser nulos");
        } else {
            params = gson.fromJson(args, argsArtImpto.class);
            
            if(params.articulo_id == null) {
                throw new Exception("articulo_id no debe ser nulo");
            }    
            
            if(params.cliente_id == null) {
                throw new Exception("cliente_id no debe ser nulo");                                
            }
            
            if(("".equals(params.articulo_id) || "null".equals(params.articulo_id))||("".equals(params.cliente_id) || "null".equals(params.cliente_id))) {
                throw new Exception("articulo_id y cliente_id no deben ser nulos");
            }
        }
            
        conn1 = gson.fromJson(conn, Conn.class);
                     
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                       
        List<ArtImpto> la = null;        
        try {
            la = queryDao.GetArtImpto(params.articulo_id, params.cliente_id);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        ArtImptoResponse laResponse = new ArtImptoResponse();
        laResponse.setArtImpto(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getArtImpto());
        return result;
    }
    
    public String GetListaClientes(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();        
        argsListaClientes params = new argsListaClientes();
        Conn conn1 = new Conn();
        
        if(args == null) {
            params.tipo_cliente_id = null;
            params.zona_cliente_id = null;
            params.cobrador_id = null;
            params.vendedor_id = null;
            params.estatus = null;
        } else {
            params = gson.fromJson(args, argsListaClientes.class);
           
            
            if("null".equals(params.tipo_cliente_id) || params.tipo_cliente_id == null) {
                params.tipo_cliente_id = null;
            }
            if("null".equals(params.zona_cliente_id) || params.zona_cliente_id == null) {
                params.zona_cliente_id = null;
            }
            if("null".equals(params.cobrador_id) || params.cobrador_id == null) {
                params.cobrador_id = null;
            }
            if("null".equals(params.vendedor_id) || params.vendedor_id == null) {
                params.vendedor_id = null;
            }
            if("null".equals(params.estatus) || params.estatus == null) {
                params.estatus = null;
            }
            
        }
            
        conn1 = gson.fromJson(conn, Conn.class);                 
        
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db); 
        
        /*List<RolClave> rc = null;
        try {
            rc = queryDao.GetRolClave();
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        } */       
                       
        List<ListaClientes> la = null;        
        try {
            la = queryDao.GetListaClientes(params.tipo_cliente_id, params.zona_cliente_id, params.cobrador_id, params.vendedor_id, params.estatus, null);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        ListaClientesResponse laResponse = new ListaClientesResponse();
        laResponse.setListaClientes(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getListaClientes());
        return result;
    }
    
    public String GetCliente(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();         
        argsCliente params = new argsCliente();
        Conn conn1 = new Conn();
        
        if(args == null) {
            throw new Exception("clave_cliente no debe ser nulo");
        } else {
            params = gson.fromJson(args, argsCliente.class);
            
            if(params.clave_cliente == null) {
                throw new Exception("clave_cliente no debe ser nulo");
            }
            
            if("".equals(params.clave_cliente) || "null".equals(params.clave_cliente)) {
                throw new Exception("clave_cliente no debe ser nulo");
            }
        }
            
        conn1 = gson.fromJson(conn, Conn.class);                
             
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                               
        List<ListaClientes> la = null;        
        try {
            la = queryDao.GetListaClientes(null, null, null, null, null, params.clave_cliente);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        ListaClientesResponse laResponse = new ListaClientesResponse();
        laResponse.setListaClientes(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getListaClientes());
        return result;
    }
    
    public String GetClienteSaldo(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();
        
        argsClienteSaldo params = new argsClienteSaldo();
        Conn conn1 = new Conn();
        
        if(args == null) {
            throw new Exception("cliente_id no debe ser nulo");
        } else {
            params = gson.fromJson(args, argsClienteSaldo.class);
            
            if(params.cliente_id == null) {
                throw new Exception("cliente_id no debe ser nulo");
            }
            
            if("".equals(params.cliente_id) || "null".equals(params.cliente_id)) {
                throw new Exception("cliente_id no debe ser nulo");
            }
        
            if(params.fecha == null || "null".equals(params.fecha)) {
                Date ahora = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("dd.MM.yyyy");            
                params.fecha = formateador.format(ahora);
            }
        }
            
        conn1 = gson.fromJson(conn, Conn.class);                                   
        
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                       
        List<ClienteSaldo> la = null;        
        try {
            la = queryDao.GetClienteSaldo(params.cliente_id, params.fecha, params.incluir_xlib);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        ClienteSaldoResponse laResponse = new ClienteSaldoResponse();
        laResponse.setClienteSaldo(la);
        
        Gson json = new Gson();
        String result = json.toJson(laResponse.getClienteSaldo());
        return result;
    }
    
    public String PostCliente(argsPCliente params, Conn conn) throws Exception {        
        DaoQueryTransaction queryDaoTran = new DaoQueryTransaction();
        String result = null;

        queryDaoTran.setServer(conn.server);
        queryDaoTran.setUsername(conn.username);
        queryDaoTran.setPassword(conn.pwd);
        queryDaoTran.setDataBase(conn.db);
        
        try {                           
            result = queryDaoTran.PostCliente(params.nombre, params.contacto1, params.contacto2, params.estatus,
                params.limite_credito, params.moneda_id, params.cond_pago_id, params.tipo_cliente_id,
                params.zona_cliente_id, params.cobrador_id, params.vendedor_id, params.clave_cliente,
                params.nombre_calle, params.num_exterior, params.num_interior, params.colonia,
                params.poblacion, params.referencia, params.ciudad_id, params.codigo_postal);                        
        } catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
        return result;
    }
    
    public String UpdateCliente(argsPCliente params, Conn conn) throws Exception {        
        DaoQueryTransaction queryDaoTran = new DaoQueryTransaction();
        String result = null;

        queryDaoTran.setServer(conn.server);
        queryDaoTran.setUsername(conn.username);
        queryDaoTran.setPassword(conn.pwd);
        queryDaoTran.setDataBase(conn.db);
        
        try {                           
            result = queryDaoTran.UpdateCliente(params.nombre, params.contacto1, params.contacto2, params.estatus,
                params.limite_credito, params.moneda_id, params.cond_pago_id, params.tipo_cliente_id,
                params.zona_cliente_id, params.cobrador_id, params.vendedor_id, params.clave_cliente,
                params.nombre_calle, params.num_exterior, params.num_interior, params.colonia,
                params.poblacion, params.referencia, params.ciudad_id, params.codigo_postal, params.cliente_id);                        
        } catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
        return result;
    }
    
    public String DeleteCliente(argsPCliente params, Conn conn) throws Exception {        
        DaoQueryTransaction queryDaoTran = new DaoQueryTransaction();
        String result = null;

        queryDaoTran.setServer(conn.server);
        queryDaoTran.setUsername(conn.username);
        queryDaoTran.setPassword(conn.pwd);
        queryDaoTran.setDataBase(conn.db);
        
        try {                           
            result = queryDaoTran.DeleteCliente(params.cliente_id);                        
        } catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
        return result;
    }
    
    public String PostDoctoVe(argsDoctoVe params, List<argsDoctoVeArt> articulos, Conn conn) throws Exception {
        DaoQueryTransaction queryDaoTran = new DaoQueryTransaction();
        String result = "";

        queryDaoTran.setServer(conn.server);
        queryDaoTran.setUsername(conn.username);
        queryDaoTran.setPassword(conn.pwd);
        queryDaoTran.setDataBase(conn.db);
        
        try {                           
            result = queryDaoTran.PostDoctoVe(params.tipo_docto, params.serie, params.fecha, params.clave_cliente, params.cliente_id, params.dir_cli_id,
                                              params.dir_consig_id, params.almacen_id, params.moneda_id, params.tipo_dscto, params.dscto_pctje,
                                              params.dscto_importe, params.fecha_vigencia_entrega, params.descripcion, params.importe_neto,
                                              params.fletes, params.otros_cargos, params.total_impuestos, params.cond_pago_id, params.vendedor_id,
                                              params.via_embarque_id, params.importe_cobro, params.descripcion_cobro, params.usuario_creador,
                                              params.modalidad_facturacion, params.forma_cobro_id, articulos);                        
        } catch(SQLException e) {
            throw new Exception(e.getMessage());
        }
        return result;
    }
    
    public String GetVersion(String conn) {
        String f = "";
        Gson gson = new Gson(); 
        Conn conn1 = new Conn();
        conn1 = gson.fromJson(conn, Conn.class);
        DaoQuery queryDao = new DaoQuery();
        
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);
        
        try {
            if(queryDao.VersionM()) {
                f = "Version de Microsip no puede trabajar con el ZeusWS";
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
        
        return f;
    }    
    
    
    public String GetDirsCliente(String args, String conn) throws Exception {
        DaoQuery queryDao = new DaoQuery();
        Gson gson = new Gson();         
        argsCliente params = new argsCliente();
        Conn conn1 = new Conn();
        
        if(args == null) {
            throw new Exception("cliente_id no debe ser nulo");
        } else {
            params = gson.fromJson(args, argsCliente.class);
            
            if(params.cliente_id == null) {
                throw new Exception("cliente_id no debe ser nulo");
            }
            
            if("".equals(params.cliente_id) || "null".equals(params.cliente_id)) {
                throw new Exception("cliente_id no debe ser nulo");
            }
        }
            
        conn1 = gson.fromJson(conn, Conn.class);                
             
        queryDao.setDriver("firebird");
        queryDao.setServer(conn1.server);
        queryDao.setUsername(conn1.username);
        queryDao.setPassword(conn1.pwd);
        queryDao.setDataBase(conn1.db);               
                               
        List<DirsClientes> la = null;        
        try {
            la = queryDao.GetDirsCliente(params.cliente_id);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        //ListaClientesResponse laResponse = new ListaClientesResponse();
        //laResponse.setListaClientes(la);
        
        Gson json = new Gson();
        String result = json.toJson(la);
        return result;
    }

}
