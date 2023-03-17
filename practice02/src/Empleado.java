/*
 * Esta es la clase Empleado, en ella se encuentran los atributos y metodos de un empleado.
 */
public class Empleado {
    /*
     * Se crean los atributos de la clase Empleado.
     */
    public int id;
    public String nombre;
    public float sueldo;
    public int diasLaborados;
    public float auxilioTransporte;

    public float sueldoDevengado;
    public float totalDevengado;

    public final float PORCENTAJE_SALUD_PENSION = 0.04f; // Es una constante que no cambia, por eso se declara con la palabra reservada final.
    public float saludDeduccion;
    public float pensionDeduccion;

    public float totalSueldo;

    /*
     * Este es el constructor de la clase Empleado.
     * 
     * El constructor es un metodo que se llama igual que la clase, y se ejecuta cuando se crea un objeto de esa clase.
     */
    public Empleado(int id, String nombre, float sueldo, int diasLaborados, float auxilioTransporte) { // Se reciben los parametros que se le pasan al constructor.
        this.id = id; // thiss es una palabra reservada que se usa para referirse a los atributos de la clase.
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.diasLaborados = diasLaborados;
        this.auxilioTransporte = auxilioTransporte;

        float sueldoDiario = this.sueldo / 30; // Se calcula el sueldo diario. Dividiendo el sueldo mensual entre 30 que son los dias del mes.

        this.sueldoDevengado = sueldoDiario * this.diasLaborados; // Se calcula el sueldo devengado. Multiplicando el sueldo diario por los dias laborados.
        this.totalDevengado = this.sueldoDevengado + this.auxilioTransporte; // Se calcula el total devengado. Sumando el sueldo devengado con el auxilio de transporte.

        // Math.round() redondea un numero decimal.
        this.saludDeduccion = Math.round((this.totalDevengado * PORCENTAJE_SALUD_PENSION)); // Se calcula la deduccion de salud. Multiplicando el total devengado por el porcentaje de salud y pension.
        this.pensionDeduccion = Math.round((this.totalDevengado * PORCENTAJE_SALUD_PENSION)); // Se calcula la deduccion de pension. Multiplicando el total devengado por el porcentaje de salud y pension.

        this.totalSueldo = this.totalDevengado - this.saludDeduccion - this.pensionDeduccion;
    }
}
