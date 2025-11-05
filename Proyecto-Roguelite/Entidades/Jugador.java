package entidades;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    // --- Atributos de Identificación ---
    private String nombre;
    private String genero; // Hombre, Mujer, Otro
    private String clase;  // Por ejemplo: "Erudito", "Nómada", etc.

    // --- Estadísticas (0 - 20) ---
    private int cordura;       // Vida principal
    private int carisma;
    private int intimidacion;
    private int inteligencia;
    private int suerte;

    // --- Inventario limitado ---
    private final List<String> inventario;
    private static final int LIMITE_INVENTARIO = 3;

    // --- Constructor ---
    public Jugador(String nombre, String genero, String clase,
                   int cordura, int carisma, int intimidacion, int inteligencia, int suerte) {

        this.nombre = nombre;
        this.genero = genero;
        this.clase = clase;
        this.cordura = limitar(cordura);
        this.carisma = limitar(carisma);
        this.intimidacion = limitar(intimidacion);
        this.inteligencia = limitar(inteligencia);
        this.suerte = limitar(suerte);
        this.inventario = new ArrayList<>();
    }

    // --- Getters básicos ---
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public String getClase() { return clase; }

    public int getCordura() { return cordura; }
    public int getCarisma() { return carisma; }
    public int getIntimidacion() { return intimidacion; }
    public int getInteligencia() { return inteligencia; }
    public int getSuerte() { return suerte; }

    public List<String> getInventario() { return inventario; }

    // --- Métodos de modificación ---
    public void reducirCarisma(int cantidad) {
        carisma -= cantidad;
        if (carisma < 0) carisma = 0;
    }

    public void reducirCordura(int cantidad) {
        cordura -= cantidad;
        if (cordura < 0) cordura = 0;
    }

    public void reducirSuerte(int cantidad) {
        suerte -= cantidad;
        if (suerte < 0) suerte = 0;
    }

    public void reducirInteligencia(int cantidad) {
        inteligencia -= cantidad;
        if (inteligencia < 0) inteligencia = 0;
    }

    public void reducirIntimidacion(int cantidad) {
        intimidacion -= cantidad;
        if (intimidacion < 0) intimidacion = 0;
    }

    public void aumentarSuerte(int cantidad) {
        suerte += cantidad;
        if (suerte > 20) suerte = 20;
    }

    public void aumentarCordura(int cantidad) {
        cordura += cantidad;
        if (cordura > 20) cordura = 20;
    }

    public void aumentarIntimidacion(int cantidad) {
        intimidacion += cantidad;
        if (intimidacion > 20) intimidacion = 20;
    }

    public void aumentarCarisma(int cantidad) {
        carisma += cantidad;
        if (carisma > 20) carisma = 20;
    }

    public void aumentarInteligencia(int cantidad) {
        inteligencia += cantidad;
        if (inteligencia > 20) inteligencia = 20;
    }


    public void modificarEstadistica(String tipo, int cantidad) {
        switch (tipo.toLowerCase()) {
            case "carisma":
                carisma = limitar(carisma + cantidad);
                break;
            case "intimidacion":
                intimidacion = limitar(intimidacion + cantidad);
                break;
            case "inteligencia":
                inteligencia = limitar(inteligencia + cantidad);
                break;
            case "suerte":
                suerte = limitar(suerte + cantidad);
                break;
            case "cordura":
                cordura = limitar(cordura + cantidad);
                break;
        }
    }

    private int limitar(int valor) {
        if (valor < 0) return 0;
        if (valor > 20) return 20;
        return valor;
    }

    // --- Inventario ---
    public boolean agregarItem(String item) {
        if (inventario.size() >= LIMITE_INVENTARIO) {
            return false; // no hay espacio
        }
        inventario.add(item);
        return true;
    }

    public boolean eliminarItem(String item) {
        return inventario.remove(item);
    }

    public boolean tieneItem(String item) {
        return inventario.contains(item);
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Inventario vacío.");
        } else {
            System.out.println("Inventario:");
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println((i + 1) + ". " + inventario.get(i));
            }
        }
    }

    // --- Estado del jugador ---
    public boolean estaVivo() {
        return cordura > 0;
    }

    // --- Representación ---
    @Override
    public String toString() {
        return "Jugador: " + nombre +
                " (" + genero + ", " + clase + ")\n" +
                "Cordura: " + cordura +
                " | Carisma: " + carisma +
                " | Intimidación: " + intimidacion +
                " | Inteligencia: " + inteligencia +
                " | Suerte: " + suerte;
    }
}
