package Entidades.Sistema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorLogros {
    private static final String CARPETA_DATOS = "Datos";
    private static final String CARPETA_PARTIDAS = "Partidas";
    private static final String ARCHIVO_DEFINICIONES = "logros_definiciones.json";
    private static final String ARCHIVO_PROGRESO = "logros_progreso.json";

    private static List<Logro> logros = new ArrayList<>();

    // Inicializar Sistema
    public static void inicializar() {
        try {
            // Solo crear/verificar carpeta de datos (no partidas, esa es de GestorPartidas)
            Path carpetaDatos = Paths.get(CARPETA_DATOS);
            if (!Files.exists(carpetaDatos)) {
                Files.createDirectory(carpetaDatos);
            }

            // Crear archivo de definiciones si no existe
            Path archivoDefiniciones = Paths.get(CARPETA_DATOS, ARCHIVO_DEFINICIONES);
            if (!Files.exists(archivoDefiniciones)) {
                crearArchivoDefiniciones();
            }

            cargarDefiniciones();
            cargarProgreso();

        } catch (IOException e) {
            System.err.println("Error al inicializar logros: " + e.getMessage());
        }
    }

    // Crear archivo de definiciones
    private static void crearArchivoDefiniciones() throws IOException {
        StringBuilder json = new StringBuilder();
        json.append("{\n  \"logros\": [\n");

        Object[][] logrosData = {
                // COMBATE
                {"PRIMERA_VICTORIA", "Primera Victoria", "Sobreviviste a tu primer encuentro", "Supera tu primera situación sin morir", "Combate", false},

                // SOCIAL
                {"SEDUCTOR", "Seductor Nato", "¿Sedujiste a una pobre ancianita? ¿¡Qué está mal contigo!?", "Explora tus sex-appeal", "Social", false},

                // EXPLORACIÓN

                // SUPERVIVENCIA
                {"AL_LIMITE", "Al Límite", "Te has quedado a 1 de cordura. No te lo crees ni tú", "Quédate a 1 golpe", "Supervivencia", false},

                // INTELIGENCIA
                {"EDUARDO", "Eduardo", "Has conseguido tener 20 de Intelgiencia. Enhorabuena, eres un Eduardo.", "Usa el 100% de tu cerebro", "Inteligencia", false},

                // SECRETOS
                {"FLIPADO", "Ves a tocar césped", "???", "Secreto", true}, // Conseguir todas las stats

                {"PUERTA_DIMENSIONAL", "Cortesía Dimensional", "Descubriste el secreto de la puerta", "???", "Secreto", true},
                {"AFORTUNADO", "Golpe de Suerte", "Supera un evento con suerte pura", "???", "Secreto", true},
                {"LOCO_REMATE", "Loco de Remate", "Llega a 0 de cordura y sobrevive", "???", "Secreto", true},
                {"MAESTRO_TODO", "Maestro de Todo", "Ten todas las stats en 15 o más", "???", "Secreto", true},
                {"SPEEDRUNNER", "Speedrunner", "Completa el juego en menos de 15 minutos", "???", "Secreto", true}
        };

        for (int i = 0; i < logrosData.length; i++) {
            Object[] logro = logrosData[i];
            json.append("    {\n");
            json.append("      \"id\": \"").append(logro[0]).append("\",\n");
            json.append("      \"nombre\": \"").append(logro[1]).append("\",\n");
            json.append("      \"descripcion\": \"").append(logro[2]).append("\",\n");
            json.append("      \"pista\": \"").append(logro[3]).append("\",\n");
            json.append("      \"categoria\": \"").append(logro[4]).append("\",\n");
            json.append("      \"oculto\": ").append(logro[5]).append("\n");
            json.append("    }");
            if (i < logrosData.length - 1) json.append(",");
            json.append("\n");
        }

        json.append("  ]\n}");

        Files.writeString(Paths.get(CARPETA_DATOS, ARCHIVO_DEFINICIONES), json.toString());
    }

    // Cargar definiciones
    private static void cargarDefiniciones() throws IOException {
        Path archivo = Paths.get(CARPETA_DATOS, ARCHIVO_DEFINICIONES);
        String json = Files.readString(archivo);

        logros.clear();
        String[] bloques = json.split("\\{\\s*\"id\":");

        for (int i = 1; i < bloques.length; i++) {
            String bloque = bloques[i];
            Logro logro = new Logro();
            logro.setId(extraerValor(bloque, "id"));
            logro.setNombre(extraerValor(bloque, "nombre"));
            logro.setDescripcion(extraerValor(bloque, "descripcion"));
            logro.setPista(extraerValor(bloque, "pista"));
            logro.setCategoria(extraerValor(bloque, "categoria"));
            logro.setOculto(extraerBoolean(bloque, "oculto"));
            logro.setDesbloqueado(false);
            logros.add(logro);
        }
    }

    // Cargar progreso
    private static void cargarProgreso() {
        try {
            Path archivo = Paths.get(CARPETA_PARTIDAS, ARCHIVO_PROGRESO);
            if (!Files.exists(archivo)) return;

            String json = Files.readString(archivo);
            String patron = "\"desbloqueados\": [";
            int inicio = json.indexOf(patron);
            if (inicio == -1) return;

            inicio += patron.length();
            int fin = json.indexOf("]", inicio);
            String contenido = json.substring(inicio, fin);

            if (contenido.trim().isEmpty()) return;

            String[] ids = contenido.split(",");
            for (String id : ids) {
                String idLimpio = id.trim().replaceAll("\"", "");
                for (Logro logro : logros) {
                    if (logro.getId().equals(idLimpio)) {
                        logro.marcarDesbloqueado();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar progreso: " + e.getMessage());
        }
    }

    // Guardar progreso
    public static void guardarProgreso() {
        try {
            StringBuilder json = new StringBuilder();
            json.append("{\n  \"desbloqueados\": [");

            List<String> desbloqueados = new ArrayList<>();
            for (Logro logro : logros) {
                if (logro.isDesbloqueado()) {
                    desbloqueados.add(logro.getId());
                }
            }

            for (int i = 0; i < desbloqueados.size(); i++) {
                json.append("\"").append(desbloqueados.get(i)).append("\"");
                if (i < desbloqueados.size() - 1) json.append(", ");
            }

            json.append("]\n}");

            Files.writeString(Paths.get(CARPETA_PARTIDAS, ARCHIVO_PROGRESO), json.toString());

        } catch (IOException e) {
            System.err.println("Error al guardar progreso: " + e.getMessage());
        }
    }

    // Desbloquear logro
    public static boolean desbloquear(String idLogro) {
        for (Logro logro : logros) {
            if (logro.getId().equals(idLogro) && !logro.isDesbloqueado()) {
                logro.marcarDesbloqueado();
                guardarProgreso();
                return true;
            }
        }
        return false;
    }

    // Mostrar notificación
    public static void mostrarNotificacion(String idLogro) {
        for (Logro logro : logros) {
            if (logro.getId().equals(idLogro)) {
                System.out.println("\n╔════════════════════════════════════════════════╗");
                System.out.println("║          ★ LOGRO DESBLOQUEADO ★              ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.println("  " + logro.getNombre());
                System.out.println("  " + logro.getDescripcion());
                System.out.println("════════════════════════════════════════════════");
                return;
            }
        }
    }

    // Estadísticas
    public static String obtenerEstadisticas() {
        int total = logros.size();
        int desbloqueados = 0;
        for (Logro logro : logros) {
            if (logro.isDesbloqueado()) desbloqueados++;
        }
        double porcentaje = (total > 0) ? (desbloqueados * 100.0 / total) : 0;
        return String.format("Logros: %d/%d (%.1f%%)", desbloqueados, total, porcentaje);
    }

    // Mostrar todos los logros
    public static void mostrarLogros() {
        Map<String, List<Logro>> porCategoria = new HashMap<>();

        for (Logro logro : logros) {
            porCategoria.computeIfAbsent(logro.getCategoria(), k -> new ArrayList<>()).add(logro);
        }

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║              LIBRO DE LOGROS                   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        System.out.println(obtenerEstadisticas());
        System.out.println();

        String[] orden = {"Combate", "Social", "Exploracion", "Supervivencia", "Inteligencia", "Secreto"};

        for (String categoria : orden) {
            List<Logro> logrosCategoria = porCategoria.get(categoria);
            if (logrosCategoria == null) continue;

            System.out.println("\n┌── " + categoria.toUpperCase() + " " + "─".repeat(40 - categoria.length()));
            for (Logro logro : logrosCategoria) {
                System.out.println("│ " + logro.toString());
            }
            System.out.println("└" + "─".repeat(48));
        }
    }

    // Verificar logro automático
    public static void verificarLogroAutomatico(Entidades.Jugador jugador, int situacionActual) {
        // Stats al máximo
        if (jugador.getCordura() == 20
                && jugador.getCarisma() == 20
                && jugador.getIntimidacion() == 20
                && jugador.getInteligencia() == 20
                && jugador.getSuerte() == 20){
            if (desbloquear("FLIPADO")) mostrarNotificacion("FLIPADO");
        }

        // Quedarte a 1 de cordura
        if (jugador.getCordura() == 1){
            if (desbloquear("AL_LIMITE")) mostrarNotificacion("AL_LIMITE");
        }

        // Conseguir 20 de inteligencia
        if (jugador.getInteligencia() == 20){
            if (desbloquear("EDUARDO")) mostrarNotificacion("EDUARDO");
        }
    }

    // Utilidades internas
    private static String extraerValor(String texto, String clave) {
        String patron = "\"" + clave + "\": \"";
        int inicio = texto.indexOf(patron);
        if (inicio == -1) return "";
        inicio += patron.length();
        int fin = texto.indexOf("\"", inicio);
        return texto.substring(inicio, fin);
    }

    private static boolean extraerBoolean(String texto, String clave) {
        String patron = "\"" + clave + "\": ";
        int inicio = texto.indexOf(patron);
        if (inicio == -1) return false;
        inicio += patron.length();
        return texto.substring(inicio, inicio + 4).equals("true");
    }

}
