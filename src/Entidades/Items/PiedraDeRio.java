package Entidades.Items;

import Entidades.Item;

public class PiedraDeRio extends Item {

	/**
	 * Objeto pasivo: Piedra de Río.
	 * Bonificaciones: +1 Cordura.
	 * Sin penalizaciones.
	 */
	public PiedraDeRio() {
		super(
				"ITEM_PIEDRA_RIO", // idMySQL
				"Piedra de Río", // nombre
				"Una piedra pulida y lisa. Calma los nervios al tocarla.",
				40, // valor (Muy bajo, común)

				1, // modCordura: +1 (Pequeño aumento de bienestar)
				0, // modCarisma
				0, // modIntimidacion
				0, // modInteligencia
				0 // modSuerte
		);
	}
}
