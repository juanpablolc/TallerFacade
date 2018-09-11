package tallerfacade;

import java.util.ArrayList;

public class Facade {

  ArrayList<Usuario> usuarios = new ArrayList<>();
  ArrayList<Ruta> rutas = new ArrayList<>();

  // Usuarios
  public String adicionarConductor(String correo, String nombre, String contraseña) {
    if (!this.estaRegistrado(correo, "conductor")) {
      Usuario usuario = new Conductor();
      usuario.adicionar(nombre, correo, contraseña);
      this.usuarios.add(usuario);
      return nombre + " ha sido registrado exitósamente como conductor.";
    } else {
      return "El correo " + correo + " ya está registrado como conductor.";
    }
  }

  public String adicionarPasajero(String correo, String nombre, String contraseña) {
    if (!this.estaRegistrado(correo, "pasajero")) {
      Usuario usuario = new Pasajero();
      usuario.adicionar(nombre, correo, contraseña);
      this.usuarios.add(usuario);
      return nombre + " ha sido registrado exitósamente como pasajero.";
    } else {
      return "El correo " + correo + " ya está registrado como pasajero.";
    }
  }

  public String adicionarAdministrador(String correo, String nombre, String contraseña) {
    if (!this.estaRegistrado(correo, "administrador")) {
      Usuario usuario = new AdministradorAdapter();
      usuario.adicionar(nombre, correo, contraseña);
      this.usuarios.add(usuario);
      return nombre + " ha sido registrado exitósamente como administrador.";
    } else {
      return "El correo " + correo + " ya está registrado como administrador.";
    }
  }

  /*
  public String[] acceder(String correo, String contraseña) {
    for (Usuario usuario : this.usuarios) {
      if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {
        String[] respuesta = new String[2];
        if (usuario instanceof Conductor) {
          respuesta[0] = "conductor";
        } else if (usuario instanceof Pasajero) {
          respuesta[0] = "pasajero";
        } else if (usuario instanceof AdministradorAdapter) {
          respuesta[0] = "administrador";
        }
        respuesta[1] = usuario.getNombre();
        return respuesta;
      }
    }

    return null;
  }
   */
 /*
  public Usuario acceder(String correo, String contraseña) {
    for (Usuario usuario : this.usuarios) {
      if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {
        return usuario;
      }
    }
    
    return null;
  }
   */
  public int acceder(String correo, String contraseña) {
    for (int i = 0; i < this.usuarios.size(); i++) {
      if (this.usuarios.get(i).getCorreo().equals(correo)
              && this.usuarios.get(i).getContraseña().equals(contraseña)) {
        return i;
      }
    }
    return -1;
  }

  public String getTipoUsuario(int id) {
    if (this.usuarios.get(id) instanceof Conductor) {
      return "conductor";
    } else if (this.usuarios.get(id) instanceof Pasajero) {
      return "pasajero";
    } else if (this.usuarios.get(id) instanceof AdministradorAdapter) {
      return "administrador";
    }
    return null;
  }

  public String getNombreUsuario(int id) {
    return this.usuarios.get(id).getNombre();
  }

  private boolean estaRegistrado(String correo, String tipoUsuario) {
    for (Usuario usuario : this.usuarios) {
      if (usuario.getCorreo().equals(correo)) {
        if ((tipoUsuario.equals("conductor") && usuario instanceof Conductor)
                || (tipoUsuario.equals("pasajero") && usuario instanceof Pasajero)
                || (tipoUsuario.equals("administrador") && usuario instanceof AdministradorAdapter)) {
          return true;
        }
      }
    }
    return false;
  }

  // Rutas
  public String registarRuta(String nombre, int idUsuario) {
    Ruta ruta = new Ruta(nombre, this.usuarios.get(idUsuario));
    this.rutas.add(ruta);
    return "La ruta ha sido registrada exitósamente.";
  }

  public int getUltimaRutaRegistrada() {
    return this.rutas.size() - 1;
  }

  public String añadirCalle(
          int idRuta,
          String nombre,
          double coordenadaXOrigen,
          double coordenadaYOrigen,
          double coordenadaXDestino,
          double coordenadaYDestino,
          double distancia,
          int tiempoRecorrido
  ) {
    this.rutas.get(idRuta).add(new Calle(
            nombre,
            coordenadaXOrigen,
            coordenadaYOrigen,
            coordenadaXDestino,
            coordenadaYDestino,
            distancia,
            tiempoRecorrido
    ));
    return "Calle " + nombre + " añadida exitósamente.";
  }

  public String listarCalles(int idRuta) {
    return this.rutas.get(idRuta).obtenerInformacion();
  }

  public boolean existenRutasConductor(int idConductor) {
    for (Ruta ruta : this.rutas) {
      if (ruta.getConductor().getCorreo().equals(this.usuarios.get(idConductor).getCorreo())) {
        return true;
      }
    }
    return false;
  }

  public String listarRutasConductor(int idConductor) {
    String rutas = "Rutas conductor " + this.usuarios.get(idConductor).getNombre() + "\n\n";
    int contadorRutas = 1;
    for (Ruta ruta : this.rutas) {
      if (ruta.getConductor().getCorreo().equals(this.usuarios.get(idConductor).getCorreo())) {
        rutas += "[" + contadorRutas + "] " + ruta.obtenerInformacion() + "\n";
        contadorRutas++;
      }
    }
    return rutas;
  }

  public String actualizarRuta(int idConductor, int numRuta, String nombre) {
    int contadorRutasConductor = 1;
    for (int i = 0; i < this.rutas.size(); i++) {
      if (this.rutas.get(i).getConductor().getCorreo().equals(this.usuarios.get(idConductor).getCorreo())) {
        if (contadorRutasConductor == numRuta) {
          this.rutas.get(i).setNombre(nombre);
          return "La ruta ha sido modificada exitósamente.";
        }
        contadorRutasConductor++;
      }
    }
    return "Número de ruta no válido.";
  }

  public boolean existenRutas() {
    return rutas.size() > 0;
  }

  public String listarRutas() {
    String rutas = "Todas las rutas registradas: ";

    for (Ruta ruta : this.rutas) {
      rutas += ruta.obtenerInformacion() + "\n";
    }

    return rutas;
  }
}
