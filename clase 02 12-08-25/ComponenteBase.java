public abstract class ComponenteBase implements ComponenteHamburguesa {
    protected final String nombre;
    protected final int precio;
    
    public ComponenteBase(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public String getNombre() { return nombre; }
    @Override
    public int getPrecio() { return precio; }
}
