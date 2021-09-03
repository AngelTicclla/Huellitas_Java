/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class Conexion {
     Connection cn= null;
      public Connection abrirConexion(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
                    cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/veterinaria_huellitas?user=root&password=123456");;
        }catch (Exception e1){
            System.out.println("Error Conexion :"+e1.getMessage());
        }
        return cn;
    }
   public void cerrarConexion(){
       try{
           cn.close();
       }catch(Exception e1){
           System.out.print("Error al Cerrar Conexion :"+e1.getMessage());
       }
   }
    
}
