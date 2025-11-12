package Entidades.Items;

import Entidades.Item;

public class MonedaSuerte extends Item {

	/**
	 * Objeto pasivo: Moneda de la Suerte.
	 * Bonificaciones: +3 Suerte.
	 * Penalización: -1 Inteligencia.
	 */
	public MonedaSuerte() {
		super(
				"ITEM_MONEDA_SUERTE", // idMySQL
				"Moneda de la Suerte", // nombre
				"Una moneda antigua gastada por el roce. Su resplandor atrae la fortuna, pero distrae el pensamiento lógico.",
				200, // valor

				0, // modCordura
				0, // modCarisma
				0, // modIntimidacion
				-1, // modInteligencia (-1 por superstición/distracción)
				3 // modSuerte: +3 (Bonificación principal)
		);
	}
}
