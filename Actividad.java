public abstract class Actividad {
    protected String nombre;
    protected String tipo;
    protected String descripcion;

    public Actividad(String nombre, String tipo, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoActividad() {
        return tipo;
    }
}
