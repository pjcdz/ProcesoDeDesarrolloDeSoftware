/**
 * Clase principal para probar el sistema de membresías y actividades.
 * 
 * Este programa demuestra el uso de diferentes tipos de membresías
 * y cómo cada una puede acceder a distintos tipos de actividades.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE MEMBRESÍAS Y ACTIVIDADES ===\n");
        
        // Crear diferentes tipos de actividades
        ActividadCardio spinning = new ActividadCardio("Spinning", "Clase de ciclismo indoor");
        ActividadCardio cinta = new ActividadCardio("Cinta", "Ejercicio en cinta de correr");
        
        ActividadDeportiva futbol = new ActividadDeportiva("Fútbol", "Partido de fútbol");
        ActividadDeportiva tenis = new ActividadDeportiva("Tenis", "Clase de tenis");
        
        ActividadPileta natacion = new ActividadPileta("Natación", "Clases de natación");
        ActividadPileta aquaerobicos = new ActividadPileta("Aquaeróbicos", "Ejercicios acuáticos");
        
        // Crear diferentes tipos de membresías
        MembresiaFull membresiaFull = new MembresiaFull(1, 12345678);
        MembresiaPorTipoDeActividad membresiaCardio = new MembresiaPorTipoDeActividad(2, 87654321, "Cardio");
        MembresiaPorTipoDeActividad membresiaDeportiva = new MembresiaPorTipoDeActividad(3, 11223344, "Deportiva");
        MembresiaPorTipoDeActividad membresiaPileta = new MembresiaPorTipoDeActividad(4, 55667788, "Pileta");
        MembresiaPorCantidadDeActividades membresia3Actividades = new MembresiaPorCantidadDeActividades(5, 99887766, 3);
        MembresiaDePrueba membresiaPruebaCardio = new MembresiaDePrueba(6, 44332211, "Cardio");
        
        // Array de membresías para probar
        Membresia[] membresias = {
            membresiaFull, 
            membresiaCardio, 
            membresiaDeportiva, 
            membresiaPileta,
            membresia3Actividades,
            membresiaPruebaCardio
        };
        
        // Array de actividades para probar
        Actividad[] actividades = {
            spinning, cinta, futbol, tenis, natacion, aquaerobicos
        };
        
        // Nombres descriptivos de las membresías
        String[] nombreMembresias = {
            "Membresía Full (ID: 1)",
            "Membresía Cardio (ID: 2)", 
            "Membresía Deportiva (ID: 3)",
            "Membresía Pileta (ID: 4)",
            "Membresía 3 Actividades (ID: 5)",
            "Membresía Prueba Cardio (ID: 6)"
        };
        
        // Probar cada membresía con cada actividad
        for (int i = 0; i < membresias.length; i++) {
            System.out.println("--- " + nombreMembresias[i] + " ---");
            
            for (Actividad actividad : actividades) {
                boolean puedeHacer = membresias[i].podesHacer(actividad);
                String resultado = puedeHacer ? "✓ SÍ" : "✗ NO";
                System.out.println(actividad.getNombre() + " (" + actividad.getTipoActividad() + "): " + resultado);
            }
            System.out.println();
        }
        
        // Casos de prueba específicos
        System.out.println("=== CASOS DE PRUEBA ESPECÍFICOS ===\n");
        
        // Caso 1: Membresía Full puede hacer todo
        System.out.println("CASO 1: Membresía Full");
        System.out.println("¿Puede hacer Spinning? " + (membresiaFull.podesHacer(spinning) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Fútbol? " + (membresiaFull.podesHacer(futbol) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Natación? " + (membresiaFull.podesHacer(natacion) ? "SÍ" : "NO"));
        System.out.println();
        
        // Caso 2: Membresía específica por tipo
        System.out.println("CASO 2: Membresía solo Cardio");
        System.out.println("¿Puede hacer Spinning (Cardio)? " + (membresiaCardio.podesHacer(spinning) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Fútbol (Deportiva)? " + (membresiaCardio.podesHacer(futbol) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Natación (Pileta)? " + (membresiaCardio.podesHacer(natacion) ? "SÍ" : "NO"));
        System.out.println();
        
        // Caso 3: Membresía de prueba
        System.out.println("CASO 3: Membresía de Prueba (1 actividad Cardio)");
        System.out.println("¿Puede hacer Spinning (Cardio)? " + (membresiaPruebaCardio.podesHacer(spinning) ? "SÍ" : "NO"));
        System.out.println("¿Puede hacer Fútbol (Deportiva)? " + (membresiaPruebaCardio.podesHacer(futbol) ? "SÍ" : "NO"));
        System.out.println();
        
        // Caso 4: Membresía por cantidad
        System.out.println("CASO 4: Membresía por Cantidad (máximo 3 actividades)");
        System.out.println("¿Puede hacer cualquier actividad? " + (membresia3Actividades.podesHacer(spinning) ? "SÍ" : "NO"));
        System.out.println("Cantidad máxima permitida: " + membresia3Actividades.getCantidadMaxima());
        System.out.println();
    }
}




