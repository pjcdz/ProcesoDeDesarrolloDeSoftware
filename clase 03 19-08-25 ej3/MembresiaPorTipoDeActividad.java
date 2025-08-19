public class MembresiaPorTipoDeActividad extends Membresia {
    private String tipo;

    public MembresiaPorTipoDeActividad(int id, int dni, String tipo) {
        super(id, dni);
        this.tipo = tipo;
    }

    public String getTipoMembresia() {
        return tipo;
    }

    @Override
    public boolean podesHacer(Actividad actividad) {
        return actividad.getTipoActividad().equals(getTipoMembresia());
    }
}
