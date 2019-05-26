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
public class Venta {
    private Fecha fecha;
    private Vendedor vendedor;
    private Cliente cliente;
    private ArrayList <Producto> productosVendidos;
    private int formaPago;
    private int códigoPromocional;
    private double total;

    public Venta(Fecha fecha, Vendedor vendedor, Cliente cliente, int formaPago, int códigoPromocional) {
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.productosVendidos = new ArrayList<Producto>();
        this.formaPago = formaPago;
        this.códigoPromocional = códigoPromocional;
    }
    
    public void añadirProductosVendidos(int código, int cantidad, ArrayList <Producto> catálogo){
        
        for (int i = 0; i < catálogo.size(); i++) {
            if(catálogo.get(i).getCodigo()==código){
            catálogo.get(i).setCantidad(cantidad);
            this.productosVendidos.add(catálogo.get(i));
            }
        }
    }
    public void impFactura(){
        System.out.println(this.fecha.getDía()+" "+this.fecha.getMes()+" "+this.fecha.getAño());
            System.out.println(this.fecha.getHora());
            System.out.println("Cliente :"+this.cliente.getNombre()+" "+this.cliente.getApellido());
            System.out.println("Vendedor: (ID - "+this.vendedor.getId()+")  Nombre: "+this.vendedor.getNombre()+" "+this.vendedor.getApellido());
            System.out.println("Productos Vendidos: ");
            
            for (int i = 0; i < this.productosVendidos.size(); i++) {
                System.out.println("Código: "+this.productosVendidos.get(i).getCodigo()+"   Cantidad: "+this.productosVendidos.get(i).getCantidad()+"  -----  $"+this.productosVendidos.get(i).getPrecioUnitario());
                this.total += (this.productosVendidos.get(i).getCantidad()*this.productosVendidos.get(i).getPrecioUnitario());
        }
            System.out.println("Total a pagar: $"+this.total);
            if(this.formaPago == 0){
                System.out.println("Forma de pago: Efectivo");
            }else if(this.formaPago == 1){
                System.out.println("Forma de pago: Débito");
            }else if(this.formaPago == 2){
                System.out.println("Forma de pago: Tarjeta");
            }
          
            if(this.códigoPromocional == 1){
                    this.total = (this.total-((this.total*10)/100));
                    System.out.println("Se aplica descuento del 10% - Nuevo total: "+ this.total);
                }else if(this.códigoPromocional == 2){
                    this.total = (this.total-((this.total*20)/100));
                    System.out.println("Se aplica descuento del 20% - Nuevo total: "+ this.total);
                }else if(this.códigoPromocional == 3){
                    this.total = (this.total-((this.total*30)/100));
                    System.out.println("Se aplica descuento del 30% - Nuevo total: "+ this.total);
                }else if(this.códigoPromocional == 4){
                    this.total = (this.total-((this.total*40)/100));
                    System.out.println("Se aplica descuento del 40% - Nuevo total: "+ this.total);
                }else{
                    System.out.println("No se le aplica descuento");
                }
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductos(ArrayList<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public int getCódigoPromocional() {
        return códigoPromocional;
    }

    public void setCódigoPromocional(int códigoPromocional) {
        this.códigoPromocional = códigoPromocional;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
