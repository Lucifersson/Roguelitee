package Entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Entidad {

    //Atributos de Identificación y Narrativa
    protected final String id;
    protected final String nombre;
    protected final String descripcion;
    protected int cantExtra;

    //TEXTO DIÁLOGO O LA PREGUNTA PRINCIPAL DE LA ENTIDAD
    protected final String pregunta;

    //Constructor
    public Entidad(String id, String nombre, String descripcion, String pregunta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantExtra = 0; /*Por defecto a 0*/
        this.pregunta = pregunta;
    }

    //Metodos de acceso Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPregunta() {
        return pregunta;
    }
    // Devuelve una lista de posibles interacciones con la entidad en la que debe combinar
    //las 4 interacciones base de la subclase más la extra calculadas

    public final List<String> getInteraccionesDisponibles(Jugador jugador) {
        //Obtener las opciones base (4) definidas por la subcclase
        List<String> interacciones = getInteraccionesBase();

        //Obtener la interacción extra calculadas en tiempo de ejecución
        ArrayList<ArrayList<String>> listaExtra = calcularInteraccionExtra(jugador, this.id);

        if (!listaExtra.isEmpty()) {
            for (ArrayList<String> extra : listaExtra) {
                interacciones.add(extra.get(1));
            }
        }

        return interacciones;
    }
    //Metodo que obliga a cada subclase a definir sus 4 ocpiones base
    public abstract List<String> getInteraccionesBase();

    //Metodo que obliga a la subclase a definir cómo se manejan la opción seleccionada
    public abstract String interactuar(Jugador jugador, String seleccion) throws InterruptedException;

    // Lógica de Interaccion Extra delegada (Calculable)

    protected final ArrayList<ArrayList<String>> calcularInteraccionExtra(Jugador jugador, String id){
        /* "1. Comer una galleta" <- El arraylist debe devolver solo el enunciado*/
        ArrayList<ArrayList<String>> interaccionesExtra = BBDD.BBDD.conectarBaseDatos(jugador, id);

        this.cantExtra = interaccionesExtra.size();
        return interaccionesExtra;
    }

}