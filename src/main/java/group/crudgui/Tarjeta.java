package group.crudgui;

import java.sql.Date;
import java.time.LocalDate;

public class Tarjeta {
    private int id;
    private int id_tipo_tarjeta;
    private int id_facilitador_tarjeta;
    private int id_cliente;

    //private LocalDate fecha_expiracion;
    private String numero_tarjeta;
    private Date fecha_expiracion;

    public Tarjeta(){}

    public Tarjeta(int id, String numero_tarjeta, int id_tipo_tarjeta, Date fecha_expiracion, int id_facilitador_tarjeta, int id_cliente)
    {
        this.fecha_expiracion = fecha_expiracion;
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_facilitador_tarjeta = id_facilitador_tarjeta;
        this.id_tipo_tarjeta = id_tipo_tarjeta;
        this.numero_tarjeta = numero_tarjeta;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
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

    public int getId_facilitador_tarjeta() {
        return id_facilitador_tarjeta;
    }

    public void setId_facilitador_tarjeta(int id_facilitador_tarjeta) {
        this.id_facilitador_tarjeta = id_facilitador_tarjeta;
    }

    public int getId_tipo_tarjeta() {
        return id_tipo_tarjeta;
    }

    public void setId_tipo_tarjeta(int id_tipo_tarjeta) {
        this.id_tipo_tarjeta = id_tipo_tarjeta;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }
}
