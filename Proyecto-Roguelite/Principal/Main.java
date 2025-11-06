package Principal;

import Entidades.Jugador;

import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static Jugador jugador;
  private static int situacionActual = 0;

  public static void main(String[] args) {
    try {
      //Mostrar pantalla de carga al inicio
      mostrarPantallaCarga();
      mostrarMenu();
    } catch (Exception e) {
      System.out.println("Error: " +e.getMessage());
      e.printStackTrace();
    }
  }

  private static void mostrarMenu(){
    String opcion = "";

    while (!opcion.equals("4")) {
      limpiarPantalla();
      System.out.println("╔════════════════════════════════════╗");
      System.out.println("║    AVENTURA ROGUELITE TERMINAL     ║");
      System.out.println("╚════════════════════════════════════╝");
      System.out.println("\n1. Nueva partida");
      System.out.println("2. Cargar partida");
      System.out.println("3. Ver estadísticas");
      System.out.println("4. Salir");
      System.out.print("\nElige una opción: ");

      opcion = scanner.nextLine();

      switch (opcion) {
        case "1" :
          nuevaPartida();
          break;
        case "2" :
          //cargarPartida(); /*PROXIMAMENTE*/
          break;
        case "3" :
          //verEstadisticas();
          break;
        case "4" :
          System.out.println("\n¿Ya te vas? ¡Hasta la próxima!");
          break;
        default:
          System.out.println("ERROR: Opción no válida");
          esperarEnter();
      }
    }
  }

  private static void nuevaPartida() {
    limpiarPantalla();
    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║        CREACIÓN DE PERSONAJE       ║");
    System.out.println("╚════════════════════════════════════╝\n");

    // Pedir nombre
    System.out.print("Nombre del personaje: ");
    String nombre = scanner.nextLine();

    // Seleccionar género
    System.out.println("\nGénero:");
    System.out.println("1. Hombre");
    System.out.println("2. Mujer");
    System.out.println("3. Otro");
    System.out.print("Elige: ");
    String generoOpcion = scanner.nextLine();

    String genero = switch (generoOpcion) {
      case "1" -> "Hombre";
      case "2" -> "Mujer";
      case "3" -> "Otro";
      default -> "Indefinido";
    };

    // Seleccionar clase
    System.out.println("\nClase:");
    System.out.println("1. ejemplo1 (Int+3, Carisma+2)");
    System.out.println("2. ejemplo2 (Suerte+3, Intimidación+2)");
    System.out.println("3. ejemplo3 (Carisma+3, Inteligencia+2)");
    System.out.println("4. ejemplo4 (Intimidación+3, Cordura+2)");
    System.out.print("Elige: ");
    String claseOpcion = scanner.nextLine();

    // Stats base (0-20)
    int cordura = 10;
    int carisma = 5;
    int intimidacion = 5;
    int inteligencia = 5;
    int suerte = 5;

    String clase;
    switch (claseOpcion) {
      case "1":
        clase = "ejemplo1";
        inteligencia += 3;
        carisma += 2;
        break;
      case "2":
        clase = "ejemplo2";
        suerte += 3;
        intimidacion += 2;
        break;
      case "3":
        clase = "ejemplo3";
        carisma += 3;
        inteligencia += 2;
        break;
      case "4":
        clase = "ejemplo4";
        intimidacion += 3;
        cordura += 2;
        break;
      default:
        clase = "defecto";
    }

    // Crear jugador
    jugador = new Jugador(nombre, genero, clase, cordura, carisma,
            intimidacion, inteligencia, suerte);

    situacionActual = 0;
    System.out.println("\n" + jugador);
    System.out.println("\n¡Personaje creado! Tu aventura comienza...");
    esperarEnter();

    // Iniciar el bucle del juego
    // jugar(); PROXIMAMENTE
  }

  private static void jugar() {
    while (jugador.estaVivo() && situacionActual < 25) {
      limpiarPantalla();
      //mostrarEstadoJugador();

      // Obtener la entidad actual (monstruo o evento)

      // Mostrar descripción de la entidad

      // Mostrar opciones

      // Opciones especiales

      // Verificar si el jugador murió

    }
  }

  private static void mostrarEstadoJugador() {
    /*MODIFICAR TABLA CON COLORES Y SIN EMOJIS*/

    System.out.println("\n┌─────────────── " + jugador.getNombre().toUpperCase() +
            " (" + jugador.getClase() + ") ───────────────┐");
    System.out.println("│ ♥ Cordura: " + jugador.getCordura() + "/20" +
            " │ ★ Carisma: " + jugador.getCarisma() +
            " │ ☠ Intimidación: " + jugador.getIntimidacion());
    System.out.println("│ Ψ Inteligencia: " + jugador.getInteligencia() +
            " │ ♣ Suerte: " + jugador.getSuerte() +
            " │ ⌂ Items: " + jugador.getInventario().size() + "/3");
    System.out.println("│ Situación: " + (situacionActual + 1) + "/25");
    System.out.println("└" + "─".repeat(58) + "┘");
  }

  private static void mostrarInventario() {
    /*Cargar de BDD*/
  }

  private static void verEstadisticas() {
    limpiarPantalla();
    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║         ESTADÍSTICAS               ║");
    System.out.println("╚════════════════════════════════════╝\n");

    /*BDD*/

    esperarEnter();
  }

  private static void limpiarPantalla() {
    /*NO SÉ COMO HACER ESTO AUN*/
  }

  private static void esperarEnter() {
    System.out.println("\nPresiona ENTER para continuar...");
    scanner.nextLine();
  }

  private static void mostrarPantallaCarga() {
    limpiarPantalla();

    // Logo ASCII
    String[] logo = {
              "",
              "    ██████╗  ██████╗  ██████╗ ██╗   ██╗███████╗██╗     ██╗████████╗███████╗",
              "    ██╔══██╗██╔═══██╗██╔════╝ ██║   ██║██╔════╝██║     ██║╚══██╔══╝██╔════╝",
              "    ██████╔╝██║   ██║██║  ███╗██║   ██║█████╗  ██║     ██║   ██║   █████╗  ",
              "    ██╔══██╗██║   ██║██║   ██║██║   ██║██╔══╝  ██║     ██║   ██║   ██╔══╝  ",
              "    ██║  ██║╚██████╔╝╚██████╔╝╚██████╔╝███████╗███████╗██║   ██║   ███████╗",
              "    ╚═╝  ╚═╝ ╚═════╝  ╚═════╝  ╚═════╝ ╚══════╝╚══════╝╚═╝   ╚═╝   ╚══════╝",
              "",
              "                        ═══ AVENTURA TERMINAL ═══",
              ""
    };

    // Mostrar logo línea por línea con efecto
    for (String linea : logo) {
      System.out.println(linea);
      esperar(80); // 80ms por línea
    }

    // Barra de carga animada
    System.out.println("\n\n");
    System.out.println("                           Cargando aventura...\n");
    mostrarBarraCarga(50); // 50 saltos

    esperar(500); //simular tiempos de carga
    System.out.println("\n\n                        ¡Presiona ENTER para comenzar!");
    scanner.nextLine();
  }

  private static void mostrarBarraCarga(int saltos) {
    int ancho = 50;
    System.out.print("            [");

    for (int i = 0; i <= saltos; i++) {
      int progreso = (i * ancho) / saltos;

      // Volver al inicio de la línea
      System.out.print("\r            [");

      // Dibujar barra
      for (int j = 0; j < ancho; j++) {
        if (j < progreso) {
          System.out.print("█");
        } else if (j == progreso) {
          System.out.print("▓");
        } else {
          System.out.print("░");
        }
      }

      System.out.print("] " + (i * 100 / saltos) + "%");

      esperar(30); // Velocidad de carga
    }

    System.out.println();
  }

  // Método para simular pausas
  private static void esperar(int milisegundos) {
    try {
      Thread.sleep(milisegundos);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
