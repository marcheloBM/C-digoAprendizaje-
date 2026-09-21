/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplilogin;

import Cl.Login.DAO.DAOUsuario;
import Cl.Login.ENT.ClUsuario;
import Cl.Login.FUN.*;
import Cl.Login.GUI.FrLogin;
import Cl.Login.LOG.Log;

/**
 *
 * @author march
 */
public class ApliLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Aplicacion Login");
        Directorio.crearDirecPre();
//        Log.log("Hola Mundo!!");
//        ClUsuario usuario = new ClUsuario("admin", "admin123");
//        DAOUsuario dAOUsuario = new DAOUsuario();
//        boolean resp = dAOUsuario.sqlSelectValidar(usuario);
//        System.out.println(""+resp);
        FrLogin frLogin = new FrLogin();
        frLogin.setVisible(true);
    }
    
}
