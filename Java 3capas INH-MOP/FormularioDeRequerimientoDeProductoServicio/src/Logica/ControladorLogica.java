package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walter Muñoz 
 */
public class ControladorLogica {
    
    
    private ControladorPersistencia cp;
   

    public ControladorLogica() {
        cp= new ControladorPersistencia();
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
         )
    {
        
     boolean resultado= cp.PruebaDeIngreso1(FechaRecp1,HoraRecep1,Recibe1,Dtecnum1,Fecha,Deptoyounidad1,Solicitante1,Cargo1, PeriUso1,Plazo,Clase,TipoC,StockBode,DescipGeneDelProSer1,MotivosDelaNecesidadyDestino1,ProcedDeBusqueda1,RecomendaProve1,MotivoDeRecom1,Anexo,AsigPptariaSubt1,ItemAsignac1,Saldo1,vbffinanzas,vbaadquisiciones,ValEst1,ValorTPesos,Impuesto);
        return resultado;
}


public boolean Modificar1(
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
         )
{       
     boolean resultado= cp.Modificar(FechaRecp1,HoraRecep1,Recibe1,Dtecnum1,Fecha,Deptoyounidad1,Solicitante1,Cargo1, PeriUso1,Plazo,Clase,TipoC,StockBode,DescipGeneDelProSer1,MotivosDelaNecesidadyDestino1,ProcedDeBusqueda1,RecomendaProve1,MotivoDeRecom1,Anexo,AsigPptariaSubt1,ItemAsignac1,Saldo1,vbffinanzas,vbaadquisiciones,ValEst1,ValorTPesos,Impuesto);
        
        return true;
}

 public boolean Logearse2(String nom, String pass){      
      boolean Valor= cp.Logearse1(nom,pass);
      return Valor;
 }
 
 public boolean IngresarUsuario(String NuevoNombre,String Contraseña){
     return cp.IngresarUsuario2(NuevoNombre,Contraseña);
 }
 
 public int BuscarNumeroCorrelativo(){    
  return cp.BuscarNumeroCorrelativo1();
 
 }

 public HashMap BuscarFormulario(int numeroformulario){
  HashMap datos= cp.BuscarFormulario1(numeroformulario);
  return datos;
 }

 public boolean BuscarFormulario1(String numero){ 
    return cp.BuscarFormulario2(numero);
 }
 
 public boolean AgregarListaDeDatos(HashMap myMap, String dnumber){
    return cp.AgregarListaDeDatos(myMap, dnumber);
 }
 
 public boolean EliminarFormulario(int valor){
 return cp.EliminarF(valor);
 }
 
 public DefaultTableModel cargarTablaDatoslo(int numeroformulario){    
     DefaultTableModel tabla= new DefaultTableModel();
     tabla = cp.cargarTablaDatos(numeroformulario);
     return tabla;
}

public ControladorPersistencia getCp() {
        return cp;
}

}
