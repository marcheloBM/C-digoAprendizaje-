/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Cl.Login.Control;

import Cl.Login.DAO.DAOUsuario;
import Cl.Login.ENT.ClUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author march
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //obtengo el submit
        String submit = request.getParameter("submit");
        submit = (submit == null) ? "" : submit;
        
        Map<String, String> data = new HashMap<>();
        //pregunto que tipo de submit es
        switch (submit) {
            case "Ingresar":
                System.out.println("Servlet_Login:Switch.LoginIngresar");
                data = LoginIngresar(request, response);
                break;
            case "AGREGAR":
                System.out.println("Servlet_Login:Switch.LoginAgregar");
                data = LoginAgregar(request, response);
                break;
            case "ACTUALIZAR":
                System.out.println("Servlet_Login:Switch.LoginActualizar");
                data = LoginActualizar(request, response);
                break;
            case "ELIMINAR":
                System.out.println("Servlet_Login:Switch.LoginEliminar");
                data = LoginEliminar(request, response);
                break;
            default:
                
                response.sendRedirect("Login.jsp");
                return;
        }
        //cargo datos
        request.setAttribute("status", data.get("status"));
        request.setAttribute("message", data.get("message"));
        //devuelvo
        request.getRequestDispatcher(data.get("url")).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Map<String, String> LoginIngresar(HttpServletRequest request, HttpServletResponse response) {
        //inicializo sesion
        HttpSession session = request.getSession();
        Map<String, String> options = new LinkedHashMap<>();
        //declaro estado y mensaje
        String status, message;
        status = "";
        message = "";
        try {
            //cargar datos en la clase
            ClUsuario clUsuario = rescataParamLogin(request,response);
            //Crear DAO
            if(DAOUsuario.sqlSelectValidar(clUsuario)){
                status = "ok";
                message = "Sesion iniciada";
                session.setAttribute("usuario", clUsuario.getUsuario());
                session.setAttribute("session_objetLogin", clUsuario);
                options.put("status", status);
                options.put("message", message);
                
                if(clUsuario.getRol().equals("Administrador")){
                    options.put("url", "/HomeAdministrador.jsp");
                } 
                if(clUsuario.getRol().equals("Tecnico")){
                    options.put("url", "HomeTecnico.jsp");
                }
                if(clUsuario.getRol().equals("Cliente")){
                    options.put("url", "HomeCliente.jsp");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
//            Log.log(ex.getMessage());
//            log.warn(ex.getMessage());
            status = "error";
            message = "Nombre y/o Contrasena incorrecta.";
            options.put("status", status);
            options.put("message", message);
            options.put("url", "/Login.jsp");
        }
        //cargo los datos a option y lo retorno
//        options.put("status", status);
//        options.put("message", message);
        
        return options;
        
    }
    
    private ClUsuario rescataParamLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        ClUsuario clUsuario= new ClUsuario(usuario, password);
        return clUsuario;
    }
    
    private Map<String, String> LoginAgregar(HttpServletRequest request, HttpServletResponse response) {
        //inicializo sesion
        HttpSession session = request.getSession();
        Map<String, String> options = new LinkedHashMap<>();
        try {
            //declaro estado y mensaje
            String status, message;
            
            //cargar datos en la clase
            ClUsuario clUsuario = rescataParamInLogin(request,response);
            System.out.println(""+clUsuario.toString());
            //Crear DAO
            DAOUsuario dAOUsuario = new DAOUsuario();
            if(!dAOUsuario.sqlInsert(clUsuario)){
                options.put("message", "[ERROR] No se pudo registrar el login.");
            }else{
                options.put("message", "[OK] Login registrado exitosamente.");
            }
            
        } //nose que es esto
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            options.put("message", e.getMessage());
        }
        options.put("url", "/HomeAdministrador.jsp");
        return options;
         
    }
    
    private ClUsuario rescataParamInLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String usuario = request.getParameter("txtUsuario");
        String nombre = request.getParameter("txtNombre");
        String password = request.getParameter("txtPassword");
        String celular = request.getParameter("txtCelular");
        String rol = request.getParameter("txtRol");
        ClUsuario clUsuario= new ClUsuario(usuario, nombre, password, celular, rol);
        return clUsuario;
    }
    
    private Map<String, String> LoginActualizar(HttpServletRequest request, HttpServletResponse response) {
        //inicializo sesion
        HttpSession session = request.getSession();
        Map<String, String> options = new LinkedHashMap<>();
        try {
            //declaro estado y mensaje
            String status, message;
            
            //cargar datos en la clase
            ClUsuario clUsuario = rescataParamAcLogin(request,response);
            System.out.println(""+clUsuario.toString());
            //Crear DAO
            DAOUsuario dAOUsuario = new DAOUsuario();
            if(!dAOUsuario.sqlUpdate(clUsuario)){
                options.put("message", "[ERROR] No se pudo actualizar el login.");
            }else{
                options.put("message", "[OK] Login actualizado exitosamente.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            options.put("message", e.getMessage());
        }
        options.put("url", "/HomeAdministrador.jsp");
        return options;
    }
    
    private ClUsuario rescataParamAcLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int stId=Integer.parseInt(request.getParameter("txtIdUsuario"));
        String stUsuario=request.getParameter("txtUsuario");
        String stNombre=request.getParameter("txtNombre");
        String stPass=request.getParameter("txtPass");
        String stCelular=request.getParameter("txtCelular");
        String stRol=request.getParameter("txtRol");
        String stPassworld=request.getParameter("txtPass");
        ClUsuario clUsuario= new ClUsuario(stId, stUsuario, stNombre, stPass, stCelular, stRol);
        return clUsuario;
    }
    
    private Map<String, String> LoginEliminar(HttpServletRequest request, HttpServletResponse response) {
        //inicializo sesion
        HttpSession session = request.getSession();
        Map<String, String> options = new LinkedHashMap<>();
        try {
            //declaro estado y mensaje
            String status, message;
            //cargar datos en la clase
            ClUsuario clUsuario = rescataParamElLogin(request,response);
            //Crear DAO
            DAOUsuario dAOUsuario = new DAOUsuario();
                if(!dAOUsuario.sqlDelete(clUsuario)){
                    options.put("message", "[ERROR] No se pudo eliminar el Login.");
                }else{
//                    options.put("url", "/Login.jsp");
                    options.put("message", "[OK] Login Eliminado exitosamente.");
//                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            options.put("message", ex.getMessage());
        }
        options.put("url", "/HomeAdministrador.jsp");
        return options;
    }
    
    private ClUsuario rescataParamElLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int stId=Integer.parseInt(request.getParameter("txtId"));
        ClUsuario clUsuario= new ClUsuario(stId);
        return clUsuario;
    }
}
