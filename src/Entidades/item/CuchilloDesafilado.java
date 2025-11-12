package Entidades;

public class CuchilloDesafilado extends Item {

	/**
	 * Objeto pasivo: Cuchillo Desafilado.
	 * Bonificaciones: +3 Intimidación.
	 * Penalización: -2 Cordura.
	 */
	public CuchilloDesafilado() {
		super(
				"ITEM_CUCHILLO", // idMySQL
				"Cuchillo Desafilado", // nombre
				"Un arma rudimentaria. Hace que la gente te evite, pero es una carga mental llevarlo.",
				90, // valor

				-2, // modCordura: -2 (Malestar o culpa pasiva)
				0, // modCarisma
				3, // modIntimidacion: +3 (Bonificación principal)
				0, // modInteligencia
				0 // modSuerte
		);
	}
}
