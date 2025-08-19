public class Miembro {
    private String nombre;
    private int dni;
    private Membresia membresia;
    
    public Miembro(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
    
    public boolean podesHacerActividad(Actividad actividad) {
        return membresia.podesHacer(actividad);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getDni() {
        return dni;
    }
}
