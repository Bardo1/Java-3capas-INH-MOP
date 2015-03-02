/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter Muñoz
 */
public class ControladorPersistencia extends ConexionSql{

    
    
    public boolean probarConexion() {
        System.out.println("paso 1");
        ConexionSql cs=  new ConexionSql();
        
        boolean b=cs.conectar();
        return b;
    }
    
    
    
  
    public HashMap BuscarFormulario1(int Numero){
        HashMap datosCuenta = null;
        ArrayList<HashMap> datos;
       ConexionSql cs=  new ConexionSql();
        
        String consulta = "SELECT * FROM formulario WHERE Dtecnum1 ='"+Numero+"'";
        cs.conectar();
        datos = cs.ejecutarConRetorno(consulta);
        cs.cerrar();
        
        if(datos.size() > 0){
            datosCuenta = datos.get(0);
        }
        return datosCuenta;
    }
    
       public boolean BuscarFormulario2(String numero){
         ConexionSql cs=  new ConexionSql();
       
        return cs.buscarForlumario3(numero);
    }
    
    
public boolean PruebaDeIngreso1(
         String FechaRecp1,
         String HoraRecep1,
         boolean Recibe1,
         String Dtecnum1,
         String Fecha,
         String Deptoyounidad1,
         String Solicitante1,
         String Cargo1,
         String PeriUso1,
         String Plazo,
         String Clase,
         String TipoC,
         String StockBode,
         String DescipGeneDelProSer1,
         String MotivosDelaNecesidadyDestino1,
         String ProcedDeBusqueda1,
         String RecomendaProve1,
         String MotivoDeRecom1,
         String Anexo,
         String AsigPptariaSubt1,
         String ItemAsignac1,
         int Saldo1,
         boolean vbffinanzas, 
         boolean vbaadquisiciones,
         double ValEst1,
         double ValorTPesos,
         double Impuesto
         ){
        ConexionSql cs=  new ConexionSql();
        
         int Recibe2;
         int vbffinanzas2; 
         int vbaadquisiciones2;
         if(vbffinanzas){vbffinanzas2=1;}else{vbffinanzas2=0;}
         if(vbaadquisiciones){vbaadquisiciones2=1;}else{vbaadquisiciones2=0;}
         if(Recibe1){Recibe2=1;}else{Recibe2=0;}
         String query ="INSERT formulario VALUES('"+FechaRecp1+"','"+HoraRecep1+"','"+Recibe2+"','"+ Dtecnum1+"','"+Fecha+"','"+Deptoyounidad1+"','"+Solicitante1+"','"+Cargo1+"','"+PeriUso1+"','"+Plazo+"','"+Clase+"','"+TipoC+"','"+StockBode+"','"+DescipGeneDelProSer1+"','"+MotivosDelaNecesidadyDestino1+"','"+ProcedDeBusqueda1+"','"+RecomendaProve1+"','"+MotivoDeRecom1+"','"+Anexo+"','"+AsigPptariaSubt1+"','"+ItemAsignac1+"','"+Saldo1+"','"+vbffinanzas2+"','"+vbaadquisiciones2+"','"+ValEst1+"','"+ValorTPesos+"','"+Impuesto+"')";
         cs.conectar();
         System.out.println(FechaRecp1);
         cs.ejecutarSinRetorno(query);
         cs.cerrar();
         return true;

}

public boolean Modificar(
         String FechaRecp1,
         String HoraRecep1,
         boolean Recibe1,
         String Dtecnum1,
         String Fecha,
         String Deptoyounidad1,
         String Solicitante1,
         String Cargo1,
         String PeriUso1,
         String Plazo,
         String Clase,
         String TipoC,
         String StockBode,
         String DescipGeneDelProSer1,
         String MotivosDelaNecesidadyDestino1,
         String ProcedDeBusqueda1,
         String RecomendaProve1,
         String MotivoDeRecom1,
         String Anexo,
         String AsigPptariaSubt1,
         String ItemAsignac1,
         int Saldo1,
         boolean vbffinanzas, 
         boolean vbaadquisiciones,
         double ValEst1,
         double ValorTPesos,
         double Impuesto
         ){
         ConexionSql cs=  new ConexionSql();       
        // Conexion c = new Conexion();
       
         int Recibe2;
         int vbffinanzas2; 
         int vbaadquisiciones2;
         if(vbffinanzas){vbffinanzas2=1;}else{vbffinanzas2=0;}
         if(vbaadquisiciones){vbaadquisiciones2=1;}else{vbaadquisiciones2=0;}
         if(Recibe1){Recibe2=1;}else{Recibe2=0;} //
         String query1 ="UPDATE formulario "
                      + "SET FechaRecp1='"+FechaRecp1+"',HoraRecep1='"+HoraRecep1+"',Recibe='"+Recibe2+"',Fecha='"+Fecha+"',Deptoyounidad1='"+Deptoyounidad1+"',Solicitante1='"+Solicitante1+"',Cargo1='"+Cargo1+"',PeriUso1='"+PeriUso1+"',Plazo='"+Plazo+"',Clase='"+Clase+"',TC='"+TipoC+"',StockBode='"+StockBode+"',DescipGeneDelProSer1='"+DescipGeneDelProSer1+"',MotivosDelaNecesidadyDestino1='"+MotivosDelaNecesidadyDestino1+"',ProcedDeBusqueda1='"+ProcedDeBusqueda1+"',RecomendaProve1='"+RecomendaProve1+"',MotivoDeRecom1='"+MotivoDeRecom1+"',Anexo='"+Anexo+"',AsigPptariaSubt1='"+AsigPptariaSubt1+"',ItemAsignac1='"+ItemAsignac1+"',Saldo1='"+Saldo1+"',vbffinanzas='"+vbffinanzas2+"',vbaadquisiciones='"+vbaadquisiciones2+"',ValEst1='"+ValEst1+"',ValorTPesos='"+ValorTPesos+"',Impuesto='"+Impuesto+"'"
                      + "WHERE Dtecnum1='"+Dtecnum1+"'";
         cs.conectar();
         System.out.println(FechaRecp1); 
        
         cs.modificaFormulario(query1);
         cs.cerrar();
         return true;

}


 public boolean IngresarUsuario2(String NuevoNombre,String Contraseña){
 ConexionSql cs=  new ConexionSql();    
 return cs.IngresarUsuario3(NuevoNombre,Contraseña);   
 }
 
 public int BuscarNumeroCorrelativo1(){
 ConexionSql cs=  new ConexionSql();    
 return cs.BuscarNumeroCorrelativo2();
 
 }
 public boolean AgregarListaDeDatos(HashMap myMap, String dnumber){
 ConexionSql cs=  new ConexionSql();    
 return cs.GuardarDatosLista(myMap, dnumber);
}
 
 
 
 public boolean EliminarF(int valor){
 ConexionSql cs=  new ConexionSql();    
 return cs.EliminarF(valor);
}
 
  public DefaultTableModel cargarTablaDatos(int numeroformulario){
       DefaultTableModel tabla= new DefaultTableModel();
       ConexionSql cs=  new ConexionSql();    
       tabla = cs.CargarTablaDatos1(numeroformulario);
       return tabla;
 }
 
  public ArrayList<HashMap> cargarFormulario(int numeroformulario){
        //Conexion c=new Conexion();
        ConexionSql cs=  new ConexionSql();
        String query= "select * from tabladatos where Dtecnum1='"+numeroformulario+"'";
        cs.conectar();
        ArrayList <HashMap> lstIndices=cs.ejecutarConRetorno(query);
        cs.cerrar();
        return lstIndices;
  }
 
  public boolean Logearse1(String nom, String pass){
      ConexionSql cs=  new ConexionSql();
      boolean Valor= cs.Logearse(nom,pass);
      return Valor;
      
  }
    
}

 