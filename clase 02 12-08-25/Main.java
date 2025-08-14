public class Main {
    public static void main(String[] args) {
        
    }
}

class Medallon {
    protected String nombre;
    protected int precio;
    
    public Medallon(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}

class Ingrediente {
    protected String nombre;
    protected int precio;
    
    public Ingrediente(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}

class Pan {
    protected String nombre;
    protected int precio;
    
    public Pan(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}

class Hamburguesa {
    protected Medallon medallones;
    protected Ingrediente ingredientes;
    protected Pan pan;

    public Hamburguesa(Medallon medallones, Ingrediente ingredientes, Pan pan) {
        this.medallones = medallones;
        this.ingredientes = ingredientes;
        this.pan = pan;
    }
}
