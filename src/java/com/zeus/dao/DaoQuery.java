 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zeus.dao;

import com.zeus.dao.mapper.*;
import com.zeus.domain.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Guillermo
 */
public class DaoQuery implements IDaoInterface {
    
    private String Driver;
    private String Server;
    private String Username;
    private String Password;
    private String DataBase;    
    //private DataSource datasource;
    JdbcTemplate jdbcTemplate;
    
    public void setDriver(String driver) {
        this.Driver = driver;
    }
    
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
    
    public String getDriver() {
        return this.Driver;
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
           
    protected void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
        
    // jdbc:firebirdsql://<host>[:<port>]/<alias-or-path-to-db>
    //protected void setConnection(String Driver, String Server, String Username, String Password, String DataBase) {
    protected void setConnection() {
        BasicDataSource dataSource = new BasicDataSource();        
        //String Url = "jdbc:firebirdsql://"+server+":3050/"+dbName;       
        dataSource.setUsername(this.getUsername());
        dataSource.setPassword(this.getPassword());
        
        if("firebird".equals(this.getDriver())) {
            dataSource.setUrl("jdbc:firebirdsql://"+this.getServer()+":3050/"+this.getDataBase()+"");        
            dataSource.setDriverClassName("org.firebirdsql.jdbc.FBDriver");
        } else if("mysql".equals(this.getDriver())){
            dataSource.setUrl("jdbc:mysql://"+this.getServer()+":3306/"+this.getDataBase()+"");
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        }        
        setDataSource(dataSource);
        
        
        
    }
    
    public String RouteDbConfig(String ruta) {
        int pos = 0;
        String t = null;
        if(ruta.toLowerCase().contains(".fdb")) {                        
            for(int i = ruta.length()-1; i >= 0; i--) {
                if('\\' == ruta.charAt(i)) {
                    pos = i;
                    t = "\\System\\Metadatos.fdb";
                    break;
                }
                if('/' == ruta.charAt(i)) {
                    pos = i;
                    t = "/System/Metadatos.fdb";
                    break;
                }
            }            
            ruta = ruta.substring(0, pos);            
        } else {
            ruta = "null";
        }
        return ruta+t;
    }
    
    public boolean VersionM() throws Exception {
        setDataBase(RouteDbConfig(getDataBase()));
        setConnection();        
        String SQL = "SELECT MAX(VERSION_SIS) AS VERSION FROM VERSIONES_SIS "
                        + "WHERE SISTEMA_ID = 20 AND (VERSION_SIS >= 7000 "
                        + "AND VERSION_SIS < 8000)";
        
        RowMapper mapper = new RowMapper() {
            @Override
            public VersionDB mapRow(ResultSet rs, int rowNum) throws SQLException {
                VersionDB row = new VersionDB();
                row.setVersion(rs.getString("VERSION"));
                return row;
            }                        
        };
        
        List<VersionDB> db = jdbcTemplate.query(SQL, mapper);        
        return db.get(0).getVersion().isEmpty();
    }

    @Override
    public List<ListaArticulos> GetListaArticulos(String Estatus, String Linea_Id, String Grupo_Id, String Articulo_Id) {        
        setConnection();
        String SQL = "";
        String Where = "";
        
        if(Articulo_Id == null) {
                
        if(Estatus != null) {
            Where = Where + "A.ESTATUS = '"+ Estatus +"' AND ";
        }
        
        if(Linea_Id != null) {
            Where = Where + "A.LINEA_ARTICULO_ID = '"+Linea_Id+"' AND ";
        }
                        
        if(Grupo_Id != null) {
            Where = Where + "B.GRUPO_LINEA_ID = '"+Grupo_Id+"' AND ";
        }
        
        if(!"".equals(Where)) {
            Where = Where.substring(0, Where.length()-4);
            Where = " WHERE " + Where;
        }  
        
        } else {
            Where = " WHERE A.ARTICULO_ID = "+Articulo_Id+"";
        }
                
        SQL = "SELECT " +
                "A.ARTICULO_ID, A.NOMBRE AS NOMBRE_ARTICULO, " +
                "A.LINEA_ARTICULO_ID, B.NOMBRE AS NOMBRE_LINEA_ARTICULO, " +
                "A.UNIDAD_VENTA AS UNIDAD_MEDIDA, A.UNIDAD_COMPRA AS UNIDAD_COMPRA, " +
                "C.CLAVE_ARTICULO, A.ES_ALMACENABLE, A.ES_JUEGO, A.ESTATUS, D.GRUPO_LINEA_ID, " +
                "D.NOMBRE AS NOMBRE_GRUPO_LINEA" +                
              " FROM " +
                "(((ARTICULOS A LEFT OUTER JOIN CLAVES_ARTICULOS C " +
                "ON A.ARTICULO_ID = C.ARTICULO_ID AND C.ROL_CLAVE_ART_ID = 17) " +
                "LEFT OUTER JOIN LINEAS_ARTICULOS B " +
                "ON A.LINEA_ARTICULO_ID = B.LINEA_ARTICULO_ID) " +
                "LEFT OUTER JOIN GRUPOS_LINEAS D " +
                "ON B.GRUPO_LINEA_ID = D.GRUPO_LINEA_ID)  ";
        
        SQL = SQL + Where;
                  
        return jdbcTemplate.query(SQL, new ListaArticulosRowMapper());
    }

    @Override
    public List<ArtExistencia> GetArtExistencia(String Articulo_id, String Almacen_id) {
        setConnection();                                 
        String SQL = "EXECUTE PROCEDURE CALC_DISP_ARTALM("+Articulo_id+","+Almacen_id+")";        
        return jdbcTemplate.query(SQL, new ArtExistenciaRowMapper());
    }

    @Override
    public List<ArtPrecio> GetArtPrecio(String Articulo_Id, String Cliente_Id, String Fecha_Venta, String Moneda_Destino_Id) {
        setConnection();        
        String SQL = "EXECUTE PROCEDURE GET_PRECIO_ARTCLI_MON("+Cliente_Id+","+Articulo_Id+",'"+Fecha_Venta+"',"+Moneda_Destino_Id+")";
        return jdbcTemplate.query(SQL, new ArtPrecioRowMapper());
    }

    @Override
    public List<ListaArticulos> GetArticulo(String Articulo_Id) {
       setConnection();
       return this.GetListaArticulos(null, null, null, Articulo_Id);
    }

    @Override
    public List<ArtImpto> GetArtImpto(String Articulo_Id, String Cliente_Id) {
        setConnection();
        String SQL = "EXECUTE PROCEDURE Z_GET_ART_IMPTO("+Articulo_Id+","+Cliente_Id+")";
        return jdbcTemplate.query(SQL, new ArtImptoRowMapper());
    }

    @Override
    public List<ListaClientes> GetListaClientes(String Tipo_Cliente_Id, String Zona_Cliente_Id, String Cobrador_Id, String Vendedor_Id, String Estatus, String Clave_Cliente) {
        setConnection();
        String Where = "";
        
        if(Clave_Cliente == null) {
        
        if(Tipo_Cliente_Id != null) {
            Where = Where + "A.TIPO_CLIENTE_ID = "+Tipo_Cliente_Id+" AND ";
        }
        
        if(Zona_Cliente_Id != null) {
            Where = Where + "A.ZONA_CLIENTE_ID = "+Zona_Cliente_Id+" AND ";
        }
        
        if(Cobrador_Id != null) {
            Where = Where + "A.COBRADOR_ID = "+Cobrador_Id+" AND ";
        }
        
        if(Vendedor_Id != null) {
            Where = Where + "A.VENDEDOR_ID = "+Vendedor_Id+" AND ";
        } 
        
        if(Estatus != null) {
            Where = Where + "A.ESTATUS = '"+Estatus+"' AND ";
        }
        
        if(!"".equals(Where)) {
            Where = Where.substring(0, Where.length()-4);
            Where = " WHERE " + Where;
        }    
        
        } else {
            Where = " WHERE H.CLAVE_CLIENTE = '" + Clave_Cliente + "'";
        }
        
        //String Rol_Clave = this.GetRolClave().get(0).getRolId();
                                
        String SQL = "SELECT " +                               
                "A.CLIENTE_ID, A.NOMBRE AS NOMBRE_CLIENTE, A.CONTACTO1, A.CONTACTO2, " +
                "A.ESTATUS, A.LIMITE_CREDITO, A.MONEDA_ID, B.NOMBRE AS NOMBRE_MONEDA, " +
                "A.COND_PAGO_ID, C.NOMBRE AS NOMBRE_COND_PAGO, A.TIPO_CLIENTE_ID, D.NOMBRE AS NOMBRE_TIPO_CLIENTE, " +
                "A.ZONA_CLIENTE_ID, E.NOMBRE AS NOMBRE_ZONA_CLIENTE, A.COBRADOR_ID, F.NOMBRE AS NOMBRE_COBRADOR, " +
                "A.VENDEDOR_ID, G.NOMBRE AS NOMBRE_VENDEDOR, H.CLAVE_CLIENTE" +
                " FROM (((((((" +
                "CLIENTES A INNER JOIN MONEDAS B ON A.MONEDA_ID = B.MONEDA_ID) " +
                "INNER JOIN CONDICIONES_PAGO C ON A.COND_PAGO_ID = C.COND_PAGO_ID) " +
                "LEFT OUTER JOIN TIPOS_CLIENTES D ON A.TIPO_CLIENTE_ID = D.TIPO_CLIENTE_ID) " +
                "LEFT OUTER JOIN ZONAS_CLIENTES E ON A.ZONA_CLIENTE_ID = E.ZONA_CLIENTE_ID) " +
                "LEFT OUTER JOIN COBRADORES F ON A.COBRADOR_ID = F.COBRADOR_ID) " +
                "LEFT OUTER JOIN VENDEDORES G ON A.VENDEDOR_ID = G.VENDEDOR_ID) " +
                "LEFT OUTER JOIN CLAVES_CLIENTES H ON A.CLIENTE_ID = H.CLIENTE_ID)"; /*AND H.ROL_CLAVE_CLI_ID = "+Rol_Clave+")";*/

        SQL = SQL + Where;
        return jdbcTemplate.query(SQL, new ListaClientesRowMapper());        
    }

    public List<RolClave> GetRolClave() {  
       setConnection();
       String SQL = "SELECT ROL_CLAVE_CLI_ID AS ROL_ID FROM ROLES_CLAVES_CLIENTES WHERE ES_PPAL = 'S'";
       return jdbcTemplate.query(SQL, new RolClaveRowMapper());
    }

   @Override
    public List<ClienteSaldo> GetClienteSaldo(String Cliente_Id, String Fecha, String Incluir_Xlib) {
       setConnection();
       String SQL = "EXECUTE PROCEDURE CALC_SALDO_CLIENTE("+Cliente_Id+",'"+Fecha+"',"+Incluir_Xlib+")";
       return jdbcTemplate.query(SQL, new ClienteSaldoRowMapper());
    }        

    public List<GenCatalogoId> GenCatalogoId() {        
        setConnection();
        RowMapper mapper = new RowMapper() {           
            @Override
            public GenCatalogoId mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenCatalogoId row = new GenCatalogoId();
                row.setCatalogoId(rs.getInt("CATALOGO_ID"));
                return row;
            }
        };
        
        return jdbcTemplate.query("EXECUTE PROCEDURE GEN_CATALOGO_ID", mapper);
    }
    
    
    public List<CiuEstPas> GetIdCiuEstPas(String Ciudad_Id) {
        setConnection();
        String SQL = "SELECT A.CIUDAD_ID, B.ESTADO_ID, C.PAIS_ID " +
        "FROM (CIUDADES A INNER JOIN ESTADOS B ON A.ESTADO_ID = B.ESTADO_ID) " +
        "INNER JOIN PAISES C ON B.PAIS_ID = C.PAIS_ID "+
        "WHERE A.CIUDAD_ID = "+Ciudad_Id+"";
        
        RowMapper mapper = new RowMapper() {
            @Override
            public CiuEstPas mapRow(ResultSet rs, int rowNum) throws SQLException {
                CiuEstPas row = new CiuEstPas();
                row.setCiudadId(rs.getString("CIUDAD_ID"));
                row.setEstadoId(rs.getString("ESTADO_ID"));
                row.setPaisId(rs.getString("PAIS_ID"));
                return row;
            }
        };
        
        return jdbcTemplate.query(SQL, mapper);
    }
    
    public List<DoctoId> GetDoctoId() {
        setConnection();
        String SQL = "EXECUTE PROCEDURE GEN_DOCTO_ID";
        RowMapper mapper = new RowMapper() {
            @Override
            public DoctoId mapRow(ResultSet rs, int rowNum) throws SQLException {
                DoctoId row = new DoctoId();
                row.setDoctoId(rs.getString("DOCTO_ID"));
                return row;
            }
        };
        return jdbcTemplate.query(SQL, mapper);
    }
    
    
     public FoliosVenta GetFolioVenta(String Word, String Tipo) throws SQLException {
        setConnection();
        String SQL = null;       
        
        if("T".equals(Tipo.toUpperCase())) {
            SQL = "SELECT FOLIO_VENTAS_ID,SERIE,CONSECUTIVO FROM FOLIOS_VENTAS WHERE TIPO_DOCTO = '"+Word+"'";   
        } else if("S".equals(Tipo.toUpperCase())) {
            SQL = "SELECT FOLIO_VENTAS_ID,SERIE,CONSECUTIVO FROM FOLIOS_VENTAS WHERE SERIE = '"+Word+"'";
        }        
        
        RowMapper mapper = new RowMapper() {
            @Override
            public FolioVenta mapRow(ResultSet rs, int rowNum) throws SQLException {
                FolioVenta row = new FolioVenta();
                row.setFolioVenta(rs.getString("FOLIO_VENTAS_ID"));
                row.setSerie(rs.getString("SERIE"));
                row.setConsecutivo(rs.getString("CONSECUTIVO"));
                return row;
            }                        
        };
        
        List<FolioVenta> r = jdbcTemplate.query(SQL, mapper);
        
        if(r.isEmpty()) {
            if("T".equals(Tipo.toUpperCase())) {
                throw new SQLException("Serie: No existe el tipo indicado por serie");
            } else if("S".equals(Tipo.toUpperCase())) {
                throw new SQLException("Serie: NO existe el serie indicado por serie");
            } 
        }
        
        String serie = r.get(0).getSerie();
        String consec = r.get(0).getConsecutivo();        
        int t = serie.length() + consec.length();
               
        for(int i = t; i < 9; i++) {
            serie = serie + "0";
        }
        
        FoliosVenta data = new FoliosVenta();
        data.setFolio(serie + consec);
        data.setFolioVentaId(r.get(0).getFolioVenta());
        data.setConsec(consec);
        //List<FoliosVenta> p = null;              
        //p.add(data);
                
        /*SQL = "UPDATE FOLIOS_VENTAS SET CONSECUTIVO = " + (Integer.parseInt(consec) + 1) + " "+ 
              "WHERE FOLIO_VENTAS_ID = "+r.get(0).getFolioVenta()+"";        
        jdbcTemplate.execute(SQL);*/
        
        return data;        
    }
         
    public List<JuegoDet> GetJuegoDet(String Articulo_Id) throws SQLException {
        setConnection();               
        
        String SQL = "SELECT B.CLAVE_ARTICULO, A.UNIDADES FROM " +
                     "(JUEGOS_DET A LEFT OUTER JOIN CLAVES_ARTICULOS B " +
                     "ON A.CLAVE_ARTICULO_ID  = B.CLAVE_ARTICULO_ID) WHERE " +
                     "A.ARTICULO_ID = "+Articulo_Id+"";
        
        RowMapper mapper = new RowMapper() {
            @Override
            public JuegoDet mapRow(ResultSet rs, int rowNum) throws SQLException {
                JuegoDet row = new JuegoDet();
                row.setClaveArticulo(rs.getString("CLAVE_ARTICULO"));
                row.setUnidades(rs.getString("UNIDADES"));
                return row;
            }                        
        };
                
        return jdbcTemplate.query(SQL, mapper);
    }
    
    public List<ImptoDoctoVe> GetImptoDoctoVe(String Docto_Ve_Id) {
        setConnection();       
        String SQL = "SELECT "+
        "C.PCTJE_IMPUESTO, C.IMPUESTO_ID, SUM(A.PRECIO_TOTAL_NETO) AS VENTA_NETA," +
        "(SUM(A.PRECIO_TOTAL_NETO)*(C.PCTJE_IMPUESTO/100)) AS IMPORTE_IMPTO FROM " +
        "(((DOCTOS_VE_DET A INNER JOIN IMPUESTOS_ARTICULOS B ON A.ARTICULO_ID=B.ARTICULO_ID) " +
        "INNER JOIN IMPUESTOS C ON B.IMPUESTO_ID=C.IMPUESTO_ID) " +
        "INNER JOIN TIPOS_IMPUESTOS D ON C.TIPO_IMPTO_ID=D.TIPO_IMPTO_ID) " +
        "WHERE A.DOCTO_VE_ID = "+Docto_Ve_Id+" FOR UPDATE GROUP BY C.PCTJE_IMPUESTO, C.IMPUESTO_ID";
        
        RowMapper mapper = new RowMapper() {
            @Override
            public ImptoDoctoVe mapRow(ResultSet rs, int rowNum) throws SQLException {
                ImptoDoctoVe row = new ImptoDoctoVe();
                row.setPctjeImpuesto(rs.getString("PCTJE_IMPUESTO"));
                row.setImpuestoId(rs.getString("IMPUESTO_ID"));
                row.setVentaNeta(rs.getString("VENTA_NETA"));
                row.setImporteImpto(rs.getString("IMPORTE_IMPTO"));
                return row;
            }                        
        };
        
        return jdbcTemplate.query(SQL, mapper);
    }
    
    public List<DirsClientes> GetDirsCliente(String Cliente_Id) {
        setConnection();       
        
        String SQL = "SELECT DIR_CLI_ID, NOMBRE_CONSIG, ES_DIR_PPAL "
                    + "FROM DIRS_CLIENTES "
                    + "WHERE CLIENTE_ID = " + Cliente_Id;
        
        RowMapper mapper = new RowMapper() {
            @Override
            public DirsClientes mapRow(ResultSet rs, int rowNum) throws SQLException {
                DirsClientes row = new DirsClientes();
                row.setDirCliId(rs.getString("DIR_CLI_ID"));
                row.setNombreConsig(rs.getString("NOMBRE_CONSIG"));
                row.setEsDirPpal(rs.getString("ES_DIR_PPAL"));
                return row;
            }                        
        };
        
        return jdbcTemplate.query(SQL, mapper);
    }
}