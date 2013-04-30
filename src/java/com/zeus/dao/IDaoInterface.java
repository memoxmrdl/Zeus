/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao;

import com.zeus.domain.*;
import java.util.List;
import javax.sql.DataSource;
/**
 *
 * @author Guillermo
 */
public interface IDaoInterface {
        
    List<ListaArticulos> GetListaArticulos(String Estatus, String Linea_Id, String Grupo_Id, String Articulo_Id);
    List<ArtExistencia> GetArtExistencia(String Articulo_id, String Almacen_id);
    List<ArtPrecio> GetArtPrecio(String Articulo_Id, String Cliente_Id, String Fecha_Venta, String Moneda_Destino_Id);    
    List<ListaArticulos> GetArticulo(String Articulo_Id);
    List<ArtImpto> GetArtImpto(String Articulo_Id, String Cliente_Id);
    List<ListaClientes> GetListaClientes(String Tipo_Cliente_Id, String Zona_Cliente_Id, String Cobrador_Id, String Vendedor_Id, String Estatus, String Cliente_Id);
    //List<RolClave> GetRolClave();
    List<ClienteSaldo> GetClienteSaldo(String Cliente_Id, String Fecha, String Incluir_Xlib);
    /*int PostCliente(String Nombre, String Contacto1, String Contacto2, String Estatus, String Limite_Credito, 
            String Moneda_Id, String Cond_Pago_Id, String Tipo_Cliente_Id, String Zona_Cliente_Id, 
            String Cobrador_Id, String Vendedor_Id, String Clave_Cliente, String Nombre_Calle,
            String Num_Exterior, String Num_Interior, String Colonia, String Poblacion, String Referencia,
            String Ciudad_Id, String Codigo_Postal) throw Exception;*/
    
     
}
