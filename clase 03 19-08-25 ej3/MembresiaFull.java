public class MembresiaFull extends Membresia {

    public MembresiaFull(int id, int dni) {
        super(id, dni);
    }

    @Override
    public boolean podesHacer(Actividad actividad) {
        return true; // puede realizar cualquier actividad
    }
}
