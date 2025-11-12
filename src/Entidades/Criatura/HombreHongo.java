package Entidades.Criatura;

import Entidades.Entidad;
import Entidades.Jugador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HombreHongo extends Entidad {

	// ... Atributos ID, NOMBRE, DESCRIPCION, PREGUNTA ...
	private final int danoMax = 8;
	private final int danoMin = 4;

	public HombreHongo() {
		super("HOMBRE_HONGO", "Hombre Hongo", "Una criatura tímida...", "Un ser cubierto de hongos... ¿Qué harás?");
	}

	@Override
	public List<String> getInteraccionesBase() {
		return Arrays.asList(
				"1. Darle un Fuerte Pisotón", // Consecuencia Fija: Daño Máximo
				"2. Pinchazo Rápido con un Dedo", // Consecuencia Fija: Daño Mínimo
				"3. Emitir un Sonido de 'Paz y Amor'", // Consecuencia Fija: Ganancia/Pérdida de item
				"4. Mantener la Respiración y Quedarse Quieto" // Consecuencia Fija: Ganancia/Pérdida de turno
		);
	}

	@Override
	public String interactuar(Jugador jugador, String seleccion) {
		switch (seleccion) {
			case "1. Darle un Fuerte Pisotón":
				jugador.reducirCordura(danoMax);
				return "El pisotón falla y tropiezas en el barro. Recibes **" + danoMax
						+ " de daño** por esporas concentradas.";

			case "2. Pinchazo Rápido con un Dedo":
				jugador.reducirCordura(danoMin);
				return "Fallaste la precisión y te pinchas con una seta. Recibes **" + danoMin
						+ " de daño** por veneno.";

			case "3. Emitir un Sonido de 'Paz y Amor'":
				// El castigo aquí es que el hongo se aprovecha de tu ingenuidad
				return "Tu aura de calma lo tranquiliza. El Hombre Hongo se retira, pero te ha robado una moneda.";

			case "4. Mantener la Respiración y Quedarse Quieto":
				return "Consigues quedarte perfectamente inmóvil y sin respirar. El Hongo te ignora y puedes pasar.";
            default:
                return interaccionExtra(jugador, seleccion, this.eventosExtra);
		}
	}

    public String interaccionExtra (Jugador jugador, String seleccion, ArrayList<ArrayList<String>> eventosExtra) {
        if (!eventosExtra.isEmpty()) {
            if (eventosExtra.get(0).get(0) == "1" && seleccion.equals("5")) {

            }
            else if (eventosExtra.get(1).get(0) == "1" && seleccion.equals("6")) {

            }
            else if (eventosExtra.get(0).get(0) == "2" && seleccion.equals("5")) {

            }
            else if (eventosExtra.get(1).get(0) == "2" && seleccion.equals("6")) {

            }
        }
        return "No entiendes bien qué hacer.";
    }
}
