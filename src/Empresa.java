/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author JUANPABLO
 */
public class Empresa {
    
   private ArrayList<Producto> catálogo; 
   private ArrayList<Venta> ventas;
   private ArrayList<Vendedor> vendedores;

    public Empresa() {
        this.catálogo = new ArrayList<Producto>();
        this.ventas = new ArrayList<Venta>();
        this.vendedores = new ArrayList<Vendedor>();
    }
     
    public boolean añadirACatálogo(int código, String descripción, double precioUnitario){
        for (int i = 0; i < this.catálogo.size(); i++) {
            if(código == this.catálogo.get(i).getCodigo()){
            return false;           
        }    
    }
        this.catálogo.add(new Producto(código,descripción,precioUnitario));
        return true;
    }
    public boolean añadirVendedor(int código, String nombre, String apellido){
        for (int i = 0; i < this.vendedores.size(); i++) {
            if(this.vendedores.get(i).getNombre().contains(nombre) && this.vendedores.get(i).getApellido().equals(apellido)){
            return false;           
        }  
    }
        this.vendedores.add(new Vendedor(código,nombre,apellido));
        return true;
    }
    public boolean RegistrarVenta(int d, int m, int a, String h, int id, String vn, String va, String cn,String ca, int formaPago, int códigoPromocional){
        for (int i = 0; i < this.vendedores.size(); i++) {
            if(this.vendedores.get(i).getId()==id&&this.vendedores.get(i).getNombre().equals(vn)&&this.vendedores.get(i).getApellido().equals(va)){
                this.ventas.add(new Venta(new Fecha(d,m,a,h),new Vendedor(id,vn,va),new Cliente(cn,ca),formaPago,códigoPromocional));
                return true;
            }
        }return false;
        
    }
    
    public double montoVentas(){
        double x = 0;
        for (int i = 0; i < this.ventas.size(); i++) {
            x += this.ventas.get(i).getTotal();
        }return x;
    } 
    
    public static void main(String[] args) {
        
        Empresa empresa = new Empresa();
        
        empresa.añadirACatálogo(001,"Guitarra", 150000);
        empresa.añadirACatálogo(002,"Bajo", 120000);
        empresa.añadirACatálogo(003,"Bateria", 500000);
        empresa.añadirACatálogo(004,"Amplificador", 80000);
        empresa.añadirACatálogo(005,"Micrófono", 10000);
        
        empresa.añadirVendedor(101,"Juan","Perez");
        empresa.añadirVendedor(102,"Andrea","Gomez");
        empresa.añadirVendedor(103,"Jhon","Florez");
        
        
        empresa.RegistrarVenta(20,05,2019,"1:48pm",101,"Juan","Perez","Andres","Carrillo",2,2);
        empresa.ventas.get(0).añadirProductosVendidos(001,2,empresa.catálogo);
        empresa.ventas.get(0).añadirProductosVendidos(002,1,empresa.catálogo);
        empresa.ventas.get(0).añadirProductosVendidos(004,4,empresa.catálogo);
        empresa.ventas.get(0).impFactura();
        System.out.println("");
        empresa.RegistrarVenta(25,05,2019,"11:26am",102,"Andrea","Gomez","Jhon","Valderrama",2,0);
        empresa.ventas.get(1).añadirProductosVendidos(001,1,empresa.catálogo);
        empresa.ventas.get(1).añadirProductosVendidos(002,1,empresa.catálogo);
        empresa.ventas.get(1).añadirProductosVendidos(004,4,empresa.catálogo);
        empresa.ventas.get(1).impFactura();
        System.out.println("");
        empresa.RegistrarVenta(1,04,2019,"8:13am",103,"Jhon","Florez","Rodrigo","Orjuela",0,4);
        empresa.ventas.get(2).añadirProductosVendidos(005,10,empresa.catálogo);
        empresa.ventas.get(2).añadirProductosVendidos(003,1,empresa.catálogo);
        empresa.ventas.get(2).añadirProductosVendidos(004,2,empresa.catálogo);
        empresa.ventas.get(2).impFactura();
        System.out.println("");
        System.out.println("");
        System.out.println("El monto total de las ventas es: $" + empresa.montoVentas());
    }
}
