public class MembresiaDePrueba extends Membresia {
    private int cantidadMaxima = 1;
    private String tipo;

    public MembresiaDePrueba(int id, int dni, String tipo) {
        super(id, dni);
        this.tipo = tipo;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public String getTipoMembresia() {
        return tipo;
    }

    @Override
    public boolean podesHacer(Actividad actividad) {
        return getCantidadMaxima() > 0 && actividad.getTipoActividad().equals(getTipoMembresia()); 
        // puede realizar la actividad si aún no ha alcanzado el límite y es del tipo correcto
    }
}
