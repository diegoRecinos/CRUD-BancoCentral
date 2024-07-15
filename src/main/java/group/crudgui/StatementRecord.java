package group.crudgui;

public class StatementRecord {
    private int id;
    private String nombre;
    private String numeroTarjeta;
    private String descripcion;
    private String facilitador;

    public StatementRecord(int id, String nombre, String numeroTarjeta, String descripcion, String facilitador) {
        this.id = id;
        this.nombre = nombre;
        this.numeroTarjeta = numeroTarjeta;
        this.descripcion = descripcion;
        this.facilitador = facilitador;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFacilitador() {
        return facilitador;
    }
}


