<%-- 
    Document   : HomeAdministrador
    Created on : 28 jun 2026, 2:08:51
    Author     : march
--%>

<%@page import="java.util.List"%>
<%@page import="Cl.Login.ENT.ClUsuario"%>
<%@page import="Cl.Login.DAO.DAOUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenedor</title>
    </head>
    <body>
        <h1>Home Administrador</h1>
        <%
            String usuario = (String) session.getAttribute("usuario");
            // consulta a BD para traer solo ese usuario
        %>
        <h2>Bienvenido <%= usuario %></h2>
        <!-- mostrar nombre, celular, rol -->
                
        <form method="post" action="ServletLogin">
            <fieldset>
                <div id="edit_farmer" style="display:none"></div>
                <div class="row">
                    <div class="col-md-2 panel panel-heading">Informacion Login</div>
                    <div class="col-md-4 panel panel-heading" style="display:none; color:red" id="contact_error"></div>
                </div>
                <div>
                    <label for="txtId">ID</label>
                            <input id="txt_id" name="txtId" type="number">
                    <label for="txtUsuario">Usuario</label>
                            <input id="txt_Usuario" name="txtUsuario" type="text">
                </div>
                <div>
                    <label for="txtNombre">Nombre</label>
                            <input id="txtnombre" name="txtNombre" type="text">
                    <label for="txtPassword">Password</label>
                            <input id="txtpassword" name="txtPassword" type="text">
                </div>
                <div class="row form-group">
                    <label for="txtCelular">Celular</label>
                            <input id="txt_celular" name="txtCelular" type="text">
                    <label for="txtRol"  >Rol</label>
                            <select id="txtRol" name="txtRol">
                                <option value="" selected disabled>Seleccione un rol</option>
                                <option value="Administrador">Administrador</option>
                                <option value="Tecnico">Tecnico</option>
                                <option value="Cliente">Cliente</option>
                              </select>
                </div>              
                
                <div>
                    <div>
                        <button id="agregar_Login" value="AGREGAR" type="submit" name="submit"> Agregar</button>
                        <button id="eliminar_Login" value="ELIMINAR" type="submit" name="submit"> Eliminar</button>
                        <button type="button" onclick=history.go(-1)> Cancelar </button>
                    </div>
                </div>
                            
            </fieldset>
        </form>
        
        <div>
            <table>
        <tr align="center">
                     <td><strong>Rut</strong></td>
                     <td><strong>Nombre</strong></td>
                     <td><strong>Apellido</strong></td>
                     <td><strong>Correo</strong></td>
                     <td><strong>Celular</strong></td>
                     <td><strong>Passworld</strong></td>
                     <td><strong>Tipo Usuario</strong></td>
                 </tr>
                 <%
                     DAOUsuario dAOUsuario = new DAOUsuario();
                     //long registro = dAOUsuario.leerCuantos("");
                     //int reg = (int)registro;
                     List<ClUsuario> list = dAOUsuario.leerUsuario();
                     for (ClUsuario elem : list) {
                         String id_usuario =String.valueOf(elem.getId());
                         String usuario_login =elem.getUsuario();
                         String nombre_login=elem.getNombre();
                         String pass_login=elem.getPass();
                         String celular_login=elem.getCelular();
                         String rol_login=elem.getRol();
                 %>
                 <form action="ServletLogin" method="post">
                     <tr align='center'>
                         <td><%=id_usuario%></td>
                         <td><input name="txtUsuario" type="text" id="txtUsuario" <%=usuario_login%> value="<%=usuario_login%>" /></td>
                         <td><input name="txtNombre" type="text" id="txtNombre" <%=nombre_login%> value="<%=nombre_login%>" /></td>
                         <td><input name="txtPass" type="text" id="txtPass" <%=pass_login%> value="<%=pass_login%>" /></td>
                         <td><input name="txtCelular" type="text" id="txtCelular" <%=celular_login%> value="<%=celular_login%>" /></td>
                         <td><input name="txtRol" type="text" id="txtRol" <%=rol_login%> value="<%=rol_login%>" /></td>
                    <td>
                        <input name="txtIdUsuario" type="hidden" id="txtIdUsuario" value="<%=id_usuario%>"/>
                        <input name="txtUsuario" type="hidden" id="txtUsuario" value="<%=usuario_login%>"/>
                        <input name="txtNombre" type="hidden" id="txtNombre" value="<%=nombre_login%>"/>
                        <input name="txtPass" type="hidden" id="txtPass" value="<%=pass_login%>"/>
                        <input name="txtCelular" type="hidden" id="txtCelular" value="<%=celular_login%>"/>
                        <input name="txtRol" type="hidden" id="txtRol" value="<%=rol_login%>"/>
                        <input class="btn btn-warning" type="submit" name="submit" value="ACTUALIZAR"> </td>
                     </tr>
                 </form>
                    <% }%>
            </table>
        </div>
        <!-- Mensaje de Error -->
        <c:if test="${not empty message}">
            <script>
                alert("${message}");
            </script>
        </c:if>
    </body>
</html>
