package group.crudgui;
import java.sql.*;

public class Transaccion {
    private int id;
    private Date fecha_compra;
    private double monto_total;
    private String descripcion;
    private int id_tarjeta;
    private int id_cliente;

    // Constructor
    public Transaccion(int id, Date fecha_compra, double monto_total, String descripcion, int id_tarjeta, int id_cliente) {
        this.id = id;
        this.fecha_compra = fecha_compra;
        this.monto_total = monto_total;
        this.descripcion = descripcion;
        this.id_tarjeta = id_tarjeta;
        this.id_cliente = id_cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }
}
