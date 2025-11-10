package Principal;

import Entidades.Jugador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorPartidas {
    private static final String CARPETA_GUARDADOS = "Partidas";
    private static final String ARCHIVO_PARTIDA = "partida.json";

    // Iniciar carpeta
    public static void inicializar() {
        try{
            Path carpeta = Paths.get(CARPETA_GUARDADOS);
            if (!Files.exists(carpeta)) {
                Files.createDirectory(carpeta);
            }
        } catch (IOException e) {
            System.out.println("ERROR AL CREAR LA CARPETA DE GUARDADO: " +e.getMessage());
        }
    }

    // Guardar personaje
    public static boolean guardarPersonaje(Jugador jugador) {
        try{
            StringBuilder json = new StringBuilder();
            json.append("{\n");
            json.append("  \"nombre\": \"").append(jugador.getNombre()).append("\",\n");
            json.append("  \"genero\": \"").append(jugador.getGenero()).append("\",\n");
            json.append("  \"clase\": \"").append(jugador.getClase()).append("\",\n");
            json.append("  \"cordura\": ").append(jugador.getCordura()).append(",\n");
            json.append("  \"carisma\": ").append(jugador.getCarisma()).append(",\n");
            json.append("  \"intimidacion\": ").append(jugador.getIntimidacion()).append(",\n");
            json.append("  \"inteligencia\": ").append(jugador.getInteligencia()).append(",\n");
            json.append("  \"suerte\": ").append(jugador.getSuerte()).append(",\n");

            // Inventario
            json.append("  \"inventario\": [");
            List<String> items = jugador.getInventario();
            for (int i = 0; i < items.size(); i++) {
                json.append("\"").append(items.get(i)).append("\"");
                if (i < items.size() - 1) json.append(", ");
            }
            json.append("],\n");

            // Metadatos
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            json.append("  \"fechaCreacion\": \"").append(fecha).append("\"\n");
            json.append("}");

            // Escribir archivo
            Path archivo = Paths.get(CARPETA_GUARDADOS, ARCHIVO_PARTIDA);
            Files.writeString(archivo, json.toString());

            return true;

        }catch (Exception e) {
            System.out.println("ERROR AL GUARDAR PERSONAJE: " +e.getMessage());
            return false;
        }
    }

    // Cargar partida
    public static Jugador cargarPersonaje() {
        try {
            Path archivo = Paths.get(CARPETA_GUARDADOS, ARCHIVO_PARTIDA);

            if (!Files.exists(archivo)) {
                return null;
            }

            String json = Files.readString(archivo);

            // Extraer datos del JSON
            String nombre = extraerValor(json, "nombre");
            String genero = extraerValor(json, "genero");
            String clase = extraerValor(json, "clase");
            int cordura = Integer.parseInt(extraerValor(json, "cordura"));
            int carisma = Integer.parseInt(extraerValor(json, "carisma"));
            int intimidacion = Integer.parseInt(extraerValor(json, "intimidacion"));
            int inteligencia = Integer.parseInt(extraerValor(json, "inteligencia"));
            int suerte = Integer.parseInt(extraerValor(json, "suerte"));

            // Reconstruir jugador
            Jugador jugador = new Jugador(nombre, genero, clase,
                    cordura, carisma, intimidacion, inteligencia, suerte);

            // Restaurar inventario
            String[] items = extraerArray(json, "inventario");
            for (String item : items) {
                jugador.agregarItem(item);
            }

            return jugador;
        }catch (Exception e) {
            System.err.println("ERROR AL CARGAR PERSONAJE: " + e.getMessage());
            return null;
        }
    }

    // Verificar si existe partida guardada
    public static boolean existePartida() {
        Path archivo = Paths.get(CARPETA_GUARDADOS, ARCHIVO_PARTIDA);
        return Files.exists(archivo);
    }

    // Borrar partida
    public static boolean borrarPartida() {
        try {
            Path archivo = Paths.get(CARPETA_GUARDADOS, ARCHIVO_PARTIDA);
            if (Files.exists(archivo)) {
                Files.delete(archivo);
                return true;
            }
            return false;
        } catch (IOException e) {
            System.err.println("ERROR AL BORRAR PARTIDA: " + e.getMessage());
            return false;
        }
    }

    // Obtener información sin cargar todo
    public static String obtenerInfoPartida() {
        try {
            Path archivo = Paths.get(CARPETA_GUARDADOS, ARCHIVO_PARTIDA);
            if (!Files.exists(archivo)) {
                return null;
            }

            String json = Files.readString(archivo);

            String nombre = extraerValor(json, "nombre");
            String clase = extraerValor(json, "clase");
            String fecha = extraerValor(json, "fechaCreacion");
            int cordura = Integer.parseInt(extraerValor(json, "cordura"));

            StringBuilder info = new StringBuilder();
            info.append("\nNombre: ").append(nombre);
            info.append("\nClase: ").append(clase);
            info.append("\nCordura: ").append(cordura).append("/20");
            info.append("\nCreado: ").append(fecha);

            return info.toString();

        } catch (IOException e) {
            return null;
        }
    }

    // Funciones internas
    private static String extraerValor(String json, String clave) {
        String patron = "\"" + clave + "\": \"";
        int inicio = json.indexOf(patron);

        if (inicio == -1) {
            // Intentar con número (sin comillas)
            patron = "\"" + clave + "\": ";
            inicio = json.indexOf(patron);

            if (inicio == -1) return "";
            inicio += patron.length();

            int fin = json.indexOf(",", inicio);

            if (fin == -1) fin = json.indexOf("\n", inicio);
            return json.substring(inicio, fin).trim();
        }

        inicio += patron.length();
        int fin = json.indexOf("\"", inicio);

        return json.substring(inicio, fin);
    }

    private static String[] extraerArray(String json, String clave) {
        String patron = "\"" + clave + "\": [";
        int inicio = json.indexOf(patron);

        if (inicio == -1) return new String[0];
        inicio += patron.length();
        int fin = json.indexOf("]", inicio);
        String contenido = json.substring(inicio, fin);

        if (contenido.trim().isEmpty()) return new String[0];

        List<String> items = new ArrayList<>();
        String[] partes = contenido.split(",");

        for (String parte : partes) {
            String limpio = parte.trim().replaceAll("\"", "");
            if (!limpio.isEmpty()) items.add(limpio);
        }

        return items.toArray(new String[0]);
    }
}
