package Entidades;// Se asumen estas importaciones necesarias

// import com.roguelike.personaje.Personaje; 
// import com.roguelike.juego.Encuentro; 

import java.util.List;

/**
 * Clase base (Abstracta) para todos los objetos (Items) del juego.
 * Define la estructura y los métodos de interacción para todos los items,
 * distinguiendo entre efectos directos (uso/consumo) y efectos de encuentro.
 */
public abstract class Item {

	// --- Atributos de Identificación y Descripción ---

	/**
	 * El ID único del objeto en la base de datos MySQL (para carga de Data
	 * Maestra).
	 */
	protected String idMySQL;

	/** El nombre del objeto, mostrado en la terminal. */
	protected String nombre;

	/** Una descripción breve para el inventario o la tienda. */
	protected String descripcion;

	/** El valor del objeto para su compra o venta en la tienda. */
	protected int valor;

	// --- Atributos de Efecto (Modificadores) ---

	/**
	 * * Indica si el objeto desbloquea interacciones especiales.
	 * Es clave para la "Comprobación de Interacción por Item" en el flujo del
	 * encuentro.
	 */
	protected boolean esActivadorDeInteraccion;

	/** Indica si el objeto se consume (desaparece del inventario) al ser usado. */
	protected boolean esConsumible;

	// ------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------

	/**
	 * Constructor base para inicializar un objeto a partir de los datos cargados
	 * desde MySQL.
	 * 
	 * @param idMySQL      ID de la base de datos.
	 * @param nombre       Nombre del objeto.
	 * @param descripcion  Descripción del objeto.
	 * @param valor        Valor de compra/venta.
	 * @param esActivador  Indica si tiene interacción especial en encuentros.
	 * @param esConsumible Indica si el item se destruye al usarlo.
	 */
	public Item(String idMySQL, String nombre, String descripcion, int valor, boolean esActivador,
			boolean esConsumible) {
		this.idMySQL = idMySQL;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.esActivadorDeInteraccion = esActivador;
		this.esConsumible = esConsumible;
	}

	// ------------------------------------------------------------------
	// MÉTODOS ABSTRACTOS CLAVE
	// ------------------------------------------------------------------

	/**
	 * 🟢 **MÉTODO ABSTRACTO REQUERIDO**
	 * Define el efecto directo que ocurre cuando el jugador utiliza el objeto
	 * (e.g., consumir una poción, leer un mapa, ganar Cordura).
	 * 
	 * @param personaje El objeto Personaje que usa el item.
	 * @return true si el efecto fue aplicado con éxito (permite manejar fallos o
	 *         requisitos).
	 */
	public abstract boolean aplicarEfectoDirecto(Jugador jugador);

	/**
	 * 🟡 **MÉTODO ABSTRACTO REQUERIDO**
	 * Define cómo este item puede modificar o generar una interacción en un
	 * Encuentro.
	 * Esto se comprueba en el "Flujo de un Encuentro con NPC".
	 * 
	 * @param personaje El objeto Personaje.
	 * @param encuentro El Encuentro actual (NPC, situación).
	 * @return true si el item causó una modificación o interacción especial (pasa a
	 *         la siguiente fase del flujo).
	 */
	public abstract boolean activarInteraccionEnEncuentro(Jugador jugador, Entidad evento);

	// ------------------------------------------------------------------
	// MÉTODOS PÚBLICOS Y GETTERS
	// ------------------------------------------------------------------

	/**
	 * Devuelve una representación del objeto para mostrarlo en el
	 * inventario/tienda.
	 * 
	 * @return String formateado.
	 */
	@Override
	public String toString() {
		return nombre + " (Valor: " + valor + (esConsumible ? " | Consumible)" : " | Persistente)");
	}

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

	public boolean esActivadorDeInteraccion() {
		return esActivadorDeInteraccion;
	}
}
