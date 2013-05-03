/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao;

import com.zeus.MsjError.ReportError;
import com.zeus.classObj.*;
import com.zeus.domain.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/**
 *
 * @author Guillermo
 */
public class DaoQueryTransaction {

    private String Server;
    private String Username;
    private String Password;
    private String DataBase;   
       
    public void setServer(String server) {
        this.Server = server;
    }
    
    public void setUsername(String username) {
        this.Username = username;
    }
    
    public void setPassword(String password) {
        this.Password = password;
    }
    
    public void setDataBase(String database) {
        this.DataBase = database;
    }
    
    public String getServer() {
        return this.Server;
    }
    
    public String getUsername() {
        return this.Username;
    }
    
    public String getPassword() {
        return this.Password;
    }
    
    public String getDataBase() {
        return this.DataBase;
    }
    
    private Connection Connection()  {
        Connection dbConnection = null;
        
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        } catch(ClassNotFoundException e) {
            e.getMessage();
        }
        
        try {
            dbConnection = DriverManager.getConnection("jdbc:firebirdsql://"+this.getServer()+":3050/"+this.getDataBase()+"", 
                                                       this.getUsername(), this.getPassword());          
        } catch(SQLException e) {
            e.getMessage();
        }
        
        return dbConnection;
    }
    
    public String PostCliente(String Nombre, String Contacto1, String Contacto2, String Estatus, String Limite_Credito, 
            String Moneda_Id, String Cond_Pago_Id, String Tipo_Cliente_Id, String Zona_Cliente_Id, 
            String Cobrador_Id, String Vendedor_Id, String Clave_Cliente, String Nombre_Calle,
            String Num_Exterior, String Num_Interior, String Colonia, String Poblacion, String Referencia,
            String Ciudad_Id, String Codigo_Postal) throws SQLException {
        
        ReportError error = new ReportError();
        DaoQuery queryDao = new DaoQuery();
        Connection conn = null;        
        PreparedStatement query1 = null;
        PreparedStatement query2 = null;
        PreparedStatement query3 = null;                
        
        String ClienteSQL = "INSERT INTO CLIENTES " +
                "(CLIENTE_ID,NOMBRE,CONTACTO1,CONTACTO2,ESTATUS,LIMITE_CREDITO," +
                "MONEDA_ID,COND_PAGO_ID,TIPO_CLIENTE_ID,ZONA_CLIENTE_ID,COBRADOR_ID," +
                "VENDEDOR_ID) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        
        String ClaveClienteSQL = "INSERT INTO CLAVES_CLIENTES " +
              "(CLAVE_CLIENTE_ID, CLAVE_CLIENTE, CLIENTE_ID, ROL_CLAVE_CLI_ID) VALUES " +             
              "(?, ?, ?, ?)";
        
        String DirClienteSQL = "INSERT INTO DIRS_CLIENTES " +
              "(DIR_CLI_ID, CLIENTE_ID, NOMBRE_CONSIG, NOMBRE_CALLE," +
              "NUM_EXTERIOR, NUM_INTERIOR, COLONIA, REFERENCIA," +
              "CIUDAD_ID, ESTADO_ID, PAIS_ID, CODIGO_POSTAL, CALLE) VALUES " +
              "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";        
        
        
        if(Nombre == null || Nombre.length() == 0) {
            throw new SQLException("[1] Error al insertar en tabla CLIENTES " +
                    "validation error for column NOMBRE, value *** null ***");
        }
        
        if(Moneda_Id == null || Moneda_Id.length() == 0) {
            throw new SQLException("[1] Error al insertar en tabla CLIENTES " +
                    "The insert failed because a column definition includes validation constraints." +
                    "validation error for column MONEDA_ID, value *** null ***");                    
        }
        
        if(Cond_Pago_Id == null || Cond_Pago_Id.length() == 0) {
            throw new SQLException("[1] Error al insertar en tabla CLIENTES " +
                    "The insert failed because a column definition includes validation constraints." +
                    "validation error for column COND_PAGO_ID, value *** null ***");
        }
        
        if(Nombre_Calle == null || Nombre_Calle.length() == 0) {
            throw new SQLException("[3] Error al insertar en tabla DIRS_CLIENTES " +
                    "validation error for column NOMBRE_CALLE, value *** null ***");                    
        }
        
        if(Ciudad_Id == null || Ciudad_Id.length() == 0) {
            throw new SQLException("[3] Error al insertar en tabla DIRS_CLIENTES " +
                    "The insert failed because a column definition includes validation constraints." +
                    "validation error for column CIUDAD_ID, value *** null ***");                    
        }
        
        if(Limite_Credito == null || Limite_Credito.length() == 0) {
            throw new SQLException("[3] Error al insertar en tabla CLIENTES " +
                    "validation error for column LIMITE_CREDITO, value *** null ***");                    
        }
        
        if(Estatus != null || Estatus.length() == 0) {
            Estatus = "A";
        }
        
        if("".equals(Tipo_Cliente_Id)) {
            Tipo_Cliente_Id = null;
        }
        if("".equals(Zona_Cliente_Id)) {
            Zona_Cliente_Id = null;
        }
        if("".equals(Cobrador_Id)) {
            Cobrador_Id = null;
        }
        if("".equals(Vendedor_Id)) {
            Vendedor_Id = null;
        }
              
        queryDao.setDriver("firebird");
        queryDao.setServer(this.getServer());
        queryDao.setUsername(this.getUsername());
        queryDao.setPassword(this.getPassword());
        queryDao.setDataBase(this.getDataBase());
        
        int Cliente_Id = 0;
        String Rol_Clave = null;
        
        try {
            Cliente_Id = queryDao.GenCatalogoId().get(0).getCatalogoId();
            Rol_Clave = queryDao.GetRolClave().get(0).getRolId();
        } catch(Exception e) {
             throw new SQLException(e.getMessage().replaceAll("[\n\r\"]", "**"));
        }
        
        List<CiuEstPas> getCEP = null;
        
        try {
           getCEP = queryDao.GetIdCiuEstPas(Ciudad_Id); 
        } catch(Exception e){
            throw new SQLException(e.getMessage());
        }
        
        try {                              
            conn = Connection();
            conn.setAutoCommit(false);
            query1 = conn.prepareStatement(ClienteSQL);
            query1.setInt(1, Cliente_Id);
            query1.setString(2, Nombre);
            query1.setString(3, Contacto1);
            query1.setString(4, Contacto2);
            query1.setString(5, Estatus);
            query1.setString(6, Limite_Credito);
            query1.setInt(7, Integer.valueOf(Moneda_Id));
            query1.setInt(8, Integer.valueOf(Cond_Pago_Id));
            query1.setString(9, Tipo_Cliente_Id);
            query1.setString(10, Zona_Cliente_Id);
            query1.setString(11, Cobrador_Id);
            query1.setString(12, Vendedor_Id);
            /*query1.setInt(9, Integer.valueOf(Tipo_Cliente_Id));
            query1.setInt(10, Integer.valueOf(Zona_Cliente_Id));
            query1.setInt(11, Integer.valueOf(Cobrador_Id));
            query1.setInt(12, Integer.valueOf(Vendedor_Id));*/
            query1.executeUpdate();
            
            if(Clave_Cliente != null && !Clave_Cliente.isEmpty()) {                 
                query2 = conn.prepareStatement(ClaveClienteSQL);
                query2.setInt(1, -1);
                query2.setString(2, Clave_Cliente);
                query2.setInt(3, Cliente_Id);
                query2.setString(4, Rol_Clave);
                query2.executeUpdate();    
            }
                        
            query3 = conn.prepareStatement(DirClienteSQL);
            query3.setInt(1, -1);
            query3.setInt(2, Cliente_Id);
            query3.setString(3, "Direccion principal");
            query3.setString(4, Nombre_Calle);
            query3.setString(5, Num_Exterior);
            query3.setString(6, Num_Interior);
            query3.setString(7, Colonia);
            //query3.setString(8, Poblacion);
            query3.setString(8, Referencia);
            query3.setString(9, getCEP.get(0).getCiudadId());
            query3.setString(10, getCEP.get(0).getEstadoId());
            query3.setString(11, getCEP.get(0).getPaisId());
            query3.setString(12, Codigo_Postal);
            query3.setString(13, Nombre_Calle+" "+Num_Exterior+" "+Num_Interior+" "+Colonia);
            query3.executeUpdate();
            
            conn.commit();
            
        } catch(SQLException e) {
            conn.rollback();
            
            /*if(error.searchStr("Column unknown POBLACION At line 1, column 117", e.getLocalizedMessage().replace("\n", ""))) {
                throw new SQLException("[3] Error al insertar en tabla DIRS_CLIENTES " +
                         "Dynamic SQL Error SQL error code = -206 Column unknown POBLACION At line 1 column 117");
            }*/
            
            if(error.searchStr("in unique index \"CLIENTES_AK1\"", e.getLocalizedMessage())) {
                throw new SQLException("[1] Error al insertar en tabla CLIENTES " +
                "Invalid insert or update value(s): object columns are constrained - " +
                "no 2 table rows can have duplicate column values." +
                "violation of PRIMARY or UNIQUE KEY constraint CLIENTES_PK1 on table CLIENTES.");
            }
            
            if(error.searchStr("in unique index \"CLAVES_CLIENTES_AK1", e.getLocalizedMessage())) {
                throw new SQLException("[2] Error al insertar en tabla CLAVES_CLIENTES "+ 
                        "attempt to store duplicate value (visible to active transactions) in unique index CLAVES_CLIENTES_AK1");                
            }
            
            throw new SQLException(e.getMessage().replaceAll("[\n\r\"]", " "));             
        } finally {
            if(query1 != null) {
                query1.close();
            }            
            if(query2 != null) {
                query2.close();
            }            
            if(query3 != null) {
                query3.close();
            }            
            if(conn != null) {
                conn.close();
            }
        }
        
        return "Se inserto el cliente " + Cliente_Id;
    }  
    
    
    public String UpdateCliente(String Nombre, String Contacto1, String Contacto2, String Estatus, String Limite_Credito, 
            String Moneda_Id, String Cond_Pago_Id, String Tipo_Cliente_Id, String Zona_Cliente_Id, 
            String Cobrador_Id, String Vendedor_Id, String Clave_Cliente, String Nombre_Calle,
            String Num_Exterior, String Num_Interior, String Colonia, String Poblacion, String Referencia,
            String Ciudad_Id, String Codigo_Postal, String Cliente_Id) throws SQLException {
        
        ReportError error = new ReportError();
        DaoQuery queryDao = new DaoQuery();
        Connection conn = null;        
        Statement query = null;        
                                                
        if(Cliente_Id == null || "".equals(Cliente_Id)) {
            throw new SQLException("Error al actualizar se requiere CLIENTE_ID");
        }       
           
        queryDao.setDriver("firebird");
        queryDao.setServer(this.getServer());
        queryDao.setUsername(this.getUsername());
        queryDao.setPassword(this.getPassword());
        queryDao.setDataBase(this.getDataBase());
                
        String ClienteSQL = null;
        String Set1 = ""; 
        
        if(Nombre != null || !"".equals(Nombre)) {
            Set1 = Set1 + "NOMBRE='" + Nombre+ "',";
        }
        if(Contacto1 != null || !"".equals(Contacto1)) {
            Set1 = Set1 + "CONTACTO1='"+ Contacto1 +"',";
        }
        if(Contacto2 != null || !"".equals(Contacto2)) {
            Set1 = Set1 + "CONTACTO2='"+ Contacto2 +"',";
        }
        if(Estatus != null || !"".equals(Estatus)) {
            Set1 = Set1 + "ESTATUS='"+ Estatus +"',";
        }
        if(Limite_Credito != null || !"".equals(Limite_Credito)) {
            Set1 = Set1 + "LIMITE_CREDITO="+Limite_Credito+",";
        }
        if(Moneda_Id != null || !"".equals(Moneda_Id)) {
            Set1 = Set1 + "MONEDA_ID="+Moneda_Id+",";
        }
        if(Zona_Cliente_Id != null || !"".equals(Zona_Cliente_Id)) {
            Set1 = Set1 + "ZONA_CLIENTE_ID="+Zona_Cliente_Id+",";
        }
        if(Cobrador_Id != null || !"".equals(Cobrador_Id)) {
            Set1 = Set1 + "COBRADOR_ID="+Cobrador_Id+",";
        }
        if(Vendedor_Id != null || !"".equals(Vendedor_Id)) {
            Set1 = Set1 + "VENDEDOR_ID="+Vendedor_Id+",";
        }
        if(!"".equals(Set1)) {
            Set1 = Set1.substring(0, Set1.length()-1);
        }         
        ClienteSQL = "UPDATE CLIENTES SET "+Set1+" WHERE CLIENTE_ID = "+ Cliente_Id;
        
        String ClaveClienteSQL = null;
        String Set2 = "";        
        if(Clave_Cliente != null || !"".equals(Clave_Cliente)) {
            Set2 = Set2 + "CLAVE_CLIENTE='"+ Clave_Cliente +"',";
        }
        if(!"".equals(Set2)) {
            Set2 = Set2.substring(0, Set2.length()-1);
        }
        ClaveClienteSQL = "UPDATE CLAVES_CLIENTES SET "+Set2+" WHERE CLIENTE_ID = "+Cliente_Id; 
        
        String DirClienteSQL = null;
        String Calle = "";
        String Set3 = "";        
        if(Nombre_Calle != null || !"".equals(Nombre_Calle)) {
            Set3 = Set3 + "NOMBRE_CALLE='"+Nombre_Calle+"',";           
            Calle = Calle + Nombre_Calle;
        }
        if(Num_Exterior != null || !"".equals(Num_Exterior)) {
            Set3 = Set3 + "NUM_EXTERIOR='"+Num_Exterior+"',";
            Calle = Calle + Num_Exterior;
        }
        if(Num_Interior != null || !"".equals(Num_Interior)) {
            Set3 = Set3 + "NUM_INTERIOR='"+Num_Interior+"',";            
            Calle = Calle + Num_Interior;
        }
        if(Colonia != null || !"".equals(Colonia)) {
            Set3 = Set3 + "COLONIA='"+Colonia+"',";
            Calle = Calle + Colonia;
        }        
        if(Poblacion != null || !"".equals(Poblacion)) {
            Set3 = Set3 + "POBLACION='"+Poblacion+"',";            
        }
        if(Referencia != null || !"".equals(Referencia)) {
            Set3 = Set3 + "REFERENCIA='"+Referencia+"',";
        }
        if(Ciudad_Id != null || !"".equals(Ciudad_Id)) {
            List<CiuEstPas> getCEP = null;
            try {
                getCEP = queryDao.GetIdCiuEstPas(Ciudad_Id); 
            } catch(Exception e){
                throw new SQLException(e.getMessage());
            }
            Set3 = Set3 + "CIUDAD_ID="+getCEP.get(0).getCiudadId()+"," +
                    "ESTADO_ID="+getCEP.get(0).getEstadoId()+"," +
                    "PAIS_ID="+getCEP.get(0).getPaisId()+",";
        }
        if(Codigo_Postal != null || "".equals(Codigo_Postal)) {
            Set3 = Set3 + "CODIGO_POSTAL='"+Codigo_Postal+"',";
        }
        if(!"".equals(Calle) || "".equals(Calle)) {
            Set3 = Set3 + "CALLE='"+Calle+"',";
        }
        if(!"".equals(Set3)) {
            Set3 = Set3.substring(0, Set3.length()-1);
        }
        DirClienteSQL = "UPDATE DIRS_CLIENTES SET "+Set3+" WHERE CLIENTE_ID = "+ Cliente_Id;
        
        
        if(Set1.isEmpty() && Set2.isEmpty() && Set3.isEmpty()) {
            throw new SQLException("Es necesario al menos ingresar un campo actualizar");
        }

        try {                     
            conn = Connection();  
            conn.setAutoCommit(false);
                        
            query = conn.createStatement();
            
            if(!"".equals(Set1)) {
                query.executeUpdate(ClienteSQL);
            }
            if(!"".equals(Set2)) {
                query.executeUpdate(ClaveClienteSQL);
            }
            if(!"".equals(Set3)) {
                query.executeUpdate(DirClienteSQL);
            }
                        
            conn.commit();            
        } catch(SQLException e) {
            
            conn.rollback();
            
            if(error.searchStr("Column unknown POBLACION At line 1, column 117", e.getLocalizedMessage().replace("\n", ""))) {
                throw new SQLException("[3] Error al insertar en tabla DIRS_CLIENTES " +
                         "Dynamic SQL Error SQL error code = -206 Column unknown POBLACION At line 1 column 117");
            }
            
            if(error.searchStr("in unique index \"CLIENTES_AK1\"", e.getLocalizedMessage())) {
                throw new SQLException("[1] Error al insertar en tabla CLIENTES " +
                "Invalid insert or update value(s): object columns are constrained - " +
                "no 2 table rows can have duplicate column values." +
                "violation of PRIMARY or UNIQUE KEY constraint CLIENTES_PK1 on table CLIENTES.");
            }
            
            if(error.searchStr("in unique index \"CLAVES_CLIENTES_AK1", e.getLocalizedMessage())) {
                throw new SQLException("[2] Error al insertar en tabla CLAVES_CLIENTES "+ 
                        "attempt to store duplicate value (visible to active transactions) in unique index CLAVES_CLIENTES_AK1");                
            }
                      
            throw new SQLException(e.getMessage().replaceAll("[\n\r\"]", " "));             
        } finally {                        
            
            if(query != null) {
                query.close();
            }                        
                        
            if(conn != null) {
                conn.close();
            }            
        }            
                
        return "true";
    }  
    
    public String DeleteCliente(String Cliente_Id) throws SQLException {
        Connection conn = null;        
        Statement query = null;
        
        if(Cliente_Id == null || "".equals(Cliente_Id)) {
            throw new SQLException("Error para eliminar se requiere CLIENTE_ID");
        }
        
        try {
            conn = Connection();
            conn.setAutoCommit(false);            
            query = conn.createStatement();            
            query.executeUpdate("DELETE FROM CLIENTES WHERE CLIENTE_ID = "+Cliente_Id);
            conn.commit();                        
        } catch(SQLException e)  {
            conn.rollback();
            throw new SQLException(e.getMessage().replaceAll("[\n\r\"]", " "));             
        } finally {
            if(query != null) {
                query.close();
            }                        
                        
            if(conn != null) {
                conn.close();
            }  
        }
        
        return "true";
    }
    
    
    public String PostDoctoVe(String Tipo_Docto, String Serie, String Fecha, String Clave_Cliente, String Cliente_Id,
                            String Dir_Cli_Id,String Dir_Consig_Id,String Almacen_Id, String Moneda_Id, String Tipo_Dscto, String Dscto_Pctje,
                            String Dscto_Importe, String Fecha_Vigencia_Entrega, String Descripcion, String Importe_Neto,
                            String Fletes, String Otros_Cargos, String Total_Impuestos, String Cond_Pago_Id, String Vendedor_Id,
                            String Via_Embarque_Id, String Importe_Cobro, String Descripcion_Cobro, String Usuario_Creador,
                            String Modalidad_Facturacion, String Forma_Cobro_Id, List<argsDoctoVeArt> articulos) throws SQLException {

        DaoQuery queryDao = new DaoQuery();
        Connection conn = null;        
        Statement query = null;
        Statement getQuery = null;
        List<JuegoDet> comp = null;                    
        
        if("".equals(Tipo_Docto) || Tipo_Docto == null) {
            throw new SQLException("tipo_docto no debe ser nulo o vacio");
        }
        if("".equals(Cliente_Id) || Cliente_Id == null) {
            throw new SQLException("cliente_id no debe ser nulo o vacio");
        }        
        if("".equals(Dir_Cli_Id) || Dir_Cli_Id == null) {
            throw new SQLException("dir_cli_id no debe ser nulo o vacio");
        } 
        /*if("".equals(Dir_Consig_Id) || Dir_Consig_Id == null) {
            throw new SQLException("dir_consig_id no debe ser nulo o vacio");
        }*/
        if("".equals(Moneda_Id) || Moneda_Id == null) {
            throw new SQLException("moneda_id no debe ser nulo o vacio");
        }
        if(Importe_Neto == null || Double.parseDouble(Importe_Neto) <= 0) {
            throw new SQLException("importe_neto no debe ser nulo y mayor a 0");
        }  
        if("".equals(Total_Impuestos) || Total_Impuestos == null) {
            throw new SQLException("total_impuestos no debe ser nulo o vacio");
        }
        if("".equals(Cond_Pago_Id) || Cond_Pago_Id == null) {
            throw new SQLException("cond_pago_id no debe ser nulo o vacio");
        }
        if("".equals(Usuario_Creador) || Usuario_Creador == null) {
            throw new SQLException("usuario_creador no debe ser nulo o vacio");
        }
        
        queryDao.setDriver("firebird");
        queryDao.setServer(this.getServer());
        queryDao.setUsername(this.getUsername());
        queryDao.setPassword(this.getPassword());
        queryDao.setDataBase(this.getDataBase());  
        
        if("P".equals(Tipo_Docto)) {
            Modalidad_Facturacion = null;
        }
        
        if("".equals(Fecha) || Fecha == null) {
            Fecha = "CURRENT_TIMESTAMP";
        } else {
            Fecha = "'"+Fecha+"'";
        }
        
        if("".equals(Dscto_Pctje) || Dscto_Pctje == null) {
            Dscto_Pctje = "0";
        }
        
        if("".equals(Dscto_Importe) || Dscto_Importe == null) {
            Dscto_Importe = "0";
        }
        
        if("".equals(Fletes) || Fletes == null) {
            Fletes = "0";
        }
        
        if("".equals(Otros_Cargos) || Otros_Cargos == null) {
            Otros_Cargos = "0";
        }
        
        if("".equals(Importe_Cobro) || Importe_Cobro == null) {
            Importe_Cobro = "0";
        }
        
        if("".equals(Tipo_Dscto) || Tipo_Dscto == null) {
            Tipo_Dscto = "P";
        }
        
        FoliosVenta p = null;        
        if("".equals(Serie) || Serie == null) {
            p = queryDao.GetFolioVenta("P", "T");                    
            Serie = p.getFolio();
        } else {
            p = queryDao.GetFolioVenta(Serie, "S");
            Serie = p.getFolio();
        }
        
        if("".equals(Dir_Consig_Id) || Dir_Consig_Id == null) {
            Dir_Consig_Id = Dir_Cli_Id;
        }
        
        if("".equals(Tipo_Dscto)) {
            Tipo_Dscto = "0";
        }
        
        if("".equals(Dscto_Pctje)) {
            Dscto_Pctje = "0";
        }
        
        if("".equals(Fecha_Vigencia_Entrega) || Fecha_Vigencia_Entrega == null) {
            Fecha_Vigencia_Entrega = "CURRENT_TIMESTAMP";
        } else {
            Fecha_Vigencia_Entrega = ""+Fecha_Vigencia_Entrega+"";
        }         
        
        String Docto_Id = queryDao.GetDoctoId().get(0).getDoctoId();                                                                         
        String DoctosVeSQL = "INSERT INTO DOCTOS_VE " +
                "(DOCTO_VE_ID, TIPO_DOCTO, FOLIO, FECHA, CLAVE_CLIENTE, "+
                "CLIENTE_ID, DIR_CLI_ID, DIR_CONSIG_ID, ALMACEN_ID, "+ 
                "MONEDA_ID, TIPO_CAMBIO, TIPO_DSCTO, DSCTO_PCTJE, "+
                "DSCTO_IMPORTE, ESTATUS, FECHA_VIGENCIA_ENTREGA, IMPORTE_NETO, "+
                "FLETES, OTROS_CARGOS, TOTAL_IMPUESTOS, SISTEMA_ORIGEN, " +
                "COND_PAGO_ID, VENDEDOR_ID, IMPORTE_COBRO, DESCRIPCION_COBRO, "+ 
                "USUARIO_CREADOR, MODALIDAD_FACTURACION, USUARIO_ULT_MODIF) VALUES " +
                "("+Docto_Id+", '"+Tipo_Docto+"', '"+Serie+"', "+Fecha+", '"+Clave_Cliente+"', "+
                ""+Cliente_Id+", "+Dir_Cli_Id+", "+Dir_Consig_Id+", "+Almacen_Id+", "+
                ""+Moneda_Id+", 1, '"+Tipo_Dscto+"', "+Dscto_Pctje+", "+
                ""+Dscto_Importe+", 'P', "+Fecha_Vigencia_Entrega+", "+Importe_Neto+", "+
                ""+Fletes+", "+Otros_Cargos+", "+Total_Impuestos+", 'VE', "+
                ""+Cond_Pago_Id+", "+Vendedor_Id+", "+Importe_Cobro+", "+Descripcion_Cobro+"," +
                "'"+Usuario_Creador+"', "+Modalidad_Facturacion+", '"+Usuario_Creador+"')";                
                        
        try {            
            conn = Connection();
            conn.setAutoCommit(false);
            query = conn.createStatement();  
            getQuery = conn.createStatement();
            query.executeUpdate(DoctosVeSQL);  
                        
            int Pos = 1;            
            String ArtSQL = null;
            String ImptoDocVeSQL = null;
            for(int i = 0; i < articulos.size(); i++) { 
                
                if(articulos.get(i).articulo_id == null || articulos.get(i).articulo_id.isEmpty()) {
                    throw new SQLException("Articulos: articulo_id no debe ser nulo o vacio");
                }                
                if(articulos.get(i).unidades == null || Double.parseDouble(articulos.get(i).unidades) <= 0) {
                    throw new SQLException("Articulos: unidades no debe ser nulo y mayor que 0");
                }
                if(articulos.get(i).precio_unitario == null || Double.parseDouble(articulos.get(i).precio_unitario) <= 0) {
                    throw new SQLException("Articulos: precio_unitario no debe ser nulo y mayor que 0");
                }
                
                String SQL = "SELECT ES_JUEGO FROM ARTICULOS WHERE ARTICULO_ID = "+articulos.get(i).articulo_id+"";
                ResultSet rs = query.executeQuery(SQL);
                while(rs.next()) {                    
                    if("S".equals(rs.getString("ES_JUEGO"))) {
                        if("J".equals(articulos.get(i).rol.toUpperCase())) {
                            break;
                        } else {
                            throw new SQLException("Articulos uno de los articulos es un juego de articulos");
                        }
                    }                     
                    if("N".equals(rs.getString("ES_JUEGO"))) {
                        if("N".equals(articulos.get(i).rol.toUpperCase())) {
                            break;
                        } else {
                            throw new SQLException("Articulos> uno de los articulos no es un juego de articulos");
                        }
                    }
                }
                
                if("N".equals(articulos.get(i).rol.toUpperCase())) {                
                        ArtSQL = "INSERT INTO DOCTOS_VE_DET " +
                        "(DOCTO_VE_DET_ID, DOCTO_VE_ID, CLAVE_ARTICULO, ARTICULO_ID, UNIDADES, PRECIO_UNITARIO," +
                        "PCTJE_DSCTO, PRECIO_TOTAL_NETO, ROL, NOTAS, POSICION) VALUES " +
                        "(-1, "+Docto_Id+", '"+articulos.get(i).clave_articulo+"', "+articulos.get(i).articulo_id+"," +
                        ""+articulos.get(i).unidades+", "+articulos.get(i).precio_unitario+", "+articulos.get(i).pctje_dscto+"," +
                        ""+this.CalcDscto(articulos.get(i).unidades, articulos.get(i).precio_unitario, articulos.get(i).pctje_dscto)+"," +
                        "'N', '"+articulos.get(0).nota_articulo+"', "+Pos+")";                        
                        query.executeUpdate(ArtSQL);
                }                
                if("J".equals(articulos.get(i).rol.toUpperCase())) {                                                          
                        ArtSQL = "INSERT INTO DOCTOS_VE_DET " +
                        "(DOCTO_VE_DET_ID, DOCTO_VE_ID, CLAVE_ARTICULO, ARTICULO_ID, UNIDADES, PRECIO_UNITARIO," +
                        "PCTJE_DSCTO, PRECIO_TOTAL_NETO, ROL, NOTAS, POSICION) VALUES " +
                        "(-1, "+Docto_Id+", '"+articulos.get(i).clave_articulo+"', "+articulos.get(i).articulo_id+"," +
                        ""+articulos.get(i).unidades+", "+articulos.get(i).precio_unitario+", "+articulos.get(i).pctje_dscto+"," +
                        ""+this.CalcDscto(articulos.get(i).unidades, articulos.get(i).precio_unitario, articulos.get(i).pctje_dscto)+"," +
                        "'J', '"+articulos.get(0).nota_articulo+"', "+Pos+")";
                        query.executeUpdate(ArtSQL);

                        comp = queryDao.GetJuegoDet(articulos.get(i).articulo_id);                    
                        for(int j = 0; j < comp.size(); j++) {
                            ArtSQL = "INSERT INTO DOCTOS_VE_DET " +
                            "(DOCTO_VE_DET_ID, DOCTO_VE_ID, CLAVE_ARTICULO, ARTICULO_ID, UNIDADES, PRECIO_UNITARIO," +
                            "PCTJE_DSCTO, PRECIO_TOTAL_NETO, ROL, NOTAS, POSICION) VALUES " +
                            "(-1, "+Docto_Id+", '"+comp.get(j).getClaveArticulo()+"', "+articulos.get(i).articulo_id+"," +
                            ""+comp.get(j).getUnidades()+", 0, 0, 0, 'C', null, "+Pos+")";
                            query.executeUpdate(ArtSQL);
                            Pos++;
                        }                                                
                }  
                Pos++;
            }
            
            String ImptosDoctoVe = "SELECT "+
            "C.PCTJE_IMPUESTO, C.IMPUESTO_ID, SUM(A.PRECIO_TOTAL_NETO) AS VENTA_NETA," +
            "(SUM(A.PRECIO_TOTAL_NETO)*(C.PCTJE_IMPUESTO/100)) AS IMPORTE_IMPTO FROM " +
            "(((DOCTOS_VE_DET A INNER JOIN IMPUESTOS_ARTICULOS B ON A.ARTICULO_ID=B.ARTICULO_ID) " +
            "INNER JOIN IMPUESTOS C ON B.IMPUESTO_ID=C.IMPUESTO_ID) " +
            "INNER JOIN TIPOS_IMPUESTOS D ON C.TIPO_IMPTO_ID=D.TIPO_IMPTO_ID) " +
            "WHERE A.DOCTO_VE_ID = "+Docto_Id+" GROUP BY C.PCTJE_IMPUESTO, C.IMPUESTO_ID";
            
            ResultSet rs = getQuery.executeQuery(ImptosDoctoVe);
            
            while(rs.next()) {
                ImptoDocVeSQL = "INSERT INTO IMPUESTOS_DOCTOS_VE " +
                "(DOCTO_VE_ID, IMPUESTO_ID, VENTA_NETA, OTROS_IMPUESTOS," +
                "PCTJE_IMPUESTO, IMPORTE_IMPUESTO) VALUES " +
                "("+Docto_Id+","+rs.getString("IMPUESTO_ID")+", "+rs.getString("VENTA_NETA")+"," +
                "0, "+rs.getString("PCTJE_IMPUESTO")+", "+rs.getString("IMPORTE_IMPTO")+")";
                query.executeUpdate(ImptoDocVeSQL);                
            }
            
            String SQL = "UPDATE FOLIOS_VENTAS SET CONSECUTIVO = " + (Integer.parseInt(p.getConsec()) + 1) + " " + 
                         "WHERE FOLIO_VENTAS_ID = "+p.getFolioVentaId()+"";
            query.executeUpdate(SQL);
                                          
            conn.commit();
        } catch(SQLException e) {      
            conn.rollback();
            throw new SQLException(e.getMessage().replaceAll("[\n\r\"]", " "));             
        } finally {
            if(getQuery != null) {
                getQuery.close();
            }    
            if(query != null) {
                query.close();
            }                                                
            if(conn != null) {
                conn.close();
            }  
        }
        
        return "Se inserto el docto " + Docto_Id; 
    }
    
    public double CalcDscto(String unidades, String precio_unitario, String pctje_dscto) {
        double u = Double.parseDouble(unidades);
        double p = Double.parseDouble(precio_unitario);
        double pd = Double.parseDouble(pctje_dscto);
        double total;
        
        if(pd != 0 && pctje_dscto != null) {
            total = (u*p)/(pd/100);            
        } else {
            total = (u*p);
        } 
        
        return total;
    }
    
}
