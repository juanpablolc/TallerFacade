package tallerfacade;

import java.util.ArrayList;

public class Facade {

  ArrayList<Usuario> usuarios = new ArrayList<>();
  ArrayList<Ruta> rutas = new ArrayList<>();

  public String adicionarConductor(String nombre, String correo, String contraseña) {
    if (!this.usuarioRegistrado(correo)) {
      Usuario usuario = new Conductor();
      usuario.adicionar(nombre, correo, contraseña);
      this.usuarios.add(usuario);
      return "Conductor registrado exitósamente.";
    } else {
      return "Ese conductor ya está registrado.";
    }
  }

  public String adicionarPasajero(String nombre, String correo, String contraseña) {
    if (!this.usuarioRegistrado(correo)) {
      Usuario usuario = new Pasajero();
      usuario.adicionar(nombre, correo, contraseña);
      this.usuarios.add(usuario);
      return "Pasajero registrado exitósamente.";
    } else {
      return "Ese pasajero ya está registrado.";
    }
  }

  public String adicionarAdministrador(String nombre, String correo, String contraseña) {
    if (!this.usuarioRegistrado(correo)) {
      Usuario usuario = new AdministradorAdapter();
      usuario.adicionar(nombre, correo, contraseña);
      this.usuarios.add(usuario);
      return "Administrador registrado exitósamente.";
    } else {
      return "Ese administrador ya está registrado.";
    }
  }

  public String acceder(String correo, String contraseña) {
    for (Usuario u : usuarios) {
      if (u.getCorreo().equals(correo) && u.getContraseña().equals(contraseña)) {
        if (u instanceof Conductor) {
          return "conductor";
        } else if (u instanceof Pasajero) {
          return "pasajero";
        } else if (u instanceof AdministradorAdapter) {
          return "administrador";
        }
      }
    }

    return "rechazado";
  }

  private boolean usuarioRegistrado(String correo) {
    for (Usuario u : usuarios) {
      if (u.getCorreo().equals(correo)) {
        return true;
      }
    }

    return false;
  }
}
