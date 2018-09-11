package tallerfacade;

public class Conductor extends Usuario {

  @Override
  public String toString() {
    return this.getNombre() + " - " + this.getCorreo();
  }
}
