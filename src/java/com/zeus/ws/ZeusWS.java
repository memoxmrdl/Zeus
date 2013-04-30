/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.ws;

import com.google.gson.Gson;
import com.zeus.MsjError.ReportError;        
import com.zeus.classObj.*;
import com.zeus.test.callDaoMethod;
import com.zeus.tools.StrTool;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

 /*
 * @author Guillermo
 */
@WebService(serviceName = "ZeusWS")
public class ZeusWS {

    /**
     * Web service operation
     */    
    @WebMethod(operationName = "GetListaArticulos")
    public String GetListaArticulos(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {               
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;            
        
        if(args == null) {
           args = null;  
        } else {
           args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn); 
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }      
                                
        try {
            result = call.GetListaArticulos(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetArtExistencia")
    public String GetArtExistencia(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;
        
        if(args == null) {
            return Send.ReturnError("articulo_id y almacen_id no deben ser nulos");  
        } else {
            args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);  
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }      
        
        try {
            result = call.GetArtExistencia(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetArtPrecio")
    public String GetArtPrecio(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;
        
        if(args == null) {
           return Send.ReturnError("articulo_id no deben ser nulo");  
        } else {
           args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);  
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        try {
            result = call.GetArtPrecio(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetArticulo")
    public String GetArticulo(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;
        
        if(args == null) {
           return Send.ReturnError("articulo_id no deben ser nulo");  
        } else {
           args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn); 
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        try {
         result = call.GetArticulo(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetArtImpto")
    public String GetArtImpto(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;      
        
        if(args == null) {
           return Send.ReturnError("articulo_id y cliente_id no deben ser nulos");  
        } else {
           args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn); 
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        try {
         result = call.GetArtImpto(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetListaClientes")
    public String GetListaClientes(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;

        if(args == null) {
           args = null;  
        } else {
           args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        try {
         result = call.GetListaClientes(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCliente")
    public String GetCliente(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;

        if(call.GetVersion(conn).isEmpty()) {
            return Send.ReturnError("Error");
        }
        
        if(args == null) {
           return Send.ReturnError("cliente_id no deben ser nulos");  
        } else {
           args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        try {
         result = call.GetCliente(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetClienteSaldo")
    public String GetClienteSaldo(@WebParam(name = "args") String args, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        String result;
        
        if(call.GetVersion(conn).isEmpty()) {
            return Send.ReturnError("asdasda");
        }        
        
        if(args == null) {
           return Send.ReturnError("cliente_id no deben ser nulos");  
        } else {
           args = tool.StrEvalJson(args);
        }
        
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);  
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        try {
         result = call.GetClienteSaldo(args, conn);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "PostCliente")
    public String PostCliente(@WebParam(name = "nombre") String nombre, @WebParam(name = "contacto1") String contacto1, 
                              @WebParam(name = "contacto2") String contacto2, @WebParam(name = "estatus") String estatus, 
                              @WebParam(name = "limite_credito") String limite_credito, @WebParam(name = "moneda_id") String moneda_id, 
                              @WebParam(name = "cond_pago_id") String cond_pago_id, @WebParam(name = "tipo_cliente_id") String tipo_cliente_id, 
                              @WebParam(name = "zona_cliente_id") String zona_cliente_id, @WebParam(name = "cobrador_id") String cobrador_id, 
                              @WebParam(name = "vendedor_id") String vendedor_id, @WebParam(name = "clave_cliente") String clave_cliente, 
                              @WebParam(name = "nombre_calle") String nombre_calle, @WebParam(name = "num_exterior") String num_exterior, 
                              @WebParam(name = "num_interior") String num_interior, @WebParam(name = "colonia") String colonia, 
                              @WebParam(name = "poblacion") String poblacion, @WebParam(name = "referencia") String referencia, 
                              @WebParam(name = "ciudad_id") String ciudad_id, @WebParam(name = "codigo_postal") String codigo_postal,
                              @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        Conn conn1 = new Conn();
        argsPCliente params = new argsPCliente();       
        Gson gson = new Gson();
        String result = null;
         
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);
            conn1 = gson.fromJson(conn, Conn.class);
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        params.nombre = nombre;
        params.contacto1 = contacto1;
        params.contacto2 = contacto2;
        params.estatus = estatus;
        params.limite_credito = limite_credito;
        params.moneda_id = moneda_id;
        params.cond_pago_id = cond_pago_id;
        params.tipo_cliente_id = tipo_cliente_id;
        params.zona_cliente_id = zona_cliente_id;
        params.cobrador_id = cobrador_id;
        params.vendedor_id = vendedor_id;
        params.clave_cliente = clave_cliente;
        params.nombre_calle = nombre_calle;
        params.num_exterior = num_exterior;
        params.num_interior = num_interior;
        params.colonia = colonia;
        //params.poblacion = poblacion;
        params.referencia = referencia;
        params.ciudad_id = ciudad_id;
        params.codigo_postal = codigo_postal;
                        
        try {
            result = call.PostCliente(params, conn1);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
                        
        return result;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "UpdateCliente")
    public String UpdateCliente(@WebParam(name = "nombre") String nombre, @WebParam(name = "contacto1") String contacto1, 
                              @WebParam(name = "contacto2") String contacto2, @WebParam(name = "estatus") String estatus, 
                              @WebParam(name = "limite_credito") String limite_credito, @WebParam(name = "moneda_id") String moneda_id, 
                              @WebParam(name = "cond_pago_id") String cond_pago_id, @WebParam(name = "tipo_cliente_id") String tipo_cliente_id, 
                              @WebParam(name = "zona_cliente_id") String zona_cliente_id, @WebParam(name = "cobrador_id") String cobrador_id, 
                              @WebParam(name = "vendedor_id") String vendedor_id, @WebParam(name = "clave_cliente") String clave_cliente, 
                              @WebParam(name = "nombre_calle") String nombre_calle, @WebParam(name = "num_exterior") String num_exterior, 
                              @WebParam(name = "num_interior") String num_interior, @WebParam(name = "colonia") String colonia, 
                              @WebParam(name = "poblacion") String poblacion, @WebParam(name = "referencia") String referencia, 
                              @WebParam(name = "ciudad_id") String ciudad_id, @WebParam(name = "codigo_postal") String codigo_postal,
                              @WebParam(name = "cliente_id") String cliente_id, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        Conn conn1 = new Conn();
        argsPCliente params = new argsPCliente();       
        Gson gson = new Gson();
        String result = null;
                             
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);
            conn1 = gson.fromJson(conn, Conn.class);
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        params.nombre = nombre;
        params.contacto1 = contacto1;
        params.contacto2 = contacto2;
        params.estatus = estatus;
        params.limite_credito = limite_credito;
        params.moneda_id = moneda_id;
        params.cond_pago_id = cond_pago_id;
        params.tipo_cliente_id = tipo_cliente_id;
        params.zona_cliente_id = zona_cliente_id;
        params.cobrador_id = cobrador_id;
        params.vendedor_id = vendedor_id;
        params.clave_cliente = clave_cliente;
        params.nombre_calle = nombre_calle;
        params.num_exterior = num_exterior;
        params.num_interior = num_interior;
        params.colonia = colonia;
        params.poblacion = poblacion;
        params.referencia = referencia;
        params.ciudad_id = ciudad_id;
        params.codigo_postal = codigo_postal;
        params.cliente_id = cliente_id;
                        
        try {
            result = call.UpdateCliente(params, conn1);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
                        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DeleteCliente")
    public String DeleteCliente(@WebParam(name = "cliente_id") String cliente_id, @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        Conn conn1 = new Conn();
        argsPCliente params = new argsPCliente();       
        Gson gson = new Gson();
        String result = null;       
                
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);
            conn1 = gson.fromJson(conn, Conn.class);
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }
        
        params.cliente_id = cliente_id;
                        
        try {
            result = call.DeleteCliente(params, conn1);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
                        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "PostDoctoVe")
    public String PostDoctoVe(@WebParam(name = "documento") argsDoctoVe documento, 
                              @WebParam(name = "conceptos") List<argsDoctoVeArt> articulos, 
                              @WebParam(name = "conn") String conn) {
        callDaoMethod call = new callDaoMethod();
        StrTool tool = new StrTool();
        ReportError Send = new ReportError();
        Conn conn1 = new Conn();               
        Gson gson = new Gson();
        String result = null;        
                
        if(conn == null) {
            return Send.ReturnError("Los datos de conexión no son correctos o esta vacia");
        } else {         
            conn = tool.StrEvalJson(conn);
            conn1 = gson.fromJson(conn, Conn.class);
            
            String t = call.GetVersion(conn);
            if(!t.isEmpty()) {
                return Send.ReturnError(t);
            }
        }       
        
        try {
            result = call.PostDoctoVe(documento, articulos, conn1);
        } catch(Exception e) {
            return Send.ReturnError(e.getMessage());
        }
                        
        return result;
    }

}        



