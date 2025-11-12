package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	// --- Constantes --
	private static final int MAX_ESTADISTICA = 20;
	private static final int MIN_ESTADISTICA = 0;
	private static final int LIMITE_INVENTARIO = 3;

	// --- Atributos de Identificación ---
	private String nombre;
	private String genero; // Hombre, Mujer, Otro
	private String clase; // Por ejemplo: "Erudito", "Nómada", etc.

	// --- Estadísticas (0 - 20) ---
	private int cordura; // Vida principal
	private int carisma;
	private int intimidacion;
	private int inteligencia;
	private int suerte;

	// --- Inventario limitado (MODIFICADO: Almacena objetos Item) ---
	private final List<Item> inventario;

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
		this.inventario = new ArrayList<>(); // Inicializado como List<Item>
	}

	// ------------------------------------------------------------------
	// LÓGICA DE INVENTARIO Y MODIFICADORES PASIVOS
	// ------------------------------------------------------------------

	/**
	 * Aplica o revierte los modificadores de un Item.
	 * 
	 * @param item   El objeto Item cuyos modificadores se aplicarán.
	 * @param factor 1 para aplicar (añadir), -1 para revertir (eliminar).
	 */
	private void aplicarModificadoresPasivos(Item item, int factor) {
		// Aplica el modificador multiplicando por el factor (1 o -1)
		aumentarCordura(item.getModCordura() * factor);
		aumentarCarisma(item.getModCarisma() * factor);
		aumentarIntimidacion(item.getModIntimidacion() * factor);
		aumentarInteligencia(item.getModInteligencia() * factor);
		aumentarSuerte(item.getModSuerte() * factor);

		String accion = (factor == 1) ? "aplicados" : "revertidos";
		System.out.println("✅ Modificadores pasivos de " + item.getNombre() + " " + accion + ".");
	}

	// --- Inventario (MODIFICADO: Usa objetos Item) ---
	public boolean agregarItem(Item item) {
		if (inventario.size() >= LIMITE_INVENTARIO) {
			System.out.println("Inventario lleno. Debes descartar un objeto primero.");
			return false;
		}
		inventario.add(item);
		// APLICAR MODIFICADORES PASIVOS
		aplicarModificadoresPasivos(item, 1);
		return true;
	}

	public boolean eliminarItem(Item item) {
		if (inventario.remove(item)) {
			// REVERTIR MODIFICADORES PASIVOS
			aplicarModificadoresPasivos(item, -1);
			return true;
		}
		return false;
	}

	// Método modificado para buscar por nombre o referencia (asumiendo que se sigue
	// usando el nombre para las comprobaciones)
	public boolean tieneItem(String nombreItem) {
		for (Item item : inventario) {
			if (item.getNombre().equalsIgnoreCase(nombreItem)) {
				return true;
			}
		}
		return false;
	}

	// Método modificado para mostrar el inventario de Items
	public void mostrarInventario() {
		if (inventario.isEmpty()) {
			System.out.println("Inventario vacío.");
		} else {
			System.out.println("Inventario (" + inventario.size() + "/" + LIMITE_INVENTARIO + "):");
			for (int i = 0; i < inventario.size(); i++) {
				// Se usa el toString() de la clase Item
				System.out.println((i + 1) + ". " + inventario.get(i).toString());
			}
		}
	}

	// ------------------------------------------------------------------
	// MÉTODOS DE MODIFICACIÓN DE ESTADÍSTICAS
	// ------------------------------------------------------------------

	// Método de límite para todas las estadísticas
	private int limitar(int valor) {
		if (valor < MIN_ESTADISTICA)
			return MIN_ESTADISTICA;
		if (valor > MAX_ESTADISTICA)
			return MAX_ESTADISTICA;
		return valor;
	}

	// Los métodos de reducción y aumento originales se mantienen y se consolidan:

	public void reducirCarisma(int cantidad) {
		carisma -= cantidad;
		carisma = limitar(carisma);
	}

	public void reducirCordura(int cantidad) {
		cordura -= cantidad;
		cordura = limitar(cordura);
	}

	public void reducirSuerte(int cantidad) {
		suerte -= cantidad;
		suerte = limitar(suerte);
	}

	public void reducirInteligencia(int cantidad) {
		inteligencia -= cantidad;
		inteligencia = limitar(inteligencia);
	}

	public void reducirIntimidacion(int cantidad) {
		intimidacion -= cantidad;
		intimidacion = limitar(intimidacion);
	}

	public void aumentarSuerte(int cantidad) {
		suerte += cantidad;
		suerte = limitar(suerte);
	}

	public void aumentarCordura(int cantidad) {
		cordura += cantidad;
		cordura = limitar(cordura);
	}

	public void aumentarIntimidacion(int cantidad) {
		intimidacion += cantidad;
		intimidacion = limitar(intimidacion);
	}

	public void aumentarCarisma(int cantidad) {
		carisma += cantidad;
		carisma = limitar(carisma);
	}

	public void aumentarInteligencia(int cantidad) {
		inteligencia += cantidad;
		inteligencia = limitar(inteligencia);
	}

	// ------------------------------------------------------------------
	// GETTERS (Añadido getEstadistica genérico)
	// ------------------------------------------------------------------

	public int getEstadistica(String nombreEstadistica) {
		switch (nombreEstadistica.toLowerCase()) {
			case "cordura":
				return cordura;
			case "carisma":
				return carisma;
			case "intimidacion":
				return intimidacion;
			case "inteligencia":
				return inteligencia;
			case "suerte":
				return suerte;
			default:
				System.err.println("Error: Estadística '" + nombreEstadistica + "' no encontrada.");
				return 0;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getGenero() {
		return genero;
	}

	public String getClase() {
		return clase;
	}

	// Getters específicos (mantienen compatibilidad)
	public int getCordura() {
		return cordura;
	}

	public int getCarisma() {
		return carisma;
	}

	public int getIntimidacion() {
		return intimidacion;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getSuerte() {
		return suerte;
	}

	public List<Item> getInventario() {
		return inventario;
	} // Cambiado a List<Item>

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
