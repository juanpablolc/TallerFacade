package tallerfacade;

import javax.swing.JOptionPane;

public class Main {

  public static void main(String[] args) {
    Facade facade = new Facade();

    int opcion;
    String mensaje;
    String nombre, correo, contraseña;

    while (true) {
      opcion = Integer.parseInt(JOptionPane.showInputDialog(
              "Seleccione una opción: \n\n"
              + "1. Registrar un usuario\n"
              + "2. Acceder al sistema\n\n"
              + "0. Salir"
      ));

      switch (opcion) {
        case 1:
          int opcion2 = -1;

          while (opcion2 != 0) {
            opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Bienvenido, seleccione una opción:\n\n"
                    + "1. Conductor\n"
                    + "2. Pasajero\n"
                    + "3. Administrador\n\n"
                    + "0. Atrás"
            ));
          }

          nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
          correo = JOptionPane.showInputDialog("Ingrese el correo institucional: ");
          contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");

          switch (opcion2) {
            case 1:
              mensaje = facade.adicionarConductor(nombre, correo, contraseña);
              JOptionPane.showMessageDialog(null, mensaje);
              break;
            case 2:
              mensaje = facade.adicionarPasajero(nombre, correo, contraseña);
              JOptionPane.showMessageDialog(null, mensaje);
              break;
            case 3:
              mensaje = facade.adicionarAdministrador(nombre, correo, contraseña);
              JOptionPane.showMessageDialog(null, mensaje);
              break;
          }

          break;
        case 2:
          correo = JOptionPane.showInputDialog("Ingrese el correo institucional: ");
          contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");

          int opcion3 = -1;

          switch (facade.acceder(correo, contraseña)) {
            case "conductor":
              while (opcion3 != 0) {
                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(
                        "Seleccione una opción: \n\n"
                        + "1. Crear o registrar una ruta\n"
                        + "2. Listar las rutas registradas\n"
                        + "3. Actualizar los datos de una ruta registrada\n"
                        + "4. Eliminar una ruta registrada\n\n"
                        + "0. Atrás"
                ));
              }
              break;
            case "pasajero":
              while (opcion3 != 0) {
                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(
                        "Seleccione una opción: \n\n"
                        + "1. Crear un registro de reserva\n"
                        + "2. Listar las reservas de un pasajero\n"
                        + "3. Modificar la reserva de un pasajero\n"
                        + "4. Eliminar una reserva\n\n"
                        + "0. Atrás"
                ));
              }
              break;
            case "administrador":
              while (opcion3 != 0) {
                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(
                        "Seleccione una opción: \n\n"
                        + "1. Listar las rutas registradas\n"
                        + "2. Listar las revas de un pasajero\n\n"
                        + "0. Atrás"
                ));
              }
              break;
            case "rechazado":
              JOptionPane.showMessageDialog(null, "Correo o contraseña incorrecta.");
              break;
          }

          break;
      }
    }

    /* Usuario usuario;
    String nombre, correo, contraseña, mensaje;

    while (true) {
      int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
              "Bienvenido, seleccione una opción:\n\n"
              + "1. Conductor\n"
              + "2. Pasajero\n"
              + "3. Administrador\n\n"
              + "0. Salir"
      ));

      int opcion2;

      switch (opcion) {
        case 1: // Conductor
          usuario = new Conductor();
          opcion2 = -1;

          while (opcion2 != 0) {
            opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Menú conductor\n\n"
                    + "1. Adicionar conductor\n"
                    + "2. Modificar conductor\n"
                    + "3. Consultar conductores\n"
                    + "4. Eliminar conductor\n\n"
                    + "0. Atraś"
            ));

            switch (opcion2) {
              case 1:
                nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
                correo = JOptionPane.showInputDialog("Ingrese el correo institucional: ");
                contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");
                mensaje = usuario.adicionar(nombre, correo, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 2:
                correo = JOptionPane.showInputDialog("Ingrese el correo del conductor que desea modificar: ");
                nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                contraseña = JOptionPane.showInputDialog("Ingrese la nueva contraseña: ");
                mensaje = usuario.modificar(correo, nombre, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 3:
                mensaje = usuario.consultar();
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 4:
                correo = JOptionPane.showInputDialog("Ingrese el correo del conductor que desea eliminar: ");
                mensaje = usuario.eliminar(correo);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
            }
          }

          break;
        case 2: // Pasajero
          usuario = new Pasajero();
          opcion2 = -1;

          while (opcion2 != 0) {
            opcion2 = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú pasajero\n\n"
                    + "1. Adicionar pasajero\n"
                    + "2. Modificar pasajero\n"
                    + "3. Consultar pasajeros\n"
                    + "4. Eliminar pasajero\n\n"
                    + "0. Atrás"
            ));

            switch (opcion2) {
              case 1:
                nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
                correo = JOptionPane.showInputDialog("Ingrese el correo institucional: ");
                contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");
                mensaje = usuario.adicionar(nombre, correo, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 2:
                correo = JOptionPane.showInputDialog("Ingrese el correo del conductor que desea modificar: ");
                nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                contraseña = JOptionPane.showInputDialog("Ingrese la nueva contraseña: ");
                mensaje = usuario.modificar(correo, nombre, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 3:
                mensaje = usuario.consultar();
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 4:
                correo = JOptionPane.showInputDialog("Ingrese el correo del conductor que desea eliminar: ");
                mensaje = usuario.eliminar(correo);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
            }
          }

          break;
        case 3: // Administrador
          usuario = new AdministradorAdapter();
          opcion2 = -1;

          while (opcion2 != 0) {
            opcion2 = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú administrador\n\n"
                    + "1. Adicionar administrador\n"
                    + "2. Modificar administrador\n"
                    + "3. Consultar administrador\n"
                    + "4. Eliminar administrador\n\n"
                    + "0. Atrás"
            ));

            switch (opcion2) {
              case 1:
                nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
                correo = JOptionPane.showInputDialog("Ingrese el correo institucional: ");
                contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");
                mensaje = usuario.adicionar(nombre, correo, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 2:
                correo = JOptionPane.showInputDialog("Ingrese el correo del administrador que desea modificar: ");
                nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");
                contraseña = JOptionPane.showInputDialog("Ingrese la nueva contraseña: ");
                mensaje = usuario.modificar(correo, nombre, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 3:
                mensaje = usuario.consultar();
                JOptionPane.showMessageDialog(null, mensaje);
                break;
              case 4:
                correo = JOptionPane.showInputDialog("Ingrese el correo del administrador que desea eliminar: ");
                mensaje = usuario.eliminar(correo);
                JOptionPane.showMessageD;ialog(null, mensaje);
                break;
            }
          }

          break;
        case 0:
          System.exit(0);
      }
    }*/
  }
}
