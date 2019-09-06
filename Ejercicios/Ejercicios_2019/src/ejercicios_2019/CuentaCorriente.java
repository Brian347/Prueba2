/*
1_(7.1). Diseñe la clase CuentaCorriente sabiendo que los datos necesarios
         son: saldo, límite de descubierto^1, nombre y DNI del titular. Las
         Las operaciones típicas con una cuenta corriente son:
         - Crear la cuenta: se necesita el nombre y DNI del titular. El saldo
           inicial será 0 y el límite de descubierto será de -50 soles
         - Sacar dinero: solo se podrá sacar dinero hasta el límite del descubierto
           El método debe indicar si ha sido posible llevar a cabo la operación.
         - Ingresar dinero: se incrementa el saldo
         - Mostrar linformación: Muestra la información disponible de la cuenta corriente.

 */
package ejercicios_2019;

/**
 *
 * @author BRIAN
 */
public class CuentaCorriente {
    double saldo;
    String nombre;
    String dni;
    double limite;
    public CuentaCorriente(String nombre, String dni){
        saldo=0;
        this.nombre=nombre;
        this.dni=dni;
        limite=-50;
    }
    
    public boolean egreso(double cant){
        boolean operacionPosible;
        if ((saldo-cant)>=limite) {
            saldo-=cant;
            operacionPosible= true;
        }else{
            System.out.println("No hay dinero suficiente");
            operacionPosible=false;
        }
        
        return operacionPosible;
    }
    
    public void ingreso (double cantidad){
        saldo+=cantidad;
    }
    
    //Métodos diferentes para mostrar la información
    
    public void mostrarInformacion(){
        System.out.println("Nombre: "+nombre);
        System.out.println("DNI: "+dni);
        System.out.println("Saldo: "+saldo);
        System.out.println("Límite: "+limite);
    }
    
    public String mostrarCad(){
        String cad="Nombre: "+nombre+", DNI: "+dni+ ", Saldo: "+saldo+", Límite: "+limite;
        return cad;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + "saldo=" + saldo + ", nombre=" + nombre + ", dni=" + dni + ", limite=" + limite + '}';
    }
    
}

class mainCuenta{
    public static void main(String[] args) {
        CuentaCorriente c=new CuentaCorriente("Naldo", "43436464");
        c.limite=-100;
        c.ingreso(1000);
        c.egreso(300);
        c.mostrarInformacion();
        System.out.println("Puedo sacar 700 soles: "+c.egreso(700));
        System.out.println("Puedo sacar 500 soles: "+c.egreso(101));
        
        System.out.println("===================================================");
        //c.mostrarInformacion();
        //System.out.println(c.toString());
        System.out.println(c.mostrarCad());
        
    }
}
