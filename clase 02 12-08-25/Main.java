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
