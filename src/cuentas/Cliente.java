package cuentas;
public class Cliente {

    private String nombre;
    private String id;
    private String fechaNacimiento;
    private String edad;
    private String direccionCasa;
    Cuenta cuentas[];

    public Cliente(String nombre, String id, String fechaNacimiento, String edad, String direccionCasa, Cuenta[] cuentas) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.direccionCasa = direccionCasa;
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public String getDireccionCasa() {
        return direccionCasa;
    }

    public double consultarSaldo(int indice){
        return cuentas[indice].getSaldo();
    }

    public void ingresarDinero(int indice,double cantidad){
        cuentas[indice].depositarDinero(cantidad);
    }

    public void retirarDinero(int indice,double cantidad){
        cuentas[indice].retirarDinero(cantidad);
    }
}