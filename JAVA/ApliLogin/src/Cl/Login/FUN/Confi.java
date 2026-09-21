/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Login.FUN;

/**
 *
 * @author march
 */
public interface Confi {
        //Configuracion Nuevo Update
    static String repositorio = "https://github.com/marcheloBM/RepararPC";
    static String versionActual = "1.0";
    
    //Configuracion de BD localhot
    //Para mySQL
    String DriverBD="com.mysql.cj.jdbc.Driver";
    //Para Oracle
//    String DriverBD="oracle.jdbc.OracleDriver";
    String ip="localhost";
    String puerto="3306";
    String BaseDatos="login";
    String userBD="root";
    String passBD="";
    
    
    //Configuracion de Log
    String nameLog="LogGeneral.log";
    // Ubicacion del los Archivos
    static String urlDirec="Login";
    
    //Configuracion de Directorio
    static String carpeta = "Login";
    static String SO = System.getProperty("os.name");
    static String userDir = System.getProperty("user.home");
//    static String userDir = "D:\\";
        
    
    //Administrador
    String loginUsep="admin";
    String loginPasp="admin123";
    //Tecnico
//    String loginUsep="tecnico1";
//    String loginPasp="tec456";
    //Administrador
//    String loginUsep="cliente1";
//    String loginPasp="cli789";
    
}
