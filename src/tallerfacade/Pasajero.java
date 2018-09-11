package tallerfacade;

public class Pasajero extends Usuario {

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
