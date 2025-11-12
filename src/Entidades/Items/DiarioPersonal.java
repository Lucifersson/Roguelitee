package Entidades.Items;

import Entidades.Item;

public class DiarioPersonal extends Item {

	/**
	 * Objeto pasivo: Diario Personal.
	 * Bonificaciones: +2 Inteligencia, +1 Cordura.
	 * Penalización: -1 Intimidación.
	 */
	public DiarioPersonal() {
		super(
				"ITEM_DIARIO", // idMySQL
				"Diario Personal", // nombre
				"Un libro de cuero gastado con notas privadas. Fomenta la calma y el análisis.",
				75, // valor (Bajo, objeto inicial o común)

				1, // modCordura: +1 (Aumenta la calma y el bienestar mental)
				0, // modCarisma
				-1, // modIntimidacion: -1 (Te hace parecer menos amenazante)
				2, // modInteligencia: +2 (Fomenta la reflexión y el análisis)
				0 // modSuerte
		);
	}
}
