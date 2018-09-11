package tallerfacade;

public abstract class Usuario {

  private String correo;
  private String nombre;
  private String contraseña;

  /*
  public Usuario (String correo, String nombre, String contraseña) {
    this.correo = correo;
    this.nombre = nombre;
    this.contraseña = contraseña;
  }
   */
  public void adicionar(String correo, String nombre, String contraseña) {
    this.setCorreo(correo);
    this.setNombre(nombre);
    this.setContraseña(contraseña);
  }
  
  public void modificar(String correo, String nombre, String contraseña) {
    this.correo = correo;
    this.nombre = nombre;
    this.contraseña = contraseña;
  }

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
