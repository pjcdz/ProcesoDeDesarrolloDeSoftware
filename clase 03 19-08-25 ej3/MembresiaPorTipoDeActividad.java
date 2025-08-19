public class MembresiaPorTipoDeActividad implements Membresia {
    private String tipo;

    public MembresiaPorTipoDeActividad(String tipo) {
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
