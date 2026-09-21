/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cl.Login.ENT;

/**
 *
 * @author march
 */
public class ClUsuario {
    private int id;
    private String usuario;
    private String nombre;
    private String pass;
    private String celular;
    private String rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    //Validar Usuario
    public ClUsuario(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }
    
    //Seleccionar & Actualizar
    public ClUsuario(int id, String usuario, String nombre, String pass, String celular, String rol) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.pass = pass;
        this.celular = celular;
        this.rol = rol;
    }

    //Seleccionar ID & Eliminar
    public ClUsuario(int id) {
        this.id = id;
    }

    //Insertar
    public ClUsuario(String usuario, String nombre, String pass, String celular, String rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.pass = pass;
        this.celular = celular;
        this.rol = rol;
    }

    //Buscar
    public ClUsuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ClUsuario{" + "id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", pass=" + pass + ", celular=" + celular + ", rol=" + rol + '}';
    }
        
    
}
