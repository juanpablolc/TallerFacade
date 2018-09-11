package tallerfacade;

import java.util.ArrayList;

public abstract class Usuario {

  private String nombre;
  private String correo;
  private String contraseña;

  public void adicionar(String nombre, String correo, String contraseña) {
    this.setNombre(nombre);
    this.setCorreo(correo);
    this.setContraseña(contraseña);
  }

  public void modificar(String correo, String nombre, String contraseña) {
    this.setNombre(nombre);
    this.setCorreo(correo);
    this.setContraseña(contraseña);
  }

  abstract public String consultar();

  abstract public String eliminar(String correo);
  
  protected String getNombre() {
    return nombre;
  }

  protected void setNombre(String nombre) {
    this.nombre = nombre;
  }

  protected String getCorreo() {
    return correo;
  }

  protected void setCorreo(String correo) {
    this.correo = correo;
  }

  protected String getContraseña() {
    return contraseña;
  }

  protected void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }
}
