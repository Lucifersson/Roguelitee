package Entidades.Items;

import Entidades.Item;

public class Uranio235 extends Item {

	/**
	 * Objeto pasivo: Uranio 235.
	 * Bonificaciones: +3 Inteligencia, +2 Suerte.
	 * Penalización severa: -5 Cordura.
	 */
	public Uranio235() {
		super(
				"ITEM_URANIO_235", // idMySQL
				"Uranio 235", // nombre
				"Material altamente inestable y radiactivo. Ofrece gran poder, pero envenena la mente.",
				700, // valor (Muy alto, objeto raro)

				-5, // modCordura: -5 (¡Severa! Radiación o miedo a la inestabilidad)
				0, // modCarisma
				0, // modIntimidacion
				3, // modInteligencia: +3 (Símbolo de alta tecnología o conocimiento)
				2 // modSuerte: +2 (Atracción de eventos extremos)
		);
	}
}
