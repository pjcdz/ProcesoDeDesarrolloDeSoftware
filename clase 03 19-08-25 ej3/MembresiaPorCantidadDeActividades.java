public class MembresiaPorCantidadDeActividades implements Membresia {
    private int cantidadMaxima;

    public MembresiaPorCantidadDeActividades(int cantidadMaxima) {
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
