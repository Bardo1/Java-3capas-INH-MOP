
package Persistencia;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author Walter Muñoz
 */
public class ConexionSql {

   
  
    private Connection conexion;
    
      public ConexionSql() {
      
        this.conexion=null;
    }
      public boolean conectar() {
        this.conexion = null;
        try {
       Class.forName("com.mysql.jdbc.Driver");
         
          String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=PBase";
            //String URL = "jdbc:sqlserver://169.99.1.22\\MSSQLSERVER:1433;databaseName=PBase";
          
            System.out.println(URL);
            try{
          //   this.conexion = DriverManager.getConnection(URL,"requerimientos","RequeINH0620");
            this.conexion = DriverManager.getConnection(URL,"sa","5371569");
            
            }catch(SQLException ex){
                return false;
            }
             if (this.conexion != null) {
                  System.out.println();
                  System.out.println("Conexion Exitosa!!!");
                  System.out.println();
                  // Meta data
                  DatabaseMetaData meta = this.conexion.getMetaData();
                  System.out.println("\nDriver Information");
                  System.out.println("Driver Name: " + meta.getDriverName());
                  System.out.println("Driver Version: " + meta.getDriverVersion());
                  System.out.println("\nDatabase Information ");
                  System.out.println("Database Name: " + meta.getDatabaseProductName());
                  System.out.println("Database Version: " + meta.getDatabaseProductVersion());
                  return true;
             }

        }catch(SQLException se) {
             se.printStackTrace();
             
        }catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
            
        }
        return false;

    }
      public boolean cerrar() {
        try {
            this.conexion.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
          
    public boolean ejecutarSinRetorno(String query){
        boolean result = true;
        if(this.conexion != null){
            
            try {
                result =this.conexion.createStatement().execute(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    public boolean modificaFormulario(String query){
    
    try{  
    this.conectar();
    java.sql.Statement conector= conexion.createStatement();
    conector.executeUpdate(query);
    conector.close();
    conexion.close();
    return true;
    
    }catch(SQLException e){
    Logger.getLogger(ConexionSql.class.getName()).log(Level.SEVERE, null, e);
    
    return false;
    }
            }
     
    
    public boolean IngresarUsuario3(String NuevoNombre,String Contraseña){
 
    try{  
    this.conectar();
    java.sql.Statement conector= conexion.createStatement();
    conector.executeUpdate("insert into usuarios (Nombre,Clave) values('"+NuevoNombre+"','"+Contraseña+"')");
    conector.close();
    conexion.close();
    return true;
    
    }catch(SQLException e){
    Logger.getLogger(ConexionSql.class.getName()).log(Level.SEVERE, null, e);
    
    return false;
    }
     
     
 } 
    
    
    
    
    
    public int BuscarNumeroCorrelativo2(){
 
     int valor=0;
     String dato="";
        try{
            this.conectar();
            java.sql.Statement conector=conexion.createStatement();
            ResultSet result =conector.executeQuery("SELECT  t.Dtecnum1 FROM formulario t WHERE t.Dtecnum1 = ( SELECT max( Dtecnum1 )  FROM formulario)");
            while(result.next()){        
            dato = result.getString("Dtecnum1");
            valor= Integer.parseInt(dato);
            valor++;
            }
            this.cerrar();
            conector.close();
            return valor;
        }catch(SQLException e){
            System.out.println("error");
            return valor;
        }
 }
    public boolean GuardarDatosLista(HashMap myMap, String dnumber ){
        
          
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            
            for(int i=0; i<myMap.size();i++){
             
                 String nombrenumero=String.valueOf(i);
                 String [] vector= (String[]) myMap.get(nombrenumero);  
                 
                 String cero=vector[0];
                 String uno=vector[1];
                 String dos=vector[2];
                 String tres=vector[3];
                 String cuatro=vector[4];
                 String cinco=vector[5];
                 String seis=vector[6];
                 String siete=vector[7];
                 String ocho=vector[8];
                 
                 
                 conector.executeUpdate("insert into tabladatos (Dtecnum1,DESCRIP,PRODSER,CANTIDAD,VALORMONEDA1,VALORESTIM,TPESOS,CALCULOIMPUESTO1,TotalTotal1) values('"+dnumber+"','"+uno+"','"+dos+"','"+tres+"','"+cuatro+"','"+cinco+"','"+seis+"','"+siete+"','"+ocho+"')");
            }           
            this.cerrar();
            conector.close();
            return true;
        }catch(SQLException e){
            System.out.println("error");
            return false;
        }
    }
  
    
    public boolean PruebaDeIngreso(String Cargo1){
  
    try{      
        this.conectar();
        java.sql.Statement conector= conexion.createStatement();
        conector.executeUpdate("insert into tablaprobar (NOMBRE) values('"+Cargo1+"')");
        conector.close();
        conexion.close();
        return true;
    }catch(SQLException e){
        Logger.getLogger(ConexionSql.class.getName()).log(Level.SEVERE, null, e);
        return false;
    }
}
    public ArrayList<HashMap> ejecutarConRetorno(String query){
       ArrayList<HashMap> listado = null;
       if(this.conexion != null){
            ResultSet result = null;
            try {
                result = this.conexion.createStatement().executeQuery(query);
                if(result != null){
                    boolean valido = result.next();
                    listado = new ArrayList<HashMap>();
                    while(valido){
                        HashMap<String, String> tupla = new HashMap<String, String>();
                         for(int i=result.getMetaData().getColumnCount(); i>0 ; i--){
                             String valorCampo = result.getString(i);
                             String nombreCampo = result.getMetaData().getColumnName(i);
                             tupla.put(nombreCampo,valorCampo);
                         }
                        listado.add(tupla);
                        valido = result.next();
                    }
             
                }
                result.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
       }
       return listado;
    }
    
   
    
    
    public boolean Logearse(String nom, String pass){
        boolean estado= false;
        String clave="";
        try{
            this.conectar();
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * from usuarios where nombre = '"+nom+"' ");
            while(result.next()){
                
                clave= result.getString("Clave");  
            }
            if(clave.equals(pass)){
                estado= true;
                
            }
            this.cerrar();
            conector.close();
            return estado;
        }catch(SQLException e){
            System.out.println("error");
            return estado;
        }
    }
    
    public boolean EliminarF(int valor){
    
          
       String valor2= String.valueOf(valor);
        try{
            this.conectar();    
            java.sql.Statement conector= conexion.createStatement();     
            conector.executeUpdate("delete from formulario where Dtecnum1='"+valor2+"'");
            conector.executeUpdate("delete from tabladatos where Dtecnum1='"+valor+"'");
            this.cerrar();
            conector.close();
            return true;
        }catch(SQLException e){
            System.out.println("error");
            return false;
        } 
    }
    
    public boolean buscarForlumario3(String numero){
       int i=0;
       boolean estado= false;
        try{
            this.conectar();
            java.sql.Statement conector=conexion.createStatement();
            ResultSet result =conector.executeQuery("select * from formulario where Dtecnum1='"+numero+"'");
            while(result.next()){
            i++;   
            }
            if(i>0){
            estado=true;
            }           
            this.cerrar();
            conector.close();
            return estado;
        }catch(SQLException e){
            System.out.println("error");
            return estado;
        }
    }
    
    
    
     
     public DefaultTableModel CargarTablaDatosPrimaria(int numeroformulario){
        DefaultTableModel ingreso;
        String[] nombreTabla= {"Descripcion En detalle del Requerimiento","Producto/Servicio","Cantidad","Precio Estimado Unitario Neto","Valor Estimado Total por Item Neto","Valor total Pesos"};
        String[] resultado= new String[6];
        ingreso = new DefaultTableModel(null, nombreTabla);
        try{
            this.conectar();    
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * from tabladatos where Dtecnum1='"+numeroformulario+"'");
            while(result.next()){                
                resultado[0]= result.getString("HoraRecep1");
                resultado[1]= result.getString("Recibe");  
                resultado[2]= result.getString("Dtecnum1");
                resultado[3]= result.getString("Fecha1");
                resultado[4]= result.getString("Deptoyounidad1");
                resultado[5]= result.getString("Solicitante1");
                resultado[6]= result.getString("Cargo1");
                resultado[7]= result.getString("Recibe");  
                resultado[8]= result.getString("PeriUso1");
                resultado[9]= result.getString("SeisDias1");
                resultado[10]= result.getString("DiezDias1");
                resultado[11]= result.getString("VeinteDias1");
                resultado[12]= result.getString("Producto1");
                resultado[13]= result.getString("TrabajoSer1");  
                resultado[14]= result.getString("AsesoConsul1");
                resultado[15]= result.getString("TCEstrategica1");
                resultado[16]= result.getString("TCRutinaria1");
                resultado[17]= result.getString("StockBodeSi1");
                resultado[18]= result.getString("StockBodeNo1");
                resultado[19]= result.getString("DescipgeneDelProSer1");
                resultado[20]= result.getString("MotivosDelaNecesidadyDestino1");
                resultado[21]= result.getString("CondicionDeAceptacion1");
                resultado[22]= result.getString("ProcedDeBusqueda1");  
                resultado[23]= result.getString("RecomendaProve1");
                resultado[24]= result.getString("MotivoDeRecom1");
                resultado[25]= result.getString("MecaDeEvalua1");
                resultado[26]= result.getString("AsigPptariasubt1");
                resultado[27]= result.getString("ItemAsignac1");
                resultado[28]= result.getString("Saldo1");
                resultado[29]= result.getString("vnzas1bffinanzas1");
                resultado[30]= result.getString("vbaadquisiciones1");
                resultado[31]= result.getString("ValEst1");  
                
                ingreso.addRow(resultado);
                
                
        }
            this.cerrar();
            conector.close();
            return ingreso;
        }catch(SQLException e){
            System.out.println("error");
            return ingreso;
        }
    }
    
    
    
    
     public DefaultTableModel CargarTablaDatos1(int numeroformulario){
        DefaultTableModel ingreso;
        String[] nombreTabla= {"Descripcion En detalle del Requerimiento","Producto/Servicio","Cantidad","Valor moneda","Precio Estimado Unitario Neto", "Valor Estimado pesos unitario Item Neto", "impuesto","Valor total Pesos"};
        String[] resultado= new String[8];
        ingreso = new DefaultTableModel(null, nombreTabla);
        try{
            this.conectar();    
            java.sql.Statement conector= conexion.createStatement();
            ResultSet result = conector.executeQuery("select * from tabladatos where Dtecnum1='"+numeroformulario+"'");
            while(result.next()){                
               
                resultado[0]= result.getString("DESCRIP");
                resultado[1]= result.getString("PRODSER");   
                resultado[2]= result.getString("CANTIDAD"); 
                resultado[3]= result.getString("VALORMONEDA1"); 
                resultado[4]= result.getString("VALORESTIM");                
                resultado[5]= result.getString("TPESOS"); 
                resultado[6]= result.getString("CALCULOIMPUESTO1");
                resultado[7]= result.getString("TotalTotal1");
                ingreso.addRow(resultado);
        }
            this.cerrar();
            conector.close();
            return ingreso;
        }catch(SQLException e){
            System.out.println("error al buscar productos ");
            return ingreso;
        }
    }

 
  
  
}
