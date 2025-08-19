public abstract class Membresia {
    protected int id;
    protected int dni;

    public Membresia(int id, int dni) {
        this.id = id;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public abstract boolean podesHacer(Actividad actividad);
}
