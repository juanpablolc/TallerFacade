package tallerfacade;

public class AdministradorAdapter extends Usuario {

  private Administrador administrador;

  public AdministradorAdapter() {
    this.administrador = new Administrador();
  }

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
