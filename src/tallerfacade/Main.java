/*
Elabore un programa que permita administrar los usuarios, las rutas y las reservas. El menú o el acceso al servicio tendrá que tener las siguientes 10 opciones:

1. Registrar un usuario 
2. Acceder al sistema
3. Crear o registrar una ruta CONDUCTOR
4. Listar las rutas registradas de un conductor CONDUCTOR, ADMINISTRADOR
5. Actualizar los datos de una ruta registrada CONDUCTOR
6. Eliminar una ruta registrada CONDUCTOR
7. Crear un registro de reserva PASAJERO
8. Listar las reservas de un pasajero PASAJERO, ADMINISTRADOR
9. Modificar la reserva de un pasajero PASAJERO
10. Eliminar una reserva PASAJERO
 */
package tallerfacade;

import javax.swing.JOptionPane;

public class Main {

  public static void main(String[] args) {
    Facade facade = new Facade();

    String mensaje, correo, nombre, contraseña, nombreRuta, nombreCalle;
    int idRuta, tiempoRecorrido, numRuta, puestosReservados;
    double coordenadaXOrigen, coordenadaYOrigen, coordenadaXDestino, coordenadaYDestino, distancia;

    int opcion;

    while (true) {
      opcion = Integer.parseInt(JOptionPane.showInputDialog(
              "TALLER FACADE\n\n"
              + "Seleccione una opción: \n\n"
              + "1. Registrar un usuario\n"
              + "2. Acceder al sistema\n\n"
              + "0. Salir"
      ));

      switch (opcion) {
        case 1:
          int opcion2;
          menu2:
          while (true) {
            opcion2 = Integer.parseInt(JOptionPane.showInputDialog(
                    "¿Qué tipo de usuario desea registrar?\n\n"
                    + "1. Conductor\n"
                    + "2. Pasajero\n"
                    + "3. Administrador\n\n"
                    + "0. Atrás"
            ));

            if (opcion2 == 0) {
              break;
            }

            correo = JOptionPane.showInputDialog("Ingrese el correo institucional: ");
            nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
            contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");

            switch (opcion2) {
              case 1:
                mensaje = facade.adicionarConductor(correo, nombre, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break menu2;
              case 2:
                mensaje = facade.adicionarPasajero(correo, nombre, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break menu2;
              case 3:
                mensaje = facade.adicionarAdministrador(correo, nombre, contraseña);
                JOptionPane.showMessageDialog(null, mensaje);
                break menu2;
            }
          }

          break;
        case 2:
          correo = JOptionPane.showInputDialog("Ingrese el correo institucional: ");
          contraseña = JOptionPane.showInputDialog("Ingrese la contraseña: ");

          int opcion3 = -1;

          int idUsuario = facade.acceder(correo, contraseña);

          if (idUsuario == -1) {
            JOptionPane.showMessageDialog(null, "Correo o contraseña no válidos.");
            continue;
          }

          switch (facade.getTipoUsuario(idUsuario)) {
            case "conductor":
              while (opcion3 != 0) {
                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(
                        "Bienvenido " + facade.getNombreUsuario(idUsuario) + " (Conductor)\n\n"
                        + "Seleccione una opción: \n\n"
                        + "1. Registrar ruta\n"
                        + "2. Listar rutas\n"
                        + "3. Actualizar ruta\n"
                        + "4. Eliminar ruta\n\n"
                        + "0. Cerrar sesión"
                ));

                switch (opcion3) {
                  case 1:
                    nombreRuta = JOptionPane.showInputDialog("Ingrese el nombre de la ruta: ");
                    mensaje = facade.registarRuta(nombreRuta, idUsuario);
                    JOptionPane.showMessageDialog(null, mensaje);
                    idRuta = facade.getUltimaRutaRegistrada();
                    int opcion4 = -1;
                    while (opcion4 != 1) {
                      if (opcion4 == -1) {
                        JOptionPane.showMessageDialog(null, "Debe añadir por lo menos una calle.");
                      }
                      nombreCalle = JOptionPane.showInputDialog("Ingrese el nombre de la calle: ");
                      coordenadaXOrigen = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada 'x' de origen: "));
                      coordenadaYOrigen = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada 'y' de origen: "));
                      coordenadaXDestino = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada 'x' de destino: "));
                      coordenadaYDestino = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada 'y' de destino: "));
                      distancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la distancia: "));
                      tiempoRecorrido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo de recorrido a 60km/h"));
                      mensaje = facade.añadirCalle(idRuta, nombreCalle, coordenadaXOrigen, coordenadaYOrigen, coordenadaXDestino, coordenadaYDestino, distancia, tiempoRecorrido);
                      JOptionPane.showMessageDialog(null, mensaje);
                      opcion4 = JOptionPane.showConfirmDialog(null, "¿Desea añadir otra calle?", "TallerFacade", JOptionPane.YES_NO_OPTION);
                    }
                    break;
                  case 2:
                    if (facade.existenRutasConductor(idUsuario)) {
                      JOptionPane.showMessageDialog(null, facade.listarRutasConductor(idUsuario));
                    } else {
                      JOptionPane.showMessageDialog(null, facade.getNombreUsuario(idUsuario) + " no tiene ninguna ruta registrada.");
                    }
                    break;
                  case 3:
                    if (facade.existenRutasConductor(idUsuario)) {
                      numRuta = Integer.parseInt(JOptionPane.showInputDialog(facade.listarRutasConductor(idUsuario) + "Ingrese el número de la ruta que desea actualizar: "));
                      nombreRuta = JOptionPane.showInputDialog("Ingrese el nuevo nombre para la ruta: ");
                      mensaje = facade.actualizarRuta(idUsuario, numRuta, nombreRuta);
                      JOptionPane.showMessageDialog(null, mensaje);
                    } else {
                      JOptionPane.showMessageDialog(null, facade.getNombreUsuario(idUsuario) + " no tiene ninguna ruta registrada.");
                    }
                    break;
                  case 4:
                    if (facade.existenRutasConductor(idUsuario)) {
                      numRuta = Integer.parseInt(JOptionPane.showInputDialog(facade.listarRutasConductor(idUsuario) + "Ingrese el número de la ruta que desea eliminar: "));
                      mensaje = facade.eliminarRuta(idUsuario, numRuta);
                      JOptionPane.showMessageDialog(null, mensaje);
                    } else {
                      JOptionPane.showMessageDialog(null, facade.getNombreUsuario(idUsuario) + " no tiene ninguna ruta registrada.");
                    }
                    break;
                }
              }
              break;
            case "pasajero":
              while (opcion3 != 0) {
                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(
                        "Bienvenido " + facade.getNombreUsuario(idUsuario) + " (Pasajero)\n\n"
                        + "Seleccione una opción: \n\n"
                        + "1. Registrar reserva\n"
                        + "2. Listar reservas\n"
                        + "3. Modificar reserva\n"
                        + "4. Eliminar reserva\n\n"
                        + "0. Cerrar sesión"
                ));
                switch (opcion3) {
                  case 1:
                    idRuta = Integer.parseInt(JOptionPane.showInputDialog(facade.listarRutas() + "Ingrese el número de la ruta que desea reservar: "));
                    puestosReservados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de puestos que desea reservar: "));
                    mensaje = facade.registrarReserva(idRuta, idUsuario, puestosReservados);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                  case 2:
                    mensaje = facade.listarReservas();
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                  case 3:
                    idRuta = Integer.parseInt(JOptionPane.showInputDialog(facade.listarRutas() + "Ingrese el número de la ruta que desea modificar: "));
                    puestosReservados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de puestos a reservar: "));
                    mensaje = facade.modificarReserva(idRuta, puestosReservados);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                  case 4:
                    idRuta = Integer.parseInt(JOptionPane.showInputDialog(facade.listarRutas() + "Ingrese el número de la ruta que desea eliminar: "));
                    mensaje = facade.eliminarReserva(idRuta);
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                }
              }
              break;
            case "administrador":
              while (opcion3 != 0) {
                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(
                        "Bienvenido " + facade.getNombreUsuario(idUsuario) + " (Administrador)\n\n"
                        + "Seleccione una opción: \n\n"
                        + "1. Listar usuarios\n"
                        + "2. Listar rutas\n"
                        + "3. Listar reservas\n\n"
                        + "0. Cerrar sesión"
                ));

                switch (opcion3) {
                  case 1:
                    if (facade.existenUsuarios()) {
                      JOptionPane.showMessageDialog(null, facade.listarUsuarios());
                    } else {
                      JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado.");
                    }
                    break;
                  case 2:
                    if (facade.existenRutas()) {
                      JOptionPane.showMessageDialog(null, facade.listarRutas());
                    } else {
                      JOptionPane.showMessageDialog(null, "No hay ninguna ruta registrada.");
                    }
                    break;
                  case 3:
                    if (facade.existenReservas()) {
                      JOptionPane.showMessageDialog(null, facade.listarReservas());
                    } else {
                      JOptionPane.showMessageDialog(null, "No hay ninguna reserva registrada.");
                    }
                    break;
                }
              }
              break;
          }
          break;
        case 0:
          System.exit(0);
      }
    }
  }
}
