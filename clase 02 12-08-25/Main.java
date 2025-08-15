import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Ejemplo 1: Hamburguesa VÁLIDA basada en el ejemplo dado
        // Pan de papa ($4500) + 1 medallón pollo ($1500) + 1 medallón carne ($2900) + cheddar ($600) + berenjena ($350) = $9850
        System.out.println("=== EJEMPLO 1: Hamburguesa VÁLIDA ===");
        Hamburguesa hamburguesa1 = new Hamburguesa();
        hamburguesa1.establecerPan(new Pan("Pan de papa", 4500));
        hamburguesa1.agregarMedallon(new Medallon("Pollo", 1500));
        hamburguesa1.agregarMedallon(new Medallon("Carne", 2900));
        hamburguesa1.agregarIngrediente(new Ingrediente("Cheddar", 600));
        hamburguesa1.agregarIngrediente(new Ingrediente("Berenjena", 350));
        
        hamburguesa1.mostrarDetalles();
        System.out.println("Total: $" + hamburguesa1.getTotalPrecio());
        
        // Ejemplo 2: Hamburguesa INVÁLIDA basada en el ejemplo dado
        // Pan de campo ($5500) + 1 medallón vegetariano ($1890) + berenjena ($350) + cheddar ($600)
        // INVÁLIDA: 2 ingredientes > 1 medallón
        System.out.println("\n=== EJEMPLO 2: Hamburguesa INVÁLIDA (más ingredientes que medallones) ===");
        Hamburguesa hamburguesa2 = new Hamburguesa();
        hamburguesa2.establecerPan(new Pan("Pan de campo", 5500));
        hamburguesa2.agregarMedallon(new Medallon("Vegetariano", 1890));
        hamburguesa2.agregarIngrediente(new Ingrediente("Berenjena", 350));
        hamburguesa2.agregarIngrediente(new Ingrediente("Cheddar", 600));
        
        hamburguesa2.mostrarDetalles();
        System.out.println("Total: $" + hamburguesa2.getTotalPrecio());
        
        // Ejemplo 3: Corrigiendo la hamburguesa inválida agregando un medallón
        System.out.println("\n=== EJEMPLO 3: Corrigiendo agregando un medallón ===");
        hamburguesa2.agregarMedallon(new Medallon("Pollo", 1500));
        hamburguesa2.mostrarDetalles();
        System.out.println("Total: $" + hamburguesa2.getTotalPrecio());
        
        // Ejemplo 4: Hamburguesa sin pan (INVÁLIDA)
        System.out.println("\n=== EJEMPLO 4: Sin pan (INVÁLIDA - falta precio base) ===");
        Hamburguesa hamburguesa4 = new Hamburguesa();
        hamburguesa4.agregarMedallon(new Medallon("Carne", 2000));
        hamburguesa4.agregarIngrediente(new Ingrediente("Queso", 500));
        
        hamburguesa4.mostrarDetalles();
        System.out.println("Total: $" + hamburguesa4.getTotalPrecio());
        
        // Ejemplo 5: Solo pan (INVÁLIDA - falta medallón)
        System.out.println("\n=== EJEMPLO 5: Solo pan (INVÁLIDA - falta medallón) ===");
        Hamburguesa hamburguesa5 = new Hamburguesa();
        hamburguesa5.establecerPan(new Pan("Pan integral", 3000));
        
        hamburguesa5.mostrarDetalles();
        System.out.println("Total: $" + hamburguesa5.getTotalPrecio());
    }
}

interface ComponenteHamburguesa {
    String getNombre();
    int getPrecio();
}

abstract class ComponenteBase implements ComponenteHamburguesa {
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

class Medallon extends ComponenteBase {
    public Medallon(String nombre, int precio) { super(nombre, precio); }
}

class Ingrediente extends ComponenteBase {
    public Ingrediente(String nombre, int precio) { super(nombre, precio); }
}

class Pan extends ComponenteBase {
    public Pan(String nombre, int precio) { super(nombre, precio); }
}

class Hamburguesa {
    private final List<ComponenteHamburguesa> medallones;
    private final List<ComponenteHamburguesa> ingredientes;
    private ComponenteHamburguesa pan;

    // Constructor vacío para crear hamburguesa dinámicamente
    public Hamburguesa() {
        this.medallones = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
        this.pan = null;
    }

    // Constructor original por si se quiere crear con componentes iniciales
    public Hamburguesa(List<ComponenteHamburguesa> medallones, List<ComponenteHamburguesa> ingredientes, ComponenteHamburguesa pan) {
        this.medallones = new ArrayList<>(medallones);
        this.ingredientes = new ArrayList<>(ingredientes);
        this.pan = pan;
    }
    
    // Métodos para agregar componentes dinámicamente
    public void agregarMedallon(ComponenteHamburguesa medallon) {
        medallones.add(medallon);
    }
    
    public void agregarIngrediente(ComponenteHamburguesa ingrediente) {
        ingredientes.add(ingrediente);
    }
    
    public void establecerPan(ComponenteHamburguesa pan) {
        this.pan = pan;
    }
    
    // Validación de estándares para hamburguesa que se puede facturar
    // Estándares: pan obligatorio (precio base), min 1 medallón, ingredientes <= medallones
    public boolean cumpleEstandares() {
        return tienePan() && tieneAlMenosUnMedallon() && noTieneMasIngredientesQueMedallones();
    }
    
    private boolean tienePan() {
        return pan != null;
    }
    
    private boolean tieneAlMenosUnMedallon() {
        return !medallones.isEmpty();
    }
    
    private boolean noTieneMasIngredientesQueMedallones() {
        return ingredientes.size() <= medallones.size();
    }
    
    // Ejemplos de otros estándares que se podrían implementar:
    /*
    private boolean tieneAlMenosDosMedallones() {
        return medallones.size() >= 2;
    }
    
    private boolean tieneMaximoCincoIngredientes() {
        return ingredientes.size() <= 5;
    }
    
    private boolean tienePrecioMinimo(int precioMinimo) {
        return getTotalPrecioInterno() >= precioMinimo;
    }
    */
    
    // Método para obtener qué estándares faltan
    public List<String> getEstandaresFaltantes() {
        List<String> faltantes = new ArrayList<>();
        
        if (!tienePan()) {
            faltantes.add("- Debe tener un pan (precio base)");
        }
        if (!tieneAlMenosUnMedallon()) {
            faltantes.add("- Debe tener al menos un medallón");
        }
        if (!noTieneMasIngredientesQueMedallones()) {
            faltantes.add("- No puede tener más ingredientes extras (" + ingredientes.size() + 
                        ") que medallones (" + medallones.size() + ")");
            faltantes.add("  → Solución: agregar un medallón o quitar " + 
                        (ingredientes.size() - medallones.size()) + " ingrediente(s)");
        }
        
        return faltantes;
    }
    
    public void mostrarDetalles() {
        if (!cumpleEstandares()) {
            System.out.println("❌ No se puede facturar la hamburguesa - No cumple con los estándares:");
            getEstandaresFaltantes().forEach(System.out::println);
            return;
        }
        
        System.out.println("✅ Hamburguesa lista para facturar:");
        System.out.println("Pan (precio base): " + pan.getNombre() + " ($" + pan.getPrecio() + ")");
        System.out.println("Medallones: " + medallones.size() + " unidades");
        medallones.forEach(m -> System.out.println("  " + m.getNombre() + " ($" + m.getPrecio() + ")"));
        
        if (ingredientes.isEmpty()) {
            System.out.println("Ingredientes extras: Ninguno");
        } else {
            System.out.println("Ingredientes extras: " + ingredientes.size() + " de " + medallones.size() + " máximos");
            ingredientes.forEach(i -> System.out.println("  " + i.getNombre() + " ($" + i.getPrecio() + ")"));
        }
    }

    public int getTotalPrecio() {
        if (!cumpleEstandares()) {
            System.out.println("⚠️  No se puede facturar - Hamburguesa no cumple estándares");
            return 0;
        }
        
        // Precio base (pan) + medallones + ingredientes extras
        int total = pan.getPrecio() + 
                    medallones.stream().mapToInt(ComponenteHamburguesa::getPrecio).sum() +
                    ingredientes.stream().mapToInt(ComponenteHamburguesa::getPrecio).sum();
        
        return total;
    }
}
