package tallerfacade;

public class Conductor extends Usuario {

  public Conductor() {
    super();
  }

  @Override
  public String consultar() {
    String mensaje = "";
    boolean hayConductores = false;

    for (Usuario usuario : this.getUsuarios()) {
      if (usuario instanceof Conductor) {
        hayConductores = true;
        mensaje += "NOMBRE: " + usuario.getNombre() + " - CORREO: " + usuario.getCorreo() + "\n";
      }
    }

    if (!hayConductores) {
      mensaje = "No hay ningún conductor registrado.";
    } else {
      mensaje = "Conductores registrados: \n\n" + mensaje;
    }

    return mensaje;
  }

  @Override
  public String eliminar(String correo) {
    boolean encontrado = false;

    for (int i = 0; i < this.getUsuarios().size(); i++) {
      if (this.getUsuarios().get(i) instanceof Conductor
              && this.getUsuarios().get(i).getCorreo().equals(correo)) {
        encontrado = true;
        this.getUsuarios().remove(i);
      }
    }

    if (!encontrado) {
      return "No se encontró ningún conductor con ese correo.";
    } else {
      return "Conductor eliminado exitósamente.";
    }
  }

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
