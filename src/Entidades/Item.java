package Entidades;

/**
 * Clase base para todos los objetos (Items) del juego.
 * Los items actúan como modificadores pasivos permanentes de estadísticas
 * mientras se encuentran en el inventario del Jugador.
 *
 * Esta clase no es abstracta y está lista para ser extendida por objetos
 * concretos.
 */
public class Item {

	// --- Atributos de Identificación y Descripción ---
	protected String idMySQL;
	protected String nombre;
	protected String descripcion;
	protected int valor; // Valor de compra/venta en la tienda

	// --- Atributos de Modificación Pasiva de Estadísticas ---
	// Valores de modificación que se aplican al Jugador.
	protected int modCordura;
	protected int modCarisma;
	protected int modIntimidacion;
	protected int modInteligencia;
	protected int modSuerte;

	// ------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------

	/**
	 * Constructor base para inicializar un objeto Item con sus atributos y
	 * modificadores.
	 * 
	 * @param idMySQL         ID de la base de datos (clave).
	 * @param nombre          Nombre del objeto.
	 * @param descripcion     Descripción breve.
	 * @param valor           Valor de compra/venta.
	 * @param modCordura      Modificador de Cordura.
	 * @param modCarisma      Modificador de Carisma.
	 * @param modIntimidacion Modificador de Intimidación.
	 * @param modInteligencia Modificador de Inteligencia.
	 * @param modSuerte       Modificador de Suerte.
	 */
	public Item(String idMySQL, String nombre, String descripcion, int valor,
			int modCordura, int modCarisma, int modIntimidacion,
			int modInteligencia, int modSuerte) {

		this.idMySQL = idMySQL;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.modCordura = modCordura;
		this.modCarisma = modCarisma;
		this.modIntimidacion = modIntimidacion;
		this.modInteligencia = modInteligencia;
		this.modSuerte = modSuerte;
	}

	// ------------------------------------------------------------------
	// GETTERS
	// ------------------------------------------------------------------

	public int getModCordura() {
		return modCordura;
	}

	public int getModCarisma() {
		return modCarisma;
	}

	public int getModIntimidacion() {
		return modIntimidacion;
	}

	public int getModInteligencia() {
		return modInteligencia;
	}

	public int getModSuerte() {
		return modSuerte;
	}

	// Getters para la información básica
	public String getIdMySQL() {
		return idMySQL;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return nombre + " (Valor: " + valor + ")";
	}
}
