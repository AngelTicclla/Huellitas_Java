/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Dao;

import Capa_Modelo.Cliente;
import java.sql.Connection;
import Capa_Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class Cliente_Dao implements ValidarAcceso {

    Connection conn;
    Conexion conect = new Conexion();
    PreparedStatement pst;
    ResultSet rs;
  

    @Override
    public int validar(Cliente client) {
          int r=0;
        String sql = "select * from TB_CLIENTE where  email_cliente=? and  contraseña_cliente=?";

        try {
            conn = conect.abrirConexion();
            pst = conn.prepareStatement(sql);
            pst.setString(1, client.getEmail());
            pst.setString(2, client.getContraseña());
            rs = pst.executeQuery();
            while (rs.next()) {
                r=r+1;
                client.setEmail(rs.getString("email_cliente"));
                client.setContraseña(rs.getString("contraseña_cliente"));

            }
            if (r==1) {
                return 1;
                
            }
            else {
            return 0;}

        } catch (Exception e) {
            return 0;
        }

    }

}
