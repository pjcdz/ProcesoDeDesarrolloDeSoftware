
import java.util.*;

/**
 * Interface que define el comportamiento común de todos los socios del club
 * Implementa el patrón Composite para manejar tanto socios individuales como el club
 */
interface Socio {
    // Punto 1: Conocer de cualquier socio su información básica
    String getNombre();
    int getNivel();
    float getPuntos();
    List<Socio> getReferidos();
    
    // Punto 4: Contador total de socios del club
    int getCounterMiembros();
    void addCounterMiembros();
    
    // Métodos para modificar estado
    int setNivel(int nivel);
    void setPuntos(float puntos);
}

/**
 * Clase que representa a un socio individual del club
 * Cada socio tiene nombre, nivel, puntos y puede tener referidos
 */
class SocioImpl implements Socio {
    private String nombre;
    private int nivel;
    private float puntos;
    private List<Socio> referidos;
    private static int counterMiembros = 0; // Contador estático global
    
    public SocioImpl(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntos = 0;
        this.referidos = new ArrayList<>();
        counterMiembros++; // Se incrementa automáticamente al crear cada socio
    }
    
    // Punto 1: Conocer información del socio
    public String getNombre() {
        return nombre;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public float getPuntos() {
        return puntos;
    }
    
    public List<Socio> getReferidos() {
        return referidos;
    }
    
    // Punto 4: Contar total de socios
    public int getCounterMiembros() {
        return counterMiembros;
    }
    
    public void addCounterMiembros() {
        counterMiembros += 1;
    }
    
    // Punto 3: Asignar nivel al referir (nivel del referidor + 1)
    public int setNivel(int nivel) {
        return nivel + 1;
    }
    
    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }
    
    // Punto 3: Referir a un socio y asignar su nivel automáticamente
    public void agregarReferido(String nombreReferido) {
        int nivelReferido = setNivel(this.nivel);
        SocioImpl nuevoReferido = new SocioImpl(nombreReferido, nivelReferido);
        this.referidos.add(nuevoReferido);
    }
}

/**
 * Clase que representa el club con sus 5 socios fundadores
 * Implementa la lógica de distribución de puntos
 */
class Club implements Socio {
    private List<Socio> fundadores;
    
    public Club() {
        // Punto 2: Agregar 5 socios fundadores (nivel 0) al club
        fundadores = new ArrayList<>();
        fundadores.add(new SocioImpl("Ana", 0));
        fundadores.add(new SocioImpl("Luis", 0));
        fundadores.add(new SocioImpl("María", 0));
        fundadores.add(new SocioImpl("Carlos", 0));
        fundadores.add(new SocioImpl("Sofia", 0));
    }
    
    // Punto 5: Entregar puntos y distribuir la mitad entre referidos
    public void entregarPuntos(float cantidad, Socio receptorPuntos) {
        // El socio se queda con la mitad de los puntos recibidos
        float puntosParaElSocio = cantidad / 2;
        receptorPuntos.setPuntos(receptorPuntos.getPuntos() + puntosParaElSocio);
        
        // La otra mitad se reparte entre los referidos
        if (!receptorPuntos.getReferidos().isEmpty()) {
            float puntosParaRepartir = cantidad / 2;
            float puntosPorReferido = puntosParaRepartir / receptorPuntos.getReferidos().size();
            
            // Distribución recursiva: cada referido reparte a su vez la mitad de lo que recibe
            for (Socio socio : receptorPuntos.getReferidos()) {
                entregarPuntos(puntosPorReferido, socio);
            }
        } else {
            // Si no tiene referidos, se queda con todos los puntos
            receptorPuntos.setPuntos(receptorPuntos.getPuntos() + (cantidad / 2));
        }
    }
    
    public List<Socio> getFundadores() {
        return fundadores;
    }
    
    // Implementación de métodos de la interface (el club actúa como contenedor)
    public String getNombre() { return "Estafa Piramidal"; }
    public int getNivel() { return -1; }
    public float getPuntos() { return 0; }
    public List<Socio> getReferidos() { return fundadores; }
    public int getCounterMiembros() { return fundadores.get(0).getCounterMiembros(); }
    public void addCounterMiembros() { }
    public int setNivel(int nivel) { return -1; }
    public void setPuntos(float puntos) { }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Socios ===");
        
        // Punto 2: Crear club con 5 socios fundadores
        Club club = new Club();
        
        System.out.println("\n--- Punto 1: Información de fundadores ---");
        for (Socio fundador : club.getFundadores()) {
            System.out.println("Fundador: " + fundador.getNombre() + 
                             " - Nivel: " + fundador.getNivel() + 
                             " - Puntos: " + fundador.getPuntos());
        }
        
        // Punto 3: Referir socios y asignar niveles
        System.out.println("\n--- Punto 3: Referir socios ---");
        SocioImpl ana = (SocioImpl) club.getFundadores().get(0);
        ana.agregarReferido("Pedro");  // Pedro será nivel 1
        ana.agregarReferido("Juan");   // Juan será nivel 1
        
        SocioImpl pedro = (SocioImpl) ana.getReferidos().get(0);
        pedro.agregarReferido("Miguel"); // Miguel será nivel 2
        
        SocioImpl luis = (SocioImpl) club.getFundadores().get(1);
        luis.agregarReferido("Carmen"); // Carmen será nivel 1
        
        // Mostrar estructura jerárquica
        mostrarEstructuraCompleta(ana, 0);
        mostrarEstructuraCompleta(luis, 0);
        
        // Punto 4: Contar total de socios
        System.out.println("\n--- Punto 4: Total de socios ---");
        System.out.println("Total de socios en el club: " + club.getCounterMiembros());
        
        // Punto 5: Entregar puntos y distribuir
        System.out.println("\n--- Punto 5: Distribución de puntos ---");
        System.out.println("Entregando 100 puntos a Ana...");
        club.entregarPuntos(100, ana);
        
        System.out.println("\nPuntos después de la distribución:");
        System.out.printf("Ana (nivel 0): %.2f puntos%n", ana.getPuntos());
        for (Socio referido : ana.getReferidos()) {
            System.out.printf("%s (nivel %d): %.2f puntos%n", 
                            referido.getNombre(), referido.getNivel(), referido.getPuntos());
            
            // Mostrar referidos de segundo nivel
            for (Socio subReferido : referido.getReferidos()) {
                System.out.printf("  %s (nivel %d): %.2f puntos%n", 
                                subReferido.getNombre(), subReferido.getNivel(), subReferido.getPuntos());
            }
        }
    }
    
    /**
     * Método auxiliar para mostrar la estructura jerárquica de referidos
     */
    private static void mostrarEstructuraCompleta(Socio socio, int profundidad) {
        String indentacion = "  ".repeat(profundidad);
        System.out.println(indentacion + "- " + socio.getNombre() + 
                          " (Nivel: " + socio.getNivel() + ")");
        
        for (Socio referido : socio.getReferidos()) {
            mostrarEstructuraCompleta(referido, profundidad + 1);
        }
    }
}


