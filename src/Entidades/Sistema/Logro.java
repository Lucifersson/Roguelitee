package Entidades.Sistema;

public class Logro {
    private String id;
    private String nombre;
    private String descripcion;
    private String pista;
    private String categoria;
    private boolean oculto;
    private boolean desbloqueado;

    // Constructor vacío para JSON
    public Logro() {}

    // Constructor completo
    public Logro(String id, String nombre, String descripcion, String pista, String categoria, boolean oculto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pista = pista;
        this.categoria = categoria;
        this.oculto = oculto;
        this.desbloqueado = false;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPista() {
        return pista;
    }
    public void setPista(String pista) {
        this.pista = pista;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public boolean isOculto() {
        return oculto;
    }
    public void setOculto(boolean oculto) {
        this.oculto = oculto;
    }
    public boolean isDesbloqueado() {
        return desbloqueado;
    }
    public void setDesbloqueado(boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }

    public void marcarDesbloqueado() { this.desbloqueado = true; }

    @Override
    public String toString() {
        if (desbloqueado) {
            return "✓ " + nombre + " - " + descripcion;
        } else if (oculto) {
            return "? " + nombre + " - [LOGRO SECRETO]";
        } else {
            return "✗ " + nombre + " - " + pista;
        }
    }
}
