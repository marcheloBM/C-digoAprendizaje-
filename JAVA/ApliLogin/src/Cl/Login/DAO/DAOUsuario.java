/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cl.Login.DAO;

import Cl.Login.BD.BD;
import Cl.Login.ENT.ClUsuario;
import Cl.Login.LOG.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author march
 */
public class DAOUsuario {
    //Validar usuario
    public boolean sqlSelectValidar(ClUsuario usuario) {
        String stSql =  "SELECT `id`, `usuario`, `nombre`, `password`, `celular`, `rol` FROM `usuarios` WHERE `usuario`=";
            stSql += "'" + usuario.getUsuario()+ "'  AND `password`=";
            stSql += "'" + usuario.getPass()+ "';";
        try {
            ResultSet rs = BD.getInstance().sqlSelect(stSql);
            if(rs==null || !rs.next())return false;
            usuario.setId(rs.getInt("id")) ;
            usuario.setUsuario(rs.getString("usuario")) ;
            usuario.setNombre(rs.getString("nombre")) ;
            usuario.setPass(rs.getString("password")) ;
            usuario.setCelular(rs.getString("celular")) ;
            usuario.setRol(rs.getString("rol")) ;
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }
    //Listar Usuario
    public static List<ClUsuario> leerUsuario() {
        List<ClUsuario> lista=new ArrayList<>();
        String strConsulta;
      
        strConsulta="SELECT `id`, `usuario`, `nombre`, `password`, `celular`, `rol` FROM `usuarios`;";
        try{
         ResultSet rs=BD.getInstance().sqlSelect(strConsulta);
         if(rs==null)return null;
         while(rs.next()){
              ClUsuario l = new ClUsuario(rs.getInt("id"), rs.getString("usuario"), 
                      rs.getString("nombre"), rs.getString("password"), 
                      rs.getString("celular"), rs.getString("rol"));
              lista.add(l);
         }
         
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return lista;
    }
    //Seleccionar ID
    public static List<ClUsuario> leerUsuario(ClUsuario clUsuario) {
        List<ClUsuario> lista=new ArrayList<>();
        String strConsulta;
        
        strConsulta="SELECT `id`, `usuario`, `nombre`, `password`, `celular`, `rol` FROM `usuarios` where id="+clUsuario.getId();
        
        try{
         ResultSet rs=BD.getInstance().sqlSelect(strConsulta);
         if(rs==null)return null;
         while(rs.next()){
             ClUsuario c = new ClUsuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("nombre"), 
                     rs.getString("password"), rs.getString("celular"),rs.getString("rol"));
              lista.add(c);
         }
         
        } catch (SQLException ex) {
//            Logger.getLogger(DAOPc.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOPc.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return lista;
    }
    //Insertar
    public static boolean sqlInsert(ClUsuario usuario) {
        try {
            String stSql  = "insert into usuarios(usuario, nombre, password, celular, rol) values (";
            stSql += "'" + usuario.getUsuario()+ "'";
            stSql += ",'" + usuario.getNombre()+ "'";
            stSql += ",'" + usuario.getPass()+ "'";
            stSql += ",'" + usuario.getCelular()+ "'";
            stSql += ",'" + usuario.getRol()+ "'";
            stSql += " )";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
//            log.info(ex.getMessage());
            return false;
        }
    }
    //Buscar
    public static List<ClUsuario> buscarUsuario(ClUsuario usuario) {
        List<ClUsuario> lista=new ArrayList<>();
        String strConsulta;
      
         strConsulta="SELECT `id`, `usuario`, `nombre`, `password`, `celular`, `rol` FROM `usuarios` where nombre='"+usuario.getNombre()+"'";
        try{
         ResultSet rs=BD.getInstance().sqlSelect(strConsulta);
         if(rs==null)return null;
         while(rs.next()){
              ClUsuario l = new ClUsuario(rs.getInt("id"), rs.getString("usuario"), rs.getString("nombre"), 
                     rs.getString("password"), rs.getString("celular"),rs.getString("rol"));
              lista.add(l);
         }
         
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return lista;
    }
    //Actualizar
    public static boolean sqlUpdate(ClUsuario usuario){		
        try {
            String stSql =  "update usuarios set ";
            stSql += "usuario='" + usuario.getUsuario()+ "'";
            stSql += ",nombre='" + usuario.getNombre()+ "'";
            stSql += ",password='" + usuario.getPass()+ "'";
            stSql += ",celular='" + usuario.getCelular()+ "'";
            stSql += ",rol='" + usuario.getRol()+ "'";
            stSql += " WHERE ";
            stSql += "id='"+usuario.getId()+"'";
            stSql += ";";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
//            log.info(ex.getMessage());
        }
        return false;
    }
    //Eliminar
    public static boolean sqlDelete(ClUsuario usuario){		
        try {
            String stSql =  "delete from usuarios where id=";
            stSql += " '" + usuario.getId()+ "'";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }
}
