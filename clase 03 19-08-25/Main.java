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
    
    CuponDescuento(String id, int porcentaje, int monto, int modo) {
        this.id = id;
        this.porcentaje = porcentaje;
        this.monto = monto;
        this.modo = modo;
    }
    
    public int importeConDescuentoPara(Producto unProducto) {
        int precioConDescuento = unProducto.getPrecioDeLista();
        if (modo == 1) { // por porcentaje
            precioConDescuento = precioConDescuento - 
                precioConDescuento * porcentaje / 100;
        }
        if (modo == 2) { // por monto
            precioConDescuento = precioConDescuento - monto;
        }
        return precioConDescuento;
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