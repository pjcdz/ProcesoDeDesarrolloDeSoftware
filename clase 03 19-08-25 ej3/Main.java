/**
 * Clase principal para probar el sistema de membresías y actividades con patrón Strategy.
 * 
 * Este programa demuestra el uso del patrón Strategy donde cada miembro
 * puede cambiar su estrategia de membresía dinámicamente.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE MEMBRESÍAS CON PATRÓN STRATEGY ===\n");
        
        // Crear diferentes tipos de actividades
        Actividad spinning = new Actividad("Spinning", "Cardio", "Clase de ciclismo indoor");
        Actividad cinta = new Actividad("Cinta", "Cardio", "Ejercicio en cinta de correr");
        
        Actividad futbol = new Actividad("Fútbol", "Deportiva", "Partido de fútbol");
        Actividad tenis = new Actividad("Tenis", "Deportiva", "Clase de tenis");
        
        Actividad natacion = new Actividad("Natación", "Pileta", "Clases de natación");
        Actividad aquaerobicos = new Actividad("Aquaeróbicos", "Pileta", "Ejercicios acuáticos");
        
        // Crear diferentes estrategias de membresía
        Membresia membresiaFull = new MembresiaFull();
        Membresia membresiaCardio = new MembresiaPorTipoDeActividad("Cardio");
        Membresia membresiaDeportiva = new MembresiaPorTipoDeActividad("Deportiva");
        Membresia membresiaPileta = new MembresiaPorTipoDeActividad("Pileta");
        Membresia membresia3Actividades = new MembresiaPorCantidadDeActividades(3);
        Membresia membresiaPruebaCardio = new MembresiaDePrueba("Cardio");
        
        // Crear miembros del gimnasio
        Miembro juan = new Miembro("Juan Pérez", 12345678);
        Miembro maria = new Miembro("María García", 87654321);
        Miembro carlos = new Miembro("Carlos Rodríguez", 11223344);
        Miembro ana = new Miembro("Ana López", 55667788);
        Miembro pedro = new Miembro("Pedro Martínez", 99887766);
        Miembro lucia = new Miembro("Lucía Fernández", 44332211);
        
        // Asignar estrategias de membresía a cada miembro
        juan.setMembresia(membresiaFull);
        maria.setMembresia(membresiaCardio);
        carlos.setMembresia(membresiaDeportiva);
        ana.setMembresia(membresiaPileta);
        pedro.setMembresia(membresia3Actividades);
        lucia.setMembresia(membresiaPruebaCardio);
        
        // Array de miembros para probar
        Miembro[] miembros = { juan, maria, carlos, ana, pedro, lucia };
        
        // Array de actividades para probar
        Actividad[] actividades = { spinning, cinta, futbol, tenis, natacion, aquaerobicos };
        
        // Nombres descriptivos de los miembros y sus membresías
        String[] descripcionMiembros = {
            "Juan (Membresía Full)",
            "María (Membresía Cardio)", 
            "Carlos (Membresía Deportiva)",
            "Ana (Membresía Pileta)",
            "Pedro (Membresía 3 Actividades)",
            "Lucía (Membresía Prueba Cardio)"
        };
        
        // Probar cada miembro con cada actividad
        for (int i = 0; i < miembros.length; i++) {
            System.out.println("--- " + descripcionMiembros[i] + " ---");
            
            for (Actividad actividad : actividades) {
                boolean puedeHacer = miembros[i].podesHacerActividad(actividad);
                String resultado = puedeHacer ? "✓ SÍ" : "✗ NO";
                System.out.println(actividad.getNombre() + " (" + actividad.getTipoActividad() + "): " + resultado);
            }
            System.out.println();
        }
        
        // Demostración del patrón Strategy: cambiar membresía dinámicamente
        System.out.println("=== DEMOSTRACIÓN DE CAMBIO DE ESTRATEGIA ===\n");
        
        System.out.println("María inicialmente tiene membresía Cardio:");
        System.out.println("¿Puede hacer Spinning (Cardio)? " + (maria.podesHacerActividad(spinning) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Fútbol (Deportiva)? " + (maria.podesHacerActividad(futbol) ? "SÍ" : "NO"));
        
        // Cambiar estrategia de membresía
        System.out.println("\nMaría cambia a membresía Full...");
        maria.setMembresia(membresiaFull);
        
        System.out.println("Ahora María tiene membresía Full:");
        System.out.println("¿Puede hacer Spinning (Cardio)? " + (maria.podesHacerActividad(spinning) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Fútbol (Deportiva)? " + (maria.podesHacerActividad(futbol) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Natación (Pileta)? " + (maria.podesHacerActividad(natacion) ? "SÍ" : "NO"));
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}




