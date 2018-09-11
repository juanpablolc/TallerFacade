package tallerfacade;

import java.util.ArrayList;

public class Ruta implements Componente {

  private String nombre;
  private Usuario conductor;
  private ArrayList<Componente> componentes;

  public Ruta() {
    this.setNombre("");
    this.setConductor(null);
    this.setComponentes(new ArrayList());
  }

  public Ruta(String nombre, Usuario conductor) {
    this.setNombre(nombre);
    this.setConductor(conductor);
    this.setComponentes(new ArrayList());
  }

  @Override
  public String obtenerInformacion() {
    String informacion = "RUTA: " + this.nombre + "\nCALLES: \n";

    for (Componente componente : componentes) {
      informacion += componente.obtenerInformacion();
    }

    return informacion;
  }

  public void add(Componente componente) {
    this.componentes.add(componente);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public Usuario getConductor() {
    return this.conductor;
  }
  
  public void setConductor(Usuario conductor) {
    this.conductor = conductor;
  }

  public ArrayList<Componente> getComponentes() {
    return componentes;
  }

  public void setComponentes(ArrayList<Componente> componentes) {
    this.componentes = componentes;
  }

}
