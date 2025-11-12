package Principal;

import Entidades.Criatura.*;
import Entidades.Entidad;
import Entidades.Eventos.*;
import Entidades.Jugador;
import Entidades.Sistema.GestorLogros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static Jugador jugador;
  private static int situacionActual = 0;

  public static void main(String[] args) {
    try {
      // iniciar sistema de guardado
      GestorPartidas.inicializar();
      GestorLogros.inicializar();

      // Mostrar pantalla de carga al inicio
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
      System.out.println("4. Libro de Logros");
      System.out.println("5. Salir");
      System.out.print("\nElige una opción: ");

      opcion = scanner.nextLine();

      switch (opcion) {
        case "1" :
          nuevaPartida();
          break;
        case "2" :
          cargarPartida();
          break;
        case "3" :
          verEstadisticas();
          break;
        case "4":
          limpiarPantalla();
          GestorLogros.mostrarLogros();
          esperarEnter();
          break;
        case "5" :
          System.out.println("\n¿Ya te vas? ¡Hasta la próxima!");
          break;
        default:
          System.out.println("\nERROR: Opción no válida");
          esperarEnter();
      }
    }
  }

  private static void nuevaPartida() {
    // Verificar si ya existe una partida
    if (GestorPartidas.existePartida()) {
      limpiarPantalla();
      System.out.println("\n═══ ADVERTENCIA ═══");
      System.out.println("Ya existe una partida guardada." +
              "\nSi creas una nueva, el anterior será eliminado." +
              "\n¿Deseas continuar? (s/n)");

      String confirmacion = scanner.nextLine();

      if (!confirmacion.equalsIgnoreCase("s")) {
        if (!confirmacion.equalsIgnoreCase("n")) {
          System.out.println("ERROR: Opción inválida");
        }
        return;
      }
    }

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
      case "4" -> "Doble Elefante Telepata De Guerra";
      default -> "Indefinido";
    };

    // Stats base (0-20)
    int cordura = 10;
    int carisma = 5;
    int intimidacion = 5;
    int inteligencia = 5;
    int suerte = 5;

    // Seleccionar clase
    System.out.println("\nClase:");
    System.out.println("1. Pícaro (Carisma+3, Intimidación+2)");
    System.out.println("2. Mago (Suerte+3, Inteligencia+2)");
    System.out.println("3. Clérigo (Cordura+3, Suerte+2)");
    System.out.println("4. Guerrero (Intimidación+3, Cordura+2)");
    System.out.print("Elige: ");
    String claseOpcion = scanner.nextLine();

    String clase;
    switch (claseOpcion) {
      case "1":
        clase = "Pícaro";
        carisma += 3;
        intimidacion += 2;
        break;
      case "2":
        clase = "Mago";
        suerte += 3;
        inteligencia += 2;
        break;
      case "3":
        clase = "Clérigo";
        cordura += 3;
        suerte += 2;
        break;
      case "4":
        clase = "Guerrero";
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

    // GUARDAR PERSONAJE EN JSON
    boolean guardado = GestorPartidas.guardarPersonaje(jugador);

    limpiarPantalla();
    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║        PERSONAJE CREADO            ║");
    System.out.println("╚════════════════════════════════════╝\n");
    System.out.println(jugador);

    if (guardado) {
      System.out.println("\nPersonaje guardado correctamente");
    } else {
      System.out.println("\nERROR AL GUARDAR LA PARTIDA");
    }

    System.out.println("\n¡Tu aventura comienza!");
    esperarEnter();

    // Iniciar el bucle del juego
     jugar();
  }

  private static void cargarPartida(){
    limpiarPantalla();

    if (!GestorPartidas.existePartida()){
      System.out.println("\n╔════════════════════════════════════╗");
      System.out.println("║     NO HAY PARTIDA GUARDADA        ║");
      System.out.println("╚════════════════════════════════════╝");
      System.out.println("\nDebes crear un personaje primero.");
      esperarEnter();
      return;
    }

    // Mostrar información del personaje guardado
    String info = GestorPartidas.obtenerInfoPartida();
    if (info != null) {
      System.out.println(info);
    }

    System.out.print("\n¿Deseas cargar este personaje? (s/n): ");
    String confirmacion = scanner.nextLine();

    if (!confirmacion.equalsIgnoreCase("s")) {
      if (!confirmacion.equalsIgnoreCase("n")) {
        System.out.println("ERROR: Opción inválida");
      }
      return;
    }

    // Cargar personaje
    jugador = GestorPartidas.cargarPersonaje();

    if (jugador != null) {
      limpiarPantalla();
      System.out.println("╔════════════════════════════════════╗");
      System.out.println("║         PERSONAJE CARGADO          ║");
      System.out.println("╚════════════════════════════════════╝\n");
      System.out.println(jugador);
      System.out.println("\nPartida cargada correctamente");
      System.out.println("\n¡Tu aventura comienza!");
      esperarEnter();

      situacionActual = 0; // Por ahora siempre empieza desde 0

      jugar();
    } else {
      System.out.println("\nERROR AL CARGAR LA PARTIDA");
      esperarEnter();
    }
  }

  private static void verEstadisticas() {
    limpiarPantalla();
    System.out.println("╔════════════════════════════════════╗");
    System.out.println("║            ESTADÍSTICAS            ║");
    System.out.println("╚════════════════════════════════════╝\n");

    if (!GestorPartidas.existePartida()) {
      System.out.println("ALERTA: NO HAY NINGUNA PARTIDA GUARDADA.");
    } else {
      String info = GestorPartidas.obtenerInfoPartida();
      if (info != null) {
        System.out.println(info);
      }
    }

    esperarEnter();

    /* MOSTRAR INFO DE BDD DE OTROS JUGADORES - RANKING */
  }

  private static void jugar() {
    // Lista con todos los eventos posibles (De momento una prueba con 3)
    List<Entidad> eventosDisponibles = new ArrayList<>();
    //Anadir todos los eventos
    eventosDisponibles.add(new AbuelaGalletas());
    eventosDisponibles.add(new AscensorPosibilidades());
    eventosDisponibles.add(new CajaTexto());
    eventosDisponibles.add(new CuartaPared());
    eventosDisponibles.add(new DemandaFontanero());
    eventosDisponibles.add(new EspejoMagico());
    eventosDisponibles.add(new GatoCuantico());
    eventosDisponibles.add(new NPCParking());
    eventosDisponibles.add(new PantallaAzul());
    eventosDisponibles.add(new ProgramaTV());
    eventosDisponibles.add(new PublicidadEmergente());
    eventosDisponibles.add(new PuenteRoto());
    eventosDisponibles.add(new ReunionNPCs());
    eventosDisponibles.add(new SalaPruebas());
    eventosDisponibles.add(new TiendaFuturista());
    eventosDisponibles.add(new WifiFantasma());

    //Anadir todas las criaturas
      eventosDisponibles.add(new AranaRedes());
      eventosDisponibles.add(new ArmaduraAbandonada());
      eventosDisponibles.add(new AutomataRoto());
      eventosDisponibles.add(new BrumaRastreadora());
      eventosDisponibles.add(new CharcoReflejos());
      eventosDisponibles.add(new CraneoRisueno());
      eventosDisponibles.add(new ElementalLlama());
      eventosDisponibles.add(new EspectroMemoria());
      eventosDisponibles.add(new EstatuaLlorona());
      eventosDisponibles.add(new GolemMusgo());
      eventosDisponibles.add(new GusanoHielo());
      eventosDisponibles.add(new HombreHongo());
      eventosDisponibles.add(new LibroEnfadado());
      eventosDisponibles.add(new LimoParlante());
      eventosDisponibles.add(new LuzBurlona());
      eventosDisponibles.add(new MurcielagoEco());
      eventosDisponibles.add(new NieblaParpadeante());
      eventosDisponibles.add(new OrejaEscuchadora());
      eventosDisponibles.add(new ParedGelatina());
      eventosDisponibles.add(new PortalDuda());
      eventosDisponibles.add(new RaizEstranguladora());
      eventosDisponibles.add(new RemolinoArena());
      eventosDisponibles.add(new RocaDesagradecida());
      eventosDisponibles.add(new Suegra());
      eventosDisponibles.add(new TentaculoLanguido());


      // Mezclamos aleatoriamente
    Collections.shuffle(eventosDisponibles);

    // Bucle del juego (ej: 25 eventos y finaliza)
    List<Entidad> eventosPartida = eventosDisponibles.subList(0, Math.min(25, eventosDisponibles.size()));

    for (Entidad evento : eventosPartida) {
      if (!jugador.estaVivo()) break; // Si muere antes de terminar el bucle de juego

      limpiarPantalla();
      mostrarEstadoJugador();

      System.out.println("Evento: " + evento.getNombre());
      System.out.println(evento.getDescripcion());
      System.out.println();
      System.out.println(evento.getPregunta());
      System.out.println();

      // Mostrar opciones base + extra
      List<String> opciones = evento.getInteraccionesDisponibles(jugador);

      for (int i = 0; i < opciones.size(); i++) {
        System.out.println(opciones.get(i));
      }
      /* OPCION EXTRA BDD - PAU A CURRAR */
      //conectarseBDD()

      System.out.print("\nElige una opción: ");
      String eleccion = scanner.nextLine();

      try {
        // Ejecutar la interacción seleccionada
        String resultado = evento.interactuar(jugador, eleccion);
        System.out.println("\n" + resultado);
      } catch (Exception e) {
        System.out.println("\nERROR al procesar el evento: " + e.getMessage());
      }

      // Verificar si el jugador sigue vivo
      if (!jugador.estaVivo()) {
        System.out.println("💀 GAME OVER 💀");
        System.out.println("Has perdido la cordura por completo...");
        System.out.println("Tus logros se han guardado.");
        GestorLogros.guardarProgreso();
        esperarEnter();
        return;
      }

      // Verificar logros automáticos
      GestorLogros.verificarLogroAutomatico(jugador, situacionActual);

      esperarEnter();
      situacionActual++;
    }

    limpiarPantalla();
    if (jugador.estaVivo()) {
      System.out.println("══════════════════════════════");
      System.out.println("     FIN DE LA AVENTURA");
      System.out.println("══════════════════════════════");
      System.out.println("\nHas completado " + situacionActual + " eventos.");
    }else{
      System.out.println("💀 GAME OVER 💀");
      System.out.println("Has perdido la cordura por completo...");
      System.out.println("Tus logros se han guardado.");
      GestorLogros.guardarProgreso();
    }
    esperarEnter();
  }

  private static void mostrarEstadoJugador() {
    System.out.println("\n┌───────────────────── " + jugador.getNombre().toUpperCase() +
            " (" + jugador.getClase() + ") ─────────────────────┐");
    System.out.println("│ ♥ Cordura: " + jugador.getCordura() + "/20" +
            " │ ★ Carisma: " + jugador.getCarisma() +
            " │ ☠ Intimidación: " + jugador.getIntimidacion());
    System.out.println("│ Ψ Inteligencia: " + jugador.getInteligencia() +
            " │ ♣ Suerte: " + jugador.getSuerte() +
            " │ ⌂ Items: " + jugador.getInventario().size() + "/3");
    System.out.println("│ Situación: " + (situacionActual + 1) + "/25");
    System.out.println("└" + "─".repeat(59) + "┘");
  }

  // FUNCIONES INTERNAS
  private static void limpiarPantalla() {
    /*NO SÉ COMO HACER ESTO AUN, NO FUNCIONA*/
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static void esperarEnter() {
    System.out.println("\nPresiona ENTER para continuar...");
    scanner.nextLine();
  }

  // SIMULACIÓN PANTALLA DE CARGA
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
