import java.util.*;

public class Hamburguesa {
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
