# Sistema de Membresías y Actividades

Este proyecto implementa un sistema de membresías para un gimnasio que permite gestionar diferentes tipos de membresías y actividades.

## Estructura del Proyecto

### Clases Base (Abstractas)
- **`Membresia.java`** - Clase abstracta base para todas las membresías
- **`Actividad.java`** - Clase abstracta base para todas las actividades

### Tipos de Actividades
- **`ActividadCardio.java`** - Actividades cardiovasculares (spinning, cinta, etc.)
- **`ActividadDeportiva.java`** - Actividades deportivas (fútbol, tenis, etc.)
- **`ActividadPileta.java`** - Actividades acuáticas (natación, aquaeróbicos, etc.)

### Tipos de Membresías
- **`MembresiaFull.java`** - Membresía completa (acceso a todas las actividades)
- **`MembresiaPorTipoDeActividad.java`** - Membresía limitada a un tipo específico de actividad
- **`MembresiaPorCantidadDeActividades.java`** - Membresía con límite de cantidad de actividades
- **`MembresiaDePrueba.java`** - Membresía de prueba (1 actividad de un tipo específico)

### Clase Principal
- **`Main.java`** - Contiene las pruebas del sistema y ejemplos de uso

## Cómo compilar y ejecutar

```bash
# Compilar todos los archivos
javac *.java

# Ejecutar el programa principal
java Main
```

## Funcionalidades

- **Polimorfismo**: Cada tipo de membresía implementa su propia lógica para determinar qué actividades puede realizar
- **Herencia**: Todas las membresías heredan de la clase base `Membresia`
- **Encapsulación**: Los atributos están protegidos y se acceden mediante métodos públicos
- **Abstracción**: Las clases base definen el comportamiento común sin implementación específica

## Casos de Uso Implementados

1. **Membresía Full**: Puede acceder a cualquier tipo de actividad
2. **Membresía por Tipo**: Solo puede acceder a actividades del tipo especificado (Cardio, Deportiva, Pileta)
3. **Membresía por Cantidad**: Puede acceder a cualquier actividad pero con un límite de cantidad
4. **Membresía de Prueba**: Acceso limitado a 1 actividad de un tipo específico

El programa incluye casos de prueba que demuestran todas estas funcionalidades.
