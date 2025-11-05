package Principal;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static Jugador jugador;
  private static int situacionActual = 0;

  public static void main(String[] args) {
    try {
      //inicializarDB(); PROXIMAMENTE
      mostrarMenu();
    } catch (Exception e) {
      System.out.println("Error: " +e.getMessage());
      e.printStackTrace();
    }
  }

  private static void mostrarMenu(){

    while (true) {
      limpiarPantalla();
      System.out.println("╔════════════════════════════════════╗");
      System.out.println("║    AVENTURA ROGUELITE TERMINAL     ║");
      System.out.println("╚════════════════════════════════════╝");
      System.out.println("\n1. Nueva partida");
      System.out.println("2. Ver estadísticas");
      System.out.println("3. Cargar partida");
      System.out.println("4. Salir");
      System.out.print("\nElige una opción: ");

      String opcion = scanner.nextLine();

      switch (opcion) {
        case "1" :
          nuevaPartida();
          break;
        case "2" :
          //verEstadisticas();
          break;
        case "3" :
          System.out.println("\n¡Hasta la próxima aventurero!");
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
    /*NO FUNCIONA*/
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static void esperarEnter() {
    System.out.println("\nPresiona ENTER para continuar...");
    scanner.nextLine();
  }
}
