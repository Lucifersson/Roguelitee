package Entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Entidad {

    //Atributos de Identificación y Narrativa

    protected final String id;
    protected final String nombre;
    protected final String descripcion;

    //TEXTO DIÁLOGO O LA PREGUNTA PRINCIPAL DE LA ENTIDAD
    protected final String pregunta;

    //Constructor
    public Entidad(String id, String nombre, String descripcion,String pregunta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
        interacciones.addAll(calcularInteraccioneExtra(jugador));

        return interacciones;
    }
    //Metodo que obliga a cada subclase a definir sus 4 ocpiones base
    public abstract List<String> getInteraccionesBase();

    //Metodo que obliga a la subclase a definir cómo se manejan la opción seleccionada
    public abstract String interactuar(Jugador jugador, String seleccion) throws InterruptedException;

    // Lógica de Interaccion Extra delegada (Calculable)

    protected final List<String> calcularInteraccioneExtra(Jugador jugador){
        //Por defecto no hay interacciones extra
        return new ArrayList<>(); // Placeholder
    }

}