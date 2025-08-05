public class MembresiaPorCantidadDeActividades extends Membresia {
    private int cantidadMaxima;

    public MembresiaPorCantidadDeActividades(int id, int dni, int cantidadMaxima) {
        super(id, dni);
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    @Override
    public boolean podesHacer(Actividad actividad) {
        return getCantidadMaxima() > 0; // puede realizar la actividad si aún no ha alcanzado el límite
    }
}
