package Entidades.Items;

import Entidades.Item;

public class TrajeImpecable extends Item {

	/**
	 * Objeto pasivo: Traje Impecable.
	 * Bonificaciones: +2 Carisma, +1 Intimidación.
	 * Penalización: -1 Cordura.
	 */
	public TrajeImpecable() {
		super(
				"ITEM_TRAJE_IMPECABLE", // idMySQL
				"Traje Impecable", // nombre
				"Te da presencia en cualquier sala, pero la rigidez te estresa.",
				180, // valor

				-1, // modCordura: -1 (Estrés por incomodidad)
				2, // modCarisma: +2 (Aumenta la credibilidad y la presencia)
				1, // modIntimidacion: +1 (Aumenta la autoridad)
				0, // modInteligencia
				0 // modSuerte
		);
	}
}
