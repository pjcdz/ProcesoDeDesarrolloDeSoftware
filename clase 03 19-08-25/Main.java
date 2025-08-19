// Strategy Interface
interface EstrategiaDescuento {
    int calcularDescuento(Producto producto);
}

// Estrategia concreta para descuento por porcentaje
class DescuentoPorPorcentaje implements EstrategiaDescuento {
    private final int porcentaje;
    
    public DescuentoPorPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    @Override
    public int calcularDescuento(Producto producto) {
        int precioBase = producto.getPrecioDeLista();
        return precioBase - (precioBase * porcentaje / 100);
    }
}

// Estrategia concreta para descuento por monto fijo
class DescuentoPorMonto implements EstrategiaDescuento {
    private final int monto;
    
    public DescuentoPorMonto(int monto) {
        this.monto = monto;
    }
    
    @Override
    public int calcularDescuento(Producto producto) {
        return producto.getPrecioDeLista() - monto;
    }
}

class Producto {
    private String descripcion;
    private int precioDeLista;
    
    public Producto(String desc, int precio) {
        this.descripcion = desc;
        this.precioDeLista = precio;
    }
    
    public int getPrecioDeLista() {
        return precioDeLista;
    }
}

class CuponDescuento {
    private final String id;
    private final int porcentaje;
    private final int monto;
    private final int modo; // 1: por porcentaje 2: por monto
    private final EstrategiaDescuento estrategia;
    
    CuponDescuento(String id, int porcentaje, int monto, int modo) {
        this.id = id;
        this.porcentaje = porcentaje;
        this.monto = monto;
        this.modo = modo;
        
        // Factory pattern para crear la estrategia apropiada
        if (modo == 1) {
            this.estrategia = new DescuentoPorPorcentaje(porcentaje);
        } else if (modo == 2) {
            this.estrategia = new DescuentoPorMonto(monto);
        } else {
            throw new IllegalArgumentException("Modo de descuento no válido");
        }
    }
    
    public int importeConDescuentoPara(Producto unProducto) {
        return estrategia.calcularDescuento(unProducto);
    }
}

public class Main {
    public static void main(String[] args) {
        Producto galaxyA15 = new Producto("Celular Samsung GalaxyA15", 249990);
        Producto iPhone16 = new Producto("Celular iPhone 16 Pro", 440000);
        CuponDescuento cupon10off = new CuponDescuento("2d33s", 10, 0, 1);
        CuponDescuento cupon20000Ars = new CuponDescuento("2d33s", 0, 20000, 2);
        
        System.out.printf(
            "Precio de lista galaxyA15: $%d, con descuento: $%d \n",
            galaxyA15.getPrecioDeLista(),
            cupon10off.importeConDescuentoPara(galaxyA15)
        );
        
        System.out.printf(
            "Precio de lista iPhone16: $%d, con descuento: $%d \n",
            iPhone16.getPrecioDeLista(),
            cupon20000Ars.importeConDescuentoPara(iPhone16)
        );
    }
}