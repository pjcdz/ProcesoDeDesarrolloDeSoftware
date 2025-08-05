public class MembresiaPorTipoDeActividad extends Membresia {
    private String tipo;

    public MembresiaPorTipoDeActividad(int id, int dni, String tipo) {
        super(id, dni);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean podesHacer(Actividad actividad) {
        return actividad.getTipo().equals(tipo);
    }
}
