package group.crudgui;
import java.sql.*;

public class Transaccion {
    private int id;
    private Date fechaCompra;
    private double montoTotal;
    private String descripcion;
    private int idTarjeta;
    private int idCliente;

    // Constructor
    public Transaccion(int id, Date fechaCompra, double montoTotal, String descripcion, int idTarjeta, int idCliente) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.montoTotal = montoTotal;
        this.descripcion = descripcion;
        this.idTarjeta = idTarjeta;
        this.idCliente = idCliente;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", fechaCompra=" + fechaCompra +
                ", montoTotal=" + montoTotal +
                ", descripcion='" + descripcion + '\'' +
                ", idTarjeta=" + idTarjeta +
                ", idCliente=" + idCliente +
                '}';
    }
}
