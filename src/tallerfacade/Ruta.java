package tallerfacade;

import java.util.ArrayList;

public class Ruta implements Componente {
  private String nombre;
  private ArrayList<Componente> componentes;
  
  public Ruta() {
    this.setNombre("");
    this.setComponentes(new ArrayList());
  }
  
  public Ruta(String nombre) {
    this.setNombre(nombre);
    this.setComponentes(new ArrayList());
  }
  
  @Override
  public String obtenerInformacion() {
    String informacion = "INFORMACIÓN " + this.nombre + "\n\n";
    
    for (Componente componente: componentes) {
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

  public ArrayList<Componente> getComponentes() {
    return componentes;
  }

  public void setComponentes(ArrayList<Componente> componentes) {
    this.componentes = componentes;
  }
  
}
