package tallerfacade;

public class AdministradorAdapter extends Usuario {

  private Administrador administrador;

  public AdministradorAdapter() {
    super();
    this.administrador = new Administrador();
  }

  @Override
  public String consultar() {
    this.administrador.listar();

    String mensaje = "";
    boolean hayAdministradores = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof AdministradorAdapter) {
        hayAdministradores = true;
        mensaje += "NOMBRE: " + usuario.getNombre() + " - CORREO: " + usuario.getCorreo() + "\n";
      }
    }

    if (!hayAdministradores) {
      mensaje = "No hay ningún administrador registrado.";
    } else {
      mensaje = "Administradores registrados: \n\n" + mensaje;
    }

    return mensaje;
  }

  @Override
  public String eliminar(String correo) {
    this.administrador.quitar();

    boolean encontrado = false;

    for (int i = 0; i < this.getUsuarios().size(); i++) {
      if (this.getUsuarios().get(i) instanceof AdministradorAdapter
              && this.getUsuarios().get(i).getCorreo().equals(correo)) {
        encontrado = true;
        this.getUsuarios().remove(i);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún administrador con ese correo.";
    } else {
      return "Administrador eliminado exitósamente.";
    }
  }

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
